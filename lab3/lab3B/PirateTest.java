/*package lab3.lab3B;
import static org.junit.Assert.*;

import org.junit.Test;

public class PirateTest 
{
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor_FEqualsOrLessThen10()
	{
		new BordaFora("10");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor_FEqualsOrHigherThen99999999()
	{
		new BordaFora("99999999");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructor_FDigitsAreNotEven()
	{
		new BordaFora("100");
	}
	
	@Test
	public void testConstructor0()
	{
		new BordaFora("50");
	}
	
	@Test
	public void testEliminateEnemies()
	{
		assertEquals(1, new BordaFora("45").steps());
		assertEquals(3, new BordaFora("3151").steps());
		assertEquals(12, new BordaFora("14115123").steps());
    }
    
    @Test
	public void testclone()
	{
        new BordaFora("45").clone();
        new BordaFora("3151").clone();
	}
}*/
