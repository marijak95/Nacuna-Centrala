package upp.backend.model;

import javax.persistence.Entity;

import upp.backend.enumeracije.TIP_CASOPISA;

import java.util.List;

import javax.persistence.*;

@Entity
public class Casopis {
	
	@Id
	private long Id;
	
	@Column
	public String naziv;
	
	@Column
	public String iSSN;
	
	@Column
	@Enumerated(EnumType.STRING)
	public TIP_CASOPISA Tip;
	
	//lista radova
	@ManyToMany(mappedBy = "Casopisi")
	public List<Rad> Radovi;
	
	//lista naucnih oblasti koje pokriva casopis	
	@ManyToMany(mappedBy = "Casopisi")
	public List<NaucnaOblast> NaucneOblasti;
	
	//zaposleni urednici, tj odbor
	@OneToOne
	public ZaposleniUrednici ZaposleniUrednici;
	
	//zaposleni recenzenti
	@ManyToOne
	public ZaposleniRecenzenti ZaposleniRecenzenti;
	
	//autori koji imaju clanstvo
	@ManyToMany(mappedBy = "clanarine")
	public List<Autor> Autori;
	
	
	
	public Casopis() {		
	}

	public Casopis(long id, String naziv, String iSSN, TIP_CASOPISA tip, List<Rad> radovi,
			upp.backend.model.ZaposleniUrednici zaposleniUrednici,
			upp.backend.model.ZaposleniRecenzenti zaposleniRecenzenti, List<Autor> autori,
			List<NaucnaOblast> naucneOblasti) {
		super();
		Id = id;
		this.naziv = naziv;
		this.iSSN = iSSN;
		Tip = tip;
		Radovi = radovi;
		ZaposleniUrednici = zaposleniUrednici;
		ZaposleniRecenzenti = zaposleniRecenzenti;
		Autori = autori;
		NaucneOblasti = naucneOblasti;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getISSN() {
		return iSSN;
	}

	public void setISSN(String iSSN) {
		this.iSSN = iSSN;
	}

	public TIP_CASOPISA getTip() {
		return Tip;
	}

	public void setTip(TIP_CASOPISA tip) {
		Tip = tip;
	}

	public List<Rad> getRadovi() {
		return Radovi;
	}

	public void setRadovi(List<Rad> radovi) {
		Radovi = radovi;
	}

	public ZaposleniUrednici getZaposleniUrednici() {
		return ZaposleniUrednici;
	}

	public void setZaposleniUrednici(ZaposleniUrednici zaposleniUrednici) {
		ZaposleniUrednici = zaposleniUrednici;
	}

	public ZaposleniRecenzenti getZaposleniRecenzenti() {
		return ZaposleniRecenzenti;
	}

	public void setZaposleniRecenzenti(ZaposleniRecenzenti zaposleniRecenzenti) {
		ZaposleniRecenzenti = zaposleniRecenzenti;
	}

	public List<Autor> getAutori() {
		return Autori;
	}

	public void setAutori(List<Autor> autori) {
		Autori = autori;
	}

	public List<NaucnaOblast> getNaucneOblasti() {
		return NaucneOblasti;
	}

	public void setNaucneOblasti(List<NaucnaOblast> naucneOblasti) {
		NaucneOblasti = naucneOblasti;
	}
	
	
	
	
	

	
	
	
}
