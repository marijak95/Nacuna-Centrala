package upp.backend.camundaServices;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MejlAutoruZaIspravkeService implements JavaDelegate{
	
	@Autowired
	private EmailService emailSer;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		User user = (User) execution.getVariable("ulogovanAutor");
		
		String naslov = "Rad je lose formatiran";
		
		String text = "Postavljeni rad nije dobro formatiran. Molili bismo Vas da u nardnih 12 sati to ispravite i posaljete novu verziju";
		
		emailSer.posaljiMejl(user.getEmail(), naslov, text);

	}
}
