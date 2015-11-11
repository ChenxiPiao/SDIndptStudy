package factorypattern;

public class FactoryPattern {
	public static void main(String[] args) {
	      ClassFactory classFactory = new ClassFactory();

	      //get an object of Software Development and call its checkSchedule method.
	      Class class1 = classFactory.getShape("Software Development");

	      //call checkSchedule method of Software Development
	      class1.checkSchedule();

	      //get an object of HCI Usability and call its checkSchedule method.
	      Class class2 = classFactory.getShape("HCI USABILITY");

	      //call checkSchedule method of HCI Usability
	      class2.checkSchedule();

	      //get an object of Capstone and call its checkSchedule method.
	      Class class3 = classFactory.getShape("CAPSTONE");

	      //call checkSchedule method of Capstone
	      class3.checkSchedule();
	   }
}
