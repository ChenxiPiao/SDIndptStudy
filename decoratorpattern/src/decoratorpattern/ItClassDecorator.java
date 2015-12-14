package decoratorpattern;

public class ItClassDecorator extends ClassDecorator{

	public ItClassDecorator(Class decoratedClass) {
		super(decoratedClass);
		// TODO Auto-generated constructor stub
	}
	
	public void take(){
		decoratedClass.take();
		setItDept(decoratedClass);
	}
	private void setItDept(Class cecoratedClass){
		System.out.println("Class Department: ITWS");
	}

}
