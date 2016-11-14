package Sensor;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import Interfaces.EventInterface;
import Listeners.LightEventListener;
import lejos.nxt.SensorPort;

public class LightSensor implements EventInterface<LightEventListener>, Runnable{
	
	private List<LightEventListener> listeners;
	private boolean isRunning;
	private lejos.nxt.LightSensor sensor;
	
	public LightSensor() {
		sensor = new lejos.nxt.LightSensor(SensorPort.S3);
		sensor.setFloodlight(true);
		isRunning = true;
		//start thread
		this.listeners = new ArrayList<>();
	}

	public void subscribe(LightEventListener listener) {
		if(!listeners.contains(listener)){
			listeners.add(listener);
		}
	}

	public void unsubscribe(LightEventListener listener) {
		if(listeners.contains(listener)){
			listeners.remove(listener);
		}
	}
	@Override
	public void notifyListeners() {
		for(LightEventListener lightListeners: listeners){
			lightListeners.onFindLineEvent();
		}
		
	}
	
	public void start(){
		new Thread(){
			@Override
			public void run() {
				boolean foundLine = false;
				while(isRunning){
					//System.out.println("Light Value: "+ sensor.getLightValue());
					if(sensor.getLightValue() <= 25 && sensor.getLightValue() >= 1){
						if(foundLine){
							notifyListeners();
							foundLine = true;
						}
					}
					else{
						foundLine = true;
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
