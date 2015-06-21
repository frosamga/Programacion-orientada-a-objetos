import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main {

	public static void main(String[]args) {
		//Mantener el MVC
		VistaJarra vJarra = new panelJarra();
		ActionListener ctrJa = new CtrJarra(vJarra);
		vJarra.controlador(ctrJa);
		//Mantener la vista en una ventana
		JFrame ventana = new JFrame("Control de cuentas");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vJarra);
		ventana.pack();
		ventana.setResizable(false);
		ventana.setVisible(true);
	}
	
}
