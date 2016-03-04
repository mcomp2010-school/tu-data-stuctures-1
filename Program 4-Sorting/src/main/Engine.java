//==============================================================
// Program 4 – Sorting Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 09/08/2010
//--------------------------------------------------------------
//CLASS:main.Engine
//--------------------------------------------------------------

package main;
import classes.StaticShared;
public class Engine {

	
	public static void main(String[] args) {
		System.out.println("---------------");
		System.out.println("Processor: Intel Core 2 Duo 2.13Ghz");
		System.out.println("Ram: 4.00 GB");
		System.out.println("64-Bit OS");

		
		System.out.println("---------------");
		System.out.println("Time Format: Minutes:Seconds.Miliseconds");
		System.out.println("---------------");
		
		System.out.println("");
		System.out.println("Generation= How long it take to Generatate the Arraylist of Random Numbers");
		System.out.println("Heap      = How long it takes to sort the arraylist with Heap sorting");
		System.out.println("Merge     = How long it takes to sort the arraylist with Merge sorting");
		System.out.println("Insertion = How long it takes to sort the arraylist with Insertion sorting");
		System.out.println("---------------");
		//
		MainPrint.PrintTop();
		//
		MainPrint.PrintPwdAllSort("10^3",StaticShared.intPwBase10(3));
		MainPrint.PrintPwdAllSort("10^5",StaticShared.intPwBase10(5));
		MainPrint.PrintPwdAllSort("10^7",StaticShared.intPwBase10(7));
		MainPrint.PrintPwdAllSort("10^9",StaticShared.intPwBase10(9));
		
		
	
		/*
		 * Power     Generation     Heap           Merge          Insertion      
			10^3      0:00.0030      0:00.01        0:00.024       0:00.014       
			10^5      0:00.034       0:00.109       0:16.349       0:51.599       
			10^7      0:03.858       0:40.448       NA				NA
		 	10^9      NA=Not able to Complete because of Memory
		 */
	}

}
