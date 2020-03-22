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
	 * @inv this.check verifica se é uma reta que passa no eixo do y
	 */
	public Reta(double m, double b) {
		this.check = false;
		this.declive = m;
		this.ordenada = b;

	}

	/**
	 * 
	 * @param ver abcissa da reta em caso dela ser vertical
	 * @inv this.ver abcissa da reta, caso seja vertical
	 * @inv this.check verifica se é uma reta que passa no eixo do y
	 */
	public Reta(double ver) {
		this.check = true;
		this.ver = ver;

	}

	
	/** 
	 * @param r1 reta de intersecao
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
	 * @return String devolve o formato de impresao da reta
	 */
	public String toString() {
		return declive + " " + ordenada + " " + ver;
	}

}