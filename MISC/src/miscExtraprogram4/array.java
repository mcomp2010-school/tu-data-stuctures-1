package miscExtraprogram4;

import java.util.ArrayList;

public class array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	
	//////////////////////////////////////////////////////
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
	
	public static int[] ConvertArrayListToArray(ArrayList<Integer> Input){
		int[]ToSortArray=new int[Input.size()];
			for(int i=0;i<=Input.size()-1;i++){
				ToSortArray[i]=Input.get(i);
			}
			return ToSortArray;
	}
	
	
	

}
