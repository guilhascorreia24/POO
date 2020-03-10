import static org.junit.Assert.*;

import org.junit.Test;

public class PointandCircunferenceTests {

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


}
