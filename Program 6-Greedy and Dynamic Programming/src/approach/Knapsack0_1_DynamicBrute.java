//==============================================================
//PROGRAM 6 – Greedy and Dynamic Programming
//==============================================================
//Emanuel Rivera
//COSC 336-101
//December 1 2010
//==============================================================
package approach;

import java.util.ArrayList;

import classes.Brute_AL;
import classes.Knapsack_Bag;
import classes.StoreInventory;

public class Knapsack0_1_DynamicBrute {
	
	public Knapsack_Bag GetMostValuedBag(StoreInventory Storex,Double dblCapacity){
		return GetMostValuedBagLOW(StealFromStoreAndMakeBags(Storex,dblCapacity));
	}
	
	private Knapsack_Bag GetMostValuedBagLOW(ArrayList<Knapsack_Bag> Input){
		ArrayList<Knapsack_Bag> STInput=SortsBags_SortedByValueASC_AL(Input);
		
		//for(int ia1=0; ia1<=STInput.size()-1;ia1++){
		//	System.out.println(ia1+""+STInput.get(ia1));
		//}
		
		if(STInput.size()!=0){
			return STInput.get(0);
		}else{
			return null;
		}
		
	}
	
    private ArrayList<Knapsack_Bag> SortsBags_SortedByValueASC_AL(ArrayList<Knapsack_Bag> input){
    	ArrayList<Knapsack_Bag> SortedList = new ArrayList<Knapsack_Bag>();
		// *********************************
		for (int i = 0; i <= input.size() - 1; i++) {
			int j = 0;
			for (j = 0; j <= SortedList.size() - 1; j++) {
		
				if (SortedList.get(j).getTotalValue() < input.get(i).getTotalValue()) {
					break;
				}
			}
			SortedList.add(j, input.get(i));
		}
		// *********************************
		return SortedList;

	}
	
    private ArrayList<Knapsack_Bag> StealFromStoreAndMakeBags(StoreInventory InputStore,Double WeightCapb){
		Brute_AL NewBruteIndexes=new Brute_AL();
		NewBruteIndexes.GetIndexes(InputStore.getNumberOfItem());
	
		ArrayList<Knapsack_Bag> Basic_Knapsack_bag_A=PopulateAL(NewBruteIndexes,InputStore,WeightCapb);

		//for(int ia1=0; ia1<=Basic_Knapsack_bag_A.size()-1;ia1++){
		//	System.out.println(ia1+""+Basic_Knapsack_bag_A.get(ia1));
		//}
		return Basic_Knapsack_bag_A;
	}
	

    private ArrayList<Knapsack_Bag> PopulateAL(Brute_AL BruteFa,StoreInventory InputStorea,double WeightCap){
		ArrayList<Knapsack_Bag> currentBagsA= new ArrayList<Knapsack_Bag>();
		currentBagsA.clear();
        
        for (int i = 0; i <= BruteFa.Get1ndLevelSize()- 1; i++) {
        	Knapsack_Bag CurBag= new Knapsack_Bag(WeightCap);
        	CurBag=MakeLocal_Knapsack_Bag(BruteFa,InputStorea,i,WeightCap);
        	
        	//System.out.println(CurBag+"\n"+CurBag.getNumberOfItem());
  
        	currentBagsA.add(CopyBag(CurBag));
		}//end for loop

		return currentBagsA;
	}//end ShowTable
	
	
    private Knapsack_Bag CopyBag(Knapsack_Bag input){
		
		Knapsack_Bag NEW1= new Knapsack_Bag(input.getCurrentWeight_Capacity());
		
		for(int i=0;i<=input.size()-1;i++){
			NEW1.Add_Item(input.get_Knapsack_Item(i).getWeight(),input.get_Knapsack_Item(i).getValue());
		}
		
		return NEW1;
	}

    private Knapsack_Bag MakeLocal_Knapsack_Bag(Brute_AL BruteF,StoreInventory InputStorea,int inpIndex,double WeightCap){
		//System.out.println(BruteF.Get2ndLevelSize(inpIndex));
		Knapsack_Bag CurrentBaga= new Knapsack_Bag(WeightCap);

		for(int i =0;i<=BruteF.Get2ndLevelSize(inpIndex)-1;i++){
			
			int indexa1=BruteF.Get2ndLevelItem(inpIndex, i);
			
			CurrentBaga.Add_Item(InputStorea.getAL_Item_WeightbyIndex(indexa1), InputStorea.getAL_Item_ValuebyIndex(indexa1));
		}

		return CurrentBaga;
	}
 
}
