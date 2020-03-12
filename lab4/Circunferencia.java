
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Circunferencia {

	private float raio;

	public Circunferencia(final Ponto p1, final Ponto p2, final Ponto p3) {
		Map<Float,Ponto> dists=new HashMap<Float,Ponto>();
		dists.put(p1.distancia(p2),p1);
		dists.put(p2.distancia(p3),p2);
		dists.put(p3.distancia(p1),p3);
		float max=Collections.max(dists.keySet());
		dists.remove(dists.get(max));
		SegmentoReta r1=new SegmentoReta(, p2);
	}

	/**
	 * 
	 * @param Ponto
	 */
	public Ponto distancia(final Ponto p) {
		return p;
	}

	public float getRaio() {
		return raio;
	}

	public void setRaio(final float raio) {
		this.raio = raio;
	}

}