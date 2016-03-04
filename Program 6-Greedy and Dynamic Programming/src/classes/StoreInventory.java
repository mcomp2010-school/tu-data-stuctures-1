//==============================================================
//PROGRAM 6 – Greedy and Dynamic Programming
//==============================================================
//Emanuel Rivera
//COSC 336-101
//December 1 2010
//==============================================================
package classes;

import java.util.ArrayList;

public class StoreInventory {
	private ArrayList<Knapsack_Item> AL_Store_Inventory = new ArrayList<Knapsack_Item>();
	private int NumberOfItem=0;
    
    
	
	public Double getAL_Item_WeightbyIndex(int inputa) {
		return AL_Store_Inventory.get(inputa).getWeight();
	}
	
	public Double getAL_Item_ValuebyIndex(int inputa) {
		return AL_Store_Inventory.get(inputa).getValue();
	}

	public int getNumberOfItem() {
		return NumberOfItem;
	}


	public StoreInventory() {
		AL_Store_Inventory.clear();
	}

	public void Add_Item(Double weight, Double value) {
		AL_Store_Inventory.add(new Knapsack_Item(weight, value));
		NumberOfItem++;
	}

	public String toString() {
		return PrintArrayList_toString(AL_Store_Inventory,"Store Inventory");
	}

	public String PrintString_SortedByValue(boolean OrderAsc) {
		return PrintArrayList_toString(StealItems_SortedByValue_AL(OrderAsc),"Store Inventory Sorted by Value");
	}
	
	public String PrintString_SortedByValue() {
		return PrintArrayList_toString(StealItems_SortedByValue_AL(true),"Store Inventory Sorted by Value");
	}
	
	public String PrintString_SortedByRatio(boolean OrderAsc) {
		return PrintArrayList_toString(StealItems_SortedByRatio_AL(OrderAsc),"Store Inventory Sorted by Ratio");
	}
	
	public String PrintString_SortedByRatio() {
		return PrintArrayList_toString(StealItems_SortedByRatio_AL(true),"Store Inventory Sorted by Ratio");
	}
	
	
	public ArrayList<Knapsack_Item> StealItems_SortedByValue_AL(boolean OrderAsc){
		
		ArrayList<Knapsack_Item> SortedList = new ArrayList<Knapsack_Item>();
		// *********************************
		for (int i = 0; i <= AL_Store_Inventory.size() - 1; i++) {
			int j = 0;
			for (j = 0; j <= SortedList.size() - 1; j++) {
				
				if(OrderAsc==true){
					if (SortedList.get(j).getValue() > AL_Store_Inventory.get(i).getValue()) {
						break;
					}
				}else{
					if (SortedList.get(j).getValue() < AL_Store_Inventory.get(i).getValue()) {
						break;
					}
				}
		
			}
			SortedList.add(j, AL_Store_Inventory.get(i));
		}
		// *********************************
		return SortedList;

	}
	
	public ArrayList<Knapsack_Item> StealItems_SortedByRatio_AL(boolean OrderAsc) {
		
		ArrayList<Knapsack_Item> SortedList = new ArrayList<Knapsack_Item>();
		// *********************************
		for (int i = 0; i <= AL_Store_Inventory.size() - 1; i++) {
			int j = 0;
			for (j = 0; j <= SortedList.size() - 1; j++) {
				
				if(OrderAsc==true){
					if (SortedList.get(j).getRatio() > AL_Store_Inventory.get(i).getRatio()) {
						break;
					}
				}else{
					if (SortedList.get(j).getRatio() < AL_Store_Inventory.get(i).getRatio()) {
						break;
					}
				}
				
			}
			SortedList.add(j, AL_Store_Inventory.get(i));
		}
		// *********************************
		return SortedList;

	}
	
	
	public String PrintArrayList_toString(ArrayList<Knapsack_Item> InputARL,String Name){
		String Output1 = "--------------------------\n";
		Output1 += Name+"\n";
		for (int i = 0; i <= InputARL.size() - 1; i++) {
			if (i < InputARL.size() - 1) {
				Output1 += InputARL.get(i).toString() + "\n";
			} else
				Output1 += InputARL.get(i).toString();
		}

		Output1 += "\n--------------------------";
		return Output1;
	}

}
