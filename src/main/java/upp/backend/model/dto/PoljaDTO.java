package upp.backend.model.dto;

import java.io.Serializable;

public class PoljaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String poljeId;

    private String vrednost;

	public PoljaDTO(String poljeId, String vrednost) {
		super();
		this.poljeId = poljeId;
		this.vrednost = vrednost;
	}
	
	public PoljaDTO() {
	}

	public String getPoljeId() {
		return poljeId;
	}

	public void setPoljeId(String poljeId) {
		this.poljeId = poljeId;
	}

	public String getVrednost() {
		return vrednost;
	}

	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}
	
	
}
