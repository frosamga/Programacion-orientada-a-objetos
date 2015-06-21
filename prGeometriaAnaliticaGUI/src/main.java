import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class main {

	public static void main(String[] args) {
		
		Recta r= new Recta(new Punto(0, 0),new Punto(0, 0));
		VistaGeometria vista = new PanelGeometria();
		CtrGeometria control = new CtrGeometria(vista,r);
		vista.controlador(control);

		
		
		JFrame ventana = new JFrame("Interseccion");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vista);
		ventana.pack();
		ventana.setVisible(true);
		ventana.setResizable(false);
			

	}

}
