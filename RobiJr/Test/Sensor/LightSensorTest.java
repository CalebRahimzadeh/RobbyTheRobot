package Sensor;

import static org.junit.Assert.*;

import org.junit.Test;

public class LightSensorTest {

	@Test
	public void testLightSensor() {
		LightSensor lightSensor = null;
		assertNull(lightSensor);
		lightSensor = new LightSensor();
		assertNotNull(lightSensor);
	}
}
