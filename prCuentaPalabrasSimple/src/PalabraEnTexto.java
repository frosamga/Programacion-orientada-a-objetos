
public class PalabraEnTexto {
	private String infoPalabra;
	private int numVeces;
	
	public PalabraEnTexto(String p){
		infoPalabra=p;
		numVeces=1;
	}
	
	public boolean sonIguales(Object o){
		boolean igual;
		igual=(o instanceof PalabraEnTexto)&&(infoPalabra.toUpperCase()== (((PalabraEnTexto)o).infoPalabra.toUpperCase()));
		if(igual){
			incrementa();
		}
		return igual; 
	
	}
	
	public String palabra(){
		return infoPalabra;
	}
	
	public int numeroVeces(){
		return numVeces;
	}
	
	public void incrementa(){
		numVeces+=1;
	}
	
	public String toString(){
		return infoPalabra+": "+numVeces+" ";
	} 
}
