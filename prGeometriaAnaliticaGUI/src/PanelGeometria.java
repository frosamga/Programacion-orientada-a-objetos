import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PanelGeometria extends JPanel implements VistaGeometria {

	private JTextField p1, p2, p3, p4, q1, q2, q3, q4;
	private JButton Interseccion;
	private JLabel r1, r1_1, r1_2,r2,r2_1,r2_2,mensaje;

	public PanelGeometria() {

		r1 = new JLabel("Recta (");
		r2 = new JLabel("Recta (");
		r1_1 = new JLabel(" , ");
		r1_2 = new JLabel(" ) ");
		r2_1 = new JLabel(" , ");
		r2_2 = new JLabel(" ) ");
		p1 = new JTextField("              ");
		p2 = new JTextField("              ");
		p3 = new JTextField("              ");
		p4 = new JTextField("              ");
		q1 = new JTextField("              ");
		q2 = new JTextField("              ");
		q3 = new JTextField("              ");
		q4 = new JTextField("              ");
		p1.setSize(20, 20);
		Interseccion = new JButton("Punto de interseccion");
		mensaje= new JLabel("el punto aparecera aqui, (escribe solo Puntos)");
		
		
		JPanel l1 = new JPanel();
		l1.setLayout(new FlowLayout());
		l1.add(r2);
		l1.add(p1);
		l1.add(p2);
		l1.add(r2_1);
		l1.add(p3);
		l1.add(p4);
		l1.add(r2_2);
		
		JPanel l2 = new JPanel();
		l2.setLayout(new FlowLayout());
		l2.add(r1);
		l2.add(q1);
		l2.add(q2);
		l2.add(r1_1);
		l2.add(q3);
		l2.add(q4);
		l2.add(r1_2);
		
		JPanel l4 = new JPanel();
		l4.setLayout(new BorderLayout());
		l4.add(mensaje, BorderLayout.CENTER);
	
		JPanel total = new JPanel();
		total.setLayout(new GridLayout(4,1));
		total.add(l1);
		total.add(l2);
		total.add(Interseccion, BorderLayout.CENTER);
		total.add(l4,BorderLayout.CENTER);
		add(total);
	}
	public void controlador(ActionListener ctr) {
		Interseccion.addActionListener(ctr);
		Interseccion.setActionCommand(INTER);
	}

	public double obtenerCantidadp1() {
		return Double.parseDouble(p1.getText());
	}
	public double obtenerCantidadp2() {
		return Double.parseDouble(p2.getText());
	}
	public double obtenerCantidadp3() {
		return Double.parseDouble(p3.getText());
	}
	public double obtenerCantidadp4() {
		return Double.parseDouble(p4.getText());
	}
	public double obtenerCantidadq1() {
		return Double.parseDouble(q1.getText());
	}
	public double obtenerCantidadq2() {
		return Double.parseDouble(q2.getText());
	}
	public double obtenerCantidadq3() {
		return Double.parseDouble(q3.getText());
	}
	public double obtenerCantidadq4() {
		return Double.parseDouble(q4.getText());
	}

	public void mensaje(String s){
		mensaje.setText(s);
	}

}
