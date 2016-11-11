package Sensor;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import Listeners.LightEventListener;

public class LightSensor implements EventListener, Runnable{
	
	private List<LightEventListener> listeners;
	private boolean isRunning;
	
	public LightSensor() {
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
	
	public void start(){
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public void stop(){
		isRunning = false;
	}


}
