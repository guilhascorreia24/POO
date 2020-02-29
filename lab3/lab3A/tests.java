package lab3.lab3A;

import static org.junit.Assert.*;

import org.junit.Test;

public class tests {
    @Test
    public void testConstructor0() {
    assertEquals(0, new T2time( 0).asSeconds());
    assertEquals(3661, new T2time( 3661).asSeconds());
    //...
    assertEquals(48435, new T2time(48435).asSeconds()); }

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor1() {
    new T2time(-1);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor2() {
    new T2time(48436);
     }

     @Test
     public void testtoString0() {
     assertEquals("00:00:00", new T2time( 0).toString());
     assertEquals("00:00:01", new T2time( 1).toString());
     assertEquals("01:01:01", new T2time(3661).toString());
     assertEquals("13:27:15", new T2time(T2time.T2DAYSECONDS-1).toString());
     }

     @Test
     public void testAdd0() {
     assertEquals("00:00:00",
     (new T2time(0,0,0).add(new T2time(0,0,0))).toString());
     assertEquals("00:00:01",
     (new T2time(0,0,1).add(new T2time(0,0,0))).toString());
     assertEquals("00:00:00",
     (new T2time(13,27,15).add(new T2time(0,0,1))).toString());
     assertEquals("00:00:01",
     (new T2time(13,27,15).add(new T2time(0,0,2))).toString());
     assertEquals("01:01:01",
     (new T2time(13,27,15).add(new T2time(1,1,2))).toString());
      }
}