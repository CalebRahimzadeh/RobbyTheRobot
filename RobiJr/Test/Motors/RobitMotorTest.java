package Motors;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobitMotorTest {

	
	@Test
	public void testRobitMotor() {
		RobitMotor motor = null;
		assertNull(motor);
		motor = new RobitMotor();
		assertNotNull(motor);
	}

	@Test
	public void testJustSawLine() {
		RobitMotor motor = new RobitMotor();
		assertEquals("true", true, motor.justSawLine());
	}

	@Test
	public void testSetSawLine() {
		RobitMotor motor = new RobitMotor();
		motor.setSawLine(true);
		assertEquals("Motor saw the line (true)", true, motor.justSawLine());
		motor.setSawLine(false);
		assertEquals("Motor saw the line", true, motor.justSawLine());
		
	}

	@Test
	public void testReverse() {
		fail("Not yet implemented");
	}

}
