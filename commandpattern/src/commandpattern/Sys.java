package commandpattern;
import java.util.ArrayList;
import java.util.List;

public class Sys {
	private List<Registration> registrationList = new ArrayList<Registration>(); 

	   public void takeRegistration(Registration registration){
		   registrationList.add(registration);		
	   }

	   public void placeRegistration(){
	   
	      for (Registration registration : registrationList) {
	    	  registration.register();
	      }
	      registrationList.clear();
	   }
}
