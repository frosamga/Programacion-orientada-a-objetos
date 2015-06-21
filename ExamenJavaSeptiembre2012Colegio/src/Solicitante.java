public class Solicitante implements Comparable<Solicitante> {
	private String nif; // NIF del tutor del solicitante
	private String nombre; // Nombre del solicitante
	private double puntos; // Numero de puntos resultado de la baremación
	private boolean tienePlaza; // Indica si el solicitante tiene o no tiene
								// plaza

	public Solicitante(String nif, String nombre, double puntos) {
		this.nif = nif;
		this.nombre = nombre;
		this.puntos = puntos;
		tienePlaza = false; // Inicialmente el solicitante no tiene plaza
	}

	// el compare y el equals nunca deben entrar en conflicto
	// si es compare acordate que devuelve -1,si es menor, 0 si es igual y 1 si
	// es mayor
	public int compareTo(Solicitante j) {
		int res;

		if (this.getPuntos() > j.getPuntos())
			res = -1;
		else if (this.getPuntos() < j.getPuntos())
			res = 1;
		else
			res = this.getNombre().compareToIgnoreCase(j.getNombre());
		return res;

	}

	// en este acordate del hashcode y que es de entrada Object o, y entonces
	// haces o instanceof Solicitante
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Solicitante) {
			Solicitante j = (Solicitante) o;
			res = nif.equalsIgnoreCase(j.nif)
					&& nombre.equalsIgnoreCase(j.nombre) && puntos == j.puntos;
		}
		return res;
	}

	// podes pasarlo como minusculas o como mayusculas, y usas los valores que
	// usaste en el equals
	public int hasCode() {
		return nif.toLowerCase().hashCode() + nombre.toLowerCase().hashCode()
				+ (int) puntos;
	}

	public void setTienePlaza(boolean plaza) {
		tienePlaza = plaza;
	}

	public boolean getTienePlaza() {
		return tienePlaza;
	}

	public String getNIF() {
		return nif;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPuntos() {
		return puntos;
	}

	public String toString() {
		return nif + " " + puntos + " " + nombre;
	}

}
