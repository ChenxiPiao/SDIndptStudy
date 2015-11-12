package prototypepattern;

public class PrototypePattern {
	   public static void main(String[] args) {
	      ClassCache.loadCache();

	      Class clonedClass1 = (Class) ClassCache.getClass("1");
	      System.out.println("Class : " + clonedClass1.getClassName());		

	      Class clonedClass2 = (Class) ClassCache.getClass("2");
	      System.out.println("Class : " + clonedClass2.getClassName());		

	      Class clonedClass3 = (Class) ClassCache.getClass("3");
	      System.out.println("Shape : " + clonedClass3.getClassName());		
	   }
	}
