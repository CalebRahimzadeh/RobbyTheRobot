package UI;

import lejos.nxt.Sound;

public class Tone {
	
	
	
	public Tone(){
		
	}
	
	public void shoutFowardTone(int duration){
		Sound.playTone(287, duration);
	}
	public void shoutBackwardTone(int duration){
		Sound.playTone(400, duration);
	}
	public void shoutPushingTone(int duration){
		Sound.playTone(100, duration);
	}

}
