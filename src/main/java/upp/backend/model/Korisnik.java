package upp.backend.model;

public class Korisnik {
	
	public String Id;
	
	public String Ime;
	
	public String Prezime;

	public String Email;
	
	public String Password;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getIme() {
		return Ime;
	}

	public void setIme(String ime) {
		Ime = ime;
	}

	public String getPrezime() {
		return Prezime;
	}

	public void setPrezime(String prezime) {
		Prezime = prezime;
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

	public Korisnik(String id, String ime, String prezime, String email, String password) {
		super();
		Id = id;
		Ime = ime;
		Prezime = prezime;
		Email = email;
		Password = password;
	}
	
	public Korisnik() {
		super();
		Id = "";
		Ime = "";
		Prezime = "";
		Email = "";
		Password = "";
	}
	
	
}
