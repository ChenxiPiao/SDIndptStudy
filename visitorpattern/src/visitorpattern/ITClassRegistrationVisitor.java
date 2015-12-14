package visitorpattern;

public class ITClassRegistrationVisitor implements ITClassVisitor {

	   @Override
	   public void visit(ITCourse itCourse) {
	      System.out.println("Register Courses from ITWS");
	   }

	   @Override
	   public void visit(SoftwareDevelopment softwareDevelopment) {
	      System.out.println("Register Courses Software Development.");
	   }

	   @Override
	   public void visit(Capstone capstone) {
	      System.out.println("Register Courses Capstone.");
	   }

	}
