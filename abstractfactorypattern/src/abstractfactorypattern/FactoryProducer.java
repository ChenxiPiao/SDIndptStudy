package abstractfactorypattern;

public class FactoryProducer {
	public static AbstractFactory getFactory(String option){
		   
	      if(option.equalsIgnoreCase("CLASSNAME")){
	         return new ClassFactory();
	         
	      }else if(option.equalsIgnoreCase("CLASSTIME")){
	         return new ClassTimeFactory();
	      }
	      
	      return null;
	   }
}
