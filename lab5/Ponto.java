
public class Ponto {
    private int x, y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
        if (x < 0 || y < 0) {
            System.out.println("iv");
            System.exit(1);
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public double dist(Ponto p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean equals(Ponto p){
        if(x==p.x && y==p.y){
            return true;
        }
        return false;
    }
    public String toString(){
        return x+":"+y;
    }
}
