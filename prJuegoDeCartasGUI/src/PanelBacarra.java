import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelBacarra extends JPanel implements VistaBacarra {
	private JButton InicJuego, FinJuego, CartaExtraJ,CartaExtraB,MePlantoJ,MePlantoB;
	private JLabel jugador,banca, ImagenCartas1, ImagenCartas2, ImagenCartas3,
			ImagenCartas4, ImagenCartas5, ImagenCartas6, carta1, carta2,
			carta3,puntos;
	private ImageIcon imagen1,imagen2,imagen3,imagen4,imagen5,imagen6;
	private JTextField puntosTextoJ,puntosTextoB;
	
	
	public PanelBacarra() {

		InicJuego = new JButton("Iniciar Juego");
		FinJuego = new JButton("Finalizar Juego");
		MePlantoJ = new JButton("Me planto");
		MePlantoB = new JButton("Me planto");
		jugador = new JLabel("Jugador");
		banca = new JLabel("Banco");
		imagen1 = new ImageIcon("/Imagenes/usar String");
		ImagenCartas1 = new JLabel(imagen1);
		imagen2 = new ImageIcon("/Imagenes/usar String");
		ImagenCartas2 = new JLabel(imagen2);
		imagen3 = new ImageIcon("/Imagenes/usar String");
		ImagenCartas3 = new JLabel(imagen3);
		imagen4 = new ImageIcon("/Imagenes/usar String");
		ImagenCartas4 = new JLabel(imagen4);
		imagen5 = new ImageIcon("/Imagenes/usar String");
		ImagenCartas5 = new JLabel(imagen5);
		imagen6 = new ImageIcon("/Imagenes/usar String");
		ImagenCartas6 = new JLabel(imagen6);
		carta1 = new JLabel("Carta1");
		CartaExtraJ = new JButton("Carta extra");
		CartaExtraB = new JButton("Carta extra");
		puntos = new JLabel("Puntos:");
		puntosTextoJ= new JTextField(5);
		puntosTextoB= new JTextField(5);
		
		

		JPanel sup = new JPanel();
		sup.setLayout(new FlowLayout());
		sup.add(InicJuego);
		sup.add(FinJuego);

		// aqui va el panel de la 1º carta,
		JPanel medioSupIzq1 = new JPanel();
		medioSupIzq1.setLayout(new GridLayout(1, 2));
		medioSupIzq1.add(ImagenCartas1);
		medioSupIzq1.add(carta1);

		JPanel medioSupIzq2 = new JPanel();
		medioSupIzq2.setLayout(new BorderLayout());
		medioSupIzq2.add(CartaExtraJ);

		JPanel medioSupIzq = new JPanel();
		medioSupIzq.setLayout(new BorderLayout());
		medioSupIzq.add(medioSupIzq1, BorderLayout.NORTH);
		medioSupIzq.add(medioSupIzq2, BorderLayout.SOUTH);

		// la 2º carta del jugador
		JPanel medioSupCen1 = new JPanel();
		medioSupCen1.setLayout(new GridLayout(1, 2));
		medioSupCen1.add(ImagenCartas2);
		medioSupCen1.add(carta2);

		JPanel medioSupCen2 = new JPanel();
		medioSupCen2.setLayout(new BorderLayout());
		medioSupCen2.add(MePlantoJ);

		JPanel medioSupCen = new JPanel();
		medioSupCen.setLayout(new BorderLayout());
		medioSupCen.add(medioSupCen1, BorderLayout.NORTH);
		medioSupCen.add(medioSupCen2, BorderLayout.SOUTH);

		//la 3º carta de jugador
		JPanel medioSupDer1 = new JPanel();
		medioSupDer1.setLayout(new GridLayout(1, 2));
		medioSupDer1.add(ImagenCartas3);
		medioSupDer1.add(carta3);

		JPanel medioSupDer2 = new JPanel();
		medioSupDer2.setLayout(new GridLayout(1,2));
		medioSupDer2.add(puntos);
		medioSupDer2.add(puntosTextoJ);

		JPanel medioSupDer = new JPanel();
		medioSupDer.setLayout(new BorderLayout());
		medioSupDer.add(medioSupDer1, BorderLayout.NORTH);
		medioSupDer.add(medioSupDer2, BorderLayout.SOUTH);

		//1º carta de la banca
		JPanel medioInfIzq1 = new JPanel();
		medioInfIzq1.setLayout(new GridLayout(1, 2));
		medioInfIzq1.add(ImagenCartas4);
		medioInfIzq1.add(carta1);

		JPanel medioInfIzq2 = new JPanel();
		medioInfIzq2.setLayout(new BorderLayout());
		medioInfIzq2.add(CartaExtraB);

		JPanel medioInfIzq = new JPanel();
		medioInfIzq.setLayout(new BorderLayout());
		medioInfIzq.add(medioInfIzq1, BorderLayout.NORTH);
		medioInfIzq.add(medioInfIzq2, BorderLayout.SOUTH);

		//2º carta de la banca

		JPanel medioInfCen1 = new JPanel();
		medioInfCen1.setLayout(new GridLayout(1, 2));
		medioInfCen1.add(ImagenCartas5);
		medioInfCen1.add(carta2);

		JPanel medioInfCen2 = new JPanel();
		medioInfCen2.setLayout(new BorderLayout());
		medioInfCen2.add(MePlantoB);

		JPanel medioInfCen = new JPanel();
		medioInfCen.setLayout(new BorderLayout());
		medioInfCen.add(medioInfCen1, BorderLayout.NORTH);
		medioInfCen.add(medioInfCen2, BorderLayout.SOUTH);

		//3º carta de la banca
		
		JPanel medioInfDer1 = new JPanel();
		medioInfDer1.setLayout(new GridLayout(1, 2));
		medioInfDer1.add(ImagenCartas6);
		medioInfDer1.add(carta3);

		JPanel medioInfDer2 = new JPanel();
		medioInfDer2.setLayout(new GridLayout(1,2));
		medioInfDer2.add(puntos);
		medioInfDer2.add(puntosTextoB);

		JPanel medioInfDer = new JPanel();
		medioInfDer.setLayout(new BorderLayout());
		medioInfDer.add(medioSupDer1, BorderLayout.NORTH);
		medioInfDer.add(medioSupDer2, BorderLayout.SOUTH);

		//esto contiene las 3 cartas del jugador
				
		JPanel medioSup1 = new JPanel();
		medioSup1.setLayout(new GridLayout(1,3));
		medioSup1.add(medioSupIzq);
		medioSup1.add(medioSupCen);
		medioSup1.add(medioSupDer);
		
		//las 3 cartas de la banca
		JPanel medioInf1 = new JPanel();
		medioInf1.setLayout(new GridLayout(1,3));
		medioInf1.add(medioInfIzq);
		medioInf1.add(medioInfCen);
		medioInf1.add(medioInfDer);
		
		//panel que contiene las cartas, pero solo el superior
		JPanel medioSup = new JPanel();
		medioSup.setLayout(new BorderLayout());
		medioSup.add(jugador, BorderLayout.NORTH);
		medioSup.add(medioSup1, BorderLayout.SOUTH);
		
		//panel que contiene las cartas, pero solo el inferior ahora
		JPanel medioInf = new JPanel();
		medioInf.setLayout(new BorderLayout());
		medioInf.add(banca, BorderLayout.NORTH);
		medioInf.add(medioInf1, BorderLayout.SOUTH);
		
		////
		//
		//
		// donde van las cartas!
		//
		//
		JPanel medioSup = new JPanel();
		medioSupIzq.setLayout(new BorderLayout());
		medioSupIzq.add();

		JPanel medioSup2 = new JPanel();
		medioSup2.setLayout(new GridLayout(1, 3));
		medioSup2.add(medioSupIzq);

		JPanel medioSup = new JPanel();
		medioSup.setLayout(new BorderLayout());

		JPanel medio = new JPanel();
		medio.setLayout(new GridLayout(3, 1));
		
		JPanel total= new JPanel(){
			
		}
		
	}

	public void añadirAHistorico(String mensaje) {
	}

	public void controlador(ActionListener ctr) {
	}

	public void error(String mensaje) {
	}

	public void habilitarBanca(boolean b) {
	}

	public void habilitarInicio() {
	}

	public void habilitarJugador(boolean b) {
	}

	public void habilitarJugar(boolean b) {
	}

	public void limpiar() {
	}

	public void nuevaCartaBanca(String fichero) {
	}

	public void nuevaCartaJugador(String fichero) {
	}

	public void ok(String mensaje) {
	}

	public void puntosBanca(double puntos) {
	}

	public void puntosJugador(double puntos) {
	}
}
