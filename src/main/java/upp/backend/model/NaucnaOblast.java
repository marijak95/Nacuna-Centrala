package upp.backend.model;

import java.util.List;

import javax.persistence.*;

import upp.backend.enumeracije.OBLAST;

@Entity
public class NaucnaOblast {
	@Id
	private Long Id;
	
	@Column
	@Enumerated(EnumType.STRING)
	public OBLAST nazivOblasti;

	@OneToMany(mappedBy = "NaucnaOblast")
	public List<Rad> Radovi;
	
	@ManyToMany
	public List<Urednik> Urednici;
	
	@ManyToMany
	public List<Recenzent> Recenzenti;
	
	@ManyToMany
	public List<Casopis> Casopisi;
	
	public NaucnaOblast() {
		
	}

	public NaucnaOblast(Long id, OBLAST nazivOblasti, List<Rad> radovi, List<Urednik> urednici,
			List<Recenzent> recenzenti, List<Casopis> casopisi) {
		super();
		Id = id;
		this.nazivOblasti = nazivOblasti;
		Radovi = radovi;
		Urednici = urednici;
		Recenzenti = recenzenti;
		Casopisi = casopisi;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public OBLAST getNazivOblasti() {
		return nazivOblasti;
	}

	public void setNazivOblasti(OBLAST nazivOblasti) {
		this.nazivOblasti = nazivOblasti;
	}

	public List<Rad> getRadovi() {
		return Radovi;
	}

	public void setRadovi(List<Rad> radovi) {
		Radovi = radovi;
	}

	public List<Urednik> getUrednici() {
		return Urednici;
	}

	public void setUrednici(List<Urednik> urednici) {
		Urednici = urednici;
	}

	public List<Recenzent> getRecenzenti() {
		return Recenzenti;
	}

	public void setRecenzenti(List<Recenzent> recenzenti) {
		Recenzenti = recenzenti;
	}

	public List<Casopis> getCasopisi() {
		return Casopisi;
	}

	public void setCasopisi(List<Casopis> casopisi) {
		Casopisi = casopisi;
	}

	
	
	
	
}
