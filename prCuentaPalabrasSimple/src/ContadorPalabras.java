import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ContadorPalabras {

	protected PalabraEnTexto[] ArrayPal;
	protected int primLibre;

	public ContadorPalabras(int tam) {
		ArrayPal = new PalabraEnTexto[tam];
		primLibre = 0;
	}

	public ContadorPalabras() {
		this(10);
	}

	private int esta(String pal) {
		int i = 0;
		PalabraEnTexto p = new PalabraEnTexto(pal);
		while (i < primLibre) {
			if (p.equals(ArrayPal[i])) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public void incluye(String pal) {
		int pos = esta(pal);
		if (pos == -1) {
			if (primLibre == ArrayPal.length) {
				PalabraEnTexto[] nuevo = new PalabraEnTexto[ArrayPal.length * 2];
				System.arraycopy(ArrayPal, 0, nuevo, 0, ArrayPal.length);
				ArrayPal = nuevo;
			}
			ArrayPal[primLibre] = new PalabraEnTexto(pal);
			primLibre++;
		} else {
			ArrayPal[pos].incrementa();
		}
	}

	public void incluyeTodas(String linea, String del) {
		StringTokenizer st = new StringTokenizer(linea, del);
		while (st.hasMoreTokens()) {
			incluye(st.nextToken());
		}
	}

	public void incluyeTodas(String[] texto, String del) {
		for (String linea : texto) {
			if (linea != null) {
				incluyeTodas(linea, del);
			}
		}
	}

	public PalabraEnTexto encuentra(String pal) {
		for (PalabraEnTexto p : ArrayPal) {
			if (p != null) {
				StringTokenizer st = new StringTokenizer(p.toString(), " :");
				while (st.hasMoreTokens()) {
					if (st.nextToken().equalsIgnoreCase(pal)) {
						return p;
					}
				}
			}
		}
		throw new NoSuchElementException("No existe la palabra " + pal);
	}

	public String toString() {
		int salto = 1;
		StringBuilder s = new StringBuilder("");
		for (PalabraEnTexto p : ArrayPal) {
			if (p != null) {
				s.append(p.toString() + ", ");
			}
			if (salto == 10) {
				s.append("\n");
				salto = 0;
			}
			salto++;
		}

		s.delete(s.length() - 3, s.length());
		return "[" + s + "]";
	}

}
