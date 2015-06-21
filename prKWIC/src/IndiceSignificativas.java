import java.util.Collection;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class IndiceSignificativas extends Indice {

	private SortedSet<String> noSignificativas;

	public IndiceSignificativas(String separadores, Collection<String> noSig) {
		super(separadores);
		noSignificativas = new TreeSet<String>();
		for (String str : noSig) {
			noSignificativas.add(str.toUpperCase());
		}
	}
	
	public IndiceSignificativas(String sep,Collection<String> colTit,Collection<String> noSig){
		this(sep,noSig);
		this.agregarTitulo(colTit);
	}
	
	public void agregarTitulo(String t) {
		StringTokenizer str = new StringTokenizer(t, separadores);
		while (str.hasMoreTokens()) {
			String palabra = str.nextToken().toUpperCase();
			//seguir
		}

	}
	
}
