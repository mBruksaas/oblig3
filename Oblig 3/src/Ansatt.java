import java.util.Date;

public class Ansatt extends Kort {
	
	public Ansatt(String forNavn, String etterNavn, int pin) {
		super(forNavn, etterNavn, pin);
	}
	
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