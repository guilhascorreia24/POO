/**
 * @version 1.2 
 * @author Guilherme Correia 61098  
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 * @since Problem for lab groups: The Point and the Circumference
 */
/*import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {

	//-----------------------Teste connstrutor Ponto------------------------------
	@Test 
	public void testPonto(){
		new Ponto(0,1);
	}
	
	@Test
	public void testPonto1(){
		new Ponto(1,11);
	}

	@Test
	public void TestPonto2(){
		new Ponto(0,0);
	}
	
	@Test
	public void TestPonto3(){
		new Ponto(321,213);
	}

//---------------------------------Teste Contrutor Reta-------------------------------------
	@Test
	public void TestReta1(){
		new Reta(2.2,27);
	}
	@Test
	public void TestReta2(){
		new Reta(1,0);
	}
	@Test
	public void TestReta3(){
		new Reta(24);
	}
	@Test
	public void TestReta4(){
		new Reta(0,24);
	}

//---------------------------------------Teste Contrutor SegemntoReta-------------------------
	@Test
	public void testSegmento(){
		new SegmentoReta(new Ponto(0,1),new Ponto(321,213));
	}
	@Test
	public void testSegmento1(){
		new SegmentoReta(new Ponto(7,1),new Ponto(3,2));
	}

	@Test
	public void testSegmento2(){
		new SegmentoReta(new Ponto(660,1),new Ponto(0,1));
	}
	@Test
	public void testSegmento3(){
		new SegmentoReta(new Ponto(10,1),new Ponto(0,3));
	}

//-----------------------------------------teste Contrutor Circunferencia --------------------------------------



	@Test
	public void TestCircunferencia3(){
		new Circunferencia(new Ponto(10,1), new Ponto(9,11), new Ponto(10,9));
	}

	@Test
	public void TestCircunferencia4(){
		new Circunferencia(new Ponto(10,10), new Ponto(0,10), new Ponto(10,0));
	}


//------------------------------------------teste distancia entre 2 pontos---------------------------
	@Test
	public void testDistanceBetweenTwoPontos() {

		Ponto a = new Ponto(4, 3);
		Ponto b = new Ponto(3, -2);
		assertEquals(5.0990195135927845, a.distancia(b), 0);

		 a = new Ponto(-2, 4.7);
		 b = new Ponto(1, 9.8);
		assertEquals(5.916924876994806, a.distancia(b), 0);

		 a = new Ponto(18.3, 2.3);
		 b = new Ponto(1.8, 4.4);
		assertEquals(16.633099530754933, a.distancia(b), 0);

		 a = new Ponto(12.1, 23);
		 b = new Ponto(1.23, 4.6);
		assertEquals(21.370935870943974, a.distancia(b), 0);

		 a = new Ponto(-8, -2.3);
		 b = new Ponto(-8.8, -10.5);
		assertEquals(8.238931969618392, a.distancia(b), 0);

		 a = new Ponto(5,2);
		 b = new Ponto(5,2);
		assertEquals(0, a.distancia(b), 0);
	}

//--------------------------------------------Teste declive--------------------------------------
	@Test
	public void testdeclive() {

		Ponto a = new Ponto(1.5, 2.3);
		Ponto b = new Ponto(5.6, -1);
		SegmentoReta r = new SegmentoReta(a, b);
		assertEquals(-0.8048780487804879, r.declive(), 0);

		 a = new Ponto(3.4, 2.2);
		 b = new Ponto(1.1, -9.8);
		 r = new SegmentoReta(a, b);
		assertEquals(5.217391304347826, r.declive(), 0);

		 a = new Ponto(-0.4, 0.0);
		 b = new Ponto(0.0, -2);
		 r = new SegmentoReta(a, b);
		assertEquals(-5, r.declive(), 0);

		 a = new Ponto(1, 5);
		 b = new Ponto(9, 4);
		 r = new SegmentoReta(a, b);
		// a(1,5) b(9,4)
		assertEquals(-0.125, r.declive(), 0);

		 a = new Ponto(-8, -1);
		 b = new Ponto(-3, -2.9);
		 r = new SegmentoReta(a, b);
		// a(-8,-1) b(-3,-2.9)
		assertEquals(-0.38, r.declive(), 0);

		 a = new Ponto(3, -3.5);
		 b = new Ponto(2, 2.5);
		 r = new SegmentoReta(a, b);
		// a(-8,-1) b(-3,-2.9)
		assertEquals(-6, r.declive(), 0);
	}


///---------------------------------------------Teste a funcao Inversa------------------------
	@Test
	public void testInversa() {

		Ponto a = new Ponto(0.0, 0.0);
		Ponto a1 = new Ponto(2.0, 2.0);
		SegmentoReta s1 = new SegmentoReta(a, a1);
		Reta r1 = new Reta(-1.0, 2.0);
		assertEquals(r1.toString(), s1.inversa().toString());

		Ponto b = new Ponto(3.0, -3.5);
		Ponto b1 = new Ponto(2.0, 2.5);
		SegmentoReta bs = new SegmentoReta(b, b1);
		double t = (double)1 / 6;
		double t1 =-(double)11 / 12;
		Reta r2 = new Reta(t, t1);
		assertEquals(r2.toString(), bs.inversa().toString());

		Ponto c = new Ponto(1.0, 1.0);
		Ponto c1 = new Ponto(0.0, 2.5);
		SegmentoReta cs = new SegmentoReta(c, c1);
		Reta r3 = new Reta(1/(1.5),(double)8.5/6);
		assertEquals(r3.toString(), cs.inversa().toString());

		Ponto d = new Ponto(-1.0, -1.0);
		Ponto d1 = new Ponto(2.0, 2.0);
		SegmentoReta ds = new SegmentoReta(d, d1);
		Reta r4 = new Reta(-1.0, 1);
		assertEquals(r4.toString(), ds.inversa().toString());
	}

//---------------------------------teste ao ponto medio de um segemnto de Reta------------------------
	@Test
	public void testPontoMedio() {
		Ponto a = new Ponto(0.0, 0.0);
		Ponto a1 = new Ponto(2.0, 2.0);
		SegmentoReta as = new SegmentoReta(a, a1);
		Ponto am = new Ponto(1.0, 1.0);
		assertEquals(am.toString(), as.pontoMedio().toString());

		Ponto b = new Ponto(3.0, -3.5);
		Ponto b1 = new Ponto(2.0, 2.5);
		SegmentoReta bs = new SegmentoReta(b, b1);
		Ponto bm = new Ponto(2.5, -0.5);
		assertEquals(bm.toString(), bs.pontoMedio().toString());

		Ponto c = new Ponto(1.0, 1.0);
		Ponto c1 = new Ponto(0.0, 2.5);
		SegmentoReta cs = new SegmentoReta(c, c1);
		Ponto cm = new Ponto(0.5, 1.75);
		assertEquals(cm.toString(), cs.pontoMedio().toString());

		Ponto d = new Ponto(-1.0, -1.0);
		Ponto d1 = new Ponto(2.0, 2.0);
		SegmentoReta ds = new SegmentoReta(d, d1);
		Ponto dm = new Ponto(0.5, 0.5);
		assertEquals(dm.toString(), ds.pontoMedio().toString());

	}

//--------------------------------------------teste a funcao da intersecao de 2 retas----------------------
	@Test
	public void intersecaoTests0() {
		Reta a = new Reta(1, 0);
		assertEquals(new Ponto(0, 0).toString(), a.intersecao(new Reta(-1, 0)).toString());

		 a = new Reta(4, 5);
		assertEquals(new Ponto(1, 9).toString(), a.intersecao(new Reta(9, 0)).toString());

		 a = new Reta(0, 2);
		assertEquals(new Ponto(-2, 2).toString(), a.intersecao(new Reta(-1, 0)).toString());

		 a = new Reta(1, 10);
		assertEquals(new Ponto(-4.5, 5.5).toString(), a.intersecao(new Reta(-1, 1)).toString());

		 a = new Reta(-(double)1 / 8, 8);
		assertEquals(new Ponto(0.5853658536585366 , 7.926829268292683).toString(), a.intersecao(new Reta(5, 5)).toString());

		 a = new Reta(2, 2);
		assertEquals(new Ponto(-1, 0).toString(), a.intersecao(new Reta(-2, -2)).toString());
	}

//-----------------------------------------teste a distancia da circunferencia ao ponto-----------------------------
	@Test
	public void testdistanciaAcircunerencia2() {
		Ponto c = new Ponto(10, 10);
		Circunferencia o = new Circunferencia(new Ponto(-5, 0), new Ponto(5, 0), new Ponto(0, -5));
		assertEquals(9.142135623730951, o.distancia(c), 0);

		 c = new Ponto(0, 20);
		 o = new Circunferencia(new Ponto(2, 0), new Ponto(0, 2), new Ponto(-2, 0));
		assertEquals(18, o.distancia(c), 0);

		 c = new Ponto(2, 3);
		 o = new Circunferencia(new Ponto(0, -3), new Ponto(-3, 0), new Ponto(3, 0));
		assertEquals(0.6055512754639891, o.distancia(c), 0);
	}	
}*/