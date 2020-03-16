public class Reta {
    private double declive;
    private double ordenada=0;

    public Reta(double m, double b) {
        if(!Double.isInfinite(m))
            this.declive = m;
        this.ordenada = b;
    }

    public Reta(double x){
        this.declive=x;
        this.ordenada=Double.POSITIVE_INFINITY;
    }

    public Ponto intersecao(Reta r1) {
        double x=(ordenada-r1.ordenada)/(declive-r1.declive);
        double y=(ordenada*r1.declive-ordenada*r1.ordenada)/(declive-r1.declive);
	    return new Ponto(x,y);
    }
    
    public String toString(){
        return declive+" "+ordenada;
    }
}