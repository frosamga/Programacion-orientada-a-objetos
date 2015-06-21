public class Vector {

	private Punto extremo;

	public Vector(double x, double y) {
		extremo = new Punto(x, y);

	}

	public Vector(Punto e) {
		extremo = e;
	}

	public Vector(Punto origen, Punto extremo) {
		extremo.x(extremo.x() - origen.x());
		extremo.y(extremo.y() - origen.y());
	}

	public double componenteX() {
		return extremo.x();
	}

	public double componenteY() {
		return extremo.y();
	}

	public double modulo() {
		return Math.sqrt(extremo.x() * extremo.x() + extremo.y() * extremo.y());
	}

	public Vector ortogonal() {
		double a = extremo.x();
		double b = extremo.y();
		// ???
		return new Vector(-b, a);
	}

	public boolean paraleloA(Vector v) {
		boolean es = false;
		if (componenteX() * v.componenteY() == componenteY() * v.componenteX()) {
			es = true;
		}
		return es;
	}

	public Punto extremoDesde(Punto p) {
		/*
		 * extremo.x(extremo.x()+p.x()); extremo.y(extremo.y()+p.y()); 
		 * return extremo;
		 */
		// sera mejor crear un nuevo objeto o devolver el extremo nuevo?

		return new Punto(extremo.x() + p.x(), extremo.y() + p.y());
	}

	public String toString() {
		return "V(" + extremo.x() + "," + extremo.y() + ")";
	}
}
