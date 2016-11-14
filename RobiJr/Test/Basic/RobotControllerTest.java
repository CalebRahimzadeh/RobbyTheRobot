package Basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotControllerTest {

	@Test
	public void testRobotController() {
		RobotController controller = null;
		assertNull("Not null", controller);
		controller = new RobotController();
		assertNotNull("null" ,controller);
	}

}
