

public class Jarra {
	
	private int contenido;

	
	private final int capacidad;

	
	public Jarra(int capacidadInicial) {
		if (capacidadInicial <= 0) {
			throw new RuntimeException(
					"La capacidad de una jarra debe ser un número mayor que cero.");
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

	
	public void vacía() {
		contenido = 0;
	}

	
	public void llenaDesde(Jarra j) {
		int cantidadMínima = Math.min(capacidad - contenido, j.contenido());
	
		contenido = contenido + cantidadMínima;
		j.contenido = j.contenido - cantidadMínima;
	}

	
	public String toString() {
		return "(" + contenido + ", " + capacidad + ")";
	}
}
