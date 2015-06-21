import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.SortedSet;


public class ControladorEurocopa implements ActionListener{
	private VistaEurocopa vista;
	private Eurocopa eurocopa;
	
	public ControladorEurocopa(VistaEurocopa v){
		vista=v;
		vista.ok("Introduzca nombre de ficheros y tope de tarjetas y pulse Boton Iniciar preferido");
		vista.habilitarInicio(true);
	}
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		try{
			if(comando.equals(VistaEurocopa.INICIAR_EUROCOPA)){
				eurocopa=new Eurocopa(vista.ficheroEquipos());
				vista.ok("Datos leidos, puede formar equipo ideal");
				vista.habilitarInicio(false);
			}else if(comando.equals(VistaEurocopa.INICIAR_EUROCOPA_JUEGO_LIMPIO)){
				eurocopa=new EurocopaJuegoLinpio(vista.ficheroEquipos(),vista.ficheroTarjetas());
				vista.ok("Datos leidos,puede formar equipo ideal");
				vista.habilitarInicio(false);
			}else if(comando.equals(VistaEurocopa.FORMAR_EQUIPO_IDEAL)){
				SortedSet<Jugador>ideal=eurocopa.formarEquipoIdeal(vista.defensas(), vista.centrocampistas(),vista.atacantes());
				vista.añadirAHistórico(Eurocopa.toString(ideal));
				Eurocopa.mostrarEquipoIdeal(vista.ficheroSalida(),ideal);
				vista.ok("Equipo formado");
			}else if(comando.equals(VistaEurocopa.FINALIZAR)){
				vista.limpiar();
				vista.ok("Introduzca nombre de ficheros y tope de tarjetas y pulse Boton Iniciar preferido");
				vista.habilitarInicio(true);
			}
		}catch(EurocopaException exc){
			vista.error("Error: "+exc.getMessage());
		}catch(IOException exc){
			vista.error("Error de entrada/salida: "+exc.getMessage());
		}catch(RuntimeException exc){
			vista.error("Error falta algun dato: ");
		}
	}
}
