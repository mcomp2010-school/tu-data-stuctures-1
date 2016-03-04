package comparison;

public class str {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("C".compareToIgnoreCase("D")<0);
		System.out.println("b".compareToIgnoreCase("c"));
		System.out.println("a".compareToIgnoreCase("c"));
		System.out.println("10".compareToIgnoreCase("c"));
		System.out.println("10".compareToIgnoreCase("11"));
		System.out.println("900".compareToIgnoreCase("11"));

	}

}
