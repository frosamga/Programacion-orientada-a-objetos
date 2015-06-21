public class Recta {

	private Vector direccion;
	private Punto pto;

	public Recta(Vector v, Punto p) {
		direccion = v;
		pto = p;
	}

	public Recta(Punto p1, Punto p2) {
		direccion = new Vector(p1, p2);
		pto = p2;	
		}

	public boolean pasaPor(Punto p) {
		return direccion.paraleloA(new Vector(pto,p));

	}

	public boolean paralelaA(Recta a) {
		return this.direccion.paraleloA(a.direccion);
	}

	public Recta paralelaPor(Punto p) {
		return new Recta(direccion, p);
	}

	public Recta perpendicularPor(Punto p) {
		pto = new Punto(p.x(), p.y());
		return new Recta(direccion.ortogonal(), pto);
	}

	public Punto interseccionCon(Recta r) {

		double d, d1, d2; 
		double ox=0; 
		double oy=0;
		Punto puntoAux;

		d = r.direccion.componenteY() * direccion.componenteX()- direccion.componenteY() * r.direccion.componenteX();
		if (this.paralelaA(r)){
			throw new RuntimeException("Rectas paralelas, nunca se cortan");
		}else if (d==0){
			 throw new RuntimeException("d es 0 y no se puede dividir entre 0.");
		}else if (d != 0) {
			d1 = direccion.componenteX() * pto.y() - direccion.componenteY()* pto.x();
			d2 = r.direccion.componenteX() * r.pto.y()- r.direccion.componenteY() * r.pto.x();
			ox = (d1 * r.direccion.componenteX() - direccion.componenteX() * d1)/ d;
			oy = -(direccion.componenteY() * d2 - r.direccion.componenteY()* d1)/ d;
		} else{
			throw new RuntimeException("error anomalo."); //por si acaso
		}
		puntoAux = new Punto(ox, oy);
		return puntoAux;
	}

	public double distanciaDesde(Punto p){
		Punto puntoAuxiliar;
		Recta rectaAux;
		Recta miRecta = new Recta(direccion.ortogonal(),p);
		puntoAuxiliar=this.interseccionCon(miRecta);
		return p.distancia(puntoAuxiliar);
	}

	public String toString() {
		return "R(" + direccion.toString() + ", " + pto.toString() + ")";
	}
}
