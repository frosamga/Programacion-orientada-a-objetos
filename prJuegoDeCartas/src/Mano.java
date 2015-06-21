public abstract class Mano {

	protected int numCartas;
	private static final int TOPE = 20;
	protected Carta[] cartas;

	public Mano() {
		numCartas = TOPE;
		cartas = new Carta[numCartas];
		
		for (int i = 0; i < numCartas; i++) {
			cartas[i] = null;
		}
		
	}

	public Mano(int num) {
		numCartas = num;
		
		if (numCartas >= 0 || numCartas < TOPE) {
			cartas = new Carta[TOPE];

			for (int i = 0; i < numCartas; i++) {
				cartas[i] = null;
			}
			
		} else {
			throw new RuntimeException("no puedes tener ese numero de cartas en la mano");
		}
	}

	public void descartaTodas() {
		for (int i = 0; i < TOPE; i++) {
			cartas[i] = null;
		}
	}

	public void agnadeCarta(Carta c) {
		int i=0;
		while(i<cartas.length){
			if(cartas[i]==null){
				cartas[i]=c;
				i=cartas.length;
			}else{
				//throw new RuntimeException("estas a tope, no puedes coger mas");
				i++;
			}
		}
	}

	public int numeroCartas() {
		int contador=0;
		for (int i = 0; i < cartas.length; i++) {
			if(cartas[i]==null){
				contador+=1;
			}
		}
		return cartas.length-contador;
	}

	public abstract double cuentaPuntos();

	public String toString() {
		String res = " ";
		for (int i=0;i<cartas.length;i++) {
			if (cartas[i] != null) {
				res += cartas[i].toString() + " ";
			}
		}
		return res;
	}
}
