public class Paciente extends Persona {

	private double altura;
	private double peso;
	private String segSocial;
	private boolean urgente;
	private Medico medico;
	private Cama cama;

	public Paciente(String dni, String nombre, String apellidos, int edad,
			Genero sexo, double a, double p, String ss, boolean urg, Cama cama) {
		super(dni, nombre, apellidos, edad, sexo);
		if (a <= 0) {
			throw new RuntimeException("altura no valida");
		}
		altura = a;
		peso = p;
		segSocial = ss;
		urgente = urg;
		this.cama = cama;
		this.cama.setPaciente(this);
		medico = null;
		
	}

	public double getAltura() {
		return this.altura;
	}

	public double getPeso() {
		return this.peso;
	}

	public String getNumSocial() {
		return this.segSocial;
	}

	public double getIndiceMasaCorporal() {
		return Math.rint(peso / altura);
	}

	public boolean esUrgencia() {
		return this.urgente;
	}

	public void setAltura(double a) {
		if (a <= 0) {
			throw new RuntimeException("altura no valida");
		}
		this.altura = a;
	}

	public void setPeso(double p) {
		if (p <= 0) {
			throw new RuntimeException("peso no valida");
		}
		this.peso = p;
	}

	public void setEsUrgencia(boolean b) {
		this.urgente = b;
	}

	public void asignaMedico(Medico doctor) {
		this.medico = doctor;
	}

	public Medico atendidoPor() {
		if (medico == null) {
			return null;
		} else {
			return this.medico;
		}
	}
	
	public Cama getCama() {
		return cama;
	}

	public void setCama(Cama c) {
		cama = c;
	}

	public void daDeAlta() {
		setCama(null);
	}


	public String toString() {
		String salida ="Paciente:"+super.toString() +" Altura: " + getAltura() + ", Peso: "
				+ getPeso() + ", numero de seguridad social: "
				+ getNumSocial() + ", IMC = " + getIndiceMasaCorporal();
		
		if (esUrgencia() == true) {
			salida += ", URGENTE";
		}
		if (atendidoPor() != null) {
			salida += ".\nSu médico: " + atendidoPor() + "\n";
		} else {
			salida += ".\nNo se tiene asignado médico.\n";
		}
		return salida;
	}

}
