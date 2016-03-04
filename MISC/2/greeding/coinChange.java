package greeding;

import java.util.ArrayList;

class Coin{
	
}

public class coinChange {

	public static void main(String[] args) {
		MakeChangeint(1.68);
		
	}
	
	static void MakeChange(Double Input){
		Double currentsum=Input;
		
		while(currentsum>=0.01){
			
			if(currentsum>=1){
				currentsum-=1.00;
				System.out.println("1.00 Coin");
				
			}else if(currentsum>=0.25){
				currentsum-=0.25;
				System.out.println("0.25 Coin");
				
			}else if(currentsum>=0.10){
				currentsum-=0.10;
				System.out.println("0.10 Coin");
				
			}else if(currentsum>=0.05){
				currentsum-=0.05;
				System.out.println("0.05 Coin");
				
			}else if(currentsum>=0.01){
				currentsum-=0.01;
				System.out.println("0.01 Coin");
			}
			
			System.out.println("{"+currentsum);
		}
		
		
	}
	
	static String RDec(int in){
		return ((double)(in)/100)+" coin";
		
	}
	static void MakeChangeint(Double Input){	
		ArrayList<Integer> Deno= new ArrayList<Integer>();

		Deno.add(100);
		Deno.add(25);
		Deno.add(10);
		Deno.add(5);
		Deno.add(1);
		/////////////////
		int currentsum=(int) (Input*100);
		
		while(currentsum>=1){
			for(int i=0;i<=Deno.size()-1;i++){
				if(currentsum>=Deno.get(i)){
					currentsum-=Deno.get(i);
					System.out.println(RDec(Deno.get(i)));
					break;
				}
			}//for
		}//while	
			
	}//sub
	
	
	
	

}
