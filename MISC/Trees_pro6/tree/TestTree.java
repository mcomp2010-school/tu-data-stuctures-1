package tree;

import tree.SeTree.Node;



public class TestTree {
	
	static SeTree NewTestTree=new SeTree();
	
	public static void main(String[] args) {
		NewTestTree.Insert_Level("","root",null);
		
		NewTestTree.Insert_Level("root","Left",Node.Left);
		
		NewTestTree.Insert_Level("root","Right",Node.Right);
		
		NewTestTree.Insert_Level("Right","R_Left",Node.Left);
		
		
		NewTestTree.traverseLevelOrder();
		NewTestTree.traverseInOrder();		
	}
	
	
}
