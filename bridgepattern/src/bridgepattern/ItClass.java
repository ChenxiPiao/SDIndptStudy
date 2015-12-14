package bridgepattern;

public class ItClass extends ClassName{

	private int time, number, code;
	
	public ItClass(int time, int number, int code, TakeClass takeClass){
		super(takeClass);
		this.time = time;
		this.number = number;
		this.code = code;
	}
	
	@Override
	public void take() {
		// TODO Auto-generated method stub
		takeClass.takeItClass(time, number, code);
	}
	
}
