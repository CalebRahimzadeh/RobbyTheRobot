package Sensor;

import static org.junit.Assert.*;

import org.junit.Test;

public class SonarSensorTest {
	@Test
	public void testSonarSensor() {
		SonarSensor sonarSensor = null;
		assertNull(sonarSensor);
		sonarSensor = new SonarSensor();
		assertNotNull(sonarSensor);
		
	}
}
