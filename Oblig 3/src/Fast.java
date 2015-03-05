/* Enkelt interface for bruk av 'Gjest' og 'Ansatt'.
 * Gjør at klassene må implementere grunn-funksjonene
 * som er implementert under. */
public interface Fast {
	public void settForNavn(String forNavn);
	public String hentForNavn();
	
	public void settEtterNavn(String etterNavn);
	public String hentEtterNavn();
	
	public void settFulltNavn(String fulltNavn);
	public String hentFulltNavn();
	
	public double beregnKreditt();
	public double beregnBonus();
}
