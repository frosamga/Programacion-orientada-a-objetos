import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class EurocopaJuegoLinpio extends Eurocopa{
	List<String>jugadoresNoPermitidos;
	public EurocopaJuegoLinpio(String ficheroPuntuaciones,String ficherotarjetas) throws IOException {
		super(ficheroPuntuaciones);
		jugadoresNoPermitidos=new ArrayList<String>();
		leerTarjetas(ficherotarjetas);
	}
	private void leerTarjetas(String ficherotarjetas)throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(ficherotarjetas));
		leer(br);
		br.close();
	}
	private void leer(BufferedReader br)throws IOException{
		String nombreJugador=br.readLine();
		while(nombreJugador!=null){
			jugadoresNoPermitidos.add(nombreJugador);
			nombreJugador=br.readLine();
		}
	}
	protected Jugador seleccionarJugador(Equipo e,String demarcacion){
		List<Jugador>jugadores=puntuaciones.get(e);
		Iterator<Jugador>iter=jugadores.iterator();
		Jugador res=null;
		while((res==null)&&iter.hasNext()){
			Jugador j=iter.next();
			if((!j.getElegido())&&(demarcacion.equalsIgnoreCase(j.getDemarcacion()))&&(jugadoresNoPermitidos.contains(j.getNombre()))){
				res=j;
			}
		}
		if(res!=null){
			while(iter.hasNext()){
				Jugador j=iter.next();
				if((!j.getElegido())&&(demarcacion.equalsIgnoreCase(j.getDemarcacion()))&&(jugadoresNoPermitidos.contains(j.getNombre()))&&(j.compareTo(res)<0)){
					res=j;
				}
			}
		}
		return res;
	}
}
