import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class panelJarra extends JPanel implements VistaJarra {

	private JLabel JarraA, JarraB, ContenidoA, CapacidadA, ContenidoB,
			CapacidadB, verificacion;
	private JButton iniciar, llenarA, llenarB, VaciarA, vaciarB, sig, ant,
			Finalizar;
	private JTextField Ja, Jb, ContA, CapA, ContB, CapB;
	private JTextArea texto;

	public panelJarra() {

		ImageIcon im1 = new ImageIcon("der.jpg");
		ImageIcon im2 = new ImageIcon("izq.jpg");

		iniciar = new JButton("Iniciar Capacidades");
		iniciar.setEnabled(true);
		JarraA = new JLabel("Jarra A");
		JarraA.setEnabled(true);
		JarraB = new JLabel("Jarra B");
		JarraB.setEnabled(true);
		Ja = new JTextField();
		Ja.setEnabled(true);
		Jb = new JTextField();
		Jb.setEnabled(true);
		
		
		llenarA = new JButton("Llenar");
		llenarA.setEnabled(false);
		llenarB = new JButton("Llenar");
		llenarB.setEnabled(false);
		VaciarA = new JButton("Vaciar");
		VaciarA.setEnabled(false);
		vaciarB = new JButton("Vaciar");
		vaciarB.setEnabled(false);
		sig = new JButton(im1);
		sig.setEnabled(false);
		ant = new JButton(im2);
		ant.setEnabled(false);
		Finalizar = new JButton("Finalizar");
		Finalizar.setEnabled(false);
		
		
		ContenidoA = new JLabel("Contenido");
		ContenidoA.setEnabled(false);
		CapacidadA = new JLabel("Capacidad");
		CapacidadA.setEnabled(false);
		ContenidoB = new JLabel("Contenido");
		ContenidoB.setEnabled(false);
		CapacidadB = new JLabel("Capacidad");
		CapacidadB.setEnabled(false);
		verificacion = new JLabel("");
		
		
		ContA = new JTextField();
		ContA.setEnabled(false);
		CapA = new JTextField();
		CapA.setEnabled(false);
		ContB = new JTextField();
		ContB.setEnabled(false);
		CapB = new JTextField();
		CapB.setEnabled(false);

		texto= new JTextArea();
		
		JPanel sup1 = new JPanel();
		sup1.setLayout(new GridLayout(1, 2));
		sup1.add(JarraA);
		sup1.add(Ja);

		JPanel sup2 = new JPanel();
		sup2.setLayout(new FlowLayout());
		sup2.add(iniciar);

		JPanel sup3 = new JPanel();
		sup3.setLayout(new GridLayout(1, 2));
		sup3.add(JarraB);
		sup3.add(Jb);

		// parte superior
		JPanel sup = new JPanel();
		sup.setLayout(new GridLayout(1, 3));
		sup.add(sup1);
		sup.add(sup2);
		sup.add(sup3);

		JPanel izq1 = new JPanel();
		izq1.setLayout(new GridLayout(1, 2));
		izq1.add(ContenidoA);
		izq1.add(ContA);

		JPanel izq2 = new JPanel();
		izq2.setLayout(new GridLayout(1, 2));
		izq2.add(CapacidadA);
		izq2.add(CapA);

		JPanel izq = new JPanel();
		izq.setLayout(new GridLayout(4, 1));
		izq.add(llenarA);
		izq.add(izq1);
		izq.add(izq2);
		izq.add(VaciarA);

		JPanel central = new JPanel();
		central.setLayout(new GridLayout(3, 1));
		central.add(sig);
		central.add(ant);
		central.add(Finalizar);

		JPanel der1 = new JPanel();
		der1.setLayout(new GridLayout(1, 2));
		der1.add(ContenidoB);
		der1.add(ContB);

		JPanel der2 = new JPanel();
		der2.setLayout(new GridLayout(1, 2));
		der2.add(CapacidadB);
		der2.add(CapB);

		JPanel der = new JPanel();
		der.setLayout(new GridLayout(4, 1));
		der.add(llenarB);
		der.add(der1);
		der.add(der2);
		der.add(vaciarB);

		JPanel centro = new JPanel();
		centro.setLayout(new GridLayout(1, 3));
		centro.add(izq);
		centro.add(central);
		centro.add(der);

		JPanel centroMasTexto = new JPanel();
		centroMasTexto.setLayout(new GridLayout(2, 1));
		centroMasTexto.add(centro);
		centroMasTexto.add(new JScrollPane(texto,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED));

		JPanel todo = new JPanel();
		todo.setLayout(new BorderLayout());
		todo.add(sup, BorderLayout.NORTH);
		todo.add(centroMasTexto,BorderLayout.CENTER);
		todo.add(verificacion,BorderLayout.SOUTH);
		add(todo);

	}

	@Override
	public void controlador(ActionListener ctr) {
		iniciar.addActionListener(ctr);
		iniciar.setActionCommand(INICIAR);
		llenarA.addActionListener(ctr);
		llenarA.setActionCommand(LLENAR_A);
		llenarB.addActionListener(ctr);
		llenarB.setActionCommand(LLENAR_B);
		VaciarA.addActionListener(ctr);
		VaciarA.setActionCommand(VACIAR_A);
		vaciarB.addActionListener(ctr);
		vaciarB.setActionCommand(VACIAR_B);
		sig.addActionListener(ctr);
		sig.setActionCommand(VOLCAR_A_EN_B);
		ant.addActionListener(ctr);
		ant.setActionCommand(VOLCAR_B_EN_A);
		Finalizar.addActionListener(ctr);
		Finalizar.setActionCommand(FINALIZAR);

	}

	@Override
	public int capacidadInicialA() {
		return Integer.parseInt(Ja.getText());
	}

	@Override
	public int capacidadInicialB() {
		return Integer.parseInt(Jb.getText());
	}

	public void error(String mensaje) {
		verificacion.setForeground(Color.RED);
		this.verificacion.setText(mensaje);
	}

	public void ok(String mensaje) {
		verificacion.setForeground(Color.RED);
		this.verificacion.setText(mensaje);
	}

	public void habilitarInicio(boolean b) {
		iniciar.setEnabled(!b);
		JarraA.setEnabled(!b);
		JarraB.setEnabled(!b);
		Ja.setEnabled(!b);	
		Jb.setEnabled(!b);
			
		llenarA.setEnabled(b);
		llenarB.setEnabled(b);
		VaciarA.setEnabled(b);
		vaciarB.setEnabled(b);
		sig.setEnabled(b);
		ant.setEnabled(b);
		Finalizar.setEnabled(b);
		ContenidoA.setEnabled(b);
		CapacidadA.setEnabled(b);
		ContenidoB.setEnabled(b);
		CapacidadB.setEnabled(b);
		
	}

	public void capacidadA(int c) {
		this.CapA.setText(String.valueOf(c));

	}

	public void capacidadB(int c) {
		this.CapB.setText(String.valueOf(c));
	}

	public void contenidoA(int c) {
		this.ContA.setText(String.valueOf(c));
	}

	public void contenidoB(int c) {
		this.ContB.setText(String.valueOf(c));
	}

	public void añadirAHistórico(String mensaje) {
		if (this.texto.getText().isEmpty()) {
			texto.setText(mensaje);
		} else {
			texto.setText(texto.getText() + "\n" + mensaje);
		}
	}

	public void limpiar() {
		this.capacidadA(0);
		this.capacidadB(0);
		this.contenidoA(0);
		this.contenidoB(0);
	}

}
