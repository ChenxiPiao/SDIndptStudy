package compositepattern;

public class CompositePattern {
	 public static void main(String[] args) {
		   
	      Class softwareDevelopment = new Class("Software Development","ITWS", 30);

	      Class capstone = new Class("Capstone","ITWS", 40);

	      Class hciUsability = new Class("HCI Usability","COMM", 40);


	      capstone.add(softwareDevelopment);
	      capstone.add(hciUsability);

	      System.out.println(capstone); 

	      }		
	   
}

