import java.util.Date;

public class Gjest extends Kort {
	private static int pin = 9999;
	private Date dato;
	private Date datoUtgaar;
	
	@SuppressWarnings("deprecation")
	public Gjest(String forNavn, String etterNavn) {
		super(forNavn, etterNavn, pin);
		dato = new Date();
		datoUtgaar = (Date) dato.clone();
		datoUtgaar.setDate(datoUtgaar.getDate() + 7);
	}
	
	public Boolean sjekkPin(int pin) {
		Date now = new Date();
		
		if(!super.isSperret()) {
			if(now.compareTo(datoUtgaar) < 1) {
				if(super.sjekkPin(pin)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
