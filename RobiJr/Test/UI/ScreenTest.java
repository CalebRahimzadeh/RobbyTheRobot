package UI;
import 
import static org.junit.Assert.*;
import org.junit.Test;

public class ScreenTest {

	@Test
	public void testDisplayHowLongCanPush() {
		Screen screen = new Screen();
		int counter = 5;
		String result = screen.displayHowLongCanPush(counter);
		assertEquals("Time to push can: 5", result);
	}

	@Test
	public void testDisplayHowManyCansMoved() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisplayHowFarCanPushed() {
		Screen screen = new Screen();
		screen.displayHowFarCanPushed(5);
		Distance cans Pushed: 
		fail("Not yet implemented");
	}

}
