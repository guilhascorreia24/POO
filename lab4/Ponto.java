/**
 * @version 1.2 
 * @author Guilherme Correia 61098  
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
public class Ponto implements Comparable<Ponto>{
	private double x;
	private double y;

	/**
	 * 
	 * @param x double abcissa do ponto
	 * @param y double ordenda do ponto
	 * @inv this.x e a abcissa do ponto
	 * @inv this.y e a ordenada do ponto
	 */
	public Ponto(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/** 
	 * @param toString(
	 * @return double devolve o valor da abcissa do ponto
	 */
	public double getX() {return x;}
	
	/** 
	 * @param toString(
	 * @return double devolve o valor da ordenada do ponto
	 */
	public double getY() {return y;}
	
	/** 
	 * @return String imprime o formato do ponto
	 */
	public String toString(){
		return x+" "+y;
	}
	
	/** 
	 * @param p ponto ao qual quero saber a distancia
	 * @return double devolve o resultado da formula 
	 */
	public double distancia(Ponto p) {
		
		double dx = x - p.x;
		double dy = y - p.y;
			
			return (double)Math.sqrt(dx * dx + dy * dy);
		}
	
	
	/** 
	 * @param b ponto que queremos comparar
	 * @return int devolve 1 de os pontos forem iguais e 0 se nao 
	 */
	@Override
	public int compareTo(Ponto b){
		Ponto p=(Ponto)b;
		if(this.x==p.x && this.y==p.y) {
			return 1;
		}
		return 0;
	}
	
}