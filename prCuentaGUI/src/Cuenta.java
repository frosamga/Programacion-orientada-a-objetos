public class Cuenta {

	private String titular;
	private double saldo;
	private int cuenta;

	public Cuenta(String tit, int cuen, double dinero) {
		titular = tit;
		cuenta = cuen;
		saldo = dinero;
	}

	public Cuenta(String tit, int cuen) {
		titular = tit;
		cuenta = cuen;
		saldo = 0;
	}

	public Cuenta() {
		titular = "nadie";
		cuenta = 0;
		saldo = 0;
	}

	public void ingreso(double a) {
		saldo = saldo + a;
	}

	public void debito(double b) {
		saldo = saldo - b;
	}

	// es mas facil crear otro ver debito.
	public double debito_obtener(double b) {
		return saldo = saldo - b;
	}

	public String titular() {
		return titular;
	}

	public double saldo() {
		return saldo;
	}

	public int cuenta() {
		return cuenta;
	}

	public String toString() {
		return "[("+titular+"/"+cuenta+") ->"+saldo+"]";
	}
}
