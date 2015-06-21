import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class RedSocial {

	private SortedMap<Persona, SortedSet<String>> infoPersonas;

	public RedSocial(String nombreFichero) throws IOException {
		infoPersonas = new TreeMap<Persona, SortedSet<String>>();
		Scanner sc = new Scanner(new File(nombreFichero));
		leerTodo(sc);
		sc.close();
	}

	private void leerTodo(Scanner sc) {
		while (sc.hasNext()) {
			leerLinea(sc.nextLine());
		}
	}

	private void leerLinea(String s) {
		StringTokenizer st = new StringTokenizer(s, "%");
		String nombre, email;
		int edad;
		List<String> aficiones = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			try {
				nombre = st.nextToken();
				edad = Integer.parseInt(st.nextToken());
				email = st.nextToken();
				StringTokenizer gustos = new StringTokenizer(st.nextToken(),
						",");

				while (gustos.hasMoreTokens()) {
					aficiones.add(gustos.nextToken());
				}
				// System.out.println(nombre + edad + email +
				// aficiones.toString());
				infoPersonas.put(new Persona(nombre, edad, email, aficiones),
						new TreeSet<String>());
			} catch (NoSuchElementException e) {
				e.getCause();
				// throw new RedSocialException("invalido");
			} catch (NumberFormatException e) {
				e.getMessage();
				// throw new RedSocialException("invalido");
			}
		}
		
		
	}

	public void añadirPersona(Persona p) {
		infoPersonas.put(p, new TreeSet<String>());
	}

	public void añadirAmigos(Persona p, String email) {
		if (infoPersonas.containsKey(p)) {
			infoPersonas.get(p).add(email);
		} else {
			throw new RedSocialException("no se encuentra tal persona");
		}
	}

	public void añadirAmigos(Persona p, List<String> emails) {
		if (infoPersonas.containsKey(p)) {
			infoPersonas.get(p).addAll(emails);
		} else {
			throw new RedSocialException("no se encuentra tal persona");
		}
	}

	public void eliminarAmigos(Persona p, List<String> emails) {
		if (infoPersonas.containsKey(p)) {
			infoPersonas.get(p).removeAll(emails);
		} else {
			throw new RedSocialException("no se encuentra tal persona");
		}
	}

	public Persona emailPersona(String email) {
		// infoPersonas
		return null;
	}

	public void imprimirFichero(String ruta) throws FileNotFoundException {
		PrintWriter pr = new PrintWriter(new File(ruta));
		System.out.println(infoPersonas.toString());
		Iterator it = infoPersonas.entrySet().iterator();
		Iterator itv = infoPersonas.values().iterator();
		while (it.hasNext()) {
			pr.print(it.next());
			pr.println(itv.next());
		}
		pr.close();
	}
}
