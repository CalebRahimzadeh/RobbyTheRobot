package Sensor;

import static org.junit.Assert.*;

import org.junit.Test;

public class ButtonSensorTest {

	@Test
	public void testButtonSensor() {
		ButtonSensor btnSensor = null;
		assertNull(btnSensor);
		btnSensor = new ButtonSensor();
		assertNotNull(btnSensor);
	}

//	@Test
//	public void testSubscribe() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUnsubscribe() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testNotifyListeners() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testStart() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRun() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testStop() {
//		fail("Not yet implemented");
//	}

}
