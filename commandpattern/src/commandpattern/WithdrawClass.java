package commandpattern;

public class WithdrawClass implements Registration{
	private Class sdClass;
	
	public WithdrawClass(Class sdClass){
		this.sdClass = sdClass;
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		sdClass.withdraw();
	}

}
