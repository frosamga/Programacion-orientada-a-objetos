public class Jarra {
	private int cantidad, capacidad;

	public Jarra(int capacidadInicial) {
		capacidad = capacidadInicial;
		cantidad = 0;
	}

	public Jarra() {
		capacidad = 0;
		cantidad = 0;
	}

	public int capacidad() {
		return capacidad;
	}

	public int cantidad() {
		return cantidad;
	}

	public void llena() {
		cantidad = capacidad;
	}

	public void vac�a() {
		cantidad = 0;
	}

	public void llenaDesde(Jarra j) {
		cantidad = cantidad + j.cantidad;
		// sobrepasa pero no se pierde, luego la comprobacion se hace despues
		if (this.cantidad > this.capacidad) {
			j.cantidad = (cantidad - capacidad);
			this.llena();

		} else {
			j.vac�a();
		}
	}

	public String toString() {
		return "cantidad: " + cantidad + " capacidad: " + capacidad;
	}
}
