package checksum;

public class EncrytionWay3newer {

	public static void main(String[] args) {
		//System.out.println(Format2charInto6Ascii("test"));
		//System.out.println(Format6AsciiInto2char("0116010101150116"));
		String In="Manny";
			   //In="2124";
		String Encode = Encode(In,"passa");

		
		//System.out.println("*****************");
		System.out.println("-"+(Encode));
		//System.out.println("-"+encode("Example 11","pass1"));
		
		//String Decode= Decode(Encode,"pass1");
		
		//System.out.println("-"+(Decode));
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////

	private static String Encode(String Input, String Password) {
		String Level1Encoded="";
		String Level2Encoded="";
		String Level3Encoded="";
		String Level4Encoded="";
		
		//*********************
		//Convert to Ascii
		Level1Encoded=Format2charInto6Ascii(Input);
		//System.out.println(Level1Encoded);
		//END Convert to Ascii
		//*********************
		
		//*********************
		//Pass1
		//*********************
		String Previous="*";
		String Current="";
		int curSum=0;
		
		int InputHashValue=PassHash(Input+Password+"size="+Input.length());
		
		for (int i=0; i < Level1Encoded.length(); i=i+4) {
			    Current=Level1Encoded.substring(i,i+4);
			    curSum+=(PassHash(Password+"-"+Previous+"-"+InputHashValue))%1000000000;
			    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			    int intCurrent=Integer.parseInt(Current)+PassHash(curSum+"*");
	
			    Level2Encoded+=formatStrDigit(intCurrent+"",4);
			    /////////////////////
			    Previous=Current;
		}
		//End pass1
		//******************		
		
		//Convert into HEX
		Level3Encoded=Level2Encoded;
		
		Current="";
		
		for (int i=0; i < Level3Encoded.length(); i=i+4) {
		    Current=Level3Encoded.substring(i,i+4);
		    //System.out.println(Current);
		    
		    int intCurrent=Integer.parseInt(Current);
		    //System.out.println(formatStrDigit(intCurrent+"",4));
			
			String Encoding = formatStrDigit(Integer.toHexString(intCurrent),3);
			//System.out.println(Encoding);
			
		    Level4Encoded+=Encoding+"";
		  
		}
		//End Convert To HEx
		//******************
		return Level4Encoded;
	}
	
	
	//////////////////////////////////////////////////////////////////////////
	//************************************************************************
	//////////////////////////////////////////////////////////////////////////
	private static String Decode(String Input, String Password) {
		String Level1Encoded=Input;
		String Level2Encoded="";
		String Level3Encoded="";
		String Level4Encoded="";

		//Convert into HEX
		
		String Current="";
		
		for (int i=0; i < Level1Encoded.length(); i=i+3) {
		    Current=Level1Encoded.substring(i,i+3);
		    //System.out.println(Current);
		    int intCurrent=Integer.parseInt(Current,16);
		    //System.out.println(formatStrDigit(intCurrent+"",4));
			String Encoding = formatStrDigit(intCurrent+"",4);
			//System.out.println(Encoding);
		    Level2Encoded+=Encoding+"";
		  
		}
		//End Convert To HEx
		//******************
		
		
		//*********************
		//Pass1
		//*********************
		
		
		String Previous="*";
		Current="";
		int curSum=0;
		
		for (int i=0; i < Level2Encoded.length(); i=i+4) {
			    Current=Level2Encoded.substring(i,i+4);
			   
			    //System.out.println(Current+"-");
			    curSum+=(PassHash(Password+"-"+Previous+"-"+i))%1000000000;
			    //curSum+=(PassHash(Password+"-"+"-"+i))%1000000000;
			    //System.out.println(curSum+"++");
			    
			    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			    //int intCurrent=Integer.parseInt(Current)-PassHash(curSum+"");
			    int intCurrent=Integer.parseInt(Current)-PassHash(curSum+"");
			    
			    //System.out.println(Password+"-"+Current+"-"+Previous+"-"+i+"="+(PassHash(Password+"-"+Previous+"-"+i))%1000000000);
			    //System.out.println(formatStrDigit(intCurrent+"",4)+"");
			    Level3Encoded+=formatStrDigit(intCurrent+"",4);
			    /////////////////////
			    Previous=intCurrent+"";
		}
		
		
		//End pass1
		//******************
		
		//System.out.println(Level3Encoded);
		//*********************
		//Convert to Ascii
		//Level4Encoded=Format6AsciiInto2char(Level3Encoded);
		//System.out.println(Level1Encoded);
		//END Convert to Ascii
		//*********************
		return Level4Encoded;
	}
	
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	static int StrHash(String Input){
		int hash=7;
		for (int i=0; i < Input.length(); i++) {
		    hash = (hash)+(Input.charAt(i)*31);
		}
		return Math.abs(hash)%1000000;
	}
	
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	
	private static int PassHash(String Input) {
		int hash = 7;
		for (int i = 0; i < Input.length(); i++) {
			hash = hash * 31 + Input.charAt(i);
		}
		return (Math.abs(hash) % 1645) + 255;
	}
	
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	
	public static String Format6AsciiInto2char(String Input){
		String Output="";

		for (int i=0; i < Input.length(); i=i+4) {

		    int Decoding=Integer.parseInt(Input.substring(i, i + 4));
		    System.out.println(Decoding);
			char c = (char) (Decoding);
			String Oa = c + "";
			
		    Output+=Oa;

		}
		
		return Output;
	}
	
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	
	public static String Format2charInto6Ascii(String Input){
		String Current="";
		String Output="";
		
		int curdivpos=0;
		
		int i=0;
		for (i=0; i < Input.length(); i++) {
		   curdivpos++;
			   
		    Current=Input.substring(i,i+1);
		    
		    char c = Current.charAt(0);
			int j = (int) c;
			
		    Output+=formatStrDigit(j+"",4);
		    
		    if(curdivpos==2&&i!=Input.length()-1){
		    	curdivpos=0;
		    	Output+="";
		    }
		    
		}
		
		if((i%2)!=0){
			Output+="0031";
		}
		
		return Output;
	}
	public static String formatStrDigit(String Input, int Length) {
		String Output = "";
		//Length++;

		while (Output.length() + Input.length() + 1 <= Length) {
			Output += "0";
		}

		Output += Input;
		return Output;
	}

}
