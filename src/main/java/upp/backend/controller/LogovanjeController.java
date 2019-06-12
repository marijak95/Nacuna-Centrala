package upp.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import upp.backend.model.Autor;
import upp.backend.model.Recenzent;
import upp.backend.model.Urednik;
import upp.backend.model.dto.KorisnikDTO;
import upp.backend.model.dto.TokenDTO;
import upp.backend.repository.AutorRepository;
import upp.backend.repository.RecenzentRepository;
import upp.backend.repository.UrednikRepository;

@RestController
@RequestMapping(value = "/login")
public class LogovanjeController {

	@Autowired
	public AutorRepository autorRep;
	
	@Autowired
	public RecenzentRepository recenzentRep;
	
	@Autowired
	public UrednikRepository urednikRep;
	
	@RequestMapping(value = "/autor", method = RequestMethod.POST)
	public ResponseEntity<TokenDTO> loginAutor(@RequestBody KorisnikDTO kordto){
		Optional<Autor> autor = autorRep.findByEmailAndPassword(kordto.getEmail(), kordto.getPassword());
		if(autor.isPresent())
			return new ResponseEntity<>(new TokenDTO(autor.get().getEmail(), "autor"), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping(value = "/recenzent", method = RequestMethod.POST)
	public ResponseEntity<TokenDTO> loginRecenzent(@RequestBody KorisnikDTO kordto){
		Optional<Recenzent> recenzent = recenzentRep.findByEmailAndPassword(kordto.getEmail(), kordto.getPassword());
		if(recenzent.isPresent())
			return new ResponseEntity<>(new TokenDTO(recenzent.get().getEmail(), "recenzent"), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
	}
	
	
	@RequestMapping(value = "/urednik", method = RequestMethod.POST)
	public ResponseEntity<TokenDTO> loginUrednik(@RequestBody KorisnikDTO kordto){
		Optional<Urednik> urednik = urednikRep.findByEmailAndPassword(kordto.getEmail(), kordto.getPassword());	
		if(urednik.isPresent())
			return new ResponseEntity<>(new TokenDTO(urednik.get().getEmail(), "urednik"), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);	
	}

	
	
}
