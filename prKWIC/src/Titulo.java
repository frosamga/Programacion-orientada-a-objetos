import java.util.StringTokenizer;

public class Titulo implements Comparable<Titulo> {

	private String titulo;

	public Titulo(String t) {
		titulo = t;
	}

	public boolean equals(Object o) {
		return (o instanceof Titulo)
				&& (((Titulo) o).titulo.equalsIgnoreCase(this.titulo));
	}

	public int hashCode() {
		return titulo.toLowerCase().hashCode();
	}

	public int compareTo(Titulo t) {
		return titulo.compareToIgnoreCase(t.titulo);
	}

	/*
	public String replace(String pal) {
		StringBuilder sb = new StringBuilder(titulo);
		String palabraAux = pal.toUpperCase();
		String sbAux = sb.toString().toUpperCase();
		int ind = sbAux.indexOf(palabraAux);
		while (ind > 0) {
			sb.replace(ind, ind + pal.length(), "...");
			sbAux = sb.toString().toUpperCase();
			int ind = sbAux.indexOf(palabraAux);
		}
		return sb.toString();
	}
	*/

	public String replace(String pal) {
		return pal.replaceAll(pal, "...");
	}

	public String toString() {
		return titulo.toUpperCase();
	}
}
