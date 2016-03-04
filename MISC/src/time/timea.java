package time;

public class timea {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Min_Sec_ms(Min_SecToSec("1:30")));

	}

	
	
	
	static Double Min_SecToSec(String input){
	  	String StrDbl=input.toString();
      	Double min=Double.parseDouble(StrDbl.substring(0, StrDbl.indexOf(":")));
      	Double Seconds=Double.parseDouble(StrDbl.substring(StrDbl.indexOf(":")+1, StrDbl.length()));
		return  (min*60)+Seconds;
	}
	
    static String Min_Sec_ms(Double DblFull){
      	String StrDbl=DblFull.toString();
      	String Seconds=StrDbl.substring(0, StrDbl.indexOf("."));
      	
      	String msSeconds=StrDbl.substring(StrDbl.indexOf(".")+1, StrDbl.length());
      	
      	Integer intseconds = Integer.parseInt(Seconds) % 60;
      	int intminutes = Integer.parseInt(Seconds) / 60;

      	String FinSecond=intseconds.toString();
      	if(FinSecond.equalsIgnoreCase("0")){
      		FinSecond="00";
      	}else if(FinSecond.length()==1){
      		FinSecond="0"+FinSecond;
      	}
      	String output=intminutes+":"+FinSecond+"."+msSeconds;
      	//System.out.println(output);
      	return output;
      }
}
