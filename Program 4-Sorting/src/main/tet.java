package main;

import java.text.NumberFormat;
import java.util.ArrayList;

import classes.StaticShared;

public class tet {

	
	public static void main(String[] args) {
		testMEM();

	}
	
	static void testArray(){
		ArrayList<Integer> newa=new ArrayList<Integer>();
		newa.ensureCapacity(StaticShared.intPwBase10(9));
		
	}
	static void testMEM(){
		 Runtime runtime = Runtime.getRuntime();

		    NumberFormat format = NumberFormat.getInstance();

		    long maxMemory = runtime.maxMemory();
		    long allocatedMemory = runtime.totalMemory();
		    long freeMemory = runtime.freeMemory();
		    

		    System.out.println("free memory: " + format.format(freeMemory / 1024) + "");
		    System.out.println("allocated memory: " + format.format(allocatedMemory / 1024) + "");
		    System.out.println("max memory: " + format.format(maxMemory / 1024) + "");
		    System.out.println("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "");
		    
		    
	}

}
