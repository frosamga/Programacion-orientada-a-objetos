
public class Equipo implements Comparable<Equipo> {
	private String nombre;
	private int numVotos;
	public Equipo(String nombre,int votos){
		this.nombre=nombre;
		numVotos=votos;
	}
	public int getVotos(){
		return numVotos;
	}
	public void setVotos(int votos){
		numVotos=votos;
	}
	public boolean equals(Object o){
		boolean res=false;
		if(o instanceof Equipo){
			Equipo e=(Equipo)o;
			res=nombre.equalsIgnoreCase(e.nombre)&& numVotos==e.numVotos;
		}
		return res;
	}
	public int compareTo(Equipo e) {
		int res=numVotos-e.numVotos;
		if(res==0){
			res=nombre.compareToIgnoreCase(e.nombre);
		}
		return res;
	}
	public int hasCode(){
		return nombre.toLowerCase().hashCode();
	}
	
	public String toString(){
		return nombre+" "+numVotos;
	}
	
	
}
