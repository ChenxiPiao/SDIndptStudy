package statepattern;

public class StatePattern {
	   public static void main(String[] args) {
	      Context context = new Context();

	      StartClass startClass = new StartClass();
	      startClass.doAction(context);

	      System.out.println(context.getState().toString());

	      EndClass endClass = new EndClass();
	      endClass.doAction(context);

	      System.out.println(context.getState().toString());
	   }
	}