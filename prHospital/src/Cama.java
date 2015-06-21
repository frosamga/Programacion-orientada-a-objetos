public class Cama {

	private String codigo;
	private Paciente paciente;

	public Cama(String numero) {
		codigo = numero;
		paciente = null;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente p) {
		paciente = p;
	}

	public boolean estaLibre() {
		boolean bool = false;
		if (paciente == null) {
			bool = true;
		}
		return bool;
	}

	public void libera() {
		paciente.daDeAlta();
	}

	public String getCodigo() {
		return codigo;
	}

	public String toString() {
		return getCodigo();
	}
}
