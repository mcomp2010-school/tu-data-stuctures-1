package tree;

import java.util.ArrayList;

public class SeTree {
	public enum Node{Left,Right};
	private BinNode root;
	
	public SeTree() {
		this.root = null;
	}

	
	public void Insert_Level(String strFind,String data,Node Input){
		
		
			
		BinNode newNode = new BinNode(data);
		
		if (root == null) {
			root = newNode;
			return;
		}
		
		ALQueue<BinNode> Queue1= new ALQueue<BinNode>();
		BinNode current;
		current=root;
		Queue1.Enqueue(current);
	
		BinNode CurPar=current;
		if(CurPar.data.equalsIgnoreCase(strFind)){
			if(Input==Node.Left){
				CurPar.leftChild = newNode;
				return;
			}else if(Input==Node.Right){
				CurPar.rightChild = newNode;
				return;
			}else return;
		}
		
		while(!Queue1.isEmpty()){
			current=Queue1.Peek();

			if(current.leftChild!=null){
				Queue1.Enqueue(current.leftChild);
				//System.out.println(current.leftChild.data);
				
				CurPar=current.leftChild;
				if(CurPar.data.equalsIgnoreCase(strFind)){
					if(Input==Node.Left){
						CurPar.leftChild = newNode;
						return;
					}else if(Input==Node.Right){
						CurPar.rightChild = newNode;
						return;
					}else return;
				}
				
				
				
			}
			
			if(current.rightChild!=null){
				Queue1.Enqueue(current.rightChild);
				//System.out.println(current.rightChild.data);
				
				CurPar=current.rightChild;
				if(CurPar.data.equalsIgnoreCase(strFind)){
					if(Input==Node.Left){
						CurPar.leftChild = newNode;
						return;
					}else if(Input==Node.Right){
						CurPar.rightChild = newNode;
						return;
					}else return;
				}
			}
			
			Queue1.Dequeue();
			
		}
	

	}
	
	
	
	
	////////////////////
	
	public void traverseInOrder() {
		AL_InOrder.clear();
		inOrder(root);
		System.out.println("INOrder    : " + PrintAL_InOrder());
	}
	
	public void traverseLevelOrder() {
		AL_LevelOrder.clear();
		Traverse_LevelOrder_Process();
		System.out.println("LevelOrder : " + PrintAL_LevelOrder());
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


	
// ***********LevelOrder
	
	private static ArrayList<String> AL_LevelOrder = new ArrayList<String>();

	private String PrintAL_LevelOrder() {
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
