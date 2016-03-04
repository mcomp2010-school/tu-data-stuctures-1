//==============================================================
// Program 3 – Balanced BST Implementation Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 10/25/2010
//--------------------------------------------------------------
//CLASS:BinNode.java
//--------------------------------------------------------------
package BST.binaryTreeClasses.SubClasses;

public class BinNode {
	public String data;
	public BinNode leftChild;
	public BinNode rightChild;
	public int IndexOfIns=-1;

	public BinNode(String value,int inputint) {
		data = value;
		IndexOfIns=inputint;
		
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

	public int getIndexOfIns() {
		return IndexOfIns;
	}

	public void setIndexOfIns(int indexOfIns) {
		IndexOfIns = indexOfIns;
	}

	public void setData(String data) {
		this.data = data;
	}
}