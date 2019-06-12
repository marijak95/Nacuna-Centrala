package upp.backend.model.dto;

import java.io.Serializable;

public class TokenDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String email;
	
	public String uloga;
	
	public TokenDTO() {
	}

	public TokenDTO(String email, String uloga) {
		super();
		this.email = email;
		this.uloga = uloga;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}
	
	
	
	

}
