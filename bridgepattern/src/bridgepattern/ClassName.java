package bridgepattern;

public abstract class ClassName {
	protected TakeClass takeClass;
	
	protected ClassName(TakeClass takeClass){
		this.takeClass = takeClass;
	}
	
	public abstract void take();
}
