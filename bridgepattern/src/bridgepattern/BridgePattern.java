package bridgepattern;

public class BridgePattern {
	public static void main(String[] args){
		ClassName softwareDevelopment = new ItClass(10, 10, 10, new SoftwareDevelopment());
		ClassName capstone = new ItClass(10, 10, 10, new Capstone());
		
		softwareDevelopment.take();
		capstone.take();
		
	}
}
