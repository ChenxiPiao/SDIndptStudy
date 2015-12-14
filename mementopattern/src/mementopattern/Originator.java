package mementopattern;

public class Originator {
	   private String cls;

	   public void setClass(String cls){
	      this.cls = cls;
	   }

	   public String getClass(){
	      return cls;
	   }

	   public Memento saveStateToMemento(){
	      return new Memento(cls);
	   }

	   public void getStateFromMemento(Memento Memento){
	      cls = Memento.getClass();
	   }
	}