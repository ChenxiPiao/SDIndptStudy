package visitorpattern;

public interface ITClassVisitor {
	public void visit(ITCourse itCourse);
	public void visit(SoftwareDevelopment softwareDevelopment);
	public void visit(Capstone capstone);
}
