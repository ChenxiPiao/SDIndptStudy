package commandpattern;

public class RegisterClass implements Registration{
	private Class sdClass;
	
	public RegisterClass(Class sdClass){
		this.sdClass = sdClass;
	}
	@Override
	public void register() {
		// TODO Auto-generated method stub
		sdClass.register();
	}
	
}
