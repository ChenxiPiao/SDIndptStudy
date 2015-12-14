package interpreterpattern;

public class TerminalClass implements Class{
	 private String data;

	   public TerminalClass(String data){
	      this.data = data; 
	   }

	   @Override
	   public boolean interpret(String context) {
	   
	      if(context.contains(data)){
	         return true;
	      }
	      return false;
	   }
}
