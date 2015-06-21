public class Habitacion {

	private String codigo;
	private Cama[] camas;

	public Habitacion(int numCam, String num) {
		codigo = num;
		camas = new Cama[numCam];
		for (int i = 0; i < numCam; i++) {
			camas[i] = new Cama(codigo + "C" + i);
		}
	}

	public Cama getCama(int i) {
		return camas[i];
	}

	public boolean hayCamaLibre() {
		boolean bool = false;
		for (int i = 0; i < camas.length; i++) {
			if (camas[i].estaLibre() == true) {
				bool = true;
			}
		}
		return bool;
	}

	public int numCamas() {
		return camas.length;
	}

	public Cama camaLibre() {
		int i = 0;
		if (hayCamaLibre() == false) {
			throw new RuntimeException(
					"No quedan camas libres en esta habitacion.");
		} else {
			while (i < numCamas() && camas[i].estaLibre() == false) {
				i++;
			}
		}
		return camas[i];
	}

	public String getCodigo() {
		return codigo;
	}

	public String toString() {
		String s = "Habitacion " + codigo + ", " + numCamas() + " camas:\n";
		for (int i = 0; i < numCamas(); i++) {
			s += "    " + camas[i].toString();
		}
		return s;
	}

}
