package proxypattern;

public class ItwsClass implements Class{
	 private String className;

	   public ItwsClass(String className){
	      this.className = className;
	      takeFromSIS(className);
	   }

	   @Override
	   public void take() {
	      System.out.println("Takinging " + className);
	   }

	   private void takeFromSIS(String className){
	      System.out.println("Checking " + className);
	   }
}
