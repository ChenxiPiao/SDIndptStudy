package proxypattern;

public class ProxyClass implements Class{
	private ItwsClass itwsClass;
	   private String className;

	   public ProxyClass(String className){
	      this.className = className;
	   }

	   @Override
	   public void take() {
	      if(itwsClass == null){
	         itwsClass = new ItwsClass(className);
	      }
	      itwsClass.take();
	   }
}
