package upp.backend.camundaServices;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class MejlIstekloVremeService implements JavaDelegate{

	@Autowired
	public EmailService emailSer;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		User user = (User) execution.getVariable("ulogovanAutor");
		
		String naslov = "Isteklo vreme za ispravku";
		
		String text = "Buduci da niste poslali ispravljenu verziju  u zadatom vremenskom roku, Vas rad je odbijen.";
		
		emailSer.posaljiMejl(user.getEmail(), naslov, text);

	}

}
