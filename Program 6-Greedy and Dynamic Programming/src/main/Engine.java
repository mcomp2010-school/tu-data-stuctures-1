//==============================================================
//PROGRAM 6 – Greedy and Dynamic Programming
//==============================================================
//Emanuel Rivera
//COSC 336-101
//December 1 2010
//==============================================================
package main;

import approach.Knapsack0_1_DynamicBrute;
import approach.Knapsack0_1_Greedy;
import classes.Knapsack_Bag;
import classes.StoreInventory;

public class Engine {

	public static void main(String[] args) {
		StoreInventory Store1= new StoreInventory();
		
		Store1.Add_Item(1.0, 2.0);
		Store1.Add_Item(2.0, 3.0);
		Store1.Add_Item(3.0, 4.0); 
		Store1.Add_Item(4.0, 5.0);
		Store1.Add_Item(5.0, 6.0);

		
		System.out.println(Store1.toString());

		System.out.println("************************");
		System.out.println("************************");
		//////////////////////////////////////////////////////
	
		double GlobalCapacity=5.0;
		
		Knapsack0_1_DynamicBrute DynamicBrute1= new Knapsack0_1_DynamicBrute();
		System.out.println(DynamicBrute1.GetMostValuedBag(Store1, GlobalCapacity).toStringCUS("KnapSack Bag Using DynamicBrute Approach"));
		System.out.println("DynamicBrute Approach uses Classes: Knapsack_Bag, KnapSack_Item, StoreInventory, Brute_AL\n" +
				"DynamicBrute Approach works by using BruteForce to get all the possible Combinations to add to Knapsack_Bag\n" +
				"Brute_AL is the class that find all the possible Combinations (Cleans and Sorts Results of Indexes to be unique in output ArrayList)\n" +
				"In Knapsack0_1_DynamicBrute it put all the output indexes to match with Knapsack_Bag items in new ArrayList of KnapSack_Bags\n" +
				"It sorts the ArrayList of KnapSack_Bags by Total Value in Descending order\n" +
				"And output the ArrayList<KnapSack_Bags> with Index 0 since it has the greatest total Value");
		
		System.out.println("************************");
		
		
		Knapsack0_1_Greedy Greedy1=new Knapsack0_1_Greedy();
		System.out.println(Greedy1.GetMostValuedBag(Store1, GlobalCapacity).toStringCUS("KnapSack Bag Using Greedy Approach"));
		System.out.println("Greedy Approach uses Classes: Knapsack_Bag, KnapSack_Item, and StoreInventory\n" +
				"Greedy Approach works by sorting the Store1 Object in\n" +
				"Descending Order (Larger First) and Adding all the Knapsack_Items Objects to Knapsack_Bag.\n" +
				"Knapsack_Bag object will allow items only when the the Weight\n" +
				"Capacity is under the GlobalCapacity.");
		System.out.println("************************");
		
		System.out.println("==============");
		Knapsack_Bag Knapsack_Bag1= new Knapsack_Bag(GlobalCapacity);
	
		//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		
		Knapsack_Bag1.Add_Item(1.0, 2.0);
		Knapsack_Bag1.Add_Item(2.0, 3.0);
		Knapsack_Bag1.Add_Item(3.0, 4.0);
		Knapsack_Bag1.Add_Item(4.0, 5.0);
		Knapsack_Bag1.Add_Item(5.0, 6.0);
		
		
		System.out.println(Knapsack_Bag1.toStringCUS("KnapSack Bag Customized"));
		
		System.out.println("Customized Approach uses Classes: Knapsack_Bag, KnapSack_Item, and StoreInventory\n" +
				"The user does the Optimization");
		System.out.println("*********");
	}

	
	
	
}
