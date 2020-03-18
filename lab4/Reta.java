public class Reta {
	private double declive ;
	private double ordenada;
	private double ver;
	private boolean check = false;

	public Reta(double m, double b) {
		this.check = false;
		this.declive = m;
		this.ordenada = b;

	}

	public Reta(double ver) {
		this.check = true;
		this.ver = ver;

	}

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

	public String toString() {
		return declive + " " + ordenada + " " + ver;
	}

}