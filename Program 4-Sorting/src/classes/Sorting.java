//==============================================================
// Program 4 – Sorting Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 09/08/2010
//--------------------------------------------------------------
//CLASS:classes.Sorting
//--------------------------------------------------------------

package classes;

import java.util.ArrayList;
import classes.StaticShared;

public class Sorting {

	// /////////////////////////////////////////
	// /////////////Insertion Sort//////////////
	// /////////////////////////////////////////
	
	public static ArrayList<Integer> insertionSort_arraylist(ArrayList<Integer> arr) {
		ArrayList<Integer> SortedList = new ArrayList<Integer>();
		// *********************************
		for (int i = 0; i <=  arr.size() - 1; i++) {
			int j = 0;
			for (j = 0; j <= SortedList.size() - 1; j++) {
				if (SortedList.get(j) >  arr.get(i)) {
					break;
				}
			}
			SortedList.add(j,  arr.get(i));
		}
		// *********************************
		return SortedList;
	}
	
	//REF
	public static void insertionSort_arraylistREF(ArrayList<Integer> arr) {
		ArrayList<Integer> Temp = (ArrayList<Integer>) arr.clone();
		arr.clear();

		// *********************************
		for (int i = 0; i <=  Temp.size() - 1; i++) {
			int j = 0;
			for (j = 0; j <= arr.size() - 1; j++) {
				if (arr.get(j) > Temp.get(i)) {
					break;
				}
			}
			arr.add(j, Temp.get(i));
		}
		// *********************************
		
	}

	// /////////////////////////////////////////
	// /////////////HeapSort////////////////////
	// /////////////////////////////////////////
	public static void HeapSort_arraylist(ArrayList<Integer> arr) {
		ArrayList<Integer> ToSort = arr;
		//////////////////////////////////////////
		int n = ToSort.size();
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify_arraylist(ToSort, i, n);
		}

		for (int i = n - 1; i > 0; i--) {
			swap_arraylist(ToSort, 0, i);
			heapify_arraylist(ToSort, 0, i);
		}
	}

	private static void heapify_arraylist(ArrayList<Integer> a, int i, int j) {
		int ai = a.get(i);
		while (2 * i + 1 < j) {
			int k = 2 * i + 1;
			if (k + 1 < j && a.get(k + 1) > a.get(k)) {
				++k;
			}
			if (ai >= a.get(k)) {
				break;
			}
			a.set(i, a.get(k));
			i = k;
		}

		a.set(i, ai);
	}
	
	// /////////////////////////////////////////
	// /////////////MergeSort///////////////////
	// /////////////////////////////////////////
	
	public static void mergeSort_arraylist(ArrayList<Integer> Input,int lo, int n){
		int low = lo;
	    int high = n;
	    if (low >= high) {
	      return;
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
	    
	 
	    }  
	

	// ///////////////******************/////////
	// ///////////////******************/////////
	// ///////////////******************//////////

	private static void swap_arraylist(ArrayList<Integer> a, int i, int j) {
		if (i == j) {
			return;
		}
		int temp = a.get(j);
		a.set(j, a.get(i));
		a.set(i, temp);
	}

}
