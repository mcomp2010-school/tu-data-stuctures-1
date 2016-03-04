package shared;

//==============================================================
//Program 5 – Hashing Implementation Program
//==============================================================
//Emanuel Rivera
//COSC 336-001
//11-22-2010
//--------------------------------------------------------------

import java.util.ArrayList;

public class IntGen {
	//////////////////////////////////////////////////////////////////
	//int n=(int)(Math.random() * (1000- 1+ 1) ) + 1;
	
	
	public static int RandomNumbera(int min, int max) {
		int n=(int)(Math.random() * (max - min + 1) ) + min;
		//System.out.println(n<min||n>max);
		while(n<min||n>max){//Make Sure Number is Between Min and Max
			n=(int)(Math.random() * (max - min + 1) ) + min;
		}
		return n;
	}
	
	public static String PrintArrayList_toString(ArrayList<Integer> InputARL){
        String Output1="";
		for (int i = 0; i <= InputARL.size() - 1; i++) {
			if(i < InputARL.size()-1){
				Output1+=InputARL.get(i).toString()+",";
			}else Output1+=InputARL.get(i).toString();
		}
		return Output1;
	}
	
	public static int PickRandomKey(ArrayList<Integer> InputARL){
        //String Output1="";
		//Output1=InputARL.get(RandomNumbera(0,InputARL.size() - 1))+"";
		//return Output1;
		return InputARL.get(RandomNumbera(0,InputARL.size() - 1));
	}
	
	public static double FindValueAverageofArrayList(ArrayList<Integer> InputARL1){
		int sum=0;
		
		for (int i = 0; i <= InputARL1.size() - 1; i++) {
			sum+=InputARL1.get(i);
		}
		
		double average=sum/InputARL1.size();
		
		return average;
	}
	
	public static ArrayList<Integer> Unique_RandomNum_ArrayL(int min,int max,int Quantity){
		ArrayList<Integer> CheckerRepeat = new ArrayList<Integer>();
		int AFTRange= Math.abs(max-min)+1;
		//System.out.println(AFTRange);
		for (int iRan = 1; iRan <= Quantity; iRan++) {
			int num = RandomNumbera(min, max);
			//Check for Repeat
			boolean Rep = false;
				for (int i = 0; i <= CheckerRepeat.size() - 1; i++) {
					if (CheckerRepeat.get(i) == num){
						Rep = true;
						
						if(iRan<=AFTRange){//Prevent Forever Loop
							iRan--;//if Repeat then -1 to fill Quantity
						}
						
					
					}
						
					    
				}
			if (Rep == false){
				CheckerRepeat.add(num);
			}
			//End Check for Repeats
			
		}
		return CheckerRepeat;
	}

	




	

}

