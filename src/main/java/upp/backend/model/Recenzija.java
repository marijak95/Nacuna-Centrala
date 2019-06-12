package upp.backend.model;

//import java.sql.Date;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import upp.backend.enumeracije.STATUS_RADA;

@Entity
public class Recenzija {
	@Id 
	private Long Id;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date date;
	
	@ManyToOne(optional = false)
	private Recenzent Recenzent;
	
	@Column
	public String KomentarAutoru;
	
	@Column
	public String KomentarUredniku;
	
	@Column
	@Enumerated(EnumType.STRING)
	public STATUS_RADA StatusRada;
	
	@JsonIgnore
	@ManyToOne
	public Rad rad;
	
	public Recenzija() {		
	}

	public Recenzija(Long id, Date date, upp.backend.model.Recenzent recenzent, String komentarAutoru,
			String komentarUredniku, STATUS_RADA statusRada, upp.backend.model.Rad rad) {
		super();
		Id = id;
		this.date = date;
		Recenzent = recenzent;
		KomentarAutoru = komentarAutoru;
		KomentarUredniku = komentarUredniku;
		StatusRada = statusRada;
		this.rad = rad;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Recenzent getRecenzent() {
		return Recenzent;
	}

	public void setRecenzent(Recenzent recenzent) {
		Recenzent = recenzent;
	}

	public String getKomentarAutoru() {
		return KomentarAutoru;
	}

	public void setKomentarAutoru(String komentarAutoru) {
		KomentarAutoru = komentarAutoru;
	}

	public String getKomentarUredniku() {
		return KomentarUredniku;
	}

	public void setKomentarUredniku(String komentarUredniku) {
		KomentarUredniku = komentarUredniku;
	}

	public STATUS_RADA getStatusRada() {
		return StatusRada;
	}

	public void setStatusRada(STATUS_RADA statusRada) {
		StatusRada = statusRada;
	}

	public Rad getRad() {
		return rad;
	}

	public void setRad(Rad rad) {
		this.rad = rad;
	}
	
	
	
	
}
