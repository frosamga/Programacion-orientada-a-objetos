/**
 * Versión muy simplificada del juego de la 7 y media
 */
public class SieteyMedia {
	public static void main(String[] args) {
		// Se crean el mazo, el jugador y la banca
		Mazo mazo = new Mazo();
		ManoSieteyMedia jugador = new ManoSieteyMedia();
		ManoSieteyMedia banca = new ManoSieteyMedia();
		
		//comprobacion de que el mazo se cree bien 
		//System.out.println(mazo.verMazo());
	
		
		// Se reparten las cartas iniciales: una al jugador y una a la banca
		jugador.agnadeCarta(mazo.daCarta());
		System.out.println(jugador.toString()+"-");
		banca.agnadeCarta(mazo.daCarta());
		System.out.println(banca.toString());
		
		// El jugador pide cartas mientras según su estrategia
		while (jugador.cuentaPuntos() <= 5) {
			System.out.println("El jugador pide una carta extra\n");
			jugador.agnadeCarta(mazo.daCarta());
			System.out.println(jugador.toString()+"-");
		}

		// La banca se planta si el jugador se ha pasado; en caso contrario pide
		// cartas
		if (jugador.cuentaPuntos() <= 7.5) { // el jugador no se ha pasado
			while (banca.cuentaPuntos() < 7.5
					&& banca.cuentaPuntos() < jugador.cuentaPuntos()) {
				System.out.println("La banca pide una carta extra\n");
				banca.agnadeCarta(mazo.daCarta());
				System.out.println(banca.toString());
			}
		}
		// Se cuentan los puntos obtenidos y se decide el ganador
		double puntosJ = jugador.cuentaPuntos();
		double puntosB = banca.cuentaPuntos();

		if (puntosJ <= 7.5 && (puntosB > 7.5 || puntosJ > puntosB)) {
			System.out.println("Gana el jugador con \n " + jugador + " ("
					+ puntosJ + " puntos) frente a \n " + banca + " (" + puntosB
					+ " puntos) de la banca\n");
		} else if (puntosB <= 7.5) {
			System.out.println("Gana la banca con \n " + banca + " (" + puntosB
					+ " puntos) frente a \n" + jugador + " (" + puntosJ
					+ " puntos) del jugador\n");
		} else {
			System.out.println("No hay ganador: \n Jugador \n " + jugador + " ("
					+ puntosJ + " puntos) y banca \n " + banca + " (" + puntosB
					+ " puntos) se han pasado\n");
		}
	}
}
