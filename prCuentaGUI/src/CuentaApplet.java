/*********************************************************
 * LTO
 *   JApplet para Cuenta Utilizando una de las vistas
 *********************************************************/
import java.awt.*;
import javax.swing.*;
public class CuentaApplet extends JApplet {
    public void init() {
    	// Montamos el MVC
    	VistaCuenta vistaCuenta = new PanelCuenta2(); // new PanelCuentas1();
        Cuenta cuenta = new Cuenta(Double.parseDouble(getParameter("saldoInicial")));
        CtrCuenta ctrCuenta = new CtrCuenta(vistaCuenta,cuenta);
        vistaCuenta.controlador(ctrCuenta);

        // Ponemos un borde a la vista
        ((JPanel)vistaCuenta).setBorder(BorderFactory.createEtchedBorder());
        // Mostramos la vista sobre un JApplet
        setContentPane((JPanel)vistaCuenta);
    }
}