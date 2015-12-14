package templatepattern;

public abstract class Class {
	 abstract void initialize();
	   abstract void startClass();
	   abstract void endClass();

	   //template method
	   public final void take(){


	      initialize();

	      startClass();

	      endClass();
	   }
}
