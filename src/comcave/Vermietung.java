package comcave;

import java.util.Date;

public class Vermietung {
	private Date beginn;
	private Date ende;
	private Mieter mieter;
	private Wohnung wohnung;
	
	public Vermietung() {
		// TODO Auto-generated constructor stub
	}

	public Vermietung(Date beginn, Date ende, Mieter mieter, Wohnung wohnung) {
		super();
		this.beginn = beginn;
		this.ende = ende;
		this.mieter = mieter;
		this.wohnung = wohnung;
	}

	public Date getBeginn() {
		return beginn;
	}

	public void setBeginn(Date beginn) {
		this.beginn = beginn;
	}

	public Date getEnde() {
		return ende;
	}

	public void setEnde(Date ende) {
		this.ende = ende;
	}

	public Mieter getMieter() {
		return mieter;
	}

	public void setMieter(Mieter mieter) {
		this.mieter = mieter;
	}

	public Wohnung getWohnung() {
		return wohnung;
	}

	public void setWohnung(Wohnung wohnung) {
		this.wohnung = wohnung;
	}
	
	
	
}
