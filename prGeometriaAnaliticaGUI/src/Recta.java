public class Recta {

	private Punto pto;
	private Vector direccion;
	private Vector d;

	public Recta(Vector v, Punto p) {
		pto = p;
		direccion = v;
	}

	public Recta(Punto p1, Punto p2) {
		pto = p1;
		direccion = this.dosPuntosVectorDirector(p1, p2);
	}

	private Vector dosPuntosVectorDirector(Punto p1, Punto p2) {
		double a = p2.x() - p1.x();
		double b = p2.y() - p1.y();
		// es mejor devolver un objeto nuevo, para no modificar el anterior.
		return d = new Vector(a, b);
	}

	public boolean pasaPor(Punto p) {
		Vector v = this.dosPuntosVectorDirector(pto, p);
		return v.paraleloA(direccion);
	}

	public boolean paralelaA(Recta r) {
		return this.direccion.paraleloA(r.direccion);
	}

	public Recta paralelaPor(Punto p) {
		return new Recta(direccion, p);
	}

	public Recta perpendicularPor(Punto p) {
		return new Recta(direccion.ortogonal(), p);
	}

	public Punto interseccionCon(Recta r) {
		if (this.paralelaA(r)) {
			throw new RuntimeException("Rectas paralelas");
		}

		double ux = r.direccion.componenteX();
		double uy = r.direccion.componenteY();
		double vx = direccion.componenteX();
		double vy = direccion.componenteY();
		double px = pto.x();
		double py = pto.y();
		double qx = r.pto.x();
		double qy = r.pto.y();
		double ox = 0, oy = 0;

		double d = (uy * vx) - (vy * ux);
		double d1 = (vx * py) - (vy * px);
		double d2 = (ux * qy) - (uy * qx);

		if (d != 0) {
			ox = (d1 * ux - vx * d2) / d;
			oy = -(vy * d2 - uy * d1) / d;
		} else {
			throw new RuntimeException("no hay interseccion entre esas rectas");
		}
		return new Punto(ox, oy);
	}

	public double distanciaDesde(Punto p) {
		Recta r = this.perpendicularPor(p);
		return this.interseccionCon(r).distancia(p);
	}

	public String toString() {
		return "R(" + direccion + "," + pto + ")";
	}

}
