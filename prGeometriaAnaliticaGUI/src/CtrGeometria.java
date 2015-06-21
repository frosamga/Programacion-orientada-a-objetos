import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtrGeometria implements ActionListener {
	private VistaGeometria vista;
	private Recta recta;
	private Recta r1,r2;

	public CtrGeometria(VistaGeometria v, Recta r) {
		vista = v;
		recta = r;
	}

	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		try {
			if (comando.equals(vista.INTER)) {
				r1= new Recta(new Punto(vista.obtenerCantidadp1(),vista.obtenerCantidadp2()),new Punto(vista.obtenerCantidadp3(),vista.obtenerCantidadp4()));
				r2= new Recta(new Punto(vista.obtenerCantidadq1(),vista.obtenerCantidadq2()),new Punto(vista.obtenerCantidadq3(),vista.obtenerCantidadq4()));
				Punto p=r1.interseccionCon(r2);
				vista.mensaje("el Punto es"+p.toString());
			}
		} catch (RuntimeException e) {
			vista.mensaje("No hay Interseccion");
		}

	}
}
