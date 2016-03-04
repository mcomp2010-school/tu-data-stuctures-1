package classes;

//==============================================================
//Program 5 – Hashing Implementation Program
//==============================================================
//Emanuel Rivera
//COSC 336-001
//11-22-2010
//--------------------------------------------------------------

public class HashDato {
    private int clave;
    private String value;
	private boolean isLazyDel=false;
    
	//
	
	public boolean get_isLazyDel() {
		return isLazyDel;
	}

	public void set_isLazyDel(boolean isLazyDel) {
		this.isLazyDel = isLazyDel;
	}

    ///////////////////////////

	public HashDato() {
	    this.clave = -1;
	    //this.clave = 0;
        this.value = null; 
        this.isLazyDel=false;
	}
	
	
    public HashDato(int Clave, String Value) {
          this.clave = Clave;
          this.value = Value; 
          this.isLazyDel=false;
    }  
    
    public HashDato(int Clave, String Value,boolean IsNewA) {
    	this.clave = Clave;
    	this.value = Value; 
    	this.isLazyDel= IsNewA;
    }
    //////////////////////////

	public int getKey() {
          return clave;

    }

    public String getValue() {
          return value;

    }
}