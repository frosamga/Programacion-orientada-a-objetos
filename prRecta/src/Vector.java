
public class Vector {

	private Punto origen,extremo;
	
	public Vector(double x, double y){
		extremo= new Punto(x,y);
		origen=new Punto();
	}
	
	public Vector(Punto e){
		extremo=e;
		origen=new Punto();
	}
	
	public Vector(Punto origen, Punto extremo){
		
			this.origen=new Punto(origen.x()-origen.x(),origen.y()-origen.y());
			this.extremo=new Punto(extremo.x()-origen.x(),extremo.y()-origen.y());
	
	}
	
	public double componenteX(){
		return extremo.x();
	}
	public double componenteY(){
		return extremo.y();
	}
	public double modulo(){
		double resultado;
		if(origen.x()==extremo.x()){
			resultado=Math.abs((origen.y()-extremo.y()));
		}else if(origen.y()==extremo.y()){
			resultado=Math.abs((origen.x()-extremo.x()));
		}else{
			resultado=origen.distancia(extremo);
			
		}
		return resultado;
	}
	public Vector ortogonal(){
		
		return new Vector(-extremo.y(),extremo.x());
	}
	
	public boolean paraleloA(Vector v){
		boolean paralelo;
		if(	this.componenteX()*v.componenteY()==this.componenteY()*v.componenteX() ){
			paralelo=true;
		}else{
			paralelo=false;		
		}
		return paralelo;
		
	}
	
	public Punto extremoDesde(Punto p){	
		double x,y;
		x=extremo.x()+p.x();
		y=extremo.y()+p.y();
		return new Punto(x,y);
	}
	
	public String toString(){
		return "V("+origen+", "+extremo+")";
	}
	
}
