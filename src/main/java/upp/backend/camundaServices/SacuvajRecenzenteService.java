package upp.backend.camundaServices;

import java.util.LinkedList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import upp.backend.model.dto.PoljaDTO;

public class SacuvajRecenzenteService implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
	
		List<String> recenzenti = new LinkedList<String>();
		
		@SuppressWarnings("unchecked")
		List<PoljaDTO> polja = (List<PoljaDTO>) execution
				.getVariable("Odabir_recenzenata");

		for (PoljaDTO polje : polja) {
			if(polje.getVrednost().equals("true")) {
				recenzenti.add(polje.getPoljeId());
			}

		}
		execution.setVariable("odabrani_recenzenti", recenzenti);
	}


}
