//==============================================================
// Program 4 – Sorting Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 09/08/2010
//--------------------------------------------------------------
//CLASS:main.MainPrint
//--------------------------------------------------------------

package main;

import java.util.ArrayList;

import classes.IntGeneration;
import classes.Sorting;
import classes.StaticShared;
import classes.Timing;

public class MainPrint {

	public static void main(String[] args) {
		PrintTop();
		PrintPwdAllSort("10^3",StaticShared.intPwBase10(4));
	
	}
	
	public static void PrintTop(){
		System.out.println(STab("Power",10)+STab("Generation",15)+STab("Heap",15)+STab("Merge",15)+STab("Insertion",15));
	}
	
	public static void PrintPwdAllSort(String InputTxt,int InputNum){
		System.out.print(STab(InputTxt,10));
		PwdAllSort(InputNum);
		System.out.println();
	}
	
	 private static String STab(String string, int fldLen) {
			int len = fldLen - string.length();
			if (len <= 0)
			    return string.substring(0, string.length());
			StringBuffer buf = new StringBuffer(fldLen);
			for (int n = 0; n < len; n++)
			    buf.append(' ');
			buf.insert(0, string);
			return new String(buf);
	 }
	 
	 
	
	private static void PwdAllSort(int InQuantity){
		//****************************
		//GVARS*************************
		//****************************
		Timing t = new Timing();
		IntGeneration RanArrayGenerator=new IntGeneration();
	
		//*********************************************************************
		//G3Arr_NUni_base******************************************************
		//*********************************************************************
		t.start();//Time
		ArrayList<Integer> G0Arr_NUni_base = RanArrayGenerator.NotUnique_RandomNum_ArrayL(1, 2147483647, InQuantity);
		//System.out.println(StaticShared.PrintArrayList_toString(G0Arr_NUni_base));
		String tG0Arr_NUni=t.stop();
		//System.out.println("Time to Generate Array with 10^3 (NotUniqueNumbers) took "+tG0Arr_NUni+" sec");
		System.out.print(STab(tG0Arr_NUni.toString()+"",15));
		
		
		//HeapSort**********************************************************************
		ArrayList<Integer> G0Arr_NUni_HeapAL= (ArrayList<Integer>) G0Arr_NUni_base.clone();//Clone so It will not be Referenced

		t.start();//Time
		Sorting.HeapSort_arraylist(G0Arr_NUni_HeapAL);
		String tG0Arr_NUni_HeapSort=t.stop();
		//System.out.println(tG0Arr_NUni_HeapSort);
		System.out.print(STab(tG0Arr_NUni_HeapSort.toString(),15));
		//
		//System.out.println(StaticShared.PrintArrayList_toString(G0Arr_NUni_HeapAL));
		G0Arr_NUni_HeapAL=null;
		
		
		//MergeSort**********************************************************************
		ArrayList<Integer> G0Arr_NUni_MergeAL= (ArrayList<Integer>) G0Arr_NUni_base.clone();//Clone so It will not be Referenced

		t.start();//Time
		Sorting.mergeSort_arraylist(G0Arr_NUni_MergeAL, 0, G0Arr_NUni_MergeAL.size()-1);
		String tG0Arr_NUni_MergeSort=t.stop();
		//System.out.println(tG0Arr_NUni_MergeSort);
		System.out.print(STab(tG0Arr_NUni_MergeSort.toString(),15));
		//
		//System.out.println(StaticShared.PrintArrayList_toString(G0Arr_NUni_MergeAL));
		G0Arr_NUni_MergeAL=null;
			
		
		
		//InsertionSort********************************************************
		ArrayList<Integer> G0Arr_NUni_InsertionAL= (ArrayList<Integer>) G0Arr_NUni_base.clone();//Clone so It will not be Referenced
		t.start();//Time
		//Sorting.insertionSort_arraylistREF(G0Arr_NUni_InsertionAL);
		Sorting.insertionSort_arraylist(G0Arr_NUni_InsertionAL);
		String tG0Arr_NUni_InsertionSort=t.stop();
		//System.out.println(tG0Arr_NUni_InsertionSort);
		System.out.print(STab(tG0Arr_NUni_InsertionSort.toString(),15));
		//
		//System.out.println(StaticShared.PrintArrayList_toString(G0Arr_NUni_InsertionAL));
		G0Arr_NUni_InsertionAL=null;
		
		
		
		//*******************************************************************************
		//*******************************************************************************
		
		
	}
	
	
	

}
