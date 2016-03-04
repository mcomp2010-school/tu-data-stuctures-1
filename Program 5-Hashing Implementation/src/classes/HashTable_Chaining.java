package classes;

//==============================================================
//Program 5 – Hashing Implementation Program
//==============================================================
//Emanuel Rivera
//COSC 336-001
//11-22-2010
//--------------------------------------------------------------

import java.util.ArrayList;

public class HashTable_Chaining {
	//*****************************************************************
	//Global Vars******************************************************
	//*****************************************************************
	private static int TABLE_SIZE = 100;
	static ArrayList<ArrayList<HashDato>> table = new ArrayList<ArrayList<HashDato>>();
	
	//*****************************************************************
	//*****************************************************************
	
    public HashTable_Chaining() {//Constructor
    	for(int i = 0;i<=TABLE_SIZE-1;i++){
    		table.add(new ArrayList<HashDato>());    		
    	}
    }//End Constructor
    
    public HashTable_Chaining(int Sizea) {//Constructor
    	for(int i = 0;i<=Sizea-1;i++){
    		table.add(new ArrayList<HashDato>());    		
    	}
    	
    	TABLE_SIZE=Sizea;
    }//End Constructor
        
    private static String PrintFormatItem(int key,int i){
    	String Output="";
    
    	if(i==0){
    		Output=""+key+"-("+table.get(key).get(i).getKey()+","+table.get(key).get(i).getValue()+")";
    	}else{
    		Output="("+table.get(key).get(i).getKey()+","+table.get(key).get(i).getValue()+")";
    	}
    	
    	if(i<table.get(key).size()-1){
    		Output+="-->";
    	}
    	
    	//
    	if(table.get(key).get(i).getValue()==null){
    		Output=""+key+"-(empty)";	
    	}

		return Output;
    }
    
	public String ShowTable(){
        String Output1="**************\n*Hash Table-Chaining*\n";
        Output1+="Index-(Key,Value)\n";
		
        for (int i = 0; i <= table.size() - 1; i++) {
			//
        	if(table.get(i).size()==0){
        		Output1+=""+i+"-(empty)";
        		
        	}
        	
        	for(int ch=0;ch<= table.get(i).size()-1;ch++){
        		Output1+=PrintFormatItem(i,ch);
   
        	}
			
        	if(i < table.size()-1){
    			Output1+="\n";
    		}
        	
			//
		}//end for loop
		
        Output1+="\n**************";
        
		return Output1;
	}//end ShowTable
	

	public int HashFunc(int key){
		return (key % TABLE_SIZE);
	}
	
	//*****************************************************************
	//Insert,Find,Delete***********************************************
	//*****************************************************************
	
    
    public void insert(int key, String value) {
    	int hash = HashFunc(key);
   
    	if(find(key)==null){//Make Sure has Unique Keys
    		table.get(hash).add(new HashDato(key,value)); 
    	}else{
    		table.get(hash).set(findIndex(key),new HashDato(key,value));
    	}
    }
    
    public String find(int key) {
    	int hash = HashFunc(key);
    	String BlString=null;
    	
    	for(int i=0;i<=table.get(hash).size()-1;i++){
    		if(table.get(hash).get(i).getKey()==key){
    			BlString=table.get(hash).get(i).getValue();
    		}
    	}

		return BlString;  
  }
    
  public int findIndex(int key) {
    	int hash = HashFunc(key);
    	int blindex=-1;
    	
    	for(int i=0;i<=table.get(hash).size()-1;i++){
    		if(table.get(hash).get(i).getKey()==key){
    			blindex=i;
    		}
    	}

		return blindex;  
  }
    
  public boolean delete(int key) {
	  	int hash = HashFunc(key);
	  	
	  	
	  	if(find(key)==null){//Make Sure has Unique Keys
    		return false;
    	}else{
    		table.get(hash).remove(findIndex(key));
    		return true;
    	}
	  	
	  	
		
  }


}
