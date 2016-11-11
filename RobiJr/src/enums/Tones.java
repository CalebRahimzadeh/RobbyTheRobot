package enums;

public enum Tones {
	
	FORWARD(1), BACKWARD(2), PUSHING(3);
	
	private int tone;
	
	Tones(int tone){
		this.tone = tone;
	}
}
