
public class Carta {

	
	Palo palo;
	private static String[] nombreCarta=new String[13];
	private int valor;
	
	public Carta(int valor, Palo palo){

		if(valor==1){
			nombreCarta[0]="As";
		}else if(valor>=2&&valor<=10){
			nombreCarta[valor-1]=String.valueOf(valor);
		}else if(valor==11){
			nombreCarta[10]="J ";	
		}else if(valor==12){
			nombreCarta[11]="Q ";
		}else if(valor==13){
			nombreCarta[12]="K ";
		}
		
		this.valor=valor;
		this.palo=palo;
	}
	public Palo palo(){
		return palo;
	}
	
	public int valor(){
		return valor;
	}
	public String toString(){
		return nombreCarta[this.valor-1]+" y palo: "+palo+"\n"; 
	}
	
}
