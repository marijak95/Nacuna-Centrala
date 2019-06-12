package upp.backend.camundaServices;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

import upp.backend.model.dto.TokenDTO;

public class ProveraNalogaService implements JavaDelegate{

	@Autowired
	public IdentityService identitySer;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		TokenDTO token = (TokenDTO)execution.getVariable("starter");
		//System.out.println("TOKEN " + token.getEmail());

		if(token.getEmail() == null) {
			execution.setVariable("ulogovanAutor", null);
			return;
		}
		
		User user = identitySer.createUserQuery().userId(token.getEmail()).singleResult();

		if (user == null)
			execution.setVariable("ulogovanAutor", null);
		else {

			System.out.println(user);
			execution.setVariable("ulogovanAutor", user);
		}
		
	}

}
