package visitorpattern;

public class VisitorPattern {
	   public static void main(String[] args) {

	      ITClass itClass = new ITCourse();
	      itClass.accept(new ITClassRegistrationVisitor());
	   }
	}