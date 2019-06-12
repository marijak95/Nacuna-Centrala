package upp.backend.camundaServices;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upp.backend.model.Rad;
import upp.backend.model.dto.PoljaDTO;
import upp.backend.repository.RadRepository;

@Service
public class SacuvajKorigovanRadService implements JavaDelegate{
	
	@Autowired
	private RadRepository radRep;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		Rad rad = (Rad) execution.getVariable("rad");

		@SuppressWarnings("unchecked")
		List<PoljaDTO> polja = (List<PoljaDTO>) execution.getVariable("Korekcija_rada");

		for (PoljaDTO polje : polja) {
			rad.setTekstPDFa(polje.getVrednost());
		}
		
		radRep.save(rad);

	}

}
