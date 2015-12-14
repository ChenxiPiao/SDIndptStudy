
public class SoftwareDevelopment implements Class{

	private String dept;
	private int capacity;

	   public SoftwareDevelopment(String dept){
	      this.dept = dept;		
	   }

	   public void setCapacity(int capacity) {
	      this.capacity = capacity;
	   }

	@Override
	public void take() {
		// TODO Auto-generated method stub
		System.out.println("Class: Take() [Department : " + dept + ", capacity :" + capacity);
	}
	
}
