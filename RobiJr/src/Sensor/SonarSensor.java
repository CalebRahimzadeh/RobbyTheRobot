package Sensor;

import java.util.EventListener;

import Interfaces.EventInterface;

public class SonarSensor implements EventInterface, Runnable{
	private boolean isRunning;
	
	public SonarSensor(){
		isRunning = true;
		//create list of listeners
		//start thread
	}

	@Override
	public void subscribe(Object listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsubscribe(Object listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyListeners() {
		// TODO Auto-generated method stub
		
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
