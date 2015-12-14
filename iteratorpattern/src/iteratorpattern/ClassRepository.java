package iteratorpattern;

public class ClassRepository implements Container{
	public String classes[] = {"Software Development" , "Capstone" ,"HCI Usability" , "Business Issues"};

	   @Override
	   public Iterator getIterator() {
	      return new NameIterator();
	   }

	   private class NameIterator implements Iterator {

	      int index;

	      @Override
	      public boolean hasNext() {
	      
	         if(index < classes.length){
	            return true;
	         }
	         return false;
	      }

	      @Override
	      public Object next() {
	      
	         if(this.hasNext()){
	            return classes[index++];
	         }
	         return null;
	      }		
	   }
}
