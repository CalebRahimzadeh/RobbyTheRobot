package Motors;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobitMotorTest {

	
	@Test
	public void testRobitMotor() {
		RobitMotor motor = new RobitMotor();
		if(motor != null)
			assertTrue("Motor constructed",true);
		else
			fail("Motor not constructed");
	}

	@Test
	public void testDriveFoward() {
		fail("Not yet implemented");
	}

	@Test
	public void testGoFast() {
		fail("Not yet implemented");
	}

	@Test
	public void testGoSlow() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeek() {
		fail("Not yet implemented");
	}

	@Test
	public void testTurnAround() {
		fail("Not yet implemented");
	}

	@Test
	public void testStop() {
		fail("Not yet implemented");
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
