public class SegmentoReta {
	
	private Ponto p1;
	private Ponto p2;

	public SegmentoReta(Ponto p1,Ponto p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Ponto getp1() {return p1;}
	public Ponto getp2() {return p2;}

	public Reta inversa() {
		float m;
		float b;
		if(p2.getX()-p2.getY()==0){
			m=p2.getX();
			return new Reta(m);
		}
		m=declive();
		b=-m*pontoMedio().getX()+pontoMedio().getY(); //B=y-mx
		return new Reta(m,b);
	}
	
	public float declive(){
		return (p2.getY()-p1.getY())/(p2.getX()-p1.getX());
	}
	public Ponto pontoMedio(){

		float xMedium = (p2.getX() + p1.getX()) / 2;
		float yMedium = (p2.getY() + p1.getY()) / 2;
		
		Ponto pMedio = new Ponto(xMedium,yMedium);
		
		return pMedio;
	}
}