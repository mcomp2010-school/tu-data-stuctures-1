package OptimizeSums;
import java.util.Queue;


public class valueref {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(sumr(10));
		System.out.println();

		// TODO Auto-generated method stub

	}

	public static int sumr(int n){
		if(n<=1)return 1;
		else{
			int num=sumr(n-1);
	        int suma=(n*n);
			System.out.println(n+","+(n*n)+","+suma+","+num);
			return num+=suma;	
		}
	
		
	}
	
	public static int fi(int n){
		if(n<=0)return 0;
		else if(n==1)return 1;
		else return n*fi(n-1);
	}
	
	public static int ref(int n){
		if(n<=0) return 0;
		else if(n==1)return 1;
		else{
			return n*ref(n-1);	
		}
	}
}
