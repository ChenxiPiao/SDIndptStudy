package decoratorpattern;

public abstract class ClassDecorator implements Class {
	protected Class decoratedClass;
	
	public ClassDecorator(Class decoratedClass){
		this.decoratedClass= decoratedClass;
	}
	
	public void take(){
		decoratedClass.take();
	}
}
