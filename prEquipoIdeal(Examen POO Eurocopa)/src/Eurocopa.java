import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class Eurocopa {
	protected SortedMap<Equipo, List<Jugador>>puntuaciones;
	public Eurocopa(String nombreFichero)throws IOException{
		puntuaciones=new TreeMap<Equipo, List<Jugador>>();
		leerPuntuaciones(nombreFichero);
	}
	private void leerPuntuaciones(String nombreFichero)throws IOException {
		BufferedReader bf=new BufferedReader(new FileReader(nombreFichero));
		leer(bf);
		bf.close();
	}
	private void leer(BufferedReader bf)throws IOException {
		String lineaEquipo= bf.readLine();
		while(lineaEquipo!=null){
			procesarEquipo(lineaEquipo,bf);
			lineaEquipo=bf.readLine();
		}
	}
	private void procesarEquipo(String lineaEquipo, BufferedReader bf) throws IOException{
		StringTokenizer st=new StringTokenizer(lineaEquipo," ");
		try{
			String nombre=st.nextToken();
			System.out.println(nombre);
			int votos=Integer.parseInt(st.nextToken());
			System.out.println(votos);
			int numJugadores=Integer.parseInt(st.nextToken());
			System.out.println(numJugadores);
			Equipo equipo=new Equipo(nombre,votos);
			procesarJugadores(equipo,numJugadores,bf);
		}catch(NoSuchElementException e){
			throw new EurocopaException("Error datos equipo");
		}catch(NumberFormatException e){
			throw new EurocopaException("Error formato equipo");
		}
	}
	private void procesarJugadores(Equipo equipo, int numJugadores,BufferedReader br)throws IOException {
		List<Jugador>jugadores=new ArrayList<Jugador>();
		for(int cont=0;cont<=numJugadores;cont++){
			String lineaJugador=br.readLine();
			StringTokenizer st=new StringTokenizer(lineaJugador," ");
			try{
				String nombre=st.nextToken();
				System.out.println(nombre);
				String demarcacion=st.nextToken();
				System.out.println(demarcacion);
				int valoracion=Integer.parseInt(st.nextToken());
				System.out.println(valoracion);
				Jugador j=new Jugador(nombre,demarcacion,valoracion);
				jugadores.add(j);
			}catch(NoSuchElementException e){
				throw new EurocopaException("Error datos jugadores");
			}catch(NumberFormatException e){
				throw new EurocopaException("Error formato jugadores");
			}
		}
		puntuaciones.put(equipo, jugadores);
	}
	public SortedSet<Jugador>formarEquipoIdeal(int defensa,int centro,int ataque)throws IOException{
		SortedSet<Jugador>ideal=new TreeSet<Jugador>();
		ideal.addAll(elegir(defensa,"DEFENSA"));
		ideal.addAll(elegir(centro,"CENTRO"));
		ideal.addAll(elegir(ataque,"ATAQUE"));
		return ideal;
	}
	private SortedSet <Jugador> elegir(int numJugadores, String demarcacion) {
		SortedSet<Jugador>elegir=new TreeSet<Jugador>();
		int contNumJugadores=0;
		Set<Equipo>equipos=puntuaciones.keySet();
		int numEquiConsultar=equipos.size();
		
		Iterator<Equipo>itr=equipos.iterator();
		while((contNumJugadores<numJugadores)&&(numEquiConsultar>0)){
			if(itr.hasNext()){
				Jugador j=seleccionarJugador(itr.next(),demarcacion);
			}
		}
		return null;
	}
	protected Jugador seleccionarJugador(Equipo e,String demarcacion){
		List<Jugador>jugadores=new ArrayList<Jugador>();
		Iterator<Jugador>iter=jugadores.iterator();
		Jugador res=null;
		while((res==null)&&iter.hasNext()){
			Jugador j=iter.next();
			if(!j.getElegido()&&(demarcacion.equalsIgnoreCase(j.getDemarcacion()))){
				res=j;
			}
		}
		if(res!=null){
			while(iter.hasNext()){
				Jugador j=iter.next();
				if((!j.getElegido())&&(demarcacion.equalsIgnoreCase(j.getDemarcacion()))&&(j.compareTo(res)<0)){
					res=j;
				}
			}
		}
		return res;
	}
	public static String toString(SortedSet<Jugador>ideal) {
		StringBuilder sb=new StringBuilder();
		for(Jugador j:ideal){
			sb.append(j.toString()).append("/n");
		}
		return sb.toString();
	}
	public static void mostrarEquipoIdeal(SortedSet<Jugador>ideal){
		System.out.println(toString(ideal));
	}
	public static void mostrarEquipoIdeal(String nombreFichero,SortedSet<Jugador>ideal)throws FileNotFoundException{
		PrintWriter pw=new PrintWriter(nombreFichero);
		pw.println(toString(ideal));
		pw.close();
	}
}
