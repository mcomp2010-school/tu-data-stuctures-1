package mid;

import java.util.ArrayList;

public class mid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> InOrder= new ArrayList<Integer>();
		
		InOrder.add(1);
		InOrder.add(2);
		InOrder.add(3);
		InOrder.add(4);
		InOrder.add(5);
		
		System.out.println(FindMid(1,9));
		
		System.out.println(InsertOrder(1,15).toString());
	}

	public static ArrayList<Integer> InsertOrder(int MIN,int MAX){
		ArrayList<Integer> temp=new ArrayList<Integer>();
		ALQueue<Integer> Queue=new ALQueue<Integer>();
		
		Queue.Enqueue(FindMid(MIN,MAX));
		
		int x=0;
		
		while(!Queue.isEmpty()&&x<=15){
			x++;
			int curmid=Queue.Peek();
				
			temp.add(Queue.Dequeue());
			
			
			
			int mostleft;
			
			//LEFT
			//if(MIN<FindMid(MIN,curmid-1)){
				Queue.Enqueue(FindMid(MIN,curmid-1));
				System.out.println(FindMid(MIN,curmid-1));
			//}
			
			
			//RIGHT
			//if(MAX>FindMid(curmid+1,MAX)){
				Queue.Enqueue(FindMid(curmid+1,MAX));
				System.out.println(FindMid(curmid+1,MAX));	
			//}
				
			System.out.println(Queue.toString());
		
		}
		
		
		return temp;
	}
	
	public static int FindMid(double min, double max){
		double mid;
		
		if(min==max){
			mid=min;
		}
		
			
		
		else{
			mid=(min+max)/2;
			mid=Math.round(mid);
			
			if(mid%2!=0){
				mid=mid+1.0;
			}	
		}
		
		return (int)mid;
	}
}
