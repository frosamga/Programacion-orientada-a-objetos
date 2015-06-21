public class Punto {

	private double x, y;

	public Punto(double a, double b) {
		x = a;
		y = b;
	}

	public Punto() {
		this(0, 0);
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public double distancia(Punto p) {
		double x2 = (x - p.x()) * (x - p.x());
		double y2 = (y - p.y()) * (y - p.y());
		return Math.sqrt(x2 + y2);
	}

	public void x(double a) {
		x = a;
	}

	public void y(double b) {
		y = b;
	}

	public void transladar(double a, double b) {
		x = a;
		y = b;
	}

	public String toString() {
		return "(" + x + " , " + y + ")";
	}
}