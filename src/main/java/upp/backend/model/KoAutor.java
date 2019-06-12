package upp.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "koautor")
public class KoAutor {
	@Id
	private Long Id;
	
	@Column
	public String Ime;
	
	@Column
	public String Prezime;

	@Column
	public String email;  //buduci da ne mora biti registrovan, nema potrebe da se cuva pass
	
	@Column
	public String Adresa;
	
	public KoAutor() {
		
	}

	public KoAutor(Long id, String ime, String prezime, String email, String adresa) {
		super();
		Id = id;
		Ime = ime;
		Prezime = prezime;
		this.email = email;
		Adresa = adresa;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresa() {
		return Adresa;
	}

	public void setAdresa(String adresa) {
		Adresa = adresa;
	}
	
	
	
	
	
	
	
	
}
