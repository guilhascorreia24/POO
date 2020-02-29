package lab3.lab3A;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class tests {
    @Test
    public void testConstructor0() {
        assertEquals(0, new T2time(0).asSeconds());
        assertEquals(3661, new T2time(3661).asSeconds());
        // ...
        assertEquals(48435, new T2time(48435).asSeconds());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor1() {
        new T2time(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor2() {
        new T2time(48436);
    }

    @Test
    public void testtoString0() {
        assertEquals("00:00:00", new T2time(0).toString());
        assertEquals("00:00:01", new T2time(1).toString());
        assertEquals("01:01:01", new T2time(3661).toString());
        assertEquals("13:27:15", new T2time(T2time.T2DAYSECONDS - 1).toString());
    }

    @Test
    public void testAdd0() {
        assertEquals("00:00:00", (new T2time(0, 0, 0).add(new T2time(0, 0, 0))).toString());
        assertEquals("00:00:01", (new T2time(0, 0, 1).add(new T2time(0, 0, 0))).toString());
        assertEquals("00:00:00", (new T2time(13, 27, 15).add(new T2time(0, 0, 1))).toString());
        assertEquals("00:00:01", (new T2time(13, 27, 15).add(new T2time(0, 0, 2))).toString());
        assertEquals("01:01:01", (new T2time(13, 27, 15).add(new T2time(1, 1, 2))).toString());
    }

    // Redirect STDIN and STDOUT for Mooshak like black box tests
    static private ByteArrayOutputStream setIOstreams(String input) {
        // set stdin
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // set stdout
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        return os;
    }

    /*
     * Mooshak performs black box tests Each row of the array represents one test
     * First element in the row is the input (what to put in STDIN) Second (and
     * last) element in the row is the expected output (at STDOUT)
     */
    static private String[][] stdiotests = { { "00:01:15\nasSeconds\n", "75\n" }, { "75\nasTime\n", "00:01:15\n" },
            { "13:27:15\nadd\n1\n", "00:00:00\n" }, { "13:27:15\nadd\n00:00:02\n", "00:00:01\n" }, };

    /*
     * Mooshak like black box tests
     */
    @Test (timeout=3000)
    public void testCase0() {
        for (String[] test : stdiotests) {
            String input = test[0];
            String expected = test[1];
            ByteArrayOutputStream os = setIOstreams(input);
            Client.main(null); // call Main()
            assertEquals(expected, os.toString());
        }
    }

}