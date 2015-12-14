package facadepattern;

public class ClassTaker {
	private Class softwareDevelopment;
	private Class capstone;
	private Class hciUsability;

	public ClassTaker() {
		softwareDevelopment= new SoftwareDevelopment();
		capstone = new Capstone();
		hciUsability = new HciUsability();
	}

	   public void takeSoftwareDevelopment(){
	      softwareDevelopment.take();
	   }
	   public void takeCapstone(){
	      capstone.take();
	   }
	   public void takeHciUsability(){
	      hciUsability.take();
	   }
}
