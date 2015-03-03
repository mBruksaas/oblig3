import java.util.Date;

public class Gjest extends Kort {
	private static int pin = 9999;
	private Date dato;
	private Date datoUtgaar;
	
	@SuppressWarnings("deprecation")
	public Gjest(String navn) {
		super(navn, pin);
		dato = new Date();
		datoUtgaar = (Date) dato.clone();
		datoUtgaar.setDate(datoUtgaar.getDate() + 7);
	}
	
	public Gjest(String navn, int pin, int kortNr, boolean sperretKort,
					Date dato, Date datoUtgaar) {
		super(navn, pin, kortNr, sperretKort);
		this.dato = dato;
		this.datoUtgaar = datoUtgaar;
	}
	
	public Gjest clone() {
		Gjest g = new Gjest(this.hentFulltNavn(), this.hentPin(),
							this.hentKortNr(), this.hentSperretKort(),
							(Date)dato.clone(), (Date)datoUtgaar.clone());
		return g;
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
