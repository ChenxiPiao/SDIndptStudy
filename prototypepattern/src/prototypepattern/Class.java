package prototypepattern;

public abstract class Class implements Cloneable {
		   
		   protected String className;
		   private String classId;
		   
		   abstract void checkSchedule();
		   
		   public String getClassName(){
		      return className;
		   }
		   
		   public String getClassId() {
		      return classId;
		   }
		   
		   public void setClassId(String classId) {
		      this.classId = classId;
		   }
		   
		   public Object clone() {
		      Object clone = null;
		      
		      try {
		         clone = super.clone();
		         
		      } catch (CloneNotSupportedException e) {
		         e.printStackTrace();
		      }
		      
		      return clone;
		   }
}

