package Basic;

import Listeners.ButtonEventListener;
import Listeners.LightEventListener;
import Listeners.SonarEventListener;
import Listeners.TimerListener;
import Motors.RobitMotor;
import Sensor.ButtonSensor;
import Sensor.LightSensor;
import Sensor.SonarSensor;
import UI.Screen;
import UI.Tone;
import Utillity.Timer;
import enums.State;
import lejos.nxt.Sound;

public class RobotController implements ButtonEventListener, SonarEventListener, LightEventListener, TimerListener{

	private ButtonSensor buttonSensor;
	private LightSensor lightSensor;
	private SonarSensor sonarSensor;
	private RobitMotor robitMotor;
	private State currentState;
	private int canCount;
	private Screen screen;
	

	public RobotController(){
		screen = new Screen();	
		robitMotor = new RobitMotor();
		buttonSensor = new ButtonSensor();
		buttonSensor.subscribe(this);

		lightSensor = new LightSensor();
		lightSensor.subscribe(this);

		sonarSensor = new SonarSensor();
		sonarSensor.subscribe(this);

		currentState = State.INIT;
		canCount = 0;
	

	}
	public void run(){
		
		buttonSensor.start();
		lightSensor.start();
		sonarSensor.start();
		currentState = State.FIND;
		robitMotor.seek();
		Sound.playTone(50, Integer.MAX_VALUE);
		
		
	}
	@Override
	public void onFindLineEvent() {
		Timer timer = null;
		synchronized (this) {
			switch(currentState){

			case EVACUATE:
				break;
			case FIND:
				
				break;
			case INIT:
				break;
			case MOVETOCAN:
				currentState = State.RESET;
				timer = new Timer(1.0f);
				timer.subscribe(this);
				timer.start();
				robitMotor.reverse();
				Sound.playTone(200, Integer.MAX_VALUE);
				Sound.systemSound(false, 2);
				
				break;
			case PUSH:
				robitMotor.driveFoward();
				Sound.playTone(100, Integer.MAX_VALUE);
				Sound.systemSound(false, 1);
				
				
				
				currentState = State.PUSHOUTOFAREA;
				timer = new Timer(0.3f);
				
				timer.subscribe(this);
				timer.start();
				
				break;
			case PUSHOUTOFAREA:
				
				
				break;
			case RESET:
				break;
			case MOVEBACKTOLINE:
				currentState = State.RESET;
				timer = new Timer(1.5f);
				timer.subscribe(this);
				timer.start();
				break;
			default:
				break;
			}
		}
	
	}

	@Override
	public void onButtonPress() {
		synchronized (buttonSensor) {
			
			switch(currentState){
			case EVACUATE:
				break;
			case FIND:
			
			case INIT:
				break;
			case MOVETOCAN:
				
				currentState = State.PUSH;
				robitMotor.driveFoward();
				Sound.playTone(300, Integer.MAX_VALUE);
				Sound.systemSound(false, 3);
				
				break;
			case PUSH:
				break;
			case PUSHOUTOFAREA:
				break;
			case RESET:
				break;
			case MOVEBACKTOLINE:
				break;
			default:
				break;
			}
		}
	}

	@Override
	public  void onObjectFound() {
		synchronized (this) {


			switch(currentState){
			case EVACUATE:
				break;
			case FIND:
				
				robitMotor.stop();
				robitMotor.driveFoward();
				//tone.shoutFowardTone(Integer.MAX_VALUE);
				Sound.playTone(100, Integer.MAX_VALUE);
				Sound.systemSound(false, 1);
				currentState = State.MOVETOCAN;
				break;
		
			case INIT:
				break;
			case MOVETOCAN:
				break;
			case PUSH:
				break;
			case PUSHOUTOFAREA:
				break;
			case MOVEBACKTOLINE:
				break;
			case RESET:
				break;
			default:
				break;

			}
		}
	}
	@Override
	public  void onTimerFinish(Timer timer) {
		timer.unsubscribe(this);
		synchronized (this) {
			switch(currentState){
			case EVACUATE:
				robitMotor.stop();
				System.out.println("Finished!");
				buttonSensor.stop();
				sonarSensor.stop();
				lightSensor.stop();
				break;
			case FIND:
				break;
		
			case INIT:
				break;
			case MOVETOCAN:
				break;
			case PUSH:
				break;
			case PUSHOUTOFAREA:
				currentState = State.MOVEBACKTOLINE;
				robitMotor.reverse();
				
				Sound.playTone(200, Integer.MAX_VALUE);
				Sound.systemSound(false, 2);
				canCount++;
				
				System.out.println(screen.displayHowManyCansMoved(canCount));

				if(canCount == 3){
					
					currentState = State.EVACUATE;
					robitMotor.driveFoward();
					
					Sound.playTone(100, Integer.MAX_VALUE);
					Sound.systemSound(false, 1);
					Timer EvacTimer = new Timer(0.3f);
					EvacTimer.subscribe(this);
					EvacTimer.start();
				}
				else{
					
				}
				
				break;
			case MOVEBACKTOLINE:
				break;
			case RESET:
				
				currentState = State.FIND;
				
				robitMotor.seek();
				break;
			default:
				break;

			}
		}

	}


}

