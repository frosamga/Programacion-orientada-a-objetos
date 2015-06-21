import java.awt.event.ActionListener;

public interface VistaBacarra {
	public static final String INICIAR = "INICIAR";
	public static final String SE_PLANTA_J = "SE_PLANTA_J";
	public static final String SE_PLANTA_B = "SE_PLANTA_B";
	public static final String CARTA_EXTRA_J = "CARTA_EXTRA_J";
	public static final String CARTA_EXTRA_B = "CARTA_EXTRA_B";
	public static final String FINALIZAR = "FINALIZAR";

	/**
	 * Pasamos el controlador
	 */
	public void controlador(ActionListener ctr);

	/**
	 * Mostramos un mensaje de error.
	 * 
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void error(String mensaje);

	/**
	 * Mostramos un mensaje de informaci�n.
	 * 
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void ok(String mensaje);

	/**
	 * Se habilita el jugar, y se deshabilita el jugador y la banca
	 * 
	 * Para ello se debe hacer uso de los m�todos habilitarJugar,
	 * habilitarJugador y habilitarBanca definidos en esta misma interfaz
	 */
	public void habilitarInicio();

	/**
	 * Habilitamos/deshabilitamos los botones de iniciar y finalizar
	 * 
	 * @param b
	 *            true si queremos habilitar el bot�n "Iniciar Juego" y
	 *            deshabilitar el bot�n "Finalizar Juego". false si queremos
	 *            deshabilitar el bot�n "Iniciar Juego" y habilitar el bot�n
	 *            "Finalizar Juego".
	 */
	public void habilitarJugar(boolean b);

	/**
	 * Habilitamos o deshabilitamos el panel de jugador
	 * 
	 * @param b
	 *            true si queremos habilitar el panel del jugador. false si
	 *            queremos deshabilitarlo.
	 */
	public void habilitarJugador(boolean b);

	/**
	 * POO PR�CTICA 5.2 (Extra) 4 Habilitamos o deshabilitamos el panel de la
	 * banca
	 * 
	 * @param b
	 *            true si queremos habilitar el panel de la banca. false si
	 *            queremos deshabilitarlo.
	 */
	public void habilitarBanca(boolean b);

	/**
	 * Mostramos una nueva carta para el jugador
	 * 
	 * @param fichero
	 *            nombre del fichero con la imagen de la carta
	 */
	public void nuevaCartaJugador(String fichero);

	/**
	 * Mostramos una nueva carta para la banca
	 * 
	 * @param fichero
	 *            nombre del fichero con la imagen de la carta
	 * 
	 */
	public void nuevaCartaBanca(String fichero);

	/**
	 * Actualizamos los puntos del jugador
	 * 
	 * @param puntos
	 *            puntos totales acumulados por el jugador
	 */
	public void puntosJugador(double puntos);

	/**
	 * Actualizamos los puntos de la banca
	 * 
	 * @param puntos
	 *            puntos totales acumulados por la banca
	 */
	public void puntosBanca(double puntos);

	/**
	 * A�adimos un mensaje al hist�rico.
	 * 
	 * @param mensaje
	 *            String con el mensaje a a�adir.
	 */
	public void a�adirAHistorico(String mensaje);

	/**
	 * Limpiamos el hist�rico.
	 */
	public void limpiar();
}