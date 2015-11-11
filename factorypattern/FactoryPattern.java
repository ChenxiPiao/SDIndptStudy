package factorypattern;

public class FactoryPattern {
	public static void main(String[] args) {
	      ClassFactory classFactory = new ClassFactory();

	      //get an object of Circle and call its draw method.
	      Class class1 = classFactory.getShape("Software Development");

	      //call draw method of Circle
	      class1.checkSchedule();

	      //get an object of Rectangle and call its draw method.
	      Class class2 = classFactory.getShape("HCI USABILITY");

	      //call draw method of Rectangle
	      class2.checkSchedule();

	      //get an object of Square and call its draw method.
	      Class class3 = classFactory.getShape("CAPSTONE");

	      //call draw method of circle
	      class3.checkSchedule();
	   }
}
