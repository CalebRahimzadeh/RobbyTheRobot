package UI;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToneTest {

	@Test
	public void testTone() {
		Tone tone = null;
		assertNull(tone);
		tone = new Tone();
		assertNotNull(tone);
	}

//	@Test
//	public void testShoutFowardTone() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testShoutBackwardTone() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testShoutPushingTone() {
//		fail("Not yet implemented");
//	}

}
