
//como es no comprobada, extiende de RuntimeException, si es comprobada solo de Exception
//acordate bien que el a�o pasado me equivoque y me quito mucha nota
public class AsignacionException extends RuntimeException {
	public AsignacionException(String msg) {
		super(msg);
	}
	
	public AsignacionException() {
		super();
	}
}
