public class Punto {

	private double x, y;

	public Punto() {
		x = y = 0;
	}

	public Punto(double a, double b) {
		x = a;
		y = b;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

	public double distancia(Punto p) {
		double py = (Math.abs(this.y() - p.y()));
		double px = (Math.abs(this.x() - p.x()));

		return Math.sqrt((py * py) + (px * px));
	}

	public void x(double a) {
		x = a;
	}

	public void y(double b) {
		y = b;
	}

	public void trasladar(double a, double b) {
		x = x + a;
		y = y + b;
	}

	public String toString() {
		return "P(" + x + "," + y + ")";
	}
}
