package commandpattern;

public class Class {
	 private String className = "Software Development";
	   private int capacity = 30;

	   public void register(){
	      System.out.println("Class [ Name: "+className+", Capacity: " + capacity +" ] registered");
	   }
	   public void withdraw(){
	      System.out.println("Class [ Name: "+className+", Capacity: " + capacity +" ] withdrew");
	   }
}
