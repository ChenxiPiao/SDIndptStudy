package mementopattern;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
   private List<Memento> mementoList = new ArrayList<Memento>();

   public void add(Memento cls){
      mementoList.add(cls);
   }

   public Memento get(int index){
      return mementoList.get(index);
   }
}