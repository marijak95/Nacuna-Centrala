package upp.backend.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Urednik extends Korisnik{
	@Column
	public String grad;
	
	@Column
	public String Drzava;
	
	//da li je glavni urednik nekog odbora
	@JsonIgnore
	@OneToOne(mappedBy = "Glavni_urednik")
	public ZaposleniUrednici GlavniUrednikOdbora;
	
	//u kom odboru se nalazi, gde je zaposlen
	@JsonIgnore
	@ManyToOne
	public ZaposleniUrednici ZaposleniUrednici;
		
	//lista naucnih oblasti za koje je kompetetan
	@JsonIgnore
	@ManyToMany(mappedBy = "Urednici")
	public List<NaucnaOblast> NaucneOblasti;

	public Urednik() {		
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

	public ZaposleniUrednici getGlavniUrednikOdbora() {
		return GlavniUrednikOdbora;
	}

	public void setGlavniUrednikOdbora(ZaposleniUrednici glavniUrednikOdbora) {
		GlavniUrednikOdbora = glavniUrednikOdbora;
	}

	public ZaposleniUrednici getZaposleniUrednici() {
		return ZaposleniUrednici;
	}

	public void setZaposleniUrednici(ZaposleniUrednici zaposleniUrednici) {
		ZaposleniUrednici = zaposleniUrednici;
	}

	public List<NaucnaOblast> getNaucneOblasti() {
		return NaucneOblasti;
	}

	public void setNaucneOblasti(List<NaucnaOblast> naucneOblasti) {
		NaucneOblasti = naucneOblasti;
	}

	public Urednik(String ime, String prezime, String email, String password, String grad, String drzava,
			upp.backend.model.ZaposleniUrednici glavniUrednikOdbora,
			upp.backend.model.ZaposleniUrednici zaposleniUrednici, List<NaucnaOblast> naucneOblasti) {
		super(ime, prezime, email, password);
		this.grad = grad;
		Drzava = drzava;
		GlavniUrednikOdbora = glavniUrednikOdbora;
		ZaposleniUrednici = zaposleniUrednici;
		NaucneOblasti = naucneOblasti;
	}
	
	
	
	
	
	
	
}
