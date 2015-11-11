package abstractfactorypattern;

public abstract class AbstractFactory {
	abstract Class getClass(String className);
	abstract ClassTime getClassTime(String classTime);
}
