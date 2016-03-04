//==============================================================
// Program 3 – Balanced BST Implementation Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 10/25/2010
//--------------------------------------------------------------
//CLASS:Engine.java  (MAIN CLASS)
//--------------------------------------------------------------
package main;

import java.util.ArrayList;
import java.util.Scanner;
import BST.binaryTreeClasses.BSTree;
import BST.binaryTreeClasses.FillBSTree;
import BST.binaryTreeClasses.SubClasses.TwoVarsSo;

public class Engine {

	public static void SP_Label(String Input){//Make Print Out look nicer
		System.out.println("___________________________________________________");
		System.out.println(Input);
		System.out.println("-------------------------");
	}
	
	public static void main(String[] args) {

		// ******************************************
		// *************Input Value Using Scanner*****
		// ******************************************
		// To USE Replace UseScanner=false to UseScanner=true;
		boolean UseScanner = true;//To USE Change to true
		if (UseScanner == true) {

			BSTree BSTGEN = new BSTree();
			Scanner ScanInput = new Scanner(System.in);
			String InputValue = "";
			System.out
					.println("Please Type any numeric " +
							"Character or alphabetic Character " +
							"(To exit inputing type in *)");
			
			while (!InputValue.equalsIgnoreCase("*")) {
				InputValue = ScanInput.next().trim();
				if (!InputValue.equalsIgnoreCase("*")) {
					BSTGEN.insert(InputValue);
				}

			}
		
			SP_Label("Using Scanner to input number or letters");//PRINT OUT
			PrintUnbalanceNBalance(BSTGEN);
			
		}

		// --*****************************************--
		// -*****Input Value Using BSTree Insert*******-
		// --*****************************************--

		// Tree Can Handle BOTH Numberic and Alphabetic Values
		SP_Label("Numberic Values");//PRINT OUT
		BSTree BSTNumberic = new BSTree();
		BSTNumberic.insert("1");
		BSTNumberic.insert("2");
		BSTNumberic.insert("3");
		BSTNumberic.insert("4");
		BSTNumberic.insert("5");
		BSTNumberic.insert("6");
		BSTNumberic.insert("7");
		BSTNumberic.insert("8");
		BSTNumberic.insert("9");
		BSTNumberic.insert("10");
		BSTNumberic.insert("11");
		BSTNumberic.insert("12");
		BSTNumberic.insert("13");
		BSTNumberic.insert("14");
		BSTNumberic.insert("15");
		
		PrintUnbalanceNBalance(BSTNumberic);
		
		
		SP_Label("Alphabetic Values");//PRINT OUT
		BSTree BSTAlph = new BSTree();
		BSTAlph.insert("A");
		BSTAlph.insert("B");
		BSTAlph.insert("C");
		BSTAlph.insert("D");
		BSTAlph.insert("E");
		BSTAlph.insert("F");
		BSTAlph.insert("G");
		BSTAlph.insert("H");
		BSTAlph.insert("I");
		BSTAlph.insert("J");
		BSTAlph.insert("K");
		BSTAlph.insert("L");
		BSTAlph.insert("M");
		BSTAlph.insert("N");
		BSTAlph.insert("O");
		PrintUnbalanceNBalance(BSTAlph);
		
		
		
		SP_Label("20 Numberic Random Values {1 to 100} (non repeating)");//PRINT OUT
		BSTree BSTRandomNumberic = new BSTree();
		ArrayList<Integer> CheckerRepeat = new ArrayList<Integer>();
		for (int iRan = 1; iRan <= 20; iRan++) {
			int num = RandomNumbera(1, 100);
			boolean Rep = false;
			for (int i = 0; i <= CheckerRepeat.size() - 1; i++) {
				if (CheckerRepeat.get(i) == num)
					Rep = true;
			}
			if (Rep == false)
				CheckerRepeat.add(num);
		}
		
		String Output1="";
		
		for (int i = 0; i <= CheckerRepeat.size() - 1; i++) {
			// System.out.println(CheckerRepeat.get(i));
			if(i < CheckerRepeat.size()-1){
				Output1+=CheckerRepeat.get(i).toString()+",";
			}else Output1+=CheckerRepeat.get(i).toString();
			
			BSTRandomNumberic.insert(CheckerRepeat.get(i).toString());
		}
		System.out.println("Insert Ord : "+Output1);
		PrintUnbalanceNBalance(BSTRandomNumberic);
	}

	// ********************************
	// ********************************
	// ********************************

	public static int RandomNumbera(int min, int max) {
		int n = (int) (max * Math.random()) + min;
		return n;
	}

	// Print unBalance Tree and calls BalanceTree();
	public static void PrintUnbalanceNBalance(BSTree BSTreeInput) {

		System.out.println("Unbalanced BST:");
		BSTreeInput.traverseInOrder();
		BSTreeInput.traversePreOrder();
		BSTreeInput.traversePostOrder();
		BSTreeInput.traverseLevelOrder();
		PrintOrganizedLevelOrder(BSTreeInput);
		System.out.println();
		
		BalanceTree(BSTreeInput);
		System.out.println();

	}

	// Balance Tree and Prints Out Using FillBSTree
	public static void BalanceTree(BSTree InTree) {
													
		InTree.traverseInOrder_NotPrint();
		// InTree.traverseInOrder();
		FillBSTree BSTS = new FillBSTree();
		BSTS.fillLevels(InTree.BSTSize);
		BSTS.traverseInOrder_NotPrint();
		// BSTS.traverseInOrder();

		ArrayList<String> Temp = new ArrayList<String>();

		ArrayList<TwoVarsSo> TempSo = new ArrayList<TwoVarsSo>();
		for (int i = 0; i <= BSTree.BSTSize - 1; i++) { // Put It in TwoVarsSo
														// for Sorting
			String var1 = BSTS.AL_InOrder.get(i);
			String var2 = InTree.AL_InOrder.get(i);
			
			TempSo.add(new TwoVarsSo(var1, var2));
		}
		// /
		//
		int curind = 1;
		while (curind <= TempSo.size()) {
			for (int i = 0; i <= TempSo.size() - 1; i++) {
				int indexa = Integer.parseInt(TempSo.get(i).Var1);
				if (curind == indexa) {
					// System.out.print(TempSo.get(i).Var2+", ");
					Temp.add(TempSo.get(i).Var2);
					curind++;
				}
			}
		}

		BSTree NewOrganizeBSTree = new BSTree();

		for (int i = 0; i <= Temp.size() - 1; i++) {
			NewOrganizeBSTree.insert(Temp.get(i));
		}

		System.out.println("----------");
		System.out.println("Complete balanced BST:");
		NewOrganizeBSTree.traverseInOrder();
		NewOrganizeBSTree.traversePreOrder();
		NewOrganizeBSTree.traversePostOrder();
		NewOrganizeBSTree.traverseLevelOrder();
		PrintOrganizedLevelOrder(NewOrganizeBSTree);
	}

	
	//This method Converts InOrder to Organized LevelOrder Using FillBSTree
	public static void PrintOrganizedLevelOrder(BSTree InTree) {
		System.out.print("Organized LevelOrder(FillBSTree):");
		InTree.traverseInOrder_NotPrint();
		// InTree.traverseInOrder();
		FillBSTree BSTS = new FillBSTree();
		BSTS.fillLevels(InTree.BSTSize);
		BSTS.traverseInOrder_NotPrint();
		// BSTS.traverseInOrder();

		ArrayList<TwoVarsSo> TempSo = new ArrayList<TwoVarsSo>();
		for (int i = 0; i <= BSTree.BSTSize - 1; i++) { // Put It in TwoVarsSo
														// for Sorting
			String var1 = BSTS.AL_InOrder.get(i);
			String var2 = InTree.AL_InOrder.get(i);
			TempSo.add(new TwoVarsSo(var1, var2));
		}
		// /
		//
		int curind = 1;
		while (curind <= TempSo.size()) {
			for (int i = 0; i <= TempSo.size() - 1; i++) {
				int indexa = Integer.parseInt(TempSo.get(i).Var1);
				if (curind == indexa) {
					if (indexa == TempSo.size()) {
						System.out.print(TempSo.get(i).Var2);
					} else {
						System.out.print(TempSo.get(i).Var2 + ",");
					}

					// Temp.add(TempSo.get(i).Var2);
					curind++;
				}
			}
		}
	}

}
