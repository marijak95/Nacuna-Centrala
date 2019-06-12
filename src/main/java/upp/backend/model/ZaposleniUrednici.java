package upp.backend.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ZaposleniUrednici implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long Id;
	
	@OneToOne(optional = false)
	public Urednik Glavni_urednik;
	
	//lista svih urednika zaposlenih u casopisu
	@JsonIgnore
	@OneToMany(mappedBy = "ZaposleniUrednici")
	public List<Urednik> Urednici;
	
	@JsonIgnore
	@OneToOne(mappedBy = "ZaposleniUrednici")
	public Casopis Casopis;
	
	public ZaposleniUrednici() {
		
	}

	public ZaposleniUrednici(Long id, Urednik glavni_urednik, List<Urednik> urednici,
			upp.backend.model.Casopis casopis) {
		super();
		Id = id;
		Glavni_urednik = glavni_urednik;
		Urednici = urednici;
		Casopis = casopis;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Urednik getGlavni_urednik() {
		return Glavni_urednik;
	}

	public void setGlavni_urednik(Urednik glavni_urednik) {
		Glavni_urednik = glavni_urednik;
	}

	public List<Urednik> getUrednici() {
		return Urednici;
	}

	public void setUrednici(List<Urednik> urednici) {
		Urednici = urednici;
	}

	public Casopis getCasopis() {
		return Casopis;
	}

	public void setCasopis(Casopis casopis) {
		Casopis = casopis;
	}
	
	
	
	
	
}
