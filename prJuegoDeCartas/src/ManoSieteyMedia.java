public class ManoSieteyMedia extends Mano {

	public double cuentaPuntos() {
		double contador = 0;
		//numero de cartas que hay en la mano, si es asi entonces hay que mover el array en mano, cuidado con eso!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		for (int i = 0; i < super.numeroCartas(); i++) {
			if (cartas[i] == null) {
				contador += 0;
			} else if (super.cartas[i].valor() >= 1
					&& super.cartas[i].valor() <= 7) {
				contador += super.cartas[i].valor();
			} else if (super.cartas[i].valor() >= 11
					&& super.cartas[i].valor() <= 13) {
				contador += 0.5;
			}
			
		}
		return contador;
	}
}