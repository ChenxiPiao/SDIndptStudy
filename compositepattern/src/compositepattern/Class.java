package compositepattern;

import java.util.ArrayList;
import java.util.List;

public class Class {
   private String name;
   private String dept;
   private int capacity;
   private List<Class> prerequire;

   // constructor
   public Class(String name,String dept, int capacity) {
      this.name = name;
      this.dept = dept;
      this.capacity = capacity;
      prerequire = new ArrayList<Class>();
   }

   public void add(Class c) {
      prerequire.add(c);
   }

   public void remove(Class c) {
      prerequire.remove(c);
   }

   public List<Class> getPrerequires(){
     return prerequire;
   }

   public String toString(){
      return ("Class :[ Name : " + name + ", dept : " + dept + ", capacity :" + capacity+" ]");
   }   
}