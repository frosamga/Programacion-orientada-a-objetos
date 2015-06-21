import java.awt.event.ActionListener;


public interface VistaGeometria {
	String INTER = "INTER";
	double obtenerCantidadp1();
	double obtenerCantidadp2();
	double obtenerCantidadp3();
	double obtenerCantidadp4();
	double obtenerCantidadq1();
	double obtenerCantidadq2();
	double obtenerCantidadq3();
	double obtenerCantidadq4();
	void mensaje(String msg);
	void controlador(ActionListener ctr);
}
