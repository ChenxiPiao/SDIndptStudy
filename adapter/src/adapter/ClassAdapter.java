package adapter;

public class ClassAdapter implements ClassReminder {

	   AdvancedClassReminder advancedClassReminder;

	   public ClassAdapter(String className){
	   
	      if(className.equalsIgnoreCase("SOFTWARE DEVELOPMENT") ){
	         advancedClassReminder = new SoftwareDevelopmentReminder();			
	         
	      }else if (className.equalsIgnoreCase("HCI USABILITY")){
	         advancedClassReminder = new HciUsabilityReminder();
	      }else if (className.equalsIgnoreCase("CAPSTONE")){
	    	 advancedClassReminder = new CapstoneReminder();
	      }
	   }

	   @Override
	   public void remind(String className, String classTime) {
	   
	      if(className.equalsIgnoreCase("SOFTWARE DEVELOPMENT")){
	         advancedClassReminder.remindSoftwareDevelopment(classTime);
	      }
	      else if(className.equalsIgnoreCase("HCI USABILITY")){
	         advancedClassReminder.remindHciUsability(classTime);
	      }
	      else if(className.equalsIgnoreCase("CAPSTONE")){
	    	 advancedClassReminder.remindCapstone(classTime);
	      }
	   }

	}
