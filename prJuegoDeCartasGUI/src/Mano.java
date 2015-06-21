public abstract class Mano {

	protected int numCartas;
	private static final int TOPE = 20;
	protected Carta[] cartas;

	public Mano() {
		numCartas = TOPE;
		cartas = new Carta[numCartas];
	}

	public Mano(int num) {
		numCartas = num;
		if (numCartas >= 0 || numCartas < TOPE) {
			cartas = new Carta[numCartas];
		} else {
			throw new RuntimeException(
					"no puedes tener ese numero de cartas en la mano");
		}
	}

	public void descartaTodas() {
		for (int i = 0; i < TOPE; i++) {
			cartas[i] = null;
		}
	}

	public void agnadeCarta(Carta c) {
		boolean lleno = true;
		int i = 0;
		while (i < cartas.length) {
			
			if (cartas[i] == null) {
				cartas[i] = c;
				i = cartas.length;
			} else{
				i++;
			}
		}
		for(int a=0;a<cartas.length;a++){
			if(cartas[a]==null){
				lleno=false;
			}
		}
		if (lleno) {
			throw new RuntimeException(
					"Estas a tope, no puedes coger mas cartas");
		}
	}

	public int numeroCartas() {
		int contador = 0;
		for (int i = 0; i < cartas.length; i++) {
			if (cartas[i] == null) {
				contador += 1;
			}
		}
		return cartas.length - contador;
	}

	public abstract double cuentaPuntos();

	public String toString() {
		String res = " ";
		for (int i = 0; i < cartas.length; i++) {
			if (cartas[i] != null) {
				res += cartas[i].toString() + " ";
			}
		}
		return res;
	}
}
