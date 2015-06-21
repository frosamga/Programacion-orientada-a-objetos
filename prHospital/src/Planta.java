public class Planta {

	private String codigo;
	private Habitacion[] habitaciones;

	public Planta(int numHab, String num) {
		codigo = num;
		habitaciones = new Habitacion[numHab];
		for (int i = 0; i < numHab; i++) {
			habitaciones[i] = new Habitacion(4, codigo + "H" + i);
		}
	}

	public Habitacion getHabitacion(int i) {
		return habitaciones[i];
	}

	public int numHabitaciones() {
		return habitaciones.length;
	}

	public boolean hayCamaLibre() {
		boolean bool = false;
		for (int i = 0; i < numHabitaciones(); i++) {
			if (habitaciones[i].hayCamaLibre() == true) {
				bool = true;
			}
		}
		return bool;
	}

	public Cama camaLibre() {
		int i = -1;
		boolean br = false;
		if (hayCamaLibre() == false) {
			throw new RuntimeException("No quedan camas libres en esta planta.");
		} else {
			while (i < numHabitaciones() && br == false) {
				i++;
				if (habitaciones[i].hayCamaLibre() == true) {
					br = true;
				}
			}
		}
		return habitaciones[i].camaLibre();
	}

	public String getCodigo() {
		return codigo;
	}

	public String toString() {
		String s = "Planta " + codigo + ", " + numHabitaciones()
				+ " habitaciones:\n";
		for (int i = 0; i < numHabitaciones(); i++) {
			s += "  " + habitaciones[i].toString();
		}
		return s;
	}

}
