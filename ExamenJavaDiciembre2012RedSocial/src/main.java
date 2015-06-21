import java.io.FileNotFoundException;
import java.io.IOException;

/**Examen que consiste en crear una red social con datos leidos por ficheros.
 * 
 * Examen UMA programacion orientada a objetos diciembre 2012
 * 
 * @author alan
 *
 */

public class main {


	public static void main(String[] args) throws IOException {
		RedSocial rs= new RedSocial("C:/Users/alan/Desktop/ficheroEntrada.txt");
		rs.imprimirFichero("C:/Users/alan/Desktop/ficheroSalida.txt");
	}

}
