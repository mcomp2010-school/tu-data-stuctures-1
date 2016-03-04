
package shared;

//==============================================================
//Program 5 – Hashing Implementation Program
//==============================================================
//Emanuel Rivera
//COSC 336-001
//11-22-2010
//--------------------------------------------------------------

public class Timing
{
      // starting and ending time measured in milliseconds
      private long startTime, stopTime;

		public Timing(){
         startTime = stopTime = 0;
      }

      public void start(){
         startTime = System.currentTimeMillis(); //current millisecond time on the system clock
      }

      public String stop(){
         stopTime = System.currentTimeMillis();
         double Current=(stopTime - startTime)/1000.0;
         return Min_Sec_ms(Current);
      }
      
      public Double stop_Double(){
          stopTime = System.currentTimeMillis();
          double Current=(stopTime - startTime)/1000.0;
          return Current;
      }
      
      
      public Double stop_dbl(){
          stopTime = System.currentTimeMillis();
        
          return (stopTime - startTime)/1000.0;
       }
      
      
      
  	
      public static String Min_Sec_ms(Double DblFull){
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
