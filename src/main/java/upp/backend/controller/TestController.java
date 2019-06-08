package upp.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/proba")
	public String writretest() {
		return "Teeeeeest!";
	}
}
