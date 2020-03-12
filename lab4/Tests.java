import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void testDistanceBetweenTwoPontos() {
		
		Ponto a = new Ponto(4,3);
		Ponto b = new Ponto(3,-2);
		//a(4,3) b(3,-2)
		assertEquals(5.0990195135927845,a.distancia(b));
		
		Ponto c = new Ponto(-2,4.7f);
		Ponto d = new Ponto(1,9.8f);
		//a(-2,4.7) b(1,9.8)
		assertEquals(5.916924876994806,c.distancia(d));
		
		Ponto e = new Ponto(18.3f,2.3f);
		Ponto f = new Ponto(1.8f,4.4f);
		//a(18.3,2.3) b(1.8,4.4)
		assertEquals(16.633099530754933,e.distancia(f));
		
		Ponto g = new Ponto(12.1f,23f);
		Ponto h = new Ponto(1.23f,4.6f);
		//a(12.1,23) b(1.23,4.6)
		assertEquals(21.370935870943974,g.distancia(h));
		
		Ponto i = new Ponto(-8f,-2.3f);
		Ponto j = new Ponto(-8.8f,-10.5f);
		//a(-8,-2.3) b(-8.8,-10.5)
		assertEquals(8.238931969618392,i.distancia(j));
		
	}
	
	@Test
	public void testSlope() {
		
		Ponto a = new Ponto(1.5f,2.3f);
		Ponto b = new Ponto(5.6f,-1f);
		//a(1.5,2.3) b(5.6,-1)
		assertEquals(-0.8048780487804879,a.slope(b));

		Ponto c = new Ponto(3.4f,2.2f);
		Ponto d = new Ponto(1.1f,-9.8f);
		//a(3.4,2.2) b(1.1,-0.5)
		assertEquals(5.217391304347826,c.slope(d));

		Ponto e = new Ponto(-0.4f,0.0f);
		Ponto f = new Ponto(0.0f,-2f);
		//a(-0.4,0) b(0,-2)
		assertEquals(-5,e.slope(f),0);
		
		Ponto g = new Ponto(1,5);
		Ponto h = new Ponto(9,4);
		//a(1,5) b(9,4)
		assertEquals(-0.125,g.slope(h));

		Ponto i = new Ponto(-8,-1);
		Ponto j = new Ponto(-3,-2.9);
		//a(-8,-1) b(-3,-2.9)
		assertEquals(-0.38,i.slope(j));
	}

	@Test
	public void testInversa() {
		
		Ponto a = new Ponto(0.0f,0.0f);
		Ponto b = new Ponto(2.0f,2.0f);
		SegmentoReta s1 = new SegmentoReta(a,b);
		Reta r1 = new Reta(-1.0f,2.0f)
		assertEquals(r1, s1.inversa());

		Ponto b = new Ponto(3.0f,-3.5f);
		Ponto b1 = new Ponto(2.0f,2.5f);
		SegmentoReta bs = new SegmentoReta(a,b);
		Reta r2 = new Reta((float)(1/6),(float)(11/12))
		assertEquals(r2, bs.inversa());

		Ponto c = new Ponto(1.0f,1.0f);
		Ponto c1 = new Ponto(0.0f,2.5f);
		SegmentoReta cs = new SegmentoReta(a,b);
		Reta r3 = new Reta((2/3),(17/12))
		assertEquals(r3, cs.inversa());
	
	}


	@Test
	public void testPontoMedio() {
		Ponto a = new Ponto(0.0f,0.0f);
		Ponto a1 = new Ponto(2.0f,2.0f);
		SegmentoReta as = new SegmentoReta(a1,a1);
		Ponto am = new Ponto(1.0f,1.0f);
		assertEquals(am, as.pontoMedio());
	
		Ponto b = new Ponto(3.0f,-3.5f);
		Ponto b1 = new Ponto(2.0f,2.5f);
		SegmentoReta bs = new SegmentoReta(a,b);
		Ponto bm = new Ponto(2.5f,-0.5f);
		assertEquals(bm, bs.pontomedio());

		Ponto c = new Ponto(1.0f,1.0f);
		Ponto c1 = new Ponto(0.0f,2.5f);
		SegmentoReta cs = new SegmentoReta(a,b);
		Ponto cm = new Ponto(0.5f,1.75f);
		assertEquals(cm, cs.pontomedio());



	}


	@Test
	public void testdistancia1() {
		Ponto p= new Ponto(0.0f,0.0f);
		Ponto q= new Ponto(0.0f,2.0f);
		Ponto r= new Ponto(2.0f,2.0f);
		assertEquals(p.distancia(q),2.0f);
		assertEquals(q.distancia(r),2.0f);
		assertEquals(p.distancia(r),2.83f);
	}
	
	public void testdistancia2() {
		Ponto p= new Ponto(0.0f,0.0f);
		Ponto q= new Ponto(0.0f,4.0f);
		Ponto r= new Ponto(4.0f,4.0f);
		assertEquals(p.distancia(q),4.0f);
		assertEquals(q.distancia(r),4.0f);
		assertEquals(p.distancia(r),5.66f);
	}
	
	
	public void testdistancia3() {
		Ponto p= new Ponto(-2.0f,2.0f);
		Ponto q= new Ponto(2.0f,2.0f);
		Ponto r= new Ponto(2.0f,-2.0f);
		assertEquals(p.distancia(q),4.0f);
		assertEquals(q.distancia(r),4.0f);
		assertEquals(p.distancia(r),5.66f);
	}

	@Test
	public void intersecaoTests(){
		Reta a=new Reta(1f,0f);
		assertEquals(new Ponto(0f,0f),a.Intersecao(new Reta(-1f,0f)));
		
		Reta a=new Reta(4f,5f);
		assertEquals(new Ponto(1f,9f),a.Intersecao(new Reta(9f,0f)));

		Reta a=new Reta(0f,2f);
		assertEquals(new Ponto(-1f,2f),a.Intersecao(new Reta(-1f,0f)));

		Reta a=new Reta(2f);
		assertEquals(new Ponto(2f,2f),a.Intersecao(new Reta(1f,1f)));

		Reta a=new Reta(-(1/8),8);
		assertEquals(new Ponto(0.58536f,7.9268f),a.Intersecao(new Reta(5f,5f)));

		Reta a=new Reta(2f,2f);
		assertEquals(new Ponto(-1,0),a.Intersecao(new Reta(-2f,-2f)));

	}

	@Test
	public void testdistanciaAcircunferencia(){
		float raio=5;
		Ponto c=new Ponto(0,0);
		Circunferencia o=new Circunferencia(new Ponto(0f,1f),new Ponto())
		assertEquals(5,)
	}




}
