package abstractfactorypattern;

public class AbstractFactoryPattern {
	public static void main(String[] args) {

	      //get class factory
	      AbstractFactory classFactory = FactoryProducer.getFactory("CLASSNAME");

	      //get an object of Class Software Development
	      Class class1 = classFactory.getClass("SOFTWARE DEVELOPMENT");

	      //call checkSchedule method of Class Software Development
	      class1.checkSchedule();

	      //get an object of Class HCI Usability
	      Class class2 = classFactory.getClass("HCI USABILITY");

	      //call checkSchedule method of Class HCI Usability
	      class2.checkSchedule();
	      
	      //get an object of Class Capstone 
	      Class class3 = classFactory.getClass("CAPSTONE");

	      //call checkSchedule method of Class Capstone
	      class3.checkSchedule();

	      //get class time factory
	      AbstractFactory classTimeFactory = FactoryProducer.getFactory("CLASSTIME");

	      //get an object of Class Time Morning
	      ClassTime classTime1 = classTimeFactory.getClassTime("MORNING");

	      //call time method of Morning
	      classTime1.time();

	      //get an object of Class Time Afternoon
	      ClassTime classTime2 = classTimeFactory.getClassTime("AFTERNOON");

	      //call time method of Afternoon
	      classTime2.time();

	      //get an object of Class Time Evening
	      ClassTime classTime3 = classTimeFactory.getClassTime("EVENING");

	      //call time method of Evening
	      classTime3.time();
	   }
}
