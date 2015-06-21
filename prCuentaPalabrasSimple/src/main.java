import java.util.NoSuchElementException;

public class main {
	public static void main(String[] args) {
		String[] datos = {
				"Guerra ten�a una jarra y Parra ten�a una perra, ",
				"pero la perra de Parra rompi� la jarra de Guerra.",
				"Guerra peg� con la porra a la perra de Parra. ",
				"�Oiga usted buen hombre de Parra!",
				"Por qu� ha pegado con la porra a la perra de Parra.",
				"Porque si la perra de Parra no hubiera roto la jarra de Guerra,",
				"Guerra no hubiera pegado con la porra a la perra de Parra." };
		String delimitadores = " .,:;-�!�?(){}[]";
		String[] noSig = { "CON", "LA", "A", "DE", "NO", "SI", "Y", "UNA" };
		ContadorPalabras contador = null;
		ContadorPalabrasSig contadorSig = null; // Si no se incluye un argumento
		// num�rico, se crea por defecto.
		try {
			int tam = Integer.parseInt(args[0]);
			System.out.println("Con argumento " + tam);
			contador = new ContadorPalabras();
			contadorSig = new ContadorPalabrasSig(noSig);
		} catch (RuntimeException e) {
			System.out.println("Por defecto...");
			contador = new ContadorPalabras();
			contadorSig = new ContadorPalabrasSig(noSig);
		} //
		// Incluimos todas las palabras que hay en datos // teniendo en cuenta
		// los
		// delimitadores
		contador.incluyeTodas(datos, delimitadores);
		contadorSig.incluyeTodas(datos, delimitadores);
		System.out.println(contador + "\n");
		System.out.println(contadorSig + "\n");
		try {
			System.out.println(contador.encuentra("parra"));
			System.out.println(contador.encuentra("Gorra"));
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}
	}
}
