package Motors;
import UI.Tone;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class RobitMotor {
	
	
	 private final double WHEEL_DIAM = 2;
	    private final double TRACK_WIDTH = 4.5;
	    private final int TRAVEL_SPEED =9;
	    private final int HIGH_SPEED = 12;
	    private final int TURN_SPEED = 100;
	    private boolean sawLine = false;
	    private Tone tones;
	    private DifferentialPilot pilot;
	    
	    public RobitMotor(){
	    	tones = new Tone();
	        pilot = new DifferentialPilot(WHEEL_DIAM, TRACK_WIDTH, Motor.A, Motor.B);
	        pilot.setTravelSpeed(TRAVEL_SPEED);
	    }	
	    public void driveFoward(){
	   
	        synchronized(this){
	            new Thread(new Runnable(){
	                @Override
	                public void run() {
	              
	                    pilot.forward();
	                }
	            }).start();
	        }
	    }
	    
	    public void goFast(){
	        pilot.setTravelSpeed(HIGH_SPEED);
	    }
	    
	    public void goSlow(){
	        pilot.setTravelSpeed(TRAVEL_SPEED);
	    }
	    public void seek() {
	        synchronized(this){
	            pilot.setRotateSpeed(TURN_SPEED);
	            new Thread(new Runnable(){
	                @Override
	                public void run() {
	                    pilot.rotateLeft();
	                }
	            }).start();
	        }
	    }
	    public void turnAround(){
	        synchronized(this){
	            pilot.setRotateSpeed(TURN_SPEED);
	            new Thread(new Runnable(){
	                @Override
	                public void run() {
	                    pilot.stop();
	                    pilot.rotateRight();
	                }
	            }).start();
	        }
	    }
	    public void stop(){
	        synchronized(this){
	            new Thread(new Runnable(){
	                @Override
	                public void run() {
	                    pilot.stop();
	                }
	            }).start();
	        }
	    }
	    
	    public boolean justSawLine() {
	        return sawLine;
	    }
	    
	    public void setSawLine(boolean sawLine){
	        this.sawLine = sawLine;
	    }
	    
	    public void reverse() {
	    	
	        synchronized(this){
	            new Thread(new Runnable(){
	                @Override
	                public void run() {
	                	
	                    pilot.backward();
	                }
	            }).start();
	        }
	    }
	

}
