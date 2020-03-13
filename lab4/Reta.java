public class Reta {
    private double declive;
    private double ordenada=0;

    public Reta(double m, double b) {
        this.declive = m;
        this.ordenada = b;
    }

    public Reta(double x){
        this.declive=x;
    }

    public Ponto intersecao(Reta r1) {

	    double x = (r1.ordenada - this.ordenada) / (this.declive - r1.declive);
	    double y = this.declive * x + this.ordenada;

	    return new Ponto((double) x, (double) y);
	}
}