package upp.backend.model.dto;

public class KorisnikDTO {

	private String Email;
	
	private String Password;

	
	public KorisnikDTO() {
		super();
	}
	

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
}
