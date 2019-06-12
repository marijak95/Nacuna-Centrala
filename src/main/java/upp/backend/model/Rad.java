package upp.backend.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Rad {
	@Id
	private Long id;
	
	@Column
	public String naslov;
	
	@Column
	public String KljucneReci;
	
	@Column
	public String Apstrakt;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "autor_fk")
	public Autor autor;
	
	@JsonManagedReference
	@ManyToMany
	public List<KoAutor> Koautori;
	
	@Transient
	public String LokacijaPDFa;
	
	@Transient
	public String KrajnjaLokacijaPDFa;

	@Column
	public String TekstPDFa;
	
	@JsonIgnore
	@ManyToMany
	public List<Casopis> Casopisi = new LinkedList<Casopis>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "NaucnaOblast_fk")
	public NaucnaOblast NaucnaOblast;
	
	//komentari glavnog urednika
	@Column
	public String KomentarGlavnogUrednika;
	
	@OneToMany(mappedBy = "rad")
	public List<Recenzija> Recenzije;

	
	public Rad() {		
	}
	
	public Rad(Long id, String naslov, String kljucneReci, String apstrakt, upp.backend.model.Autor autor,
			List<KoAutor> koautori, String lokacijaPDFa, String krajnjaLokacijaPDFa, String tekstPDFa,
			List<Casopis> casopisi, upp.backend.model.NaucnaOblast naucnaOblast, String komentarGlavnogUrednika,
			List<Recenzija> recenzije) {
		super();
		this.id = id;
		this.naslov = naslov;
		KljucneReci = kljucneReci;
		Apstrakt = apstrakt;
		this.autor = autor;
		Koautori = koautori;
		LokacijaPDFa = lokacijaPDFa;
		KrajnjaLokacijaPDFa = krajnjaLokacijaPDFa;
		TekstPDFa = tekstPDFa;
		Casopisi = casopisi;
		NaucnaOblast = naucnaOblast;
		KomentarGlavnogUrednika = komentarGlavnogUrednika;
		Recenzije = recenzije;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getKljucneReci() {
		return KljucneReci;
	}

	public void setKljucneReci(String kljucneReci) {
		KljucneReci = kljucneReci;
	}

	public String getApstrakt() {
		return Apstrakt;
	}

	public void setApstrakt(String apstrakt) {
		Apstrakt = apstrakt;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<KoAutor> getKoautori() {
		return Koautori;
	}

	public void setKoautori(List<KoAutor> koautori) {
		Koautori = koautori;
	}

	public String getLokacijaPDFa() {
		return LokacijaPDFa;
	}

	public void setLokacijaPDFa(String lokacijaPDFa) {
		LokacijaPDFa = lokacijaPDFa;
	}

	public String getKrajnjaLokacijaPDFa() {
		return KrajnjaLokacijaPDFa;
	}

	public void setKrajnjaLokacijaPDFa(String krajnjaLokacijaPDFa) {
		KrajnjaLokacijaPDFa = krajnjaLokacijaPDFa;
	}

	public String getTekstPDFa() {
		return TekstPDFa;
	}

	public void setTekstPDFa(String tekstPDFa) {
		TekstPDFa = tekstPDFa;
	}

	public List<Casopis> getCasopisi() {
		return Casopisi;
	}

	public void setCasopisi(List<Casopis> casopisi) {
		Casopisi = casopisi;
	}

	public NaucnaOblast getNaucnaOblast() {
		return NaucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblast naucnaOblast) {
		NaucnaOblast = naucnaOblast;
	}

	public String getKomentarGlavnogUrednika() {
		return KomentarGlavnogUrednika;
	}

	public void setKomentarGlavnogUrednika(String komentarGlavnogUrednika) {
		KomentarGlavnogUrednika = komentarGlavnogUrednika;
	}

	public List<Recenzija> getRecenzije() {
		return Recenzije;
	}

	public void setRecenzije(List<Recenzija> recenzije) {
		Recenzije = recenzije;
	}
	
	
	
	
	
}
