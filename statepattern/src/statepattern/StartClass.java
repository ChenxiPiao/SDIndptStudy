package statepattern;

public class StartClass implements State {

	   public void doAction(Context context) {
	      System.out.println("Class starts");
	      context.setState(this);	
	   }

	   public String toString(){
	      return "Start State";
	   }
	}