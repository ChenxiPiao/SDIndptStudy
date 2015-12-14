package firstOne;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main{
	private String name;
	private int population;
	public Main(String name, int population)
	{
		this.name = name;
	    this.population = population;
	}
	public String getName()
	{
	     return this.name;
	}

	public int getPopulation()
	{
	     return this.population;
	}
	public String toString()
	{
	     return getName() + " - " + getPopulation();
	}
	public static void main(String args[])
	{
		Comparator<Main> OrderIsdn =  new Comparator<Main>(){
			public int compare(Main o1, Main o2) {
				// TODO Auto-generated method stub
				int numbera = o1.getPopulation();
				int numberb = o2.getPopulation();
				if(numberb > numbera)
				{
					return 1;
				}
				else if(numberb<numbera)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			
			}

			
			
		};
		Queue<Main> priorityQueue =  new PriorityQueue<Main>(11,OrderIsdn);
		
			    
			
		Main t1 = new Main("t1",1);
		Main t3 = new Main("t3",3);
		Main t2 = new Main("t2",2);
		Main t4 = new Main("t4",0);
		priorityQueue.add(t1);
		priorityQueue.add(t3);
		priorityQueue.add(t2);
		priorityQueue.add(t4);
		System.out.println(priorityQueue.poll().toString());
	}
}
