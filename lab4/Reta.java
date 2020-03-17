public class Reta {
    private double declive;
    private double ordenada=0;
    private double vertical=Double.NEGATIVE_INFINITY;

    public Reta(double m, double b) {
        this.declive = m;
        this.ordenada = b;
    }

    public Reta(double vertical){
        this.vertical=vertical;
    }

    public Ponto intersecao(Reta r1) {
        if(!Double.isInfinite(vertical)){
            ordenada=vertical;
        }
	    double x = (r1.ordenada - this.ordenada) / (this.declive - r1.declive);
        double y = this.declive * x + this.ordenada;
        if(!Double.isInfinite(vertical)){
            double s=x;
            y=x;
            x=s;
        }
	    return new Ponto( x,  y);
    }

    public String toString(){
        return declive+" "+ordenada;
    }
    
}