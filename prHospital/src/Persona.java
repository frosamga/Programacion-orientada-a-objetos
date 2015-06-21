
public abstract class Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private Genero sexo;
	
	public Persona(String dni, String nombre, String apellidos,int edad, Genero sexo){
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
		this.sexo=sexo;
	}
	
	public String getDni(){
		return dni;
	}
	public String getNombre(){
		return nombre;
	}
	public String getApellidos(){
		return apellidos;
	}
	public int getEdad(){
		return edad;
	}
	public Genero getSexo(){
		return sexo;
	}
	public void setEdad(int e){
		edad=e;
	}
	public void setSexo(Genero c){
		sexo=c;
	}
	public String toString(){
		return "Dni: "+dni+" - Nombre: "+nombre+" - Apellidos: "+apellidos+" - edad: "+edad+" - Sexo: "+sexo;
	}
}


