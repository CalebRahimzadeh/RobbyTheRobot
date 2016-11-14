package Sensor;

import java.util.ArrayList;
import java.util.List;

import Interfaces.EventInterface;
import Listeners.ButtonEventListener;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class ButtonSensor implements EventInterface<ButtonEventListener>, Runnable {

	private List<ButtonEventListener> listeners;
	private TouchSensor sensor;
	private boolean isRunning;

	public ButtonSensor() {
		sensor = new TouchSensor(SensorPort.S1);
		isRunning = true;
		listeners = new ArrayList();
	}

	public void subscribe(ButtonEventListener listener) {
		// add listener to list
		if (!listeners.contains(listener)) {
			listeners.add(listener);
		}
	}

	public void unsubscribe(ButtonEventListener listener) {
		// remove listener to list
		if (listeners.contains(listener)) {
			listeners.remove(listener);
		}
	}

	@Override
	public void notifyListeners() {
		for (ButtonEventListener buttonEventListener : listeners) {
			buttonEventListener.onButtonPress();
		}
	}

	public void start() {
		new Thread() {
			@Override
			public void run() {
				boolean justPressed = false;

				while (isRunning) {
					if (sensor.isPressed()) {

						if (!justPressed) {

							notifyListeners();
							justPressed = true;
						}
					} else {
						justPressed = false;
					}
				}
			}
		}.start();
	}

	@Override
	public void run() {
		this.start();
	}

	public void stop() {
		this.isRunning = false;
	}
}
