package Utillity;

public class Counter {
	
	private int canCounter;
	private int TimeCounter;
	private int canPushedCounter;
	
	public Counter(){
		canCounter = 0;
		TimeCounter = 0;
		canPushedCounter = 0;
		
	}

	public int getCanCounter() {
		return canCounter;
	}

	public void setCanCounter(int canCounter) {
		this.canCounter = canCounter;
	}

	public int getTimeCounter() {
		return TimeCounter;
	}

	public void setTimeCounter(int timeCounter) {
		TimeCounter = timeCounter;
	}

	public int getCanPushedCounter() {
		return canPushedCounter;
	}

	public void setCanPushedCounter(int canPushedCounter) {
		this.canPushedCounter = canPushedCounter;
	}
	
	
	

}
