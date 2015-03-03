import java.util.Date;

public class Ansatt extends Kort implements Fast {
	private double timeLonn;
	private int aarAnsiennitet;
	private static int kredittKonstant = 8;
	private static int bonusKonstant = 15;
	
	public Ansatt(String navn, int pin, double timeLonn, int aarAnsiennitet) {
		super(navn, pin);
		this.timeLonn = timeLonn;
		this.aarAnsiennitet = aarAnsiennitet;
	}
	
	public void settForNavn(String forNavn) { super.settForNavn(forNavn); }
	public String hentForNavn() { return super.hentForNavn(); }
	
	public void settEtterNavn(String etterNavn) { super.settEtterNavn(etterNavn); }
	public String hentEtterNavn() { return super.hentEtterNavn(); }
	
	public void settFulltNavn(String fulltNavn) { super.settFulltNavn(fulltNavn); }
	public String hentFulltNavn() { return super.hentFulltNavn(); }
	
	public double beregnKreditt() { return kredittKonstant * timeLonn; }
	public double beregnBonus() { return bonusKonstant * aarAnsiennitet; }
	
	public Boolean sjekkPin(int pin) {
		if(!super.isSperret()) {
			if(this.isArbeidstid()) {
				return true;
			} else {
				if(super.sjekkPin(pin)) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("deprecation")
	public Boolean isArbeidstid() {
		Date now = new Date();
		
		if(now.getDay() > 0 && now.getDay() < 6) {
			if(now.getHours() > 6 && now.getHours() < 17) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}