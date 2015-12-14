package interpreterpattern;

public class InterpreterPattern {
	public static Class getITClass(){
	      Class softwareDevelopment = new TerminalClass("Software Development");
	      Class capstone = new TerminalClass("Capstone");
	      return new OrClass(softwareDevelopment, capstone);		
	   }


	   public static void main(String[] args) {
	     Class isITClass = getITClass();
	    

	      System.out.println("Software Development is an IT class? " + isITClass.interpret("Software Development"));

	   }
}
