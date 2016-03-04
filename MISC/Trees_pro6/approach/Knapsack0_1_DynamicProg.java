//==============================================================
//PROGRAM 6 – Greedy and Dynamic Programming
//==============================================================
//Emanuel Rivera
//COSC 336-101
//December 1 2010
//==============================================================
package approach;

//import java.util.ArrayList;

public class Knapsack0_1_DynamicProg {

	public static void main(String[] args) {
		//System.out.println(max(3,8));
		//System.out.println(V.length);
		//System.out.println();
		System.out.println(KS(10,5));
	}
	
	
	
	static int n = 5;
	static int V[]={7,2,1,6,12};
	static int W[]={3,1,2,4,6};
	
	public static int KS(int C,int i){
		if (i>n) return 0;
		else if (C<W[i]){
			return KS(C,i+1);
		}
		else{
			
			if(maxBL(KS(C,i+1),V[i]+KS(C-W[i],i+1))==true){
				return KS(C,i+1);
			}else{
				return V[i]+KS(C-W[i],i+1);
			}
		}
	
	}
	
	
	public static int max(int one,int two){
		if(one>two){
			return one;
		}else if(two>one){
			return two;
		}
		else return(one);
	}
	
	public static boolean maxBL(int one,int two){
		if(one>two){
			return true;
		}else if(two>one){
			return false;
		}
		else return(true);
	}
}
