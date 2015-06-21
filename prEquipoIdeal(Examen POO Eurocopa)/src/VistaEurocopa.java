import java.awt.event.ActionListener;


public interface VistaEurocopa {
	public static final String INICIAR_EUROCOPA = "INICIAR_EUROCOPA";
	public static final String INICIAR_EUROCOPA_JUEGO_LIMPIO = "INICIAR_EUROCOPA_JUEGO_LIMPIO";
	public static final String FORMAR_EQUIPO_IDEAL = "FORMAR_EQUIPO_IDEAL";
	public static final String FINALIZAR = "FINALIZAR";
	
	/**
	 * Pasamos el controlador.
	 */
	public void controlador(ActionListener ctr);
	
	/**
	 * Obtenemos el fichero con los datos de los equipos y jugadores.
	 * @return String con el nombre de fichero de los equipos.
	 */
	public String ficheroEquipos();
	
	/**
	 * Obtenemos el fichero con los datos de las tarjetas.
	 * @return String con el nombre de fichero de las tarjetas.
	 */
	public String ficheroTarjetas();

	/**
	 * Obtenemos el fichero para salida de datos.
	 * @return String con el nombre de fichero de salida.
	 */
	public String ficheroSalida();
	
	/**
	 * Obtenemos el n�mero de defensas para el equipo ideal
	 * @return int con el n�mero de defensas
	 */
	public int defensas();
	
	/**
	 * Obtenemos el n�mero de centrocampistas para el equipo ideal
	 * @return int con el n�mero de centrocampistas
	 */
	public int centrocampistas();
	
	/**
	 * Obtenemos el n�mero de atacantes para el equipo ideal
	 * @return int con el n�mero de atacantes
	 */
	public int atacantes();
	
	/**
	 * Mostramos un mensaje de error.
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void error(String mensaje);
	
	/**
	 * Mostramos un mensaje de informaci�n.
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void ok(String mensaje);
	
	/**
	 * Habilitamos o deshabilitamos el modo inicializaci�n o formaci�n de equipos
	 * @param b
	 *       true para habilitar el modo inicializaci�n; false para el modo formaci�n de equipos
	 */
	public void habilitarInicio(boolean b);
	
	/**
	 * A�adimos un mensaje al hist�rico.
	 * @param mensaje
	 *            String con el mensaje a a�adir.
	 */
	public void a�adirAHist�rico(String mensaje);
	
	/**
	 * Limpiamos el hist�rico.
	 */
	public void limpiar();
}
