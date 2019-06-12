package upp.backend.camundaServices;


import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import upp.backend.model.Casopis;
import upp.backend.model.dto.PoljaDTO;
import upp.backend.repository.CasopisRepository;

public class ProveraOpenAccessService implements JavaDelegate{

	public CasopisRepository casopisRep;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		@SuppressWarnings("unchecked")
		List<PoljaDTO> polja = (List<PoljaDTO>) execution.getVariable("Odabir_casopisa");

		String ISSN = "";
		for (PoljaDTO polje : polja) {
			ISSN = polje.getVrednost();
		}
		
		Casopis c = casopisRep.findByISSN(ISSN);

		execution.setVariable("izabranCasopis", c);
		
	}

}
