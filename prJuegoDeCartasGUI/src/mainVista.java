import javax.swing.JFrame;


public class mainVista {

	public static void main(String args[]){
		
		JFrame ventana = new JFrame("Juego de Cartas");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane(new PanelBacarra());
		ventana.pack();
		ventana.setVisible(true);
		
		
	}
}
