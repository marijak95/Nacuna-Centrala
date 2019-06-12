package upp.backend.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.form.FormField;
import org.camunda.bpm.engine.form.TaskFormData;
import org.camunda.bpm.engine.impl.form.FormFieldImpl;
import org.camunda.bpm.engine.impl.form.type.BooleanFormType;
import org.camunda.bpm.engine.impl.form.type.EnumFormType;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import upp.backend.enumeracije.STATUS_RADA;
import upp.backend.model.Casopis;
import upp.backend.model.Rad;
import upp.backend.model.Recenzent;
import upp.backend.model.Recenzija;
import upp.backend.model.dto.FormaDTO;
import upp.backend.model.dto.PoljaDTO;
import upp.backend.model.dto.StringDTO;
import upp.backend.model.dto.TaskDTO;
import upp.backend.model.dto.TokenDTO;
import upp.backend.repository.CasopisRepository;
import upp.backend.repository.RecenzentRepository;
import upp.backend.repository.RecenzijaRepository;

@RestController
@RequestMapping(value = "/process")
public class ProcessController {
	
	@Autowired
	public CasopisRepository casopisRep;
	
	@Autowired
	public RecenzijaRepository recenzijaRep;
	
	@Autowired
	public RecenzentRepository recenzentRep;

	@Autowired
	public RuntimeService runtimeSer;
	
	@Autowired
	public FormService formSer;
	
	@Autowired
	public TaskService taskSer;
	
	
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public ResponseEntity<StringDTO> startProcess(@RequestBody TokenDTO token) {

		System.out.println("EMAIL " + token.getEmail());

		Map<String, Object> starterVariable = new HashMap<>();
		starterVariable.put("starter", token);
		Execution execution = runtimeSer.startProcessInstanceByKey("upp", starterVariable);

		return new ResponseEntity<>(new StringDTO(execution.getId()), HttpStatus.OK);
	}

	@PostMapping(path = "/get/tasks")
	public ResponseEntity<List<TaskDTO>> get(@RequestBody TokenDTO token) {

		List<Task> tasks = taskSer.createTaskQuery().list();

		List<TaskDTO> taskdtos = new ArrayList<TaskDTO>();

		for (Task task : tasks) {
			boolean notTakenRegistrationTask = task.getName().equals("Unos podataka");
			if (notTakenRegistrationTask) {
				taskdtos.add(new TaskDTO(task.getId(), task.getName()));
			} else if (token.getEmail() != null)
				if (token.getEmail().equals(task.getAssignee())) {
					taskdtos.add(new TaskDTO(task.getId(), task.getName()));
				}
		}

		return new ResponseEntity<>(taskdtos, HttpStatus.OK);
	}

	@GetMapping(path = "/get/{taskId}", produces = "application/json")
	public @ResponseBody FormaDTO get(@PathVariable String taskId) {

		Task task = taskSer.createTaskQuery().taskId(taskId).singleResult();

		TaskFormData tfd = formSer.getTaskFormData(task.getId());
		List<FormField> properties = tfd.getFormFields();

		if (task.getName().equals("Odabir casopisa"))
			properties = kreirajCasopiseForm();

		if (task.getName().equals("Dodela uloge recenzenatima")) {
			properties = kreirajMoguceRecenzenteForm(task);
		}

		if (task.getName().equals("Odabir recenzenata")) {
			properties = kreirajRecenzentaForm(task);
		}

		return new FormaDTO(task.getId(), properties, task.getProcessInstanceId());
	}

	private List<FormField> kreirajRecenzentaForm(Task task) {
		// TODO Auto-generated method stub

		String executionId = task.getExecutionId();
		@SuppressWarnings("unchecked")
		List<String> recEmails = (List<String>) runtimeSer.getVariable(executionId, "recenzentiEmails");

		List<FormField> properties = new LinkedList<FormField>();

		for (String email : recEmails) {

			Recenzent r = recenzentRep.findByEmail(email);

			FormFieldImpl ff = new FormFieldImpl();
			ff.setId(r.getEmail());
			ff.setLabel(r.getIme() + " " + r.getPrezime());

			BooleanFormType booleanType = new BooleanFormType();
			ff.setType(booleanType);
			properties.add(ff);
		}
		return properties;
	}

	private List<FormField> kreirajMoguceRecenzenteForm(Task task) {

		List<Recenzent> recenzenti = recenzentRep.findAll();
		List<FormField> properties = new LinkedList<FormField>();

		String executionId = task.getExecutionId();
		@SuppressWarnings("unchecked")
		List<String> odabraniRecenzenti = (List<String>) runtimeSer.getVariable(executionId, "odabraniRecenzenti");

		for (Recenzent r : recenzenti) {
			boolean found = false;
			if (odabraniRecenzenti != null) {
				for (String email : odabraniRecenzenti) {
					if (r.getEmail().equals(email))
						found = true;
				}
			}
			if (!found) {
				FormFieldImpl ff = new FormFieldImpl();
				ff.setId(r.getEmail());
				ff.setLabel(r.getIme() + " " + r.getPrezime());

				BooleanFormType booleanType = new BooleanFormType();
				ff.setType(booleanType);
				properties.add(ff);
			}
		}
		return properties;
	}

	private List<FormField> kreirajCasopiseForm() {
		FormFieldImpl ff = new FormFieldImpl();
		ff.setId("casopis_id");
		ff.setLabel("Casopis");

		List<Casopis> casopisi = casopisRep.findAll();
		Map<String, String> mapa = new HashMap<String, String>();

		for (Casopis c : casopisi) {
			mapa.put(c.getISSN(), c.getNaziv());
		}

		EnumFormType enumType = new EnumFormType(mapa);
		ff.setType(enumType);
		List<FormField> properties = new LinkedList<FormField>();
		properties.add(ff);

		return properties;
	}

	@PostMapping(path = "/submit/{taskId}/{email}")
	public @ResponseBody ResponseEntity<StringDTO> post(@RequestBody List<PoljaDTO> dto,
			@PathVariable String taskId, @PathVariable String email) {
		HashMap<String, Object> map = this.preuzmiPolja(dto);

		Task task = taskSer.createTaskQuery().taskId(taskId).singleResult();
		String processInstanceId = task.getProcessInstanceId();

		if (task.getName().equals("Recenzija")) {
			izvrsavanjeRecenzije(dto, task, email);
		}

		String processVariable = task.getName().toLowerCase().replace(" ", "_");
		runtimeSer.setVariable(processInstanceId, processVariable, dto);
		formSer.submitTaskForm(taskId, map);
		return new ResponseEntity<>(new StringDTO("success"), HttpStatus.OK);
	}

	private void izvrsavanjeRecenzije(List<PoljaDTO> dto, Task task, String email) {
		// TODO Auto-generated method stub
		
		String executionId = task.getExecutionId();
		Rad rad = (Rad) runtimeSer.getVariable(executionId, "rad");
		
		Recenzent recenzent = recenzentRep.findByEmail(email);
		
		System.out.println("Recenzent " + recenzent.getEmail());
		
		Recenzija recenzija = new Recenzija();
		recenzija.setRecenzent(recenzent);
		recenzija.setDate(new Date());
		recenzija.setRad(rad);
		
		for (PoljaDTO polje : dto) {
			if (polje.getPoljeId().equals("statusRada")) {
				String status = polje.getVrednost();
				recenzija.setStatusRada(STATUS_RADA.valueOf(status));
			}
			if (polje.getPoljeId().equals("komentarAutoru")) {
				recenzija.setKomentarAutoru(polje.getVrednost());
			}
			if (polje.getPoljeId().equals("komentarUredniku")) {
				recenzija.setKomentarUredniku(polje.getVrednost());
			}
		}
		
		recenzijaRep.save(recenzija);
	}

	private HashMap<String, Object> preuzmiPolja(List<PoljaDTO> list) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		for (PoljaDTO polje : list) {
			map.put(polje.getPoljeId(), polje.getVrednost());
		}

		return map;
	}
	
	@GetMapping("komentari/{radId}")
	public ResponseEntity<List<Recenzija>> getKomentare(@PathVariable Long RadId) {
		
		return new ResponseEntity<>(recenzijaRep.findByRadId(RadId), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
