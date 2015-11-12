package adapter;

public class CourseReminder implements ClassReminder {
	   ClassAdapter classAdapter; 

	   @Override
	   public void remind(String className, String classTime) {		

	      if(className.equalsIgnoreCase("OPERATING SYSTEMS")){
	         System.out.println("Going to Operating Systems class! Time: " + classTime);			
	      } 
	      else if(className.equalsIgnoreCase("SOFTWARE DEVELOPMENT") || className.equalsIgnoreCase("HCI USABILITY") || className.equalsIgnoreCase("CAPSTONE")){
	         classAdapter = new ClassAdapter(className);
	         classAdapter.remind(className, classTime);
	      }
	      
	      else{
	         System.out.println("You didn't register the class: " + className + ". You don't have to go!");
	      }
	   }   
	}