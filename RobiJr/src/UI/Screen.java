package UI;



public class Screen {
	
	public void displayCanRemovalInfo(int counter) {
		System.out.println(this.howLongCanPushMsg(counter));
		System.out.println(this.howManyCansMovedMsg(counter));
		System.out.println(this.howFarCanPushedMsg(counter));
	}
	
	public String howLongCanPushMsg(int counter){
		return "Time to push can: " + counter;
	}
	
	public String howManyCansMovedMsg(int counter){
		return "Cans moved: " + counter;
	}
	
	public String howFarCanPushedMsg(int counter){
		return "Distance cans Pushed: " + counter;
	}
	
}
