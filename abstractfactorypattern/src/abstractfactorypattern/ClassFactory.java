package abstractfactorypattern;

public class ClassFactory extends AbstractFactory {

	@Override
	Class getClass(String className) {
		// TODO Auto-generated method stub
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

	@Override
	ClassTime getClassTime(String classTime) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
