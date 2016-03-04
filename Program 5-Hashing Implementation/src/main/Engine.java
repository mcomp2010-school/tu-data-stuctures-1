package main;

//==============================================================
//Program 5 – Hashing Implementation Program
//==============================================================
//Emanuel Rivera
//COSC 336-001
//11-22-2010
//--------------------------------------------------------------

import java.util.ArrayList;

import classes.HashTable_Chaining;
import classes.HashTable_Linear;
import classes.HashTable_Quadratic;
import shared.IntGen;
import shared.Timing;

public class Engine {

	public static void main(String[] args) {
		//********************************************************
		double Time_Total_Quadratic_Insert=0;
		double Time_Total_Quadratic_Find=0;
		double Time_Total_Quadratic_Delete=0;
		
		double Time_Average_Quadratic_Insert=0;
		double Time_Average_Quadratic_Find=0;
		double Time_Average_Quadratic_Delete=0;
		
		//////////////
		
		double Time_Total_Chaining_Insert=0;
		double Time_Total_Chaining_Find=0;
		double Time_Total_Chaining_Delete=0;
		
		double Time_Average_Chaining_Insert=0;
		double Time_Average_Chaining_Find=0;
		double Time_Average_Chaining_Delete=0;
		
		//********************************************************
		
		//HashTable_Linear HashTable_Linear1=new HashTable_Linear();//Linear
		HashTable_Quadratic HashTable_Quadratic1= new HashTable_Quadratic();
		HashTable_Chaining HashTable_Chaining1=new HashTable_Chaining();
		//////////////////////////////
		Timing GetTime = new Timing();
		//********************************************************
		ArrayList<Integer> RandomSet= IntGen.Unique_RandomNum_ArrayL(0, 1000, 20);;
	
		for(int i = 0 ; i<=RandomSet.size()-1;i++){
			//HashTable_Linear1.insert(RandomSet.get(i), "v="+RandomSet.get(i)+"");
			
			GetTime.start();//TIME
			HashTable_Quadratic1.insert(RandomSet.get(i), "v="+RandomSet.get(i)+"");
			Time_Total_Quadratic_Insert+=GetTime.stop_Double();//TIME
			
			
			GetTime.start();//TIME
			HashTable_Chaining1.insert(RandomSet.get(i), "v="+RandomSet.get(i)+"");
			Time_Total_Chaining_Insert+=GetTime.stop_Double();//TIME
		}
		
		//********************************************************
		//********************************************************
		//Show tables before operations
		System.out.println(HashTable_Quadratic1.ShowTable());
		System.out.println(HashTable_Chaining1.ShowTable());
		
		
		
		
		//********************************************************
		//********************************************************
		//During operations
		//System.out.println(IntGen.PickRandomKey(RandomSet));
		System.out.println("*********************************");
		
		for(int i_Quad_Find=1;i_Quad_Find<=10;i_Quad_Find++){
			GetTime.start();//TIME
			HashTable_Quadratic1.find(IntGen.PickRandomKey(RandomSet));
			Time_Total_Quadratic_Find+=GetTime.stop_Double();//TIME
			
			GetTime.start();//TIME
			HashTable_Chaining1.find(IntGen.PickRandomKey(RandomSet));
			Time_Total_Chaining_Find+=GetTime.stop_Double();//TIME
			
		}

		

		
		//********************************************************
		//Delete
		
		
		for(int i_Quad_DEL=1;i_Quad_DEL<=10;i_Quad_DEL++){
			GetTime.start();//TIME
			HashTable_Quadratic1.delete(IntGen.PickRandomKey(RandomSet));
			Time_Total_Quadratic_Delete+=GetTime.stop_Double();//TIME
			
			GetTime.start();//TIME
			HashTable_Chaining1.delete(IntGen.PickRandomKey(RandomSet));
			Time_Total_Chaining_Delete+=GetTime.stop_Double();//TIME
		}
		
	
		//********************************************************
		//********************************************************
		//Show tables After operations
		System.out.println(HashTable_Quadratic1.ShowTable());
		System.out.println(HashTable_Chaining1.ShowTable());
		
		System.out.println("*********************************");
		
		//********************************************************
		Time_Average_Quadratic_Insert=Time_Total_Quadratic_Insert/RandomSet.size();
		Time_Average_Chaining_Insert=Time_Total_Chaining_Insert/RandomSet.size();
		///////////////////////
		System.out.println("Average Time it took to insert 1 item in Quadratic Probling out of 20="+Time_Average_Quadratic_Insert);
		System.out.println("Average Time it took to insert 1 item in Chaining Probling out of 20 ="+Time_Average_Chaining_Insert);
		
		Time_Average_Quadratic_Find=Time_Total_Quadratic_Find/10;
		Time_Average_Chaining_Find=Time_Total_Chaining_Find/10;
		///////////////////////
		System.out.println("Average Time it took to find 1 Random number from the table in Quadratic Probling out of 10="+Time_Average_Quadratic_Find);
		System.out.println("Average Time it took to find 1 Random number from the table in Chaining Probling out of 10="+Time_Average_Chaining_Find);
		Time_Average_Quadratic_Delete=Time_Total_Quadratic_Delete/10;
		Time_Average_Chaining_Delete=Time_Total_Chaining_Delete/10;
		///////////////////////
		System.out.println("Average Time it took to delete 1 Random number from the table in Quadratic Probling out of 10="+Time_Average_Quadratic_Delete);
		System.out.println("Average Time it took to delete 1 Random number from the table in Chaining Probling out of 10="+Time_Average_Chaining_Delete);
	}
	
	

}
