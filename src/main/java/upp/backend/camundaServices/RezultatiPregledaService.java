package upp.backend.camundaServices;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import upp.backend.model.Rad;
import upp.backend.model.dto.PoljaDTO;
import upp.backend.repository.RadRepository;

public class RezultatiPregledaService implements JavaDelegate{

	@Autowired
	private RadRepository radRep;

	@Override
	public void execute(DelegateExecution execution) throws Exception {		
		Rad rad = (Rad) execution.getVariable("rad");
		
		@SuppressWarnings("unchecked")
		List<PoljaDTO> polja = (List<PoljaDTO>) execution
				.getVariable("Rezultati_pregleda");

		boolean  relevantan = false;
		boolean dobroFormatiran = false;
		for (PoljaDTO polje : polja) {
			if (polje.getPoljeId().equals("Relevantan"))
				if(polje.getVrednost().equals("true"))
					relevantan = true;
			if (polje.getPoljeId().equals("DobroFormatiran"))
				if(polje.getVrednost().equals("true"))
					dobroFormatiran = true;
			if (polje.getPoljeId().equals("Komentar")) {
				rad.setKomentarGlavnogUrednika(polje.getVrednost());
				radRep.save(rad);
			}
		}

		execution.setVariable("relevantan", relevantan);
		execution.setVariable("dobroFormatiran", dobroFormatiran);
	}

	
}
