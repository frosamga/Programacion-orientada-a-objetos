/*
//esta en comentario para probar el Bacarra
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
		banca.agnadeCarta(mazo.daCarta());
		
		// El jugador pide cartas mientras según su estrategia
		while (jugador.cuentaPuntos() <= 5) {
			System.out.println("El jugador pide una carta extra");
			jugador.agnadeCarta(mazo.daCarta());	
		}

		// La banca se planta si el jugador se ha pasado; en caso contrario pide
		// cartas
		if (jugador.cuentaPuntos() <= 7.5) { // el jugador no se ha pasado
			while (banca.cuentaPuntos() < 7.5
					&& banca.cuentaPuntos() < jugador.cuentaPuntos()) {
				System.out.println("La banca pide una carta extra");
				banca.agnadeCarta(mazo.daCarta());
			}
		}
		// Se cuentan los puntos obtenidos y se decide el ganador
		double puntosJ = jugador.cuentaPuntos();
		double puntosB = banca.cuentaPuntos();
		
		if (puntosJ <= 7.5 && (puntosB > 7.5 || puntosJ > puntosB)) {
			System.out.println("Gana el jugador con " + jugador + " \n("
					+ puntosJ + " puntos)\n frente a \n " + banca + " (" + puntosB
					+ " puntos) de la banca\n");
		} else if (puntosB <= 7.5) {
			System.out.println("Gana la banca con  " + banca + " \n(" + puntosB
					+ " puntos)\n frente a \n" + jugador + " (" + puntosJ
					+ " puntos) del jugador\n");
		} else {
			System.out.println("No hay ganador: \n Jugador \n " + jugador + " ("
					+ puntosJ + " puntos)\n y banca \n " + banca + " (" + puntosB
					+ " puntos) se han pasado\n");
		}
	}
}
*/