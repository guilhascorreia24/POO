import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Circunferencia {

	private double raio;
	private Ponto centro;

	public Circunferencia( Ponto p1,  Ponto p2,  Ponto p3) {
		centro(p1,p2,p3);
		raio=p1.distancia(centro);
	}

	private void centro(Ponto p1,Ponto p2,Ponto p3){
		Map<SegmentoReta,Double> pontos=new HashMap<SegmentoReta,Double>();
		pontos.put(new SegmentoReta(p1, p2),p1.distancia(p2));
		pontos.put(new SegmentoReta(p2, p3),p2.distancia(p3));
		pontos.put(new SegmentoReta(p3, p1),p3.distancia(p1));
		double max=Collections.max(pontos.values());
		SegmentoReta[] ps=new SegmentoReta[2];int i=0;

		for(SegmentoReta p:pontos.keySet()){
			if(max==pontos.get(p)){
			}
			else{
			ps[i++]=p;
			}
		}
		SegmentoReta s1=ps[0];
		SegmentoReta s2=ps[1];
		if(s1.declive()==s2.declive()){System.out.println("invalid points");
	System.exit(1);}
		Reta r1=s1.inversa();
		Reta r2=s2.inversa();
		centro=r1.intersecao(r2);
		System.out.println(centro);
	}


	/**
	 * 
	 * @param Ponto
	 */
	public double distancia( Ponto p) {
		double dx = centro.getX() - p.getX();
		double dy = centro.getY() - p.getY();
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