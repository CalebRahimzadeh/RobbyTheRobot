package Motors;

import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class RobitMotor {

	private final double WHEEL_DIAM = 2;
	private final double TRACK_WIDTH = 4.5;
	private final int TRAVEL_SPEED = 5;
	private final int HIGH_SPEED = 12;
	private final int TURN_SPEED = 90;
	private boolean sawLine = false;
	private DifferentialPilot pilot;

	public RobitMotor() {
		pilot = new DifferentialPilot(WHEEL_DIAM, TRACK_WIDTH, Motor.A, Motor.B);
		pilot.setTravelSpeed(TRAVEL_SPEED);
	}

	public void driveFoward() {
		synchronized (this) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					pilot.backward();
				}
			}).start();
		}
	}

	public void goFast() {
		pilot.setTravelSpeed(HIGH_SPEED);
	}

	public void goSlow() {
		pilot.setTravelSpeed(TRAVEL_SPEED);
	}

	public void seek() {
		synchronized (this) {
			pilot.setRotateSpeed(TURN_SPEED);
			new Thread(new Runnable() {
				@Override
				public void run() {
					pilot.rotateLeft();
				}
			}).start();
		}
	}

	public void turnAround() {
		synchronized (this) {
			pilot.setRotateSpeed(TURN_SPEED);
			new Thread(new Runnable() {
				@Override
				public void run() {
					pilot.stop();
					pilot.rotateRight();
				}
			}).start();
		}
	}

	public void stop() {
		synchronized (this) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					pilot.stop();
				}
			}).start();
		}
	}

	public boolean justSawLine() {
		return this.sawLine;
	}

	public void setSawLine(boolean sawLine) {
		this.sawLine = sawLine;
	}

	public void reverse() {
		synchronized (this) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					pilot.forward();
				}
			}).start();
		}
	}

}
