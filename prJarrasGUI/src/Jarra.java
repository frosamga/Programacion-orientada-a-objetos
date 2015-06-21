

public class Jarra {
	
	private int contenido;

	
	private final int capacidad;

	
	public Jarra(int capacidadInicial) {
		if (capacidadInicial <= 0) {
			throw new RuntimeException(
					"La capacidad de una jarra debe ser un n�mero mayor que cero.");
		}
		capacidad = capacidadInicial;
		contenido = 0;
	}

	
	public int capacidad() {
		return capacidad;
	}

	
	public int contenido() {
		return contenido;
	}

	
	public void llena() {
		contenido = capacidad;
	}

	
	public void vac�a() {
		contenido = 0;
	}

	
	public void llenaDesde(Jarra j) {
		int cantidadM�nima = Math.min(capacidad - contenido, j.contenido());
	
		contenido = contenido + cantidadM�nima;
		j.contenido = j.contenido - cantidadM�nima;
	}

	
	public String toString() {
		return "(" + contenido + ", " + capacidad + ")";
	}
}
