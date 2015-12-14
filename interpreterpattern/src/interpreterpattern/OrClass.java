package interpreterpattern;

public class OrClass implements Class{
	private Class clss1 = null;
	   private Class clss2 = null;

	   public OrClass(Class clss1, Class clss2) { 
	      this.clss1 = clss1;
	      this.clss2 = clss2;
	   }
	@Override
	public boolean interpret(String context) {
		// TODO Auto-generated method stub
		return clss1.interpret(context) || clss2.interpret(context);
	}

}
