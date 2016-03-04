package main;
//==============================================================
//Program 5 – Hashing Implementation Program
//==============================================================
//Emanuel Rivera
//COSC 336-001
//11-22-2010
//--------------------------------------------------------------

import classes.HashTable_Chaining;
import classes.HashTable_Linear;
import classes.HashTable_Quadratic;

public class testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Chaining_Testing();
		//Quad_Testing();
		

	}

	private static void Quad_Testing(){
		HashTable_Quadratic HashTable_Quadratic1=new HashTable_Quadratic(10);
		
		
		HashTable_Quadratic1.insert(4, "v4");
		HashTable_Quadratic1.insert(55, "v55");
		HashTable_Quadratic1.insert(6, "v6");
		HashTable_Quadratic1.insert(78, "v78");
		HashTable_Quadratic1.insert(8, "v8");
		HashTable_Quadratic1.insert(2, "v2");
		HashTable_Quadratic1.insert(9, "9");
		HashTable_Quadratic1.insert(10, "v10");
		
		HashTable_Quadratic1.insert(44, "v44");
		HashTable_Quadratic1.insert(444, "v444");
		//HashTable_Quadratic1.insert(449, "v448");
		
		System.out.println(HashTable_Quadratic1.ShowTable());
		
		System.out.println(HashTable_Quadratic1.delete(44));
		System.out.println(HashTable_Quadratic1.ShowTable());
		
	}
	private static void Chaining_Testing(){
		HashTable_Chaining HashTable_Chaining1=new HashTable_Chaining(10);
		System.out.println(HashTable_Chaining1.ShowTable());
		HashTable_Chaining1.insert(50, "v50");
	
		HashTable_Chaining1.insert(54, "v54");
		HashTable_Chaining1.insert(55, "v55");
		HashTable_Chaining1.insert(65, "v65");
		HashTable_Chaining1.insert(75, "v75");
		
		HashTable_Chaining1.insert(99, "v99");
		HashTable_Chaining1.insert(999, "v999");
		HashTable_Chaining1.insert(551, "v551");
		
		System.out.println(HashTable_Chaining1.ShowTable());
		//System.out.println(HashTable_Chaining1.findIndex(75));
		System.out.println(HashTable_Chaining1.delete(65));
		System.out.println(HashTable_Chaining1.delete(99));
		System.out.println(HashTable_Chaining1.delete(551));
		
		System.out.println(HashTable_Chaining1.find(551));
		System.out.println(HashTable_Chaining1.ShowTable());
	}
	
	private void Linear_Testing(){
		HashTable_Linear HashTable_Linear1=new HashTable_Linear();
		
		HashTable_Linear1.insert(8,"8");
		HashTable_Linear1.insert(6,"6");
		HashTable_Linear1.insert(3,"3");
		HashTable_Linear1.insert(7,"7");
		HashTable_Linear1.insert(2,"2");
		HashTable_Linear1.insert(33,"33");
		HashTable_Linear1.insert(43,"43");
		HashTable_Linear1.insert(53,"53");
		HashTable_Linear1.insert(1000,"1000");
		
	
		System.out.println(HashTable_Linear1.ShowTable());
		
		
		System.out.println(HashTable_Linear1.find(3));
		System.out.println(HashTable_Linear1.delete(3));
		System.out.println(HashTable_Linear1.delete(43));
		
		System.out.println(HashTable_Linear1.ShowTable());
		
		System.out.println(HashTable_Linear1.find(53));
	}
}
