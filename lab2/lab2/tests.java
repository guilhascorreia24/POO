/*package lab2.lab2;

import static org.junit.Assert.*;

import org.junit.Test;

public class tests {
    @Test
    public void testConstructor0() {
        assertEquals(0, new Hora("0").convert_seconds());
        assertEquals(3661, new Hora("3661").convert_seconds());
        // ...
        assertEquals(48435, new Hora("48435").convert_seconds());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1() {
        new Hora("-1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2() {
        new Hora("48436");
    }

    @Test
    public void testtoString0() {
        assertEquals("00:00:00", new Hora("0").toString());
        assertEquals("00:00:01", new Hora("1").toString());
        assertEquals("01:01:01", new Hora("3661").toString());
        assertEquals("13:27:15", new Hora(String.valueOf(Hora.total - 1)).toString());
    }

    @Test
    public void testAdd0() {
        assertEquals("00:00:00", (new Hora(0, 0, 0).add(new Hora(0, 0, 0))).toString());
        assertEquals("00:00:01", (new Hora(0, 0, 1).add(new Hora(0, 0, 0))).toString());
        assertEquals("00:00:00", (new Hora(13, 27, 15).add(new Hora(0, 0, 1))).toString());
        assertEquals("00:00:01", (new Hora(13, 27, 15).add(new Hora(0, 0, 2))).toString());
        assertEquals("01:01:01", (new Hora(13, 27, 15).add(new Hora(1, 1, 2))).toString());
    }
}*/