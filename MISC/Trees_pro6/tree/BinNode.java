//==============================================================
//PROGRAM 6 – Greedy and Dynamic Programming
//==============================================================
//Emanuel Rivera
//COSC 336-101
//December 1 2010
//==============================================================
package tree;

public class BinNode {
	public String data;
	public BinNode leftChild;
	public BinNode rightChild;

	public BinNode(String value) {
		data = value;
		
	}
	
	public String getData() {
		return data;
	}
	

	// *********************************
	public BinNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinNode leftChild) {
		this.leftChild = leftChild;
	}

	public BinNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinNode rightChild) {
		this.rightChild = rightChild;
	}


	public void setData(String data) {
		this.data = data;
	}
}