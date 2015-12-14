package chainofresponsibilitypattern;

public class LMSAssignment extends AbstractAssignment{
	
	public LMSAssignment (int level){
		this.level = level;
	}

	@Override
	protected void write(String announcement) {
		// TODO Auto-generated method stub
		System.out.println("LMS: Announcement:" + announcement);
		
	}

}
