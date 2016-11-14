package UI;
import static org.junit.Assert.*;
import org.junit.Test;

public class ScreenTest {

	@Test
	public void testDisplayHowLongCanPush() {
		Screen screen = new Screen();
		String result = screen.howLongCanPushMsg(5);
		assertEquals("Time to push can: 5", result);
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
