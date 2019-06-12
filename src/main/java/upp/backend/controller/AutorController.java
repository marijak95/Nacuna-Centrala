package upp.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import upp.backend.model.Autor;
import upp.backend.model.Rad;
import upp.backend.model.dto.TokenDTO;
import upp.backend.repository.AutorRepository;
import upp.backend.repository.RadRepository;

@RestController
@RequestMapping(value = "/autor")
@CrossOrigin(maxAge = 3600)
public class AutorController {
	
	@Autowired
	public AutorRepository autorRep;
	
	@Autowired
	public RadRepository radRep;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Autor> registracija(@RequestBody Autor autor){

		return new ResponseEntity<>(autorRep.save(autor), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/moji-radovi", method = RequestMethod.POST)
	public ResponseEntity<List<Rad>> getMyTheses(@RequestBody TokenDTO token){
		
		return new ResponseEntity<>(radRep.findByAutorEmail(token.getEmail()), HttpStatus.OK);
	}

}
