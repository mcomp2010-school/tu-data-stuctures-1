package classes;

//==============================================================
//Program 5 – Hashing Implementation Program
//==============================================================
//Emanuel Rivera
//COSC 336-001
//11-22-2010
//--------------------------------------------------------------

import java.util.ArrayList;

public class HashTable_Linear {
	//*****************************************************************
	//Global Vars******************************************************
	//*****************************************************************
	private static int TABLE_SIZE = 100;
	static ArrayList<HashDato> table = new ArrayList<HashDato>();
	static int SizeCap=1;
	
	//*****************************************************************
	//*****************************************************************
	
    public HashTable_Linear() {//Constructor
    	for(int i = 1;i<=TABLE_SIZE;i++){
    		table.add(new HashDato());
    	}
    }//End Constructor
    
    public HashTable_Linear(int Sizea) {//Constructor
    	for(int i = 0;i<=Sizea-1;i++){
    		table.add(new HashDato());   		
    	}
    	TABLE_SIZE=Sizea;
    }//End Constructor
    
    
    private static String PrintFormatItem(int i){
    	String Output=""+i+"-("+table.get(i).getKey()+","+table.get(i).getValue()+")-"+table.get(i).get_isLazyDel();
    		if(table.get(i).getValue()==null){
    			Output=""+i+"-(empty)-"+table.get(i).get_isLazyDel();	
    		}
    	if(i < table.size()-1){
			Output+="\n";
		}
		return Output;
    }
    
	public String ShowTable(){
        String Output1="**************\n*Hash Table-Linear*\n";
        Output1+="Index-(Key,Value)-Lazy Delete\n";
		
        for (int i = 0; i <= table.size() - 1; i++) {
			//
				Output1+=PrintFormatItem(i);
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
    	if(SizeCap<=TABLE_SIZE){//make sure that it is not filled
    		
    		int hash = HashFunc(key);
            while (table.get(hash).getValue() != null && table.get(hash).getKey() != key){
          	  hash = HashFunc(hash + 1);
          	        
            }
            
            table.set(hash,new HashDato(key, value));
            SizeCap++;
    	}//SizeCAP

    }
    
    public String find(int key) {
    	int hash = HashFunc(key);

        while (table.get(hash).getValue() != null && table.get(hash).getKey() != key||table.get(hash).get_isLazyDel()==true){
      	  hash = HashFunc(hash + 1);
        }
              
        if (table.get(hash).getValue() == null){
      	  return "null";
        }   
        else{
      	  return table.get(hash).getValue();
        }
  }
    
  public boolean delete(int key) {
	  	int hash = HashFunc(key);

        while (table.get(hash).getValue() != null && table.get(hash).getKey() != key||table.get(hash).get_isLazyDel()==true){
      	  hash = HashFunc(hash + 1);
        }
              
        if (table.get(hash).getValue() == null){
      	  return false;
        }   
        else{
        	
        	table.set(hash, new HashDato(-1,null,true));
        	
      	  return true;
        }
  }


}
