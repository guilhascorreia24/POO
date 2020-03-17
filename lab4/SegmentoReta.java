public class SegmentoReta{
	
	private Ponto p1;
	private Ponto p2;

	public SegmentoReta(Ponto p1,Ponto p2) {
		if(p1.compareTo(p2)==1){
			System.out.println("invalid points");
			System.exit(1);}
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Ponto getp1() {return new Ponto(p1.getX(),p1.getY());}
	public Ponto getp2() {return new Ponto(p2.getX(),p2.getY());}

	public Reta inversa() {
		double m;
		double b;
		if(p1.getX()-p2.getX()==0){
			b=p2.getY()/2;
			return new Reta(Double.NEGATIVE_INFINITY,b);
		}
		if(p1.getY()-p2.getY()==0){
			m=p2.getX()/2;
			return new Reta(m,Double.NEGATIVE_INFINITY);
		}
		m=-1/declive();
		b=-m*pontoMedio().getX()+pontoMedio().getY(); //B=y-mx
		return new Reta(m,b);
	}
	
	public double declive(){
		return (p2.getY()-p1.getY())/(p2.getX()-p1.getX());
	}

	public double Ordenada(){
		return declive()*pontoMedio().getX()+pontoMedio().getY();
	}
	public Ponto pontoMedio(){

		double xMedium = (p2.getX() + p1.getX()) / 2;
		double yMedium = (p2.getY() + p1.getY()) / 2;
		
		Ponto pMedio = new Ponto(xMedium,yMedium);
		
		return pMedio;
	}

	public String toString(){
		return p1+" "+p2;
	}
}