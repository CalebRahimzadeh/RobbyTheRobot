package UI;



public class Screen {
	
	
	public void displayCanRemovalInfo(int counter){
		System.out.println(this.displayHowLongCanPush(counter));
		System.out.println(this.displayHowManyCansMoved(counter));
		System.out.println(this.displayHowFarCanPushed(counter));
		
	}


	
	public String displayHowLongCanPush(int counter){
		return "Time to push can: " + counter;
	}
	
	public String displayHowManyCansMoved(int counter){
		return "Cans moved: " + counter;
	}
	
	public String  displayHowFarCanPushed(int counter){
		return "Distance cans Pushed: " + counter;
	}
	
}
