import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void testDistanceBetweenTwoPoints() {
		
		Point a = new Point(4,3);
		Point b = new Point(3,-2);
		//a(4,3) b(3,-2)
		assertEquals(5.0990195135927845,a.distance(b),0);
		
		Point c = new Point(-2,4.7);
		Point d = new Point(1,9.8);
		//a(-2,4.7) b(1,9.8)
		assertEquals(5.916924876994806,c.distance(d),0);
		
		Point e = new Point(18.3,2.3);
		Point f = new Point(1.8,4.4);
		//a(18.3,2.3) b(1.8,4.4)
		assertEquals(16.633099530754933,e.distance(f),0);
		
		Point g = new Point(12.1,23);
		Point h = new Point(1.23,4.6);
		//a(12.1,23) b(1.23,4.6)
		assertEquals(21.370935870943974,g.distance(h),0);
		
		Point i = new Point(-8,-2.3);
		Point j = new Point(-8.8,-10.5);
		//a(-8,-2.3) b(-8.8,-10.5)
		assertEquals(8.238931969618392,i.distance(j),0);
		
	}
	
	@Test
	public void testSlope() {
		
		Point a = new Point(1.5,2.3);
		Point b = new Point(5.6,-1);
		//a(1.5,2.3) b(5.6,-1)
		assertEquals(-0.8048780487804879,a.slope(b),0);

		Point c = new Point(3.4,2.2);
		Point d = new Point(1.1,-9.8);
		//a(3.4,2.2) b(1.1,-0.5)
		assertEquals(5.217391304347826,c.slope(d),0);

		Point e = new Point(-0.4,0.0);
		Point f = new Point(0.0,-2);
		//a(-0.4,0) b(0,-2)
		assertEquals(-5,e.slope(f),0);
		
		Point g = new Point(1,5);
		Point h = new Point(9,4);
		//a(1,5) b(9,4)
		assertEquals(-0.125,g.slope(h),0);

		Point i = new Point(-8,-1);
		Point j = new Point(-3,-2.9);
		//a(-8,-1) b(-3,-2.9)
		assertEquals(-0.38,i.slope(j),0);
	}

	@Test
	public void testInverseSlope() {
		
		Point a = new Point(0.0,0.0);
		
		//m = 5
		assertEquals(-0.2,a.inverseSlope(5),0);

		//m = 1.6
		assertEquals(-0.625,a.inverseSlope(1.6),0);

		//m = 8.7
		assertEquals(-0.1149425287356322,a.inverseSlope(8.7),0);

		//m = -3.2
		assertEquals(0.3125,a.inverseSlope(-3.2),0);

		//m = -4.8
		assertEquals(0.20833333333333334,a.inverseSlope(-4.8),0);
	}
}
