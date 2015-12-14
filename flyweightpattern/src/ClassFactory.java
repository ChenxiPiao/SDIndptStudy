import java.util.HashMap;

public class ClassFactory {
	private static final HashMap<String, Class> softwareDevelopmentMap = new HashMap();

	public static Class getSoftwareDevelopment(String dept) {
		SoftwareDevelopment softwareDevelopment = (SoftwareDevelopment)softwareDevelopmentMap.get(dept);

	      if(softwareDevelopment == null) {
	    	  softwareDevelopment = new SoftwareDevelopment(dept);
	    	  softwareDevelopmentMap.put(dept, softwareDevelopment);
	         System.out.println("Creating class from department : " + dept);
	      }
	      return softwareDevelopment;
	   }
}
