package visitorpattern;

public class SoftwareDevelopment implements ITClass {

	   @Override
	   public void accept(ITClassVisitor itClassVisitor) {
	      itClassVisitor.visit(this);
	   }
	}
