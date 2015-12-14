package chainofresponsibilitypattern;

public class ClassAssignment extends AbstractAssignment{

	public ClassAssignment(int level){
		this.level = level;
	}
	
	@Override
	protected void write(String announcement) {
		// TODO Auto-generated method stub
		System.out.println("Class Assignment Announcement:" + announcement);
		
	}
	
}
