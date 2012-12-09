package fourletterwordgame;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fourletterwordgame.MyUtilities;


public class MyUtilitiesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testhowManyLettersMatch() {
		
		MyUtilities myUtilities = new MyUtilities();
		
		assertEquals(1,myUtilities.howManyLettersMatch("AABA","BBBB"));
		assertEquals(1,myUtilities.howManyLettersMatch("BBBB","AABA"));
		
	}

}
