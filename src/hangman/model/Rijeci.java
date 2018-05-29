package hangman.model;

public class Rijeci {

	String rijec;
	int kategorija;
	
	
	public Rijeci(String rijec, int kategorija) {
		super();
		this.rijec = rijec;
		this.kategorija = kategorija;
	}


	public String getRijec() {
		return rijec;
	}


	public void setRijec(String rijec) {
		this.rijec = rijec;
	}


	public int getKategorija() {
		return kategorija;
	}


	public void setKategorija(int kategorija) {
		this.kategorija = kategorija;
	}


	@Override
	public String toString() {
		return "Rijeci [rijec=" + rijec + ", kategorija=" + kategorija + "]";
	}
	
}