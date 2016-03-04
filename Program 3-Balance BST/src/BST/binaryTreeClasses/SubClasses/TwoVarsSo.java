//==============================================================
// Program 3 – Balanced BST Implementation Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 10/25/2010
//--------------------------------------------------------------
//CLASS:TwoVarsSo.java
//--------------------------------------------------------------
package BST.binaryTreeClasses.SubClasses;

public class TwoVarsSo{
	
	public String toString() {
		return "[" + Var1 + ", " + Var2 + "]";
	}

	public String Var1="";
	public String Var2="";
	
	public TwoVarsSo(String var1, String var2) {
		
		Var1 = var1;
		Var2 = var2;
	}
}
