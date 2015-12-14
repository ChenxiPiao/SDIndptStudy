package chainofresponsibilitypattern;

public class ChainPattern {
	private static AbstractAssignment getChainOfAssignments(){

	      AbstractAssignment lmsAssignment = new LMSAssignment(AbstractAssignment.RESEARCH);
	      AbstractAssignment classAssignment = new LMSAssignment(AbstractAssignment.PRESENTATION);


	      lmsAssignment.setNextLogger(classAssignment);

	      return lmsAssignment;	
	   }

	   public static void main(String[] args) {
	      AbstractAssignment assignmentChain = getChainOfAssignments();

	      assignmentChain.assignmentAnnouncement(AbstractAssignment.RESEARCH, 
	         "This is a research assignment.");

	      assignmentChain.assignmentAnnouncement(AbstractAssignment.PAPER, 
	         "This is a paper assignment.");

	      assignmentChain.assignmentAnnouncement(AbstractAssignment.PRESENTATION, 
	         "This is a presentation assignment.");
	   }
}
