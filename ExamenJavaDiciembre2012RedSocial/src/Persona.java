import java.util.List;

public class Persona implements Comparable<Persona> {

	private String nombre, email;
	private int edad;
	private List<String> aficiones;

	public Persona(String nombre, int edad, String email, List<String> lista) {
		if (edad <= 0) {
			throw new RedSocialException("edad no valida");
		}
		if (lista.isEmpty()) {
			throw new RedSocialException("lista de aficiones vacia");
		}
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
		this.aficiones = lista;
	}

	public boolean equals(Object o){
		return (o instanceof Persona)&&(this.nombre.equalsIgnoreCase(((Persona)o).getNombre()))&&this.email.equals(((Persona)o).getEmail());
	}
	public int hashCode(){
		return nombre.toLowerCase().hashCode()+email.hashCode();
	}
	public int compareTo(Persona p){
		int res=0;
		if(email.length()<p.email.length()){
			res=-1;
		}else if(email.length()>p.email.length()){
			res=1;
		}else{
			res=nombre.compareToIgnoreCase(p.nombre);
		}
		return res;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}

	public int getEdad() {
		return edad;
	}

	public List<String> getAficiones() {
		return aficiones;
	}

	public String toString() {
		return nombre + " " + edad + " (" + email + ")";
	}



}
