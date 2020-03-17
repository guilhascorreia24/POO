public class Ponto implements Comparable<Ponto>{
	private double x;
	private double y;
	public Ponto(double x, double y) {
		
		this.x = x;
		this.y = y;
	}
	public double getX() {return x;}
	public double getY() {return y;}
	public String toString(){
		return x+" "+y;
	}
	public double distancia(Ponto p) {
		
		double dx = x - p.x;
		double dy = y - p.y;
			
			return (double)Math.sqrt(dx * dx + dy * dy);
		}
	
	@Override
	public int compareTo(Ponto b){
		Ponto p=(Ponto)b;
		if(this.x==p.x && this.y==p.y) {
			return 1;
		}
		return 0;
	}
	
}