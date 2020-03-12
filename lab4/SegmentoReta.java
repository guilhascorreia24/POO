public class SegmentoReta {
	
	private Ponto p1;
	private Ponto p2;

	public SegmentoReta(Ponto p1,Ponto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Ponto getp1() {return p1;}
	public Ponto getp2() {return p2;}

	/**/
	public Reta inversa() {
		String m;
		float b;
		if(p2.getX()-p2.getY()==0){
			b=0;
		}
		else{
			float m1=(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
			float b=-m1*pontoMedio().getX()+pontoMedio().getY(); //B=y-mx
			m=String.valueOf(m1);
		}
		return new Reta(m,b);
	}
public Ponto pontoMedio(){

		float xMedium = (this.getp1X() + this.getp2X()) / 2;
		float yMedium = (this.getp1Y() + this.getp2Y()) / 2;
		
		Ponto pMedio = new Ponto(xMedium,yMedium);
		
		return pMedio;
	}
}