package mementopattern;

public class MementoPattern {
	   public static void main(String[] args) {
	   
	      Originator originator = new Originator();
	      CareTaker careTaker = new CareTaker();
	      
	      originator.setClass("Software Development");
	      originator.setClass("Capstone");
	      careTaker.add(originator.saveStateToMemento());
	      
	      originator.setClass("HCI Usability");
	      System.out.println("Current State: " + originator.getClass());		
	      
	      originator.getStateFromMemento(careTaker.get(1));
	      System.out.println("Second saved Class: " + originator.getClass());
	   }
	}