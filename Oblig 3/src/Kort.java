
abstract class Kort {
	private String forNavn;
	private String etterNavn;
	private int pin;
	private int kortNr;
	private int nesteKortNr = 1;
	private boolean sperretKort;
	
	public Kort(String forNavn, String etterNavn, int pin) {
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.pin = pin;
		kortNr = nesteKortNr;
		nesteKortNr++;
		sperretKort = false;
	}
	
	public String getNavn() { return (forNavn + " " + etterNavn); }
	
	public Boolean isSperret() { return sperretKort; }
	
	public Boolean sjekkPin(int pin) { return (this.pin == pin); }
	
	public String toString() {
		return ("Navn: " + forNavn + " " + etterNavn + 
				"\nPin: " + pin + "\nKortnummer: " + kortNr + 
				"\nKortet er " + (sperretKort ? "sperret" : "ikke sperret"));
	}
}
