package UI;

import lejos.nxt.Sound;

public class Tone {
		
	public Tone(){
		
	}
	
	public void shoutFowardTone(int duration){
		Sound.playTone(4, duration);
	}
	public void shoutBackwardTone(int duration){
		Sound.playTone(2, duration);
	}
	public void shoutPushingTone(int duration){
		Sound.playTone(1, duration);
	}

}
