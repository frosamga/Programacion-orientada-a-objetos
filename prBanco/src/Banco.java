public class Banco {
	private Cuenta[] ctas;
	private static final int NCTAS = 10;
	private static final int NUMCTALIBRE = 1001;
	private String nombre;
	private int ppl = 0;
	private int unca = NUMCTALIBRE;

	public Banco(String entidad) {
		this(entidad, NCTAS);
	}

	public Banco(String entidad, int a) {
		nombre = entidad;
		ctas = new Cuenta[a];
	}

	public int abrirCuenta(String nombreTitular, double saldo) {

		Cuenta[] ctas1 = ctas;
		if (ctas[ctas.length - 1] == null) {
			ctas[ppl] = new Cuenta(nombreTitular, unca, saldo);
			ppl++;
			unca++;
		} else {
			System.arraycopy(ctas, 0, ctas1, 0, 2 * ctas.length);
		}
		return unca - 1;
	}

	public int abrirCuenta(String nombreTitular) {
		ctas[ppl] = new Cuenta(nombreTitular, unca, 0);
		ppl++;
		unca++;
		return unca - 1;
	}

	public void cerrarCuenta(int numCuenta) {
		for (int a = posicionCuenta(numCuenta); a < ctas.length - 1; a++) {
			ctas[a] = ctas[a + 1];
		}
	}

	private int posicionCuenta(int cuent) {
		int aux = 0;
		int i = 0;
		boolean b = false;

		while ((i < ctas.length) && (ctas[i]) != null) {
			if (ctas[i].cuenta() == cuent) {
				aux = i;
				b = true;
			}
			i++;
		}

		if (!b) {
			throw new RuntimeException("No existe la cuenta dada");
		}
		return aux;
	}

	public void ingreso(int cuenta, double dinero) {
		ctas[posicionCuenta(cuenta)].ingreso(dinero);
	}

	public double debito(int cuenta, double dinero) {
		double saldo;
		if (dinero <= ctas[posicionCuenta(cuenta)].saldo()) {
			saldo = ctas[posicionCuenta(cuenta)].debito_obtener(dinero);
		} else {
			saldo = ctas[posicionCuenta(cuenta)].debito_obtener(ctas[posicionCuenta(cuenta)].saldo());
		}
		return saldo;
	}

	public double saldo(int cuenta) {
		return ctas[posicionCuenta(cuenta)].saldo();
	}

	// que tiene que devolver con double?
	public void transferencia(int cuenta1, int cuenta2, double dinero) {
		double sueldo_ingresar;
		if (dinero > ctas[posicionCuenta(cuenta1)].saldo()) {
			ctas[posicionCuenta(cuenta2)].ingreso(ctas[posicionCuenta(cuenta1)]
					.saldo());
			this.debito(cuenta1, ctas[posicionCuenta(cuenta1)].saldo());

		} else {
			sueldo_ingresar = dinero;
			debito(cuenta1, dinero);
			ingreso(cuenta2, dinero);
		}

	}

	public String toString() {
		String aux = "[";
		int i = 0;
		while ((i < ctas.length) && (ctas[i] != null)) {
			aux = aux + ctas[i].toString();
			i++;
		}
		return aux + "]";
	}
}
