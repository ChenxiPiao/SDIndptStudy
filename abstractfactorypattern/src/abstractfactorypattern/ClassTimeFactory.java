package abstractfactorypattern;


public class ClassTimeFactory extends AbstractFactory{

	@Override
	Class getClass(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	ClassTime getClassTime(String classTime) {
		// TODO Auto-generated method stub
		if(classTime == null){
			return null;
		}		
		if(classTime.equalsIgnoreCase("MORNING")){
			return new Morning();
        
		} else if(classTime.equalsIgnoreCase("AFTERNOON")){
			return new Afternoon();
        
		} else if(classTime.equalsIgnoreCase("EVENING")){
			return new Evening();
		}
     
		return null;
	}

}
