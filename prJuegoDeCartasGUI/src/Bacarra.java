
public class Bacarra {
	public static void main(String[] args) {
		double puntosJ;
		double puntosB;

		Mazo mazo = new Mazo();
		ManoBacarra jugador = new ManoBacarra();
		ManoBacarra banca = new ManoBacarra();

		// Se reparten las cartas iniciales: una al jugador y una a la banca
		jugador.agnadeCarta(mazo.daCarta());
		jugador.agnadeCarta(mazo.daCarta());
		banca.agnadeCarta(mazo.daCarta());
		banca.agnadeCarta(mazo.daCarta());

		puntosJ = jugador.cuentaPuntos();
		puntosB = banca.cuentaPuntos();

		if (jugador.esNatural()) {
			System.out.println("Gana el jugador con " + jugador + " \n"
					+"por ser Natural con :"+ puntosJ);

		} else if (banca.esNatural()) {
			System.out.println("Gana la banca con  " + banca + " \n" +
					"por ser Natural con: "+puntosB);
		}else if(jugador.esNatural()&&banca.esNatural()){
			System.out.println("Empate por naturales con jugador: "+puntosJ+"y banco"+puntosB);
		}else {
			System.out.println("El jugador pide una carta extra");
			jugador.agnadeCarta(mazo.daCarta());
			System.out.println("La banca pide una carta extra");
			banca.agnadeCarta(mazo.daCarta());

			while (jugador.cuentaPuntos() <= 5) {
				System.out.println("El jugador pide una carta extra");
				jugador.agnadeCarta(mazo.daCarta());

			}
			// tomare en cuenta si solo tiene menos puntos que el jugador.
			while (banca.cuentaPuntos() < jugador.cuentaPuntos()) {
				System.out.println("La banca pide una carta extra");
				banca.agnadeCarta(mazo.daCarta());
			}
			puntosJ = jugador.cuentaPuntos();
			puntosB = banca.cuentaPuntos();

			double contadorJugador = Math.abs(9 - puntosJ);
			double contadorBanca = Math.abs(9 - puntosB);
			if (contadorJugador < contadorBanca) {
				System.out.println("Gana el jugador con " + jugador + " \n("
						+ puntosJ + " puntos)\n frente a \n " + banca + " ("
						+ puntosB + " puntos) de la banca\n");

			} else if (contadorBanca < contadorJugador) {
				System.out.println("Gana la banca con  " + banca + " \n("
						+ puntosB + " puntos)\n frente a \n" + jugador + " ("
						+ puntosJ + " puntos) del jugador\n");

			} else {
				System.out.println("Empate!: \n Jugador \n " + jugador + " ("
						+ puntosJ + " puntos)\n y banca \n " + banca + " ("
						+ puntosB + " puntos)\n");
			}
		}
	}
}