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
	 * @inv centro ponto que representa a circunferencia sem condicoes previas
	 * @inv raio e a distancia do centro a um dos pontos(p1,p2,p3) se condicoes previas
	 */
	public Circunferencia(Ponto p1, Ponto p2, Ponto p3) {
		this.centro=centro(p1, p2, p3);
		this.raio = p1.distancia(centro);
	}

	
	/** 
	 * @param p1 primeiro ponto da circunferencia
	 * @param p2 segundo ponto da circunferencia
	 * @param p3 terceiro ponto da circunferencia
	 * elabora os 2 segementos de reta que passa nos 3 pontos, deseguida encontra as inversas 
	 * desses 2 segementos reta e por fim calcula o ponto de intersecao dessas 2 retas 
	 * @pos declive das retas nao pode ser igual 
	 * @return Ponto devolve um ponto de intersecao das 2 retas que é o centro
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
	 * @pre ponto tem estar fora da circunferencia
	 * @param Ponto p encontra-se fora da circunferencia
	 * calcula a distancia do ponto p ao centro da circunferencia e deppois subtrai pelo raio
	 * @return double devolve a distancia do ponto p a circunferencia pela formula 
	 * @throws new IOException() sai do sistema com um mensagem "invalid points" se o raio for maior que a distancia entre os
	 * pontos p e centro
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
	 * @return Ponto devolve o ponto do centro
	 */
	public Ponto getCentro() {
		return new Ponto(centro.getX(), centro.getY());
	}

}