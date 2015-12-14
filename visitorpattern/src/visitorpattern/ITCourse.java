package visitorpattern;

public class ITCourse implements ITClass{
	ITClass[] itClasses;

	   public ITCourse(){
		   itClasses = new ITClass[] {new SoftwareDevelopment(), new Capstone()};		
	   } 


	   @Override
	   public void accept(ITClassVisitor ITClassVisitor) {
	      for (int i = 0; i < itClasses.length; i++) {
	    	  itClasses[i].accept(ITClassVisitor);
	      }
	      ITClassVisitor.visit(this);
	   }
}
