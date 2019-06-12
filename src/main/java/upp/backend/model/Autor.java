package upp.backend.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import upp.backend.enumeracije.TITULA;

@Entity
public class Autor extends Korisnik {
	
	@Column
	public String grad;
	
	@Column
	public String Drzava;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TITULA Titula;
	
	//radovi
	@JsonIgnore
	@OneToMany(mappedBy = "autor")
	private List<Rad> radovi = new LinkedList<Rad>();
	
	
	//uplacene clanarine u magazinima
	@JsonIgnore
	@ManyToMany
	private List<Casopis> clanarine = new LinkedList<Casopis>();

	public Autor() {		
	}
	
	public Autor(String ime, String prezime, String email, String password, String grad, String drzava, TITULA titula,
			List<Rad> radovi, List<Casopis> clanarine) {
		super(ime, prezime, email, password);
		this.grad = grad;
		Drzava = drzava;
		Titula = titula;
		this.radovi = radovi;
		this.clanarine = clanarine;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return Drzava;
	}

	public void setDrzava(String drzava) {
		Drzava = drzava;
	}

	public TITULA getTitula() {
		return Titula;
	}

	public void setTitula(TITULA titula) {
		Titula = titula;
	}

	public List<Rad> getRadovi() {
		return radovi;
	}

	public void setRadovi(List<Rad> radovi) {
		this.radovi = radovi;
	}

	public List<Casopis> getClanarine() {
		return clanarine;
	}

	public void setClanarine(List<Casopis> clanarine) {
		this.clanarine = clanarine;
	}
	
	
	
	
	
}
