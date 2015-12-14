package chainofresponsibilitypattern;

public abstract class AbstractAssignment {
	public static int RESEARCH = 1;
	   public static int PAPER = 2;
	   public static int PRESENTATION = 3;

	   protected int level;

	   //next element in chain or responsibility
	   protected AbstractAssignment nextAssignment;

	   public void setNextLogger(AbstractAssignment nextAssignment){
	      this.nextAssignment = nextAssignment;
	   }

	   public void assignmentAnnouncement(int level, String announcement){
	      if(this.level <= level){
	         write(announcement);
	      }
	      if(nextAssignment !=null){
	         nextAssignment.assignmentAnnouncement(level, announcement);
	      }
	   }

	   abstract protected void write(String announcement);
}
