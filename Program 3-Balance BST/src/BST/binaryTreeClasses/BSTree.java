//==============================================================
// Program 3 – Balanced BST Implementation Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 10/25/2010
//--------------------------------------------------------------
//CLASS:BSTree.java
//--------------------------------------------------------------
package BST.binaryTreeClasses;

import java.util.ArrayList;
import queue.ALQueue;
import BST.binaryTreeClasses.SubClasses.BinNode;

public class BSTree {
	private BinNode root;
	public static int BSTSize = 0;

	public BSTree() {
		root = null;
		BSTSize = 0;
		AL_InOrder.clear();
		AL_PREOrder.clear();
		AL_PostOrder.clear();
		AL_LevelOrder.clear();
	}

	// =================================================================
	public void insert(String data) {  // Insert Method
		BinNode newNode = new BinNode(data, -1);
		if (root == null) {
			root = newNode;
			BSTSize++;
			newNode.IndexOfIns = BSTSize;
		} else {
			BinNode current = root; 
			BinNode parent;
			while (true) {
				parent = current; 
				if (IsSmaller(data, current.data)) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						BSTSize++;
						newNode.IndexOfIns = BSTSize;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						BSTSize++;
						newNode.IndexOfIns = BSTSize;
						return;
					}
				}
			}
		}
	}

	// **************************************************************
	// Comparison Methods*********************************************
	// **************************************************************
	
	public static boolean IsSmaller(String StrA, String StrB) {
		boolean isSmaller = true;

		if (IsNum(StrA) && IsNum(StrB)) {//If Both Numbers then Compare as Integer
			int inta = Integer.parseInt(StrA);
			int intb = Integer.parseInt(StrB);

			if (inta < intb)
				isSmaller = true;
			else
				isSmaller = false;
		} else {// Comparing Values as String.  
			if (StrA.compareToIgnoreCase(StrB) < 0)
				isSmaller = true;
			else if (StrA.compareToIgnoreCase(StrB) > 0)
				isSmaller = false;
		}

		return isSmaller;
	}

	public static boolean IsNum(String Input) {//Check if Input is Number
		boolean isnum = true;

		try {
			Integer.parseInt(Input);
		} catch (Exception e) {
			isnum = false;
		}

		return isnum;
	}

	// ***************************************************
	// ************Displaying Tree*************************
	// ***************************************************
	public void traverseInOrder() {
		AL_InOrder.clear();
		inOrder(root);
		System.out.println("INOrder    : " + PrintAL_InOrder());
	}

	public void traverseInOrder_NotPrint() {
		AL_InOrder.clear();
		inOrder(root);
	}

	public void traversePreOrder() {
		AL_PREOrder.clear();
		PreOrder(root);
		System.out.println("PreOrder   : " + PrintAL_PREOrder());
	}

	public void traverseLevelOrder() {
		AL_LevelOrder.clear();
		Traverse_LevelOrder_Process();
		System.out.println("LevelOrder : " + PrintAL_LevelOrder());
	}
	


	public void traversePreOrder_NotPrint() {
		AL_PREOrder.clear();
		PreOrder(root);

	}

	public void traversePostOrder() {
		AL_PostOrder.clear();
		PostOrder(root);
		System.out.println("PostOrder  : " + PrintAL_PostOrder());
	}

	// =================================================================
	// ***********InOrder
	public static ArrayList<String> AL_InOrder = new ArrayList<String>();

	public String PrintAL_InOrder() {
		String Output = "";
		for (int i = 0; i <= AL_InOrder.size() - 1; i++) {
			if (i >= AL_InOrder.size() - 1)
				Output += AL_InOrder.get(i);
			else
				Output += AL_InOrder.get(i) + ",";
		}
		return Output;
	}

	// ***********
	private void inOrder(BinNode Root) {// LNR
		if (Root == null)
			return;
		else {
			inOrder(Root.leftChild);
			AL_InOrder.add(Root.getData());
			inOrder(Root.rightChild);
		}
	}

	// ***********PreOrder
	public static ArrayList<String> AL_PREOrder = new ArrayList<String>();

	public String PrintAL_PREOrder() {
		String Output = "";
		for (int i = 0; i <= AL_PREOrder.size() - 1; i++) {
			if (i >= AL_PREOrder.size() - 1)
				Output += AL_PREOrder.get(i);
			else
				Output += AL_PREOrder.get(i) + ",";
		}
		return Output;
	}

	// ***********

	private void PreOrder(BinNode Root) {// NLR
		if (Root == null)
			return;
		else {
			AL_PREOrder.add(Root.getData());
			PreOrder(Root.leftChild);
			PreOrder(Root.rightChild);
		}
	}

	// ***********PostOrder
	public static ArrayList<String> AL_PostOrder = new ArrayList<String>();

	public String PrintAL_PostOrder() {
		String Output = "";
		for (int i = 0; i <= AL_PostOrder.size() - 1; i++) {
			if (i >= AL_PostOrder.size() - 1)
				Output += AL_PostOrder.get(i);
			else
				Output += AL_PostOrder.get(i) + ",";
		}
		return Output;
	}

	// ***********
	private void PostOrder(BinNode Root) { // LRN
		if (Root == null)
			return;
		else {
			PostOrder(Root.leftChild);
			PostOrder(Root.rightChild);
			// System.out.println(Root.getData());
			AL_PostOrder.add(Root.getData());
		}
	}

	// ***************************************
	// ***************************************
	
	// ***********LevelOrder
	
	public static ArrayList<String> AL_LevelOrder = new ArrayList<String>();

	public String PrintAL_LevelOrder() {
		String Output = "";
		for (int i = 0; i <= AL_LevelOrder.size() - 1; i++) {
			if (i >= AL_LevelOrder.size() - 1)
				Output += AL_LevelOrder.get(i);
			else
				Output += AL_LevelOrder.get(i) + ",";
		}
		return Output;
	}
	
	
	private void Traverse_LevelOrder_Process() {//
		ALQueue<BinNode> Queue1= new ALQueue<BinNode>();
		BinNode current;
		current=root;
		Queue1.Enqueue(current);
		AL_LevelOrder.add(current.data);
		
		while(!Queue1.isEmpty()){
			current=Queue1.Peek();
			
			if(current.leftChild!=null){
				AL_LevelOrder.add(current.leftChild.data);
				Queue1.Enqueue(current.leftChild);
			}
			
			if(current.rightChild!=null){
				AL_LevelOrder.add(current.rightChild.data);
				Queue1.Enqueue(current.rightChild);
			}
			
			Queue1.Dequeue();
			
		}
	

	}
	
	
	
}
