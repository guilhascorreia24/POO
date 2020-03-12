public class Ponto {
	private float x;
	private float y;
	public Ponto(float x, float y) {
		
		this.x = x;
		this.y = y;
	}
	public float getX() {return x;}
	public float getY() {return y;}
	public float distancia(Ponto p) {
		
		float dx = x - p.x;
		float dy = y - p.y;
			
			return (float)Math.sqrt(dx * dx + dy * dy);
		}
}