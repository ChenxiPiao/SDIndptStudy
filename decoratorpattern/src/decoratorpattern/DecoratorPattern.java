package decoratorpattern;

public class DecoratorPattern {
	public static void main(String[] args) {

	      Class softwareDevelopment = new SoftwareDevelopment();

	      Class itSoftwareDevelopment = new ItClassDecorator(new SoftwareDevelopment());

	      Class itCapstone = new ItClassDecorator(new Capstone());
	      System.out.println("Taking Class Software Development at RPI");
	      softwareDevelopment.take();

	      System.out.println("\nTaking Class Software Development at RPI ITWS");
	      itSoftwareDevelopment.take();

	      System.out.println("\nTaking Class Capstone at RPI ITWS");
	      itCapstone.take();
	   }
}
