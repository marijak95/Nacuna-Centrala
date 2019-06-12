package upp.backend.camundaServices;

import java.util.LinkedList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.springframework.stereotype.Service;

import upp.backend.model.Casopis;
import upp.backend.model.NaucnaOblast;
import upp.backend.model.Rad;
import upp.backend.model.Recenzent;

@Service
public class PonudaListeRecenzenataService implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		List<String> povratna = new LinkedList<String>();

		Casopis c = (Casopis) execution.getVariable("izabranCasopis");
		Rad rad = (Rad) execution.getVariable("rad");
		NaucnaOblast oblast = rad.getNaucnaOblast();


		if (c.getZaposleniRecenzenti() != null) {
			List<Recenzent> recenzenti = c.getZaposleniRecenzenti().getRecenzenti();

			for (Recenzent r : recenzenti) {
				for (NaucnaOblast no : r.getNaucneOblasti()) {
					if (no.getId() == oblast.getId()) {
						povratna.add(r.getEmail());
					}
				}
			}
		}

		execution.setVariable("recenzenti", povratna);
		
	}

}
