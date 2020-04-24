
public class Ponto {
public double x, y;
public Ponto(double x,double y){
    this.x=x;
    this.y=y;
    if(x<0 || y<0){
        System.out.println("iv");
        System.exit(1);
    }
}
public double dist (Ponto p) {
 double dx = x - p.x;
 double dy = y - p.y;
 return Math.sqrt(dx*dx + dy*dy);
 }
}
