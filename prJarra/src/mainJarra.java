public class mainJarra {

	public static void main(String[] args) {

		Jarra j = new Jarra(7);
		Jarra j1 = new Jarra(5);

		System.out.println(j.toString());
		System.out.println(j1.toString());

		// que me quede un litro
		j1.llena();
		j.llenaDesde(j1);
		System.out.println(j.toString());
		System.out.println(j1.toString());
		j1.llena();
		j.llenaDesde(j1);
		System.out.println(j.toString());
		System.out.println(j1.toString());
		j.vacía();
		j.llenaDesde(j1);
		System.out.println(j.toString());
		System.out.println(j1.toString());
		j1.llena();
		j.llenaDesde(j1);
		System.out.println(j.toString());
		System.out.println(j1.toString());
		System.out.println("ya tenemos un litro!");

	}

}
