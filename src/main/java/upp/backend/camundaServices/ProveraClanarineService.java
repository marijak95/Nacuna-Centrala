package upp.backend.camundaServices;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;

import upp.backend.model.Autor;
import upp.backend.model.Casopis;

public class ProveraClanarineService implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		Casopis c = (Casopis) execution.getVariable("izabranCasopis");
		User user = (User) execution.getVariable("ulogovanAutor");
		
		for(Autor autor: c.getAutori()) {
			if(autor.getEmail().equals(user.getId())) {
				execution.setVariable("placeno", true);
				return;
			}
		}
		execution.setVariable("placeno", false);
		
	}

	
}
