package upp.backend.camundaServices;

import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

import upp.backend.model.Autor;
import upp.backend.model.dto.PoljaDTO;

public class KreirajKorisnikaService implements JavaDelegate{

	@Autowired
	public IdentityService identitySer;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {		
		@SuppressWarnings("unchecked")
		List<PoljaDTO> registracija = (List<PoljaDTO>) execution
				.getVariable("UnosPodataka");

		Autor autor = kreiraj(registracija);
		System.out.println("AUTHOR " + autor);
		User user = identitySer.newUser(autor.getEmail());
		user.setEmail(autor.getEmail());
		user.setFirstName(autor.getIme());
		user.setLastName(autor.getPrezime());
		user.setPassword(autor.getPassword());
		
		
		if(identitySer.createUserQuery().userId(user.getId()).singleResult() != null)
			throw new BpmnError("Vec postoji autor sa istim emailom");
		else {
			identitySer.saveUser(user);
			identitySer.createMembership(user.getId(), "autor");
			execution.setVariable("ulogovanAutor", user);
		}
		
	}
	
	private Autor kreiraj(List<PoljaDTO> reg) {
		Autor a = new Autor();
		for (PoljaDTO polja : reg) {

			if (polja.getPoljeId().equals("ime_reg")) {
				a.setIme(polja.getVrednost());
			}
			if (polja.getPoljeId().equals("prezime_reg")) {
				a.setPrezime(polja.getVrednost());
			}
			if (polja.getPoljeId().equals("email_reg")) {
				a.setEmail(polja.getVrednost());
			}
			if (polja.getPoljeId().equals("password_reg")) {
				a.setPassword(polja.getVrednost());
			}
			
		}
		
		return a;
	}

}
