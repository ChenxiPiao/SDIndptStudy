package statepattern;

public class EndClass implements State {

	   public void doAction(Context context) {
	      System.out.println("Class ends");
	      context.setState(this);	
	   }

	   public String toString(){
	      return "Stop State";
	   }
	}