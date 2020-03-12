/*import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	//bruno testes
	@Test
	public void testDistanceBetweenTwoPoints() {
		
		Point a = new Point(4,3);
		Point b = new Point(3,-2);
		//a(4,3) b(3,-2)
		assertEquals(5.0990195135927845,a.distancia(b));
		
		Point c = new Point(-2,4.7);
		Point d = new Point(1,9.8);
		//a(-2,4.7) b(1,9.8)
		assertEquals(5.916924876994806,c.distancia(d));
		
		Point e = new Point(18.3,2.3);
		Point f = new Point(1.8,4.4);
		//a(18.3,2.3) b(1.8,4.4)
		assertEquals(16.633099530754933,e.distancia(f));
		
		Point g = new Point(12.1,23);
		Point h = new Point(1.23,4.6);
		//a(12.1,23) b(1.23,4.6)
		assertEquals(21.370935870943974,g.distancia(h));
		
		Point i = new Point(-8,-2.3);
		Point j = new Point(-8.8,-10.5);
		//a(-8,-2.3) b(-8.8,-10.5)
		assertEquals(8.238931969618392,i.distancia(j));
		
	}
	
	@Test
	public void testSlope() {
		
		Point a = new Point(1.5,2.3);
		Point b = new Point(5.6,-1);
		//a(1.5,2.3) b(5.6,-1)
		assertEquals(-0.8048780487804879,a.slope(b));

		Point c = new Point(3.4,2.2);
		Point d = new Point(1.1,-9.8);
		//a(3.4,2.2) b(1.1,-0.5)
		assertEquals(5.217391304347826,c.slope(d));

		Point e = new Point(-0.4,0.0);
		Point f = new Point(0.0,-2);
		//a(-0.4,0) b(0,-2)
		assertEquals(-5,e.slope(f),0);
		
		Point g = new Point(1,5);
		Point h = new Point(9,4);
		//a(1,5) b(9,4)
		assertEquals(-0.125,g.slope(h));

		Point i = new Point(-8,-1);
		Point j = new Point(-3,-2.9);
		//a(-8,-1) b(-3,-2.9)
		assertEquals(-0.38,i.slope(j));
	}

	@Test
	public void testInversa() {
		
		Ponto a = new Point(0.0,0.0);
		Ponto b = new Point(2.0,2.0);
		SegmentoReta s1 = new SegmentoReta(a,b);
		Reta r1 = new Reta(-1.0,2.0)
		assertEquals(r1, s1.inversa());

		Ponto b = new Point(3.0,-3.5);
		Ponto b1 = new Point(2.0,2.5);
		SegmentoReta bs = new SegmentoReta(a,b);
		Reta r1 = new Reta(,-3.0)
		assertEquals(r1, s1.inversa());
		
	
	}


	@Test
	public void testPontoMedio() {
		Ponto a = new Point(0.0,0.0);
		Ponto a1 = new Point(2.0,2.0);
		SegmentoReta as = new SegmentoReta(a1,a1);
		Ponto am = new Point(1.0,1.0);
		assertEquals(am, as.pontomedio());
	
		Ponto b = new Point(3.0,-3.5);
		Ponto b1 = new Point(2.0,2.5);
		SegmentoReta bs = new SegmentoReta(a,b);
		Ponto bm = new Point(2.5,-0.5);
		assertEquals(bm, bs.pontomedio());



	}
	//fela tests
	@Test
	public void testdistancia1() {
		Point p= new Point(0.0,0.0);
		Point q= new Point(0.0,2.0);
		Point r= new Point(2.0,2.0);
		assertEquals(p.distancia(q),2.0);
		assertEquals(q.distancia(r),2.0);
		assertEquals(p.distancia(r),2.83);
	}
	
	public void testdistancia2() {
		Point p= new Point(0.0,0.0);
		Point q= new Point(0.0,4.0);
		Point r= new Point(4.0,4.0);
		assertEquals(p.distancia(q),4.0);
		assertEquals(q.distancia(r),4.0);
		assertEquals(p.distancia(r),5.66);
	}
	
	
	public void testdistancia3() {
		Point p= new Point(-2.0,2.0);
		Point q= new Point(2.0,2.0);
		Point r= new Point(2.0,-2.0);
		assertEquals(p.distancia(q),4.0);
		assertEquals(q.distancia(r),4.0);
		assertEquals(p.distancia(r),5.66);
	}

	//guilherme teste

	@Test
	public void intersecaoTests(){
		Reta a=new Reta(1,0);
		assertEquals(new Ponto(0,0),a.Intersecao(new Reta(-1,0)));
		
		Reta a=new Reta(4,5);
		assertEquals(new Ponto(1,9),a.Intersecao(new Reta(9,0)));

		Reta a=new Reta(0,2);
		assertEquals(new Ponto(-1,2),a.Intersecao(new Reta(-1,0)));

		Reta a=new Reta("n",0);
		assertEquals(new Ponto(2,2),a.Intersecao(new Reta(1,1)));

		Reta a=new Reta(-(1/8),8);
		assertEquals(new Ponto(0.58536,7.9268),a.Intersecao(new Reta(5,5)));

		Reta a=new Reta(2,2);
		assertEquals(new Ponto(-1,0),a.Intersecao(new Reta(-2,-2)));

	}

	@Test
	public void testdistanciaAcircunferencia(){
		raio=5;
		Ponto c=new Ponto(0,0);
		Circunferencia o=new Circunferencia(new Ponto(0,1),new Ponto())
		assertEquals(5,)
	}




}*/
