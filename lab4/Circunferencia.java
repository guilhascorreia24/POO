
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Circunferencia {

	private float raio;

	public Circunferencia(final Ponto p1, final Ponto p2, final Ponto p3) {
		Map<Ponto,Float> dists=new HashMap<Ponto,Float>();
		dists.put(p1,p1.distancia(p2));
		dists.put(p2,p2.distancia(p3));
		dists.put(p3,p3.distancia(p1));
		float max=Collections.max(dists.values());
		dists.remove(dists.keySet().);
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