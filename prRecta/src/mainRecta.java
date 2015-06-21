public class mainRecta {
	/**
	 * De las primeras practicas, calcula pitagoras y cosas asi, distancia entre
	 * puntos y demas
	 * 
	 * @param args
	 */

	public static void main(String[] args) { // Calcular el área del triángulo
		// definido por sus tres vértices
		Punto p1 = new Punto(0, 0);
		Punto p2 = new Punto(4, 0);
		Punto p3 = new Punto(8, 0); // Se calcula la distancia entre p1 y p2
		double base = p1.distancia(p2);
		System.out.println(base);
		// Se calcula la recta que pasa por p1 y p2
		Recta r1 = new Recta(p1, p2);
		System.out.println(r1.toString());
		// // se calcula la distancia entre p3 y r1
		double altura = r1.distanciaDesde(p3); // El area es base*altura/2
		System.out.println(altura);
		double area = base * altura / 2;
		System.out.printf("Puntos %s %s %s\n", p1, p2, p3);
		System.out.println("Área = " + area);
	}
}
