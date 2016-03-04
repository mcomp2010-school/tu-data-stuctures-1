package OptimizeSums;

public class Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//O3toO2();
		int n=10;
		for(int i=0; i<n; i++)
			  for(int j=i; j<n; j++)System.out.println(i+","+j);

				  
	}
	
	public static void O3toO2(){
		int sum=0;
		int N=99;
		
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= N; j++){
				for (int k = 1; k <= N; k++){
					sum++;
				}	
			}
		}

		System.out.println("O(n^3) sum is "+sum);
		
		sum=0;
		
		
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= (N*N); j++){
					sum++;
			
			}
		}

		System.out.println("O(n^2) sum is "+sum);
		
		
	}

}
