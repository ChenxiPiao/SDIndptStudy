package builderpattern;

public class BuilderPattern {
	public static void main(String args[]) {
	      
        //Creating object using Builder pattern in java
        Class softwareDevelopment = new Class.Builder().className("Software Development").classTime("10:00 AM - 11:50 AM").professorName("Ingrid Liu").location("Lally 02").duration("1h 50min").build();

        System.out.println(softwareDevelopment);
    }
}