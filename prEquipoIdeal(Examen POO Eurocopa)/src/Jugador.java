
public class Jugador implements Comparable<Jugador> {
	private String nombre;
	private String demarcacion ;
	private int puntuacion;
	private boolean elegido;
	
	public Jugador(String nombre,String demarcacion,int puntuacion){
		this.nombre=nombre;
		this.demarcacion=demarcacion;
		this.puntuacion=puntuacion;
		elegido=false;
	}
	public String getNombre(){
		return nombre;
	}
	public String getDemarcacion(){
		return demarcacion;
	}
	public boolean getElegido(){
		return elegido;
	}
	public void setElegido(){
		elegido=true;
	}
	public boolean equals(Object o){
		boolean res=false;
		if(o instanceof Jugador){
			Jugador j=(Jugador) o;
			res=demarcacion.equalsIgnoreCase(j.demarcacion)&& puntuacion==j.puntuacion&& nombre.equalsIgnoreCase(j.nombre);
		}
		return res;
	}
	public int compareTo(Jugador j) {
		int res=j.getDemarcacion().compareToIgnoreCase(this.getDemarcacion());
		if(res==0){
			res=j.puntuacion-puntuacion;
			if(res==0){
				res=nombre.compareToIgnoreCase(j.nombre);
			}
		}
		return res;
	}
	public int hasCode(){
		return nombre.toLowerCase().hashCode();
	}
	
	public String toString(){
		return nombre+" "+demarcacion+" "+puntuacion;
	}
}
