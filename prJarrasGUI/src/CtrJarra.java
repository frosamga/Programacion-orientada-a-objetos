import java.awt.event.*;

public class CtrJarra implements ActionListener {

	private VistaJarra v;
	private Jarra jarraA;
	private Jarra jarraB;

	public CtrJarra(VistaJarra vc) {
		v = vc;
	}

	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();

		if (comando.equals(v.INICIAR)) {
			accionIniciar();
		} else if (comando.equals(v.LLENAR_A)) {
			accionLlenar('A');
		} else if (comando.equals(v.LLENAR_B)) {
			accionLlenar('B');
		} else if (comando.equals(v.VACIAR_A)) {
			accionVaciar('A');
		} else if (comando.equals(v.VACIAR_B)) {
			accionVaciar('B');
		} else if (comando.equals(v.VOLCAR_A_EN_B)) {
			accionVolcarEn('A');
		} else if (comando.equals(v.VOLCAR_B_EN_A)) {
			accionVolcarEn('B');
		} else if (comando.equals(v.FINALIZAR)) {
			accionFinalizar();
		}
	}
	
	private void accionFinalizar() {
		v.capacidadA(0);
		v.capacidadB(0);
		v.contenidoA(0);
		v.contenidoB(0);
		v.habilitarInicio(false);

	}

	private void accionVolcarEn(char c) {
		switch (c) {
		case 'A':
			if(jarraA.contenido()>0) {
				jarraB.llenaDesde(jarraA);
				v.contenidoB(jarraB.contenido());
				v.contenidoA(jarraA.contenido());
				v.añadirAHistórico("Llenamos la jarra B con la jarra "+c);
			}else {
				v.error("La jarra A está vacía");
			}
			break;
		case 'B':
			if(jarraB.contenido()>0) {
				jarraA.llenaDesde(jarraB);
				v.contenidoA(jarraA.contenido());
				v.contenidoB(jarraB.contenido());
				v.añadirAHistórico("Llenamos la jarra A con la jarra "+c);
			}else {
				v.error("La jarra B está vacía ");
			}
		}
	}

	private void accionVaciar(char c) {
		switch (c) {
		case 'A':
			if(jarraA.contenido()>0) {
				jarraA.vacía();
				v.contenidoA(0);
				v.añadirAHistórico("Vaciamos la jarra "+c);
			}else {
				v.error("La jarra A ya está vacía");
			}
			break;
		case 'B':
			if(jarraB.contenido()>0) {
				jarraB.vacía();
				v.contenidoB(0);
				v.añadirAHistórico("Vaciamos la jarra "+c);
			}else {
				v.error("La jarra B ya está vacía");
			}
			break;
		}
	}

	private void accionLlenar(char c) {
		switch (c) {
		case 'A':
			if(jarraA.contenido()<jarraA.capacidad()) {
				jarraA.llena();
				v.contenidoA(jarraA.capacidad());
				v.añadirAHistórico("Llenamos la jarra "+c);
			}else {
				v.error("La jarra A ya está llena");
			}
			break;
		case 'B':
			if(jarraB.contenido()<jarraB.capacidad()) {
				jarraB.llena();
				v.contenidoB(jarraB.capacidad());
				v.añadirAHistórico("Llenamos la jarra "+c);
			}else {
				v.error("La jarra B ya está llena");
			}
			break;
		}
		
	}

	private void accionIniciar() {
		int capacidadInicialA;
		int capacidadInicialB;
		try {
			capacidadInicialA = v.capacidadInicialA();
			capacidadInicialB = v.capacidadInicialB();
			if ((capacidadInicialA > 0) && (capacidadInicialB > 0)) {
				jarraA = new Jarra(capacidadInicialA);
				jarraB = new Jarra(capacidadInicialB);
				v.capacidadA(capacidadInicialA);
				v.capacidadB(capacidadInicialB);
				v.contenidoA(0);
				v.contenidoB(0);
				v.ok("Jarras creadas correctamente");
				v.habilitarInicio(true);
			} else {
				v.error("Las capacidades de las jarras deben ser mayor que cero");
			}
		} catch (NumberFormatException e) {
			v.error("Las capacidades de las jarras deben ser números");
		}

	}

}

