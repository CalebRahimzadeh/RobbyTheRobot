package Utillity;

import java.util.ArrayList;
import java.util.List;

import Interfaces.EventInterface;
import Listeners.TimerListener;


public class Timer implements EventInterface<TimerListener> {
	private List<TimerListener> Listeners;
	private final long TIME;
	
	public Timer(float timeInSeconds){
		Listeners = new ArrayList<>();
		this.TIME = (long) (timeInSeconds * 1000);
	}

	@Override
	public void subscribe(TimerListener listener) {
		if(!Listeners.contains(listener)){
			Listeners.add(listener);
		}
	}

	@Override
	public void unsubscribe(TimerListener listener) {
		if(Listeners.contains(listener)){
			Listeners.remove(listener);
		}

	}

	@Override
	public void notifyListeners() {
		for(TimerListener listner: Listeners){
			listner.onTimerFinish(this);
		}

	}

	public void start(){
		new Thread(){
			public void run() {
				try {
					Thread.sleep(TIME);
					notifyListeners();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}.start();
	}
	
}
