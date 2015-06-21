/*********************************************************
 * LTO
 *    Controlador
 *********************************************************/
import java.awt.event.*;
public class CtrCuenta  implements ActionListener {
    private VistaCuenta vistaCuenta;
    private Cuenta      cuenta;
    
    /**
     * Al constructor se le pasa la vista y el modelo
     */
    public CtrCuenta(VistaCuenta vc, Cuenta c) {
        vistaCuenta = vc;
        cuenta      = c;
    }
    
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();
        vistaCuenta.mensaje(" ");
        if (comando.equals(VistaCuenta.INGRESO)) {
            double cantidad = vistaCuenta.obtenerCantidad();
            cuenta.ingresa(cantidad);
            vistaCuenta.saldo(cuenta.saldo());
            vistaCuenta.mensaje("Ingreso realizado con �xito");
        } else if (comando.equals(VistaCuenta.GASTO)) {
            double cantidad = vistaCuenta.obtenerCantidad();
            double realCantidad = cuenta.extrae(cantidad);
            vistaCuenta.saldo(cuenta.saldo());
            if (cantidad != realCantidad) {
                vistaCuenta.mensaje("Extracci�n limitada a "+String.format("%12.2f",realCantidad));            
            } else {
                vistaCuenta.mensaje("Extracci�n realizada con �xito");
            }
        } else if (comando.equals(VistaCuenta.SALDO)) {
            vistaCuenta.saldo(cuenta.saldo());
            vistaCuenta.mensaje("Saldo consultado con �xito");
        }
    }
}
