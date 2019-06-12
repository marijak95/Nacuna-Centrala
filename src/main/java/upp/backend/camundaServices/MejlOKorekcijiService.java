package upp.backend.camundaServices;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class MejlOKorekcijiService implements JavaDelegate{
	
	@Autowired
	public EmailService emailSer;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		User user = (User) execution.getVariable("ulogovanAutor");
		
		String naslov = "Koreckcija rada";
		
		String text = "Korigujte rad na osnovu komentara i u roku od 48 sati posaljite novu verziju.";
		
		emailSer.posaljiMejl(user.getEmail(), naslov, text);

	}

}
