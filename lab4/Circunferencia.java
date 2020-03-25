/**
 * @version 1.2 
 * @author Guilherme Correia 61098  
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Circunferencia {

	private double raio;
	private Ponto centro;

	/**
	 * 
	 * @param p1 primeiro ponto da circunferencia
	 * @param p2 segundo ponto da circunferencia
	 * @param p3 terceiro ponto da circunferencia
	 * @inv centro ponto que representa o centro da circunferencia sem condicoes previas
	 * @inv raio e a distancia do centro a um dos pontos(p1,p2,p3) sem condicoes previas
	 */
	public Circunferencia(Ponto p1, Ponto p2, Ponto p3) {
		this.centro=centro(p1, p2, p3);
		this.raio = p1.distancia(centro);
	}

	
	/** 
	 * elabora os 2 segmentos de reta com um ponto central e os outros dois, como extremos de cada uma dos segmentos, de seguida 	 * encontra as inversas 
	 * desses 2 segmentos de reta e por fim calcula o ponto de intersecao dessas 2 retas 
	 * @param p1 primeiro ponto da circunferencia
	 * @param p2 segundo ponto da circunferencia
	 * @param p3 terceiro ponto da circunferencia
	 * @pos declive das retas nao pode ser igual 
	 * @return Ponto devolve o ponto de intersecao das 2 retas que sera o centro da cirncuferencia
	 */
	private Ponto centro(Ponto p1, Ponto p2, Ponto p3) {
		Map<SegmentoReta, Double> pontos = new HashMap<SegmentoReta, Double>();
		pontos.put(new SegmentoReta(p1, p2), p1.distancia(p2));
		pontos.put(new SegmentoReta(p2, p3), p2.distancia(p3));
		pontos.put(new SegmentoReta(p3, p1), p3.distancia(p1));
		double max = Collections.max(pontos.values());
		SegmentoReta[] ps = new SegmentoReta[2];
		int i = 0;
		for (SegmentoReta p : pontos.keySet()) {
			if (max == pontos.get(p)) {
			} else {
				ps[i++] = p;
			}
		}
		pontos.clear();
		SegmentoReta s1 = ps[0];
		SegmentoReta s2 = ps[1];
			try{
				if(s1.declive() == s2.declive()) throw new IOException();
			}catch (IOException e){
				System.out.println("invalid points");
				System.exit(0);
			}
		Reta r1 = s1.inversa();
		Reta r2 = s2.inversa();
		return r1.intersecao(r2);
	}

	/**
	 * calcula a distancia do ponto p ao centro da circunferencia e depois subtrai pelo raio
	 * @pre ponto tem  de estar fora da circunferencia
	 * @param Ponto p encontra se fora da circunferencia
	 * @return double devolve a distancia do ponto p a circunferencia pela formula 
	 * @throws new IOException() sai do sistema com um mensagem "invalid points" se o raio for maior que a distancia entre os
	 * pontos p e o centro
	 */
	public double distancia(Ponto p) {
		double dx = centro.getX() - p.getX();
		double dy = centro.getY() - p.getY();
		double objetivo = (double) Math.sqrt(dx * dx + dy * dy);
		try{
			if(objetivo <= raio)throw new IOException();
		}catch (IOException e){
			System.out.println("invalid points");
			System.exit(0);
		}
		objetivo = objetivo - raio;
		return objetivo;
	}

	
	/** 
	 * 
	 * @return double devolve o raio da circunferencia
	 */
	public double getRaio() {
		return raio;
	}

	
	/** 
	 * @return Ponto devolve o ponto do centro da circunferencia
	 */
	public Ponto getCentro() {
		return new Ponto(centro.getX(), centro.getY());
	}

}