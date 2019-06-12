package upp.backend.camundaServices;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

import upp.backend.model.Autor;
import upp.backend.model.Casopis;
import upp.backend.repository.AutorRepository;
import upp.backend.repository.CasopisRepository;

public class PlacanjeService implements JavaDelegate{
	@Autowired
	private AutorRepository autorRep;
	
	@Autowired
	private CasopisRepository casopisRep;

	@Override
	public void execute(DelegateExecution execution) throws Exception {		
		
		Casopis c = (Casopis) execution.getVariable("izabranCasopis");
		User user = (User) execution.getVariable("ulogovanAutor");
		
		Autor autor = autorRep.findByEmail(user.getId());
		
		autor.getClanarine().add(c);
		c.getAutori().add(autor);
		autorRep.save(autor);
		casopisRep.save(c);
	}

	
}
