import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ma {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		ArrayList DoubleStack = new ArrayList();
		DoubleStack.add("1");
		DoubleStack.add("2");
		DoubleStack.add("3");
		DoubleStack.add("4");
		DoubleStack.add("5");
		DoubleStack.add("2");
		DoubleStack.add("4");
		DoubleStack.add("10");

		// DoubleStack.remove(0);
		// DoubleStack.remove(DoubleStack.size()-1);

		System.out.println(DoubleStack);
		System.out.print(Lsearch("1",DoubleStack));
	}

	public static int Lsearch(String D, ArrayList inlist) {
		int LastIndex = 0;
		for (int i = inlist.size() - 1; i >=0; i--) {
			if (D.equals(inlist.get(i))) {
				LastIndex=LastIndex+1;
			}
		}
		return LastIndex;

	}

}
