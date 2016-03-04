package miscExtraprogram4;

import java.util.ArrayList;

public class IntGen {
	//////////////////////////////////////////////////////////////////
	
	public static int RandomNumbera(int min, int max) {
		int n=(int)(Math.random() * (max - min + 1) ) + min;
		//System.out.println(n<min||n>max);
		while(n<min||n>max){//Make Sure Number is Between Min and Max
			n=(int)(Math.random() * (max - min + 1) ) + min;
		}
		return n;
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
	
	public static ArrayList<Integer> insertionSortUsingOneAL(ArrayList<Integer> arr){
		ArrayList<Integer> Sort= new ArrayList<Integer>(); 
		//for (int a = 0; a <= arr.size()-1; a++){
		//	Sort.add(arr.get(a));
		//}
		Sort=arr;
		//*********************************
		int i, j;
		Integer numac;
		for (i = 1; i < Sort.size(); i++){
			j = i;
			numac = Sort.get(i);
		    while (j > 0 && (numac<Sort.get(j-1))){	
				Sort.set(j, Sort.get(j-1));
				j--;
			}
			Sort.set(j,numac);
		}
		//*********************************
		return Sort;
	}
	//**************
}

