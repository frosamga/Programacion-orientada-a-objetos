public class Departamento {

	private String nombre;
	private Medico[] medicos;

	public Departamento(String nombre, Medico[] medicos) {
		this.nombre = nombre;
		this.medicos = medicos;
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumMedicos() {
		return medicos.length;
	}

	public int numMedicos(Categoria cat) {
		int contador = 0;
		for (int i = 0; i < medicos.length; i++) {
			if (medicos[i].getCategoriaProfesional() == cat) {
				contador++;
			}
		}
		return contador;
	}


	
	public Medico getMedico(String dni) {
		Medico med = null;
		for (int i = 0; i < medicos.length; i++) {
			if (dni == medicos[i].getDni()) {
				med = medicos[i];
			}
		}
		return med;
	}
	

	public boolean trabajaEnDepartamento(Medico medico) {

		for (int i = 0; i < medicos.length; i++) {
			if (this.medicos[i].equals(medico)) {
				return true;
			} 
		}
		return false;
	}

	public String toString(){
		String salida=" departamento: "+nombre+"\n";
		for (int i=0; i<this.getNumMedicos(); i++) {
			salida +="  "+medicos[i].toString()+" \n";
		}
		return salida;
	}
	
}
