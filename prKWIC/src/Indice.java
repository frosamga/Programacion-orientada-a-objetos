import java.util.Collection;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Indice {

	protected SortedSet<Titulo> titulos;
	protected SortedMap<String, SortedSet<Titulo>> indice;
	protected String separadores;

	public Indice(String sep) {
		separadores = sep;
		indice = new TreeMap<String, SortedSet<Titulo>>();
		titulos= new TreeSet<Titulo>();

	}

	public Indice(String sep, Collection<String> frases) {
		separadores = sep;
		indice = new TreeMap<String, SortedSet<Titulo>>();
		titulos= new TreeSet<Titulo>();
		agregarTitulo(frases);
		
	}

	public void agregarTitulo(Collection<String> ct) {
		for (String tit : ct) {
			agregarTitulo(tit);
		}
	}
	//ver de nuevo,(palabra -> conjunto de títulos en los que aparece)?
	public void agregarTitulo(String t) {
		StringTokenizer str = new StringTokenizer(t, separadores);
		while (str.hasMoreTokens()) {
			String palabra = str.nextToken().toUpperCase();
			titulos.add(new Titulo(t));
			indice.put(palabra, titulos);
		}

	}

	public String presentaIndice() {
		Iterator it= indice.
	}

	public String toString() {
		return this.presentaIndice();
	}
}
