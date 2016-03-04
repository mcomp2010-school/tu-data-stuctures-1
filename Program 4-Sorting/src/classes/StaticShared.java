//==============================================================
// Program 4 – Sorting Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 09/08/2010
//--------------------------------------------------------------
//CLASS:classes.StaticShared
//--------------------------------------------------------------
package classes;

import java.util.ArrayList;

public class StaticShared {
	//Prints an ArrayList to a Nice looking list with ,s
	public static String PrintArrayList_toString(ArrayList<Integer> InputARL){
        String Output1="";
		for (int i = 0; i <= InputARL.size() - 1; i++) {
			if(i < InputARL.size()-1){
				Output1+=InputARL.get(i).toString()+",";
			}else Output1+=InputARL.get(i).toString();
		}
		return Output1;
	}
	
	public static String PrintArray_toString(int[] InputARL){
        String Output1="";
		for (int i = 0; i <= InputARL.length - 1; i++) {
			if(i < InputARL.length-1){
				Output1+=InputARL[i]+",";
			}else Output1+=InputARL[i];
		}
		return Output1;
	}
	
	public static int intPwBase10(int input){//Return 10^input as Int
		int output=(int) Math.pow(10, input);
		return output;
	}
}
