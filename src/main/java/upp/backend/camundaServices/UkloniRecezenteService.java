package upp.backend.camundaServices;

import java.util.LinkedList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class UkloniRecezenteService implements JavaDelegate{
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {

		@SuppressWarnings("unchecked")
		List<String> recezenti = (List<String>) execution.getVariable("recezenti");
		@SuppressWarnings("unchecked")
		List<String> odabrani = (List<String>) execution.getVariable("odabrani_recezenti");

		List<String> povratna = new LinkedList<String>();

		for (String email : recezenti) {
			boolean found = false;
			for (String e : odabrani) {
				if (email.equals(e))
					found = true;
			}
			if(!found)
				povratna.add(email);
		}

		execution.setVariable("recezenti", povratna);

	}

}
