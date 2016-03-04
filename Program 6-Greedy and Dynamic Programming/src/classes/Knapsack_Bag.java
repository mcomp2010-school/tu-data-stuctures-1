//==============================================================
//PROGRAM 6 – Greedy and Dynamic Programming
//==============================================================
//Emanuel Rivera
//COSC 336-101
//December 1 2010
//==============================================================
package classes;

import java.util.ArrayList;

public class Knapsack_Bag {
	public  ArrayList<Knapsack_Item> AL_Knap_Sack = new ArrayList<Knapsack_Item>();
	private int NumberOfItem=0;
	private double Weight_Capacity=-1.0;
	
	private double TotalValue=0.0;
	private double TotalWeight=0.0;
	

	public int size() {
		return AL_Knap_Sack.size();
	}

	public Knapsack_Item get_Knapsack_Item(int x) {
		return AL_Knap_Sack.get(x);
	}
	
	public void add_Knapsack_Item(Knapsack_Item NW) {
		AL_Knap_Sack.add(NW);
	}

	
	public int getNumberOfItem() {
		return NumberOfItem;
	}
	
	public double getCurrentWeight_Capacity() {
		return Weight_Capacity;
	}

	public void setWeight_Capacity(double weight_Capacity) {
		Weight_Capacity = weight_Capacity;
	}

	public Knapsack_Bag(double capacity) {
		this.AL_Knap_Sack.clear();
		this.Weight_Capacity=capacity;
		this.TotalValue=0.0;
		this.NumberOfItem=0; 
		this.TotalWeight=0.0;
		this.NumberOfItem=0;
		
		
	}


	public double getTotalValue() {
		return TotalValue;
	}

	public void Add_Item(Double weight, Double value) {
		//System.out.println(Weight_Capacity-weight);
		//System.out.println(TotalWeight+"-"+Weight_Capacity);
		
		if((TotalWeight+weight)<=Weight_Capacity){
			AL_Knap_Sack.add(new Knapsack_Item(weight, value));
			//Weight_Capacity-=weight;
			TotalWeight+=weight;
			NumberOfItem++;
			TotalValue+=value;
		}  
		
	}

	public String toString() {
		return PrintArrayList_toString(AL_Knap_Sack,"Knapsack Bag");
	}
	
	public String toStringCUS(String Input) {
		return PrintArrayList_toString(AL_Knap_Sack,Input);
	}
	

	public String PrintString_SortedByValue(boolean OrderAsc) {
		return PrintArrayList_toString(StealItems_SortedByValue_AL(OrderAsc),"Knapsack Sorted by Value");
	}
	
	public String PrintString_SortedByValue() {
		return PrintArrayList_toString(StealItems_SortedByValue_AL(true),"Knapsack Sorted by Value");
	}
	
	public String PrintString_SortedByRatio(boolean OrderAsc) {
		return PrintArrayList_toString(StealItems_SortedByRatio_AL(OrderAsc),"Knapsack Sorted by Ratio");
	}
	
	public String PrintString_SortedByRatio() {
		return PrintArrayList_toString(StealItems_SortedByRatio_AL(true),"Knapsack Sorted by Ratio");
	}
	
	
	public ArrayList<Knapsack_Item> StealItems_SortedByValue_AL(boolean OrderAsc) {
		
		ArrayList<Knapsack_Item> SortedList = new ArrayList<Knapsack_Item>();
		// *********************************
		for (int i = 0; i <= AL_Knap_Sack.size() - 1; i++) {
			int j = 0;
			for (j = 0; j <= SortedList.size() - 1; j++) {
				if(OrderAsc==true){
					if (SortedList.get(j).getValue() >AL_Knap_Sack.get(i).getValue()) {
						break;
					}
				}else{
					if (SortedList.get(j).getValue() <AL_Knap_Sack.get(i).getValue()) {
						break;
					}
				}
				
			}
			SortedList.add(j,AL_Knap_Sack.get(i));
		}
		// *********************************
		return SortedList;

	}
	
	public ArrayList<Knapsack_Item> StealItems_SortedByRatio_AL(boolean OrderAsc) {
		
		ArrayList<Knapsack_Item> SortedList = new ArrayList<Knapsack_Item>();
		// *********************************
		for (int i = 0; i <= AL_Knap_Sack.size() - 1; i++) {
			int j = 0;
			for (j = 0; j <= SortedList.size() - 1; j++) {
				
				if(OrderAsc==true){
					if (SortedList.get(j).getRatio() > AL_Knap_Sack.get(i).getRatio()) {
						break;
					}
				}else{
					if (SortedList.get(j).getRatio() < AL_Knap_Sack.get(i).getRatio()) {
						break;
					}
				}
			
			}
			SortedList.add(j, AL_Knap_Sack.get(i));
		}
		// *********************************
		return SortedList;

	}
	
	
	public String PrintArrayList_toString(ArrayList<Knapsack_Item> InputARL,String Name){
		String Output1 = "";
		//Output1 += "--------------------------\n";
		Output1 += Name+"\n";
		for (int i = 0; i <= InputARL.size() - 1; i++) {
			if (i < InputARL.size() - 1) {
				Output1 += InputARL.get(i).toString() + "\n";
			} else
				Output1 += InputARL.get(i).toString();
		}

		Output1 += "\nTotal Value: " + TotalValue;
		
		Output1 += "\n--------------------------";
		return Output1;
	}



	

}
