package Sensor;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import Interfaces.EventInterface;
import Listeners.SonarEventListener;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class SonarSensor implements EventInterface<SonarEventListener>, Runnable{
	private boolean isRunning;
	private List<SonarEventListener> listeners;
	private UltrasonicSensor sensor;
	
	public SonarSensor(){
		sensor = new UltrasonicSensor(SensorPort.S2);
		this.listeners = new ArrayList();
		isRunning = true;
	}

	@Override
	public void subscribe(SonarEventListener listener) {
		if(!listeners.contains(listener)){
			listeners.add(listener);
		}
	}

	@Override
	public void unsubscribe(SonarEventListener listener) {
		if(listeners.contains(listener)){
			listeners.remove(listener);
		}
		
	}

	@Override
	public void notifyListeners() {
		for(SonarEventListener sonarListeners: listeners){
			sonarListeners.onObjectFound();
		}
	}
	
	public void start(){
		new Thread(){
			@Override
			public void run() {
				boolean foundObject = false;
				while(isRunning){
					if(sensor.capture() > 24){
						if(!foundObject){
						notifyListeners();
						foundObject = true;
						}	
					}
					else{
						foundObject = false;
					}			
				}
			}
			
		}.start();
		
	}

	@Override
	public void run() {
		start();
		
	}
	public void stop(){
		isRunning = false;
	}


}
