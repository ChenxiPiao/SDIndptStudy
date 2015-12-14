package visitorpattern;

public class Capstone implements ITClass {
	@Override
	   public void accept(ITClassVisitor itClassVisitor) {
	      itClassVisitor.visit(this);
	   }
}
