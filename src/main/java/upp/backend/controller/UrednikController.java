package upp.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import upp.backend.model.Rad;
import upp.backend.repository.RadRepository;



@RestController
@RequestMapping(value = "/urednik")
public class UrednikController {

	@Autowired
	public RadRepository radRep;
	
	@RequestMapping(value = "/radovi", method = RequestMethod.GET)
	public ResponseEntity<List<Rad>> getRadove(){
	
		return new ResponseEntity<>(radRep.findAll(), HttpStatus.OK);
	}
}
