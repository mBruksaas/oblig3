
abstract class Kort implements Comparable<Kort>, Cloneable {
	private String forNavn;
	private String etterNavn;
	private int pin;
	private int kortNr;
	private static int nesteKortNr = 1;
	private boolean sperretKort;
	
	public abstract Kort clone();
	public int hentPin() { return pin; }
	public int hentKortNr() { return kortNr; }
	public boolean hentSperretKort() { return sperretKort; }
	
	public Kort(String navn, int pin, int kortNr, boolean sperretKort) {
		this.settFulltNavn(navn);
		this.pin = pin;
		this.kortNr = kortNr;
		this.sperretKort = sperretKort;
	}
	
	public Kort(String navn, int pin) {
		this.settFulltNavn(navn);
		this.pin = pin;
		kortNr = nesteKortNr;
		nesteKortNr++;
		sperretKort = false;
	}
	
	public int compareTo(Kort k) {
		if(etterNavn.compareTo(k.hentEtterNavn()) > 0) {
			return 1;
		} else if(etterNavn.compareTo(k.hentEtterNavn()) < 0) {
			return -1;
		} else {
			if(forNavn.compareTo(k.hentForNavn()) > 0) {
				return 1;
			} else if(forNavn.compareTo(k.hentForNavn()) < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	public void settForNavn(String forNavn) { this.forNavn = forNavn; }
	public String hentForNavn() { return forNavn; }
	
	public void settEtterNavn(String etterNavn) { this.etterNavn = etterNavn; }
	public String hentEtterNavn() { return etterNavn; }
	
	public void settFulltNavn(String fulltNavn) {
		String[] navn = fulltNavn.split(" ");
		this.forNavn = navn[0];
		this.etterNavn = "";
		for(int i = 1; i < navn.length; i++) {
			this.etterNavn += navn[i] + " ";
		}
	}
	public String hentFulltNavn() { return (forNavn + " " + etterNavn); }
	
	public Boolean isSperret() { return sperretKort; }
	
	public Boolean sjekkPin(int pin) { return (this.pin == pin); }
	
	public String toString() {
		return ("Navn: " + forNavn + " " + etterNavn + 
				"\nPin: " + pin + "\nKortnummer: " + kortNr + 
				"\nKortet er " + (sperretKort ? "sperret" : "ikke sperret"));
	}
}