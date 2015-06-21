import java.util.*;

public class Mazo {
	private int numCartas;
	private static Random alea;
	private Carta[] mazo;

	public Mazo() {
		numCartas = 52;
		mazo = new Carta[numCartas];
		alea = new Random();
		baraja();
	}
	
	//solo me sirve de comprobacion para ver si esta bien
	public String verMazo(){
		String aux="en el mazo hay: ";
		for(int i=0;i<mazo.length;i++){
			aux=aux+mazo[i]+"\n";
		}
		return aux;
	}
	
	public void baraja() {
		int a;
		Palo b;
		// si esta la carta repetida entonces vuelve a llamar a aleatorio.
		for (int i = 0; i < mazo.length; i++) {
			a = alea.nextInt(13) + 1;
			b = devuelvePalo();
			while (estaEn(mazo, a, b)) {
				a = alea.nextInt(13) + 1;
				b = devuelvePalo();
			}
			mazo[i] = new Carta(a, b);
		}
	}

	private boolean estaEn(Carta[] mazo, int a, Palo palo) {
		boolean es = false;

		for (int i = 0; i < mazo.length; i++) {
			if (mazo[i] != null && mazo[i].valor() == a
					&& mazo[i].palo() == palo) {
				es = true;
			}

		}
		return es;
	}

	// sirve para hacer un aleatorio de palo, convirtiendolo primero en un array y luego destransformandolo.
	private Palo devuelvePalo() {
		int x = new Random().nextInt(Palo.values().length);
		return Palo.values()[x];
	}

	public int numeroCartas() {
		return numCartas;
	}

	public Carta daCarta() {

		alea = new Random();
		Carta naipe = null;
		int aleatorio=0; 
		//meto el hueco que queda donde saque el naipe la ultima carta, y luego bajo una posicion
		if (numCartas <= 0) {
			throw new RuntimeException("El mazo esta vacio.");
		} else {
			aleatorio = alea.nextInt(numCartas);
			naipe = mazo[aleatorio];
			mazo[aleatorio] = mazo[numCartas - 1];
			mazo[numCartas - 1] = null;
			numCartas--;
		}
		return naipe;
	}

}
