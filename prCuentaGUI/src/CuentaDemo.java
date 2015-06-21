/*********************************************************
 * LTO
 *    Aplicación con GUI
 *********************************************************/

import javax.swing.*;
import java.awt.event.*;
public class CuentaDemo {
    public static void main(String [] args) {
    	// Montamos el MVC
        VistaCuenta vistaCuenta = new PanelCuenta1();                   // Creamos la vista
//        VistaCuenta vistaCuenta = new PanelCuenta2();                 // Creamos la vista
        Cuenta cuenta = new Cuenta(Double.parseDouble(args[0]));        //  el modelo
        ActionListener ctrCuenta = new CtrCuenta(vistaCuenta, cuenta);  //  y el controlador
        vistaCuenta.controlador(ctrCuenta);                             // Asignamos el controlador a la vista
        
        // Mostramos la vista en una ventana
        JFrame ventana = new JFrame("Control de cuentas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setContentPane((JPanel)vistaCuenta);                   // Necesario este Cast
        ventana.pack();
        ventana.setVisible(true);
    }
}
