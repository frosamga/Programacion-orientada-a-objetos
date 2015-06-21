public class Hospital {

	private String nombre;
	private String direccion;
	private Departamento[] departamentos;
	private Planta[] plantas;

	public Hospital(String nombre, String direccion,Departamento[] departamentos,int numPlantas) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.departamentos = departamentos;
		plantas = new Planta[numPlantas];
		for (int i = 0; i < numPlantas; i++) {
			plantas[i] = new Planta(8, "P" + i);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getNumDepartamentos() {
		return departamentos.length;
	}

	
	public Departamento getDepartamento(String nom) {
		Departamento aux = this.departamentos[0];

		for (int i = 0; i < departamentos.length; i++) {
			if (departamentos[i].getNombre() == nom) {
				aux = departamentos[i];
			} else {
				throw new RuntimeException(
						"no existe ese nombre de departamento");
			}

		}
		return aux;
	}

	public int numPlantas() {
		return plantas.length;
	}

	public Planta getPlanta(int i) {
		return plantas[i];
	}

	public String toString() {
		String salida = "Hospital: " + nombre + " , direccion:  " + direccion;

		for (int i = 0; i < departamentos.length; i++) {
			salida=salida+" , departamentos: "+departamentos[i].getNombre();
		}
		return salida;
	}
}
