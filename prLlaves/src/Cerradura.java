import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Cerradura {

	public static final int MAX_MARCAS_POR_ANCLAJES = 4;
	private List<Set<Integer>> anclajes = new ArrayList<Set<Integer>>();

	public Cerradura(int numAnclajes) throws LyCException {
		if (numAnclajes < 0) {
			throw new LyCException("Numero de anclajes no valido");
		}
		for (int i = 0; i < numAnclajes; i++) {
			anclajes.add(new TreeSet<Integer>());
		}
	}

	public void agregarMarca(int anclaje, int marca) throws LyCException {

		if (anclaje < 0 || anclaje > anclajes.size() || marca < 0 || marca > 10) {
			throw new LyCException("error de datos al agregar marca");
		}
		if (anclajes.get(anclaje).size() >= MAX_MARCAS_POR_ANCLAJES) {
			throw new LyCException("No se pueden agregar mas marcas");
		}

		anclajes.get(anclaje).add(marca);
	}

	public boolean abrir(Llave llave) {
		boolean abre = false;
		if (llave.numeroDeDientes() == anclajes.size()) {
			for (int i = 0; i < anclajes.size(); i++) {
				if (this.encajaDienteAnclaje(llave.obtenerAltura(i),
						anclajes.get(i))) {
					abre = true;
				}
			}

		}
		return abre;
	}

	private static boolean encajaDienteAnclaje(int altura, Set<Integer> anclaje) {
		boolean encaja = false;
		for (Integer a : anclaje) {
			if (altura + a == 10) {
				encaja = true;
			}
		}
		return encaja;
	}

	public String toString() {
		return anclajes.toString();
	}
}
