package Basic;

import Listeners.ButtonEventListener;
import Listeners.LightEventListener;
import Listeners.SonarEventListener;
import Listeners.TimerListener;
import Motors.RobitMotor;
import Sensor.ButtonSensor;
import Sensor.LightSensor;
import Sensor.SonarSensor;
import Utillity.Timer;
import enums.State;

public class RobotController implements ButtonEventListener, SonarEventListener, LightEventListener, TimerListener{

	private ButtonSensor buttonSensor;
	private LightSensor lightSensor;
	private SonarSensor sonarSensor;
	private RobitMotor robitMotor;
	private State currentState;
	private int canCount;

	public RobotController(){
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
				break;
			case PUSH:
				robitMotor.driveFoward();
				currentState = State.PUSHOUTOFAREA;
				timer = new Timer(0.5f);
				timer.subscribe(this);
				timer.start();
				
				break;
			case PUSHOUTOFAREA:
				
				
				break;
			case RESET:
				break;
			case MOVEBACKTOLINE:
				currentState = State.RESET;
				timer = new Timer(2.0f);
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
				robitMotor.driveFoward();
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
				canCount++;
				if(canCount == 3){
					
					currentState = State.EVACUATE;
					robitMotor.driveFoward();
					Timer EvacTimer = new Timer(1.0f);
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

