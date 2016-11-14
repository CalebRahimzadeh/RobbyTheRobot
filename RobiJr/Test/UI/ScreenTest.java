package UI;
import static org.junit.Assert.*;
import org.junit.Test;

import Sensor.ButtonSensor;

public class ScreenTest {

	@Test
	public void testScreen() {
		Screen screen = null;
		assertNull(screen);
		screen = new Screen();
		assertNotNull(screen);
	}
	@Test
	public void testDisplayHowLongCanPush() {
		Screen screen = new Screen();
		String result = screen.howLongCanPushMsg(555);
		assertEquals("Time to push can: 555", result);
		result = screen.howLongCanPushMsg(01);
		System.out.println(result);
		assertEquals("Time to push can: 1", result);
	}

	@Test
	public void testDisplayHowManyCansMoved() {
		Screen screen = new Screen();
		String result = screen.howManyCansMovedMsg(3);
		assertEquals("Cans moved: 3",  result);
	}

	@Test
	public void testDisplayHowFarCanPushed() {
		Screen screen = new Screen();
		String result = screen.howFarCanPushedMsg(10);
		assertEquals("Distance cans Pushed: 10",  result);
	}

}
