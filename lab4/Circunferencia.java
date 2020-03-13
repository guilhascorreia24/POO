

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Circunferencia {

	private double raio;
	private Ponto centro;

	public Circunferencia(final Ponto p1, final Ponto p2, final Ponto p3) {
		centro(p1,p2,p3);
		raio=p1.distancia(centro);
	}

	private void centro(Ponto p1,Ponto p2,Ponto p3){
		Map<Ponto,Double> pontos=new HashMap<Ponto,Double>();
		pontos.put(p1,p1.distancia(p2));
		pontos.put(p2,p2.distancia(p3));
		pontos.put(p3,p3.distancia(p1));
		double max=Collections.max(pontos.values());Ponto intermedio=new Ponto(0,0);
		Ponto[] ps=new Ponto[3];int i=0;
		for(Ponto p:pontos.keySet()){
			if(max==pontos.get(p)){
				intermedio=p;
			}
			ps[i++]=p;
		}
		SegmentoReta s1=new SegmentoReta(ps[0], intermedio);
		SegmentoReta s2=new SegmentoReta(ps[1], intermedio);
		if(s1.declive()==s2.declive()){System.out.println("invalid points");  }
		Reta r1=new Reta(-1/s1.declive(), s1.Ordenada());
		Reta r2=new Reta(-1/s2.declive(),s2.Ordenada());
		centro=r1.intersecao(r2);
	}

	/**
	 * 
	 * @param Ponto
	 */
	public double distancia(final Ponto p) {
		double dx = 0 - p.getX();
		double dy = 0 - p.getY();
		double objetivo=(double)Math.sqrt(dx * dx + dy * dy);
		if(objetivo<=raio){
			System.out.println("invalid points"); 
			System.exit(1);
		}
		objetivo= objetivo-raio;
		return objetivo;
	}

	public double getRaio() {
		return raio;
	}

	public Ponto getCentro(){
		return new Ponto(centro.getX(),centro.getY()); 
	}

}