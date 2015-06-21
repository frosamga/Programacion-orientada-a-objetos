public class Circulo {
	private double radio;
	private Punto centro;

	public Circulo() {
		centro = new Punto();
		radio = 0;
	}

	public Circulo(Punto p, double r) {
		centro = new Punto(p.x(), p.y());
		radio = r;
	}

	public Punto centro() {
		return centro;
	}

	public double radio() {
		return radio;
	}

	public void centro(Punto p) {
		centro.x(p.x());
		centro.y(p.y());
	}

	public void radio(double r) {
		radio = r;
	}

	public void trasladar(double a, double b) {
		centro.trasladar(a, b);
		// centro.x(centro.x() + a);
		// centro.y(centro.y() + b);
	}

	public String toString() {
		return centro.toString()+"radio: "+radio;
	}

}
