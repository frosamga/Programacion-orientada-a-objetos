public class Cilindro {
	private double altura;
	private Circulo base;

	public Cilindro() {
		base = new Circulo();
		altura = 0;
	}

	public Cilindro(Circulo b, double a) {
		base = new Circulo(b.centro(), b.radio());
		altura = a;
	}

	public Circulo base() {
		return base;
	}

	public double altura() {
		return altura;
	}

	public void base(Circulo b) {
		base = new Circulo(b.centro(), b.radio());
	}

	public void altura(double a) {
		altura = a;
	}

	public void trasladar(double a, double b) {
		base.trasladar(a, b);
	}

	public String toString() {
		return base.toString() + " altura: " + altura	;
	}

}
