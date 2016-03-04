//==============================================================
// Program 3 – Balanced BST Implementation Program
//==============================================================
// Emanuel Rivera
// Cosc 336-101
// 10/25/2010
//--------------------------------------------------------------
//CLASS:ALQueue.java
//--------------------------------------------------------------
package tree;

import java.util.ArrayList;

public class ALQueue<T>{
	ArrayList<T> ArrayBase = new ArrayList<T>();
	public ALQueue() {
	
	}

	public T Dequeue(){
		T StrItem=null;
			
		if(ArrayBase.size()-1>=0){
			StrItem=ArrayBase.get(0);
			ArrayBase.remove(0);
			
		}
	
		return StrItem;
	}

	public void Enqueue(T StrItem){
		ArrayBase.add(StrItem);
	}
	
	public boolean isEmpty(){
		if(ArrayBase.size()-1>=0){
			return false;
		}else return true;
		
		
	}
	
	public boolean isLast(){
		if(ArrayBase.size()<=0){
			return true;
		}else return false;
	}
	
	public boolean isPreLast(){
		if(ArrayBase.size()==1){
			return true;
		}else return false;
	}
	
	public T Peek(){
		T StrItem=null;
			
		if(ArrayBase.size()-1>=0){
			StrItem=ArrayBase.get(0);
		}
	
		return StrItem;
	}
	
	public int Size(){
		return ArrayBase.size();
	}
}
