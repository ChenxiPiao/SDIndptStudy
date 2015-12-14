
public class FlyweightPattern {
	 private static final String depts[] = { "ITWS", "COMM", "CSCI", "MGMT"};
	  
	 
	 public static void main(String[] args) {

	      for(int i=0; i < 20; ++i) {
	         Class softwareDevelopment = (Class)ClassFactory.getSoftwareDevelopment(getRandomDept());
	         softwareDevelopment.setCapacity(30);
	         softwareDevelopment.take();
	      }
	   }
	   private static String getRandomDept() {
	      return depts[(int)(Math.random()*depts.length)];
	   }

}
