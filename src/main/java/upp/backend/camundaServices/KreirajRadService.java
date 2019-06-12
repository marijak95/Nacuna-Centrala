package upp.backend.camundaServices;


import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

import upp.backend.enumeracije.OBLAST;
import upp.backend.model.Autor;
import upp.backend.model.Casopis;
import upp.backend.model.NaucnaOblast;
import upp.backend.model.Rad;
import upp.backend.model.dto.PoljaDTO;
import upp.backend.repository.AutorRepository;
import upp.backend.repository.NaucnaOblastRepository;
import upp.backend.repository.RadRepository;

public class KreirajRadService implements JavaDelegate{

	@Autowired
	private NaucnaOblastRepository naucnaOblastRep;
	
	@Autowired
	private AutorRepository autorRep;
	
	@Autowired
	private RadRepository radRep;

	@Override
	public void execute(DelegateExecution execution) throws Exception {	
		User ulogovan = (User) execution.getVariable("ulogovanAutor");
		Autor autor = autorRep.findByEmail(ulogovan.getId());
		
		Casopis c = (Casopis) execution.getVariable("izabranCasopis");
		
		@SuppressWarnings("unchecked")
		Rad rad = ucitajRad((List<PoljaDTO>) execution.getVariable("Prijava_Rada"));
		rad.setAutor(autor);
		rad.getCasopisi().add(c);
		
		radRep.save(rad);

		execution.setVariable("rad", rad);
		execution.setVariable("glavniUrednik", c.getZaposleniUrednici().getGlavni_urednik());

	}
	
	private Rad ucitajRad(List<PoljaDTO> forma) {
		Rad rad = new Rad();
		for (PoljaDTO polja : forma) {

			if (polja.getPoljeId().equals("Naslov")) {
				rad.setNaslov(polja.getVrednost());
			}
			
			if (polja.getPoljeId().equals("KljucneReci")) {
				rad.setKljucneReci(polja.getVrednost());
			}
			
			if (polja.getPoljeId().equals("Apstrakt")) {
				rad.setApstrakt(polja.getVrednost());
			}
			
			if (polja.getPoljeId().equals("Koautori")) {
		//		rad.setKoautori(polja.getVrednost());
			}
			
			if (polja.getPoljeId().equals("NaucnaOblast")) {
				OBLAST o = OBLAST.valueOf(polja.getVrednost());
				NaucnaOblast no = naucnaOblastRep.findByNazivOblasti(o);
				rad.setNaucnaOblast(no);
			}
			
			if (polja.getPoljeId().equals("PDF")) {
				rad.setTekstPDFa(polja.getVrednost());
			}
			
		}
		
		return rad;
	}

}
