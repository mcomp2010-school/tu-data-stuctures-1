package miscExtraprogram4;

import java.util.ArrayList;



public class ArrayListTOArray {

	public static void main(String[] args) {
		
		
		
		
		
		
	}
	
	

	

	////
	public static ArrayList<Integer> ConvertArrayToListBack(ArrayList<Integer> Input){
		int[]ToSortArray=new int[Input.size()];
	
			for(int i=0;i<=Input.size()-1;i++){
				ToSortArray[i]=Input.get(i);
			}
			//Do some converting for Merge Sorting
	//**************************************************//
		
		
	
	
		
	//**************************************************//
			ArrayList<Integer> FinishAL=new ArrayList<Integer>();
			for(int i=0;i<=ToSortArray.length-1;i++){
				FinishAL.add(ToSortArray[i]);
			}
			
			return FinishAL;
	}

	
	/////////////
	///////
	///////////
	//////////
	////////
	/////////

	
	public static ArrayList<Integer> mergeSort_arraylist(ArrayList<Integer> Input,int lo, int n){
		int low = lo;
	    int high = n;
	    if (low >= high) {
	      return null;
	    }
	    int middle = (low + high) / 2;
	    mergeSort_arraylist(Input, low, middle);
	        mergeSort_arraylist(Input, middle + 1, high);
	    int end_low = middle;
	    int start_high = middle + 1;
	    while ((lo <= end_low) && (start_high <= high)) {
	    if(Input.get(low)<Input.get(start_high)){  
	        low++;
	            } else {
	        int Temp = Input.get(start_high);
	        for (int k = start_high- 1; k >= low; k--) {
	          
	        	Input.set(k+1, Input.get(k));
	        }
	        	Input.set(low, Temp);
	                low++;
	                end_low++;
	                start_high++;
	            }
	        }
	    
	  
		return Input;
	    }  
	
  
}
