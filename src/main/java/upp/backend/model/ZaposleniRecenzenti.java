package upp.backend.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class ZaposleniRecenzenti{
	
	@Id
	private Long Id;
	
	
	//lista svih recenzenata zaposlenih u casopisu
	@OneToMany(mappedBy = "ZaposleniRecenzenti")
	public List<Casopis> Casopisi;
	
	@ManyToMany
	public List<Recenzent> Recenzenti;

	public ZaposleniRecenzenti() {
	}

	public ZaposleniRecenzenti(Long id, List<Casopis> casopisi, List<Recenzent> recenzenti) {
		super();
		Id = id;
		Casopisi = casopisi;
		Recenzenti = recenzenti;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public List<Casopis> getCasopisi() {
		return Casopisi;
	}

	public void setCasopisi(List<Casopis> casopisi) {
		Casopisi = casopisi;
	}

	public List<Recenzent> getRecenzenti() {
		return Recenzenti;
	}

	public void setRecenzenti(List<Recenzent> recenzenti) {
		Recenzenti = recenzenti;
	}
	
	
	
	
	
	
}
