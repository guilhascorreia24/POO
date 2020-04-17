/**
 * @version 1.2 
 * @author Guilherme Correia 61098  
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
public class Reta {
	private double declive ;
	private double ordenada;
	private double ver;
	private boolean check = false;

	/**
	 * 
	 * @param m declive da reta
	 * @param b ordenada da reta
	 * @inv this.declive declive da reta
	 * @inv this.ordenada ordenada da reta
	 * @inv this.check afirma que a reta nao e paralela ao eixo y
	 */
	public Reta(double m, double b) {
		this.check = false;
		this.declive = m;
		this.ordenada = b;

	}

	/**
	 * @param ver abcissa da reta em caso dela ser vertical
	 * @inv this.ver abcissa da reta, caso seja vertical
	 * @inv this.check afirma que a reta nao e paralela ao eixo y
	 */
	public Reta(double ver) {
		this.check = true;
		this.ver = ver;

	}

	
	/** 
	 * @param r1 reta reta que interseta o objeto presente
	 * @return Ponto devolve o ponto em que as 2 retas se intersetam
	 * 
	 */
	public Ponto intersecao(Reta r1) {
		double x = 0;
		double y = 0;
		if (!this.check && !r1.check) {
			x = (r1.ordenada - this.ordenada) / (this.declive - r1.declive);
			y = this.declive * x + this.ordenada;
		} 
		else if (this.check) {
			x = this.ver;
			y = r1.declive * x + r1.ordenada;
		} 
		else if (r1.check) {
			x = r1.ver;
			y = this.declive * x + this.ordenada;
		}
		return new Ponto(x, y);
		
	}

	
	/** 
	 * @return String devolve o formato de impressao da reta
	 */
	public String toString() {
		return declive + " " + ordenada + " " + ver;
	}

}