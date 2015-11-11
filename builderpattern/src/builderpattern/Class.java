package builderpattern;

public class Class {
	private final String className;  
    private final String classTime;  
    private final String professorName;
    private final String location;     
    private final String duration;   


    public static class Builder {

        private String className;
        private String classTime;  
        private String professorName;
        private String location;     
        private String duration;   

        //builder methods for setting property
        public Builder className(String name){this.className = name; return this; }
        public Builder classTime(String time){this.classTime = time; return this; }
        public Builder professorName(String pname){this.professorName = pname; return this; }
        public Builder location(String location){this.location = location; return this; }
        public Builder duration(String duration){this.duration = duration; return this; }
        
      
      
        //return fully build object
        public Class build() {
            return new Class(this);
        }
    }

    //private constructor to enforce object creation through builder
    private Class(Builder builder) {
        this.className = builder.className;
        this.classTime = builder.classTime;
        this.professorName = builder.professorName;
        this.location = builder.location;
        this.duration = builder.duration;
        
    }

    @Override
    public String toString() {
        return "Class{" + "Class-Name: " + className + ", Class-Time: " + classTime + ", Professor: " + professorName + ", Location: " + location + ", Duration=" + duration + '}';
    } 
}
