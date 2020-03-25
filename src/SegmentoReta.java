/**
 * @version 1.2 
 * @author Guilherme Correia 61098  
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
import java.io.IOException;

public class SegmentoReta{
	
	private Ponto p1;
	private Ponto p2;

	/**
	 * @pre pontos nao podem ser iguais
	 * @param p1 ponto extremidade do segmento de reta
	 * @param p2 ponto extremidade do segmento de reta
	 * @throws new IOException() apresenta uma mensagem "invalid points" e encerra o programa caso os pontos sejam iguais
	 * @inv this.p1 ponto extremidade do segmento de reta
	 * @inv this.p2 ponto extremidade do segmento de reta
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
	 * @return Ponto devolve o ponto de uma extremidade do segmento de reta
	 */
	public Ponto getp1() {return new Ponto(p1.getX(),p1.getY());}
	
	/** 
	 * 
	 * @return Ponto devolve o ponto de uma extremidade do segmento de reta
	 */
	public Ponto getp2() {return new Ponto(p2.getX(),p2.getY());}

	
	/**
	 * @return Reta devolve a reta que e inversa ao segmento que passa no ponto medio do segmento
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
	 * @return double devolve o declive do segmento do segmento atraves da formula do declive
	 */
	public double declive(){
		return (p1.getY()-p2.getY())/(p1.getX()-p2.getX());
	}
	
	/** 
	 * @return Ponto devolve o ponto medio do segmento atraves da formula do ponto medio
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