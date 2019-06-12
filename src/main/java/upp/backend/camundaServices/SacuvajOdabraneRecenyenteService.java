package upp.backend.camundaServices;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import upp.backend.model.dto.PoljaDTO;

public class SacuvajOdabraneRecenyenteService implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		@SuppressWarnings("unchecked")
		List<String> recenzenti = (List<String>) execution.getVariable("recenzenti");
		
		@SuppressWarnings("unchecked")
		List<PoljaDTO> polja = (List<PoljaDTO>) execution
				.getVariable("Dodela_uloge_recenzenta");

		for (PoljaDTO polje : polja) {
			if(polje.getVrednost().equals("true")) {
				recenzenti.add(polje.getPoljeId());
			}

		}
		
	}
}
