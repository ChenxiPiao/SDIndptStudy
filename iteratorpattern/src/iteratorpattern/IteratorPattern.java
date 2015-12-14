package iteratorpattern;

public class IteratorPattern {
	public static void main(String[] args) {
	      ClassRepository classesRepository = new ClassRepository();

	      for(Iterator iter = classesRepository.getIterator(); iter.hasNext();){
	         String classes = (String)iter.next();
	         System.out.println("Class : " + classes);
	      } 	
	   }
}
