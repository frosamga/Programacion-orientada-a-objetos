import java.util.ArrayList;
import java.util.List;

public class Llave {

	public static final int MAX_ALTURA_DIENTE = 10;
	private List<Integer> dientes;

	public Llave(int numDientes) throws LyCException {
		if (numDientes <= 0) {
			throw new LyCException("Numero de dientes no valido");
		}
		dientes = new ArrayList<Integer>();
		for (int i = 0; i < numDientes; i++) {
			dientes.add(MAX_ALTURA_DIENTE);
		}
	}

	public void limarDiente(int diente, int altura) throws LyCException {	
		if (diente < 0 || diente > dientes.size() || altura < 0 || altura > 10) {
			throw new LyCException("error al limar");
		}
		
		dientes.set(diente, dientes.get(diente)-altura);
	}

	public int obtenerAltura(int diente) {
		return dientes.get(diente);
	}

	public int numeroDeDientes() {
		return dientes.size();
	}

	public String toString() {
		StringBuilder cad = new StringBuilder();
		cad.append("(");
		for (int i = 0; i < dientes.size(); i++) {
			cad.append(dientes.get(i) + ",");
		}
		cad.deleteCharAt(cad.length()-1);
		cad.append(")");
		return cad.toString();
	}
}
