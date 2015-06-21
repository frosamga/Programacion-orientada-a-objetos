import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		String[] datos = { "La rosa púrpura del Cairo", "La rosa del azafrán",
				"El color Púrpura" };
		List<String> frases = Arrays.asList(datos);
		String separadores = " ,;.:()¿!¡?";
		Indice index = new Indice(separadores, frases);
		System.out.println(index.presentaIndice());
		String[] noSig = { "el", "ella", "la", "lo", "un", "una", "del" };
		Collection<String> colNoSig = Arrays.asList(noSig);
		IndiceSignificativas indexSig = new IndiceSignificativas(separadores,
				frases, colNoSig);
		System.out.println(indexSig.presentaIndice());
	}
}