//==============================================================
// Program 4 – Sorting Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 09/08/2010
//--------------------------------------------------------------
//CLASS:classes.IntGeneration
//--------------------------------------------------------------
package classes;

import java.util.ArrayList;

public class IntGeneration {
	
	public int IntUpperLimit=2147483647;//This is Max Int Limit
	
	
	private static int RandomNumbera(int min, int max) { //Generate a Random Number between MIN and MAX
		int n=(int)(Math.random() * (max - min + 1) ) + min;
		while(n<min||n>max){//Make Sure Number is Between Min and Max
			n=(int)(Math.random() * (max - min + 1) ) + min;
		}
		return n;
	}
	//This will Give a NotUnique Random Number Array List Between Min and Max
	//and has to have Quantity number of Integers
	public ArrayList<Integer> NotUnique_RandomNum_ArrayL(int min,int max,int Quantity){
		ArrayList<Integer> CheckerRepeat = new ArrayList<Integer>();
		for (int iRan = 1; iRan <= Quantity; iRan++) {
			int num = RandomNumbera(min, max);
			CheckerRepeat.add(num);
		}
		return CheckerRepeat;//
	}


}
