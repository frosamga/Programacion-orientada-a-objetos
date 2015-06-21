public class Medico extends Persona {

	private Categoria categoriaProf;
	private boolean trabajaEnPrivado;
	private double horasSemanales;

	public Medico(String dni, String nombre, String apellidos, int edad,
			Genero sexo, Categoria cat, boolean trabajaP, double horas) {

		super(dni, nombre, apellidos, edad, sexo);
		categoriaProf = cat;
		trabajaEnPrivado = trabajaP;
		horasSemanales = horas;

	}

	public Categoria getCategoriaProfesional() {
		return this.categoriaProf;

	}

	public boolean trabajaEnPrivado() {
		return this.trabajaEnPrivado;
	}

	public double getHorasSemanales() {
		return this.horasSemanales;
	}

	public void setCategoriaProfesional(Categoria cat) {
		categoriaProf = cat;
	}

	public String toString() {
		
		String salida=" Categoria: "+categoriaProf+", trabaja en privado: "+ this.trabajaEnPrivado+ " ,horas semanales: "+this.horasSemanales;
		return "informacion medico: "+super.toString()+salida;
	}
}
