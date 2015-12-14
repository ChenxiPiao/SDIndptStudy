package templatepattern;

public class SoftwareDevelopment extends Class {

	   @Override
	   void endClass() {
	      System.out.println("Software Development Class Finished!");
	   }

	   @Override
	   void initialize() {
	      System.out.println("Software Development Class Initialized! Start class.");
	   }

	   @Override
	   void startClass() {
	      System.out.println("Software Development Class Started!");
	   }
	}