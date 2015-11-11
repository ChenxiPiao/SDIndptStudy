package factorypattern;

public class ClassFactory {
	public Class getShape(String className){
		if(className == null){
			return null;
		}		
		if(className.equalsIgnoreCase("SOFTWARE DEVELOPMENT")){
			return new SoftwareDevelopment();
        
		} else if(className.equalsIgnoreCase("HCI USABILITY")){
			return new HciUsability();
        
		} else if(className.equalsIgnoreCase("CAPSTONE")){
			return new Capstone();
		}
     
		return null;
	}
}
