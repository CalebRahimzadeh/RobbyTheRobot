package UI;

import Utillity.Counter;

public class Screen {


	
	public void displayHowLongCanPush(Counter counter){
		System.out.println(counter.getTimeCounter());
	}
	
	public void displayHowManyCansMoved(Counter counter){
		System.out.println(counter.getCanCounter());
	}
	
	public void  displayHowFarCanPushed(Counter counter){
		System.out.println(counter.getCanPushedCounter());
	}
	
}
