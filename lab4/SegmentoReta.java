import java.io.IOException;

public class SegmentoReta{
	
	private Ponto p1;
	private Ponto p2;

	/**
	 * 
	 * @param p1 ponto que faz o segmento de reta
	 * @param p2 ponto que faz o segmento de reta
	 * @throws new IOException() apresenta uma mensagem "invalid points" e encerra o programa caso os pontos sejam iguais
	 * @inv this.p1 ponto que faz parte do segmento
	 * @inv this.p2 ponto que faz parte do segmento 
	 */
	public SegmentoReta(Ponto p1,Ponto p2) {
			try{
				if(p1.compareTo(p2)==1)throw new IOException();
			}catch (IOException e){
				System.out.println("invalid points");
				System.exit(0);
			}
		this.p1 = p1;
		this.p2 = p2;
	}
	
	
	/** 
	 * 
	 * @return Ponto devolve o ponto que controi o segmento
	 */
	public Ponto getp1() {return new Ponto(p1.getX(),p1.getY());}
	
	/** 
	 * 
	 * @return Ponto devolve o ponto que controi o segmento
	 */
	public Ponto getp2() {return new Ponto(p2.getX(),p2.getY());}

	
	/** 
	 * @return Reta devolve a reta que é inversa ao segmento que passa no ponto medio do segmento
	 */
	public Reta inversa() {
		double m;
		double b;
		if(p1.getY()-p2.getY()==0){
			m=(p2.getX()+p1.getX())/2;
			return new Reta(m);
		}
		if(p1.getX()-p2.getX()==0){
			b=(p2.getY()+p1.getY())/2;
			return new Reta(0,b);
		}
		m=-1/declive();
		b=-m*pontoMedio().getX()+pontoMedio().getY(); //B=y-mx
		return new Reta(m,b);
	}
	
	
	/** 
	 * @return double devolve o declive do segmento do segmento atraves da formula
	 */
	public double declive(){
		return (p1.getY()-p2.getY())/(p1.getX()-p2.getX());
	}
	
	/** 
	 * @return Ponto devolve o ponto medio do segmento atraves da formula
	 */
	public Ponto pontoMedio(){

		double xMedium = (p2.getX() + p1.getX()) / 2;
		double yMedium = (p2.getY() + p1.getY()) / 2;
		
		Ponto pMedio = new Ponto(xMedium,yMedium);
		
		return pMedio;
	}

	
	/** 
	 * @return String devolve o formato de impressao do segmento
	 */
	public String toString(){
		return p1+" "+p2;
	}
}