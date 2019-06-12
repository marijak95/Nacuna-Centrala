package upp.backend.camundaServices;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

import upp.backend.model.Rad;
import upp.backend.model.Urednik;

public class MejlAutoruIGlavnogUrenikuService implements JavaDelegate{
	
	@Autowired
	public EmailService emailSer;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		User ulogovan = (User) execution.getVariable("ulogovanAutor");
		Urednik glavniUrednik = (Urednik) execution.getVariable("glavniUrednik");
		Rad rad = (Rad) execution.getVariable("rad");
		
		
		emailSer.KreiranRadMejl(ulogovan.getEmail(), glavniUrednik.getEmail(), rad);
		
	}
}
