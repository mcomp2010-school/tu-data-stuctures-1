import java.util.ArrayList;



public class arraylistex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList Num = new ArrayList();
		
		Num.add("1");
		Num.add("2");
		Num.add("1");
		Num.add("2");
		Num.add("3");
		Num.add("5");
		Num.add("2");
		
		for(int i = 0 ; i<Num.size();i++){
			System.out.println(Num.get(i));
		}

		
		System.out.println("-----");
		
		ArrayList TempStorage1 = (ArrayList)Num.clone();
	
		for(int i=0;i<TempStorage1.size();i++)
		{
			for(int j=i+1;j<TempStorage1.size();j++)
			{
				if(TempStorage1.get(i).equals(TempStorage1.get(j))){
					TempStorage1.remove(j);
				}
			}
		}
		
		for(int i = 0 ; i<TempStorage1.size();i++){
			System.out.println(TempStorage1.get(i));
		}
		
		
	}

}
