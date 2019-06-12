package upp.backend.camundaServices;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import upp.backend.model.dto.PoljaDTO;

public class SacuvajKrajnjuOdlukuService implements JavaDelegate{
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		@SuppressWarnings("unchecked")
		List<PoljaDTO> polja = (List<PoljaDTO>) execution
				.getVariable("Pregled_korigovanog_rada");

		for (PoljaDTO polje : polja) {
			execution.setVariable("krajnjaOdluka", polje.getVrednost());
		}
	}


}
