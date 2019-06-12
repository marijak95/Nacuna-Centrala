package upp.backend.model;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Recenzent extends Korisnik{

	@Column
	public String grad;
	
	@Column
	public String Drzava;
	
	//lista zaposlenih recenzenata tj u kojim je odborima recenzent
	@JsonIgnore
	@ManyToMany(mappedBy = "Recenzenti")
	public List<ZaposleniRecenzenti> ZaposleniRecenzenti;
	
	//lista naucnih oblasti za koje je kompetetan
	@JsonIgnore
	@ManyToMany(mappedBy = "Recenzenti")
	public List<NaucnaOblast> NaucneOblasti;
	
	public Recenzent() {		
	}

	public Recenzent(String ime, String prezime, String email, String password, String grad, String drzava,
			List<upp.backend.model.ZaposleniRecenzenti> zaposleniRecenzenti, List<NaucnaOblast> naucneOblasti) {
		super();
		this.grad = grad;
		Drzava = drzava;
		ZaposleniRecenzenti = zaposleniRecenzenti;
		NaucneOblasti = naucneOblasti;
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

	public List<ZaposleniRecenzenti> getZaposleniRecenzenti() {
		return ZaposleniRecenzenti;
	}

	public void setZaposleniRecenzenti(List<ZaposleniRecenzenti> zaposleniRecenzenti) {
		ZaposleniRecenzenti = zaposleniRecenzenti;
	}

	public List<NaucnaOblast> getNaucneOblasti() {
		return NaucneOblasti;
	}

	public void setNaucneOblasti(List<NaucnaOblast> naucneOblasti) {
		NaucneOblasti = naucneOblasti;
	}
	
	
	
}
