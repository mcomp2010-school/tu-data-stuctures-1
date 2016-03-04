//==============================================================
// Program 3 – Balanced BST Implementation Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 10/25/2010
//--------------------------------------------------------------
//CLASS:FillBSTree.java
//--------------------------------------------------------------

package tree;

import java.util.ArrayList;
import tree.ALQueue;
import tree.BinNode;

public class FillBSTree {

	private BinNode root;

	public FillBSTree() {
		root = null;
		AL_InOrder.clear();
	}
		
	public void fillLevels(int size){
		//ArrayList<BinNode> Q1=new ArrayList<BinNode>();
		//ArrayList<BinNode> Q2=new ArrayList<BinNode>();
		
		ALQueue<BinNode> Q1a=new ALQueue<BinNode>();
		ALQueue<BinNode> Q2a=new ALQueue<BinNode>();
		
		int MaxSize=size;
		Integer OnCount=1;
		
		BinNode newNode = new BinNode(OnCount.toString());
		root = newNode;
		
		BinNode current = root; 
		Q1a.Enqueue(current);
				
		BinNode parent;
		while(OnCount<=MaxSize){
			
			while(!Q1a.isEmpty()){
				OnCount++;
				if(OnCount<=MaxSize){
					parent = Q1a.Peek(); 
					
					parent.leftChild =new BinNode(OnCount.toString());
				
					Q2a.Enqueue(parent.leftChild);		
				}	
				//System.out.println(MaxSize+"\t"+OnCount);
				////////////////////////////
				OnCount++;
				if(OnCount<=MaxSize){
					parent = Q1a.Peek(); 
					
					parent.rightChild = new BinNode(OnCount.toString());

					Q2a.Enqueue(parent.rightChild);
			
				}
				//System.out.println(MaxSize+"\t"+OnCount);
				Q1a.Dequeue();	
			}
			while(!Q2a.isEmpty()){//Put all the Roots in Queue 1
			Q1a.Enqueue(Q2a.Dequeue());
				
			}
		}
	}
	// ***************************************************
	// ************Displaying Tree*************************
	// ***************************************************
	public void traverseInOrder() {
		AL_InOrder.clear();
		inOrder(root);
		System.out.println("INOrder:  "+PrintAL_InOrder());
	}
	
	public void traverseInOrder_NotPrint() {
		AL_InOrder.clear();
		inOrder(root);
	}
	// =================================================================
	// ***********InOrder
	public static ArrayList<String> AL_InOrder= new ArrayList<String>();
	
	public String PrintAL_InOrder(){
		String Output="";
		for(int i=0;i<=AL_InOrder.size()-1;i++){
			if(i>=AL_InOrder.size()-1)Output+=AL_InOrder.get(i);
			else Output+=AL_InOrder.get(i)+",";
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

}
