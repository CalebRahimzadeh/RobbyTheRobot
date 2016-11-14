package Utility;

import static org.junit.Assert.*;

import org.junit.Test;

import Utillity.Timer;

public class TimerTest {

	@Test
	public void testTimer() {
		Timer timer = null;
		assertNull(timer);
		timer = new Timer(0f);
		assertNotNull(timer);
		timer = new Timer(55555f);
		assertNotNull(timer);
	}

}
