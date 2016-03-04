//==============================================================
//PROGRAM 6 – Greedy and Dynamic Programming
//==============================================================
//Emanuel Rivera
//COSC 336-101
//December 1 2010
//==============================================================
package classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Brute_AL {

	private static ArrayList<ArrayList<String>> BruteC=new ArrayList<ArrayList<String>>();


	public ArrayList<ArrayList<String>> GetIndexes(int inSize){
		BruteC.clear();
		GenerateIndexes(St1_Size(inSize));
		
		return BruteC;
	}
	
	public int Get1ndLevelSize(){
		return BruteC.size();
	}
	
	public int Get2ndLevelSize(int inpIndex){
		return BruteC.get(inpIndex).size();
	}
	
	public int Get2ndLevelItem(int inpIndex,int inbInd){
		return Integer.parseInt(BruteC.get(inpIndex).get(inbInd));
	}
	
	

	  @SuppressWarnings({ "rawtypes", "unchecked" })
	private void removeDuplicate(ArrayList<ArrayList<String>> arlList)
	  {
	   Set set = new HashSet();
		 List newList = new ArrayList();
		 for (Iterator iter = arlList.iterator();    iter.hasNext(); ) {
		 Object element = iter.next();
		   if (set.add(element))
		      newList.add(element);
		    }
		 arlList.clear();
		 arlList.addAll(newList);
		 
	  }
	  

	private ArrayList<String> St1_Size(int inputa){
		ArrayList<String> Current= new ArrayList<String>();
		for(int i=0;i<=inputa-1;i++){
			Current.add(i+"");
		}
		return Current;
	}


    private String PrintFormatItem(int key,int i){
    	String Output="";
    
    	if(i==0){
    		Output=""+(key+1)+"-"+BruteC.get(key).get(i)+"";
    	}else{
    		Output=""+BruteC.get(key).get(i)+"";
    	}
    	
    	if(i<BruteC.get(key).size()-1){
    		Output+=",";
    	}
    	
    	//

		return Output;
    }
    
	public String ShowTable(){
        String Output1="**************\n";
		
        for (int i = 0; i <= BruteC.size() - 1; i++) {
			//        	
        	for(int ch=0;ch<= BruteC.get(i).size()-1;ch++){
        		Output1+=PrintFormatItem(i,ch);
        		
        	}
			
        	if(i < BruteC.size()-1){
    			Output1+="\n";
    		}
        	
			//
		}//end for loop
        Output1+="\n**************";
		return Output1;
	}//end ShowTable
	
	///////////////////////////////////////////////////////////
	private void GenerateIndexes(ArrayList<String> Inputa) {
		for (int j = 0; j <= Inputa.size() - 1; j++) {
			nextString(Inputa.get(j).toString(), Inputa);
		}
		removeDuplicate(BruteC);
	}
	
	
	  @SuppressWarnings({ "rawtypes", "unchecked" })
	private ArrayList<String> Items(String Inputa){
		ArrayList<String> Current= new ArrayList<String>();
		
		for (int i = 0; i < Inputa.length(); i += 1) {
				 Current.add(Inputa.substring(i, i+1));
		}
	
		Set set = new HashSet();
		 List newList = new ArrayList();
		 for (Iterator iter = Current.iterator();    iter.hasNext(); ) {
		 Object element = iter.next();
		   if (set.add(element))
		      newList.add(element);
		    }
		 Current.clear();
		 Current.addAll(newList);

		return Current;
	}
	
	
	private void nextString(String s, ArrayList<String> Inputb) {
		
		BruteC.add(Items(s));
		
		
		//System.out.println(FirstIndex+"-"+s);

		for (int i = 0; i <= Inputb.size() - 1; i++) {
			
			BruteC.add(Items(s + Inputb.get(i).toString()));
			
			//System.out.println(FirstIndex+"-"+s + Inputb.get(i).toString());

			if ((s + Inputb.get(i).toString()).length() <= Inputb.size() - 1){
					nextString(s + Inputb.get(i).toString(), Inputb);
				

			}
		}

	}
}