package upp.backend.camundaServices;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upp.backend.model.Casopis;
import upp.backend.model.Rad;
import upp.backend.model.Urednik;



@Service
public class MejlUrednikuOblastiService implements JavaDelegate{

	@Autowired
	public EmailService emailSer;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		Casopis c = (Casopis) execution.getVariable("izabranCasopis");
		Rad rad = (Rad) execution.getVariable("rad");

		List<Urednik> urednici = c.getZaposleniUrednici().getUrednici();
		boolean pronadjenUrednik = false;
		
		String naslov = "Izbor recenzenata";
		String text = "Izaberite recezente za rad pod naslovom: " + rad.getNaslov();

		for (Urednik u : urednici) {
			for (Urednik temp : rad.getNaucnaOblast().getUrednici()) {
				if (u.getId() == temp.getId()) {
					execution.setVariable("urednikOblasti", u);		
					emailSer.posaljiMejl(u.getEmail(), naslov, text);
					pronadjenUrednik = true;
					break;
				}
			}
		}

		if (!pronadjenUrednik) {
			Urednik glavniUrednik = (Urednik) execution.getVariable("glavniUrednik");
			emailSer.posaljiMejl(glavniUrednik.getEmail(), naslov, text);
			execution.setVariable("urednikOblasti", glavniUrednik);
		}
	}
	
}
