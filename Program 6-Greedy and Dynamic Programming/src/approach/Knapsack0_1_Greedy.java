//==============================================================
//PROGRAM 6 – Greedy and Dynamic Programming
//==============================================================
//Emanuel Rivera
//COSC 336-101
//December 1 2010
//==============================================================
package approach;

import java.util.ArrayList;

import classes.Knapsack_Bag;
import classes.Knapsack_Item;
import classes.StoreInventory;

public class Knapsack0_1_Greedy {


	public Knapsack_Bag GetMostValuedBag(StoreInventory Storex,Double dblCapacity){
		Knapsack_Bag GreedyBag=new Knapsack_Bag(dblCapacity);
		
		ArrayList<Knapsack_Item> SortedStore= Storex.StealItems_SortedByValue_AL(false);
		
		//String Output1 = "--------------------------\n";
		
		for (int i = 0; i <= SortedStore.size() - 1; i++) {
			if (i < SortedStore.size() - 1) {
				//Output1 += SortedStore.get(i).toString() + "\n";
			} else{
				//Output1 += SortedStore.get(i).toString();
			}
				
			
			GreedyBag.Add_Item(SortedStore.get(i).getWeight(), SortedStore.get(i).getValue());
		}
		
		
		
		//System.out.println(Output1);
		
		
		return GreedyBag;
	}
	
	
}
