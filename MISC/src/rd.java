import java.io.*;
import java.util.Scanner;
import java.util.Stack;
	
public final class rd {
	  static String[][] MainTable =new String[20][20];
	  static Stack<String> MainStack=new Stack<String>();
	  
	  
	public static void main(String[] args) throws IOException {
		processLineByLine();
		System.out.println("TableBEF");
		PrintTable();
		Controller(1,3);
		System.out.println("TableAFT");
		PrintTable();
	}
	  
	  public static void Controller(int y,int x){
		  MainStack.push("("+y+","+x+")");
		  int cou=0;
		  boolean p=true;
		  
		  while(!MainStack.isEmpty()){
			  
			  cou++;
			  if(cou>=1000000){
				  break;
			  }
			 

			if(((x-1) >= 0)){//Moving Left
					if(MainTable[y][x-1].equalsIgnoreCase("0")){
						//System.out.println("Moving Left");
						MainTable[y][x]="*";//*********
						x--;
					}
					else if(MainTable[y][x-1].equalsIgnoreCase("*")){
						MainTable[y][x]="3";//*********
						x++;;
					}
					else if(MainTable[y][x-1].equalsIgnoreCase("E")){
						System.out.println("I am Free");
						MainTable[y][x]="2";
						break;
					}
				}
				
			  
				if (((x+1) <= (MainTable[0].length - 1))){//Moving Right
					
					if(MainTable[y][x+1].equalsIgnoreCase("0")){
						//System.out.println("Moving Right");
						MainTable[y][x]="*";//*********
						x++;
					}
					else if(MainTable[y][x+1].equalsIgnoreCase("*")){
						MainTable[y][x]="3";//*********
						x--;
					}
					else if(MainTable[y][x+1].equalsIgnoreCase("E")){
						System.out.println("I am Free");
						MainTable[y][x]="2";
						break;
					}
				}
				if(((y+1) <= (MainTable.length - 1))){//Moving Down
					
					if(MainTable[y+1][x].equalsIgnoreCase("0")){
						//System.out.println("Moving Down");
						MainTable[y][x]="*";//*********
						y++;
					}
					else if(MainTable[y+1][x].equalsIgnoreCase("*")){
						MainTable[y][x]="3";//*********
						y--;
					}
					else if(MainTable[y+1][x].equalsIgnoreCase("E")){
						System.out.println("I am Free");
						MainTable[y][x]="2";
						break;
					}
				}

				if((y-1) >= 0){//Moving Up
					
					if(MainTable[y-1][x].equalsIgnoreCase("0")){
						//System.out.println("Moving Up");
						MainTable[y][x]="*";//*********
						y--;
					}
					else if(MainTable[y-1][x].equalsIgnoreCase("*")){
					    MainTable[y][x]="3";//*********
						y++;
					}
					else if(MainTable[y-1][x].equalsIgnoreCase("E")){
						System.out.println("I am Free");
						MainTable[y][x]="2";
						break;
					}
				}
				
				
		  }
	  }

	  public static void PrintTable(){
		  for(int i=0;i<=19;i++){
			  for(int j=0;j<=19;j++){
				System.out.print(MainTable[i][j]);
			  }
			  System.out.println();
		  }
			  
		
	  }
	  
	  public static void processLineByLine() throws FileNotFoundException {
		File parser = new File("maze.txt");
		Scanner scanner = new Scanner(parser);
	    Integer y=0;
	    Integer x=0;
	    try {
	      while ( scanner.hasNextLine() ){
	        String str = scanner.nextLine();
	        char[] ch = str.toCharArray();
	        for (char c : ch){
	        	String L=Character.toString(c);
	        	//System.out.print(L+"-"+y+","+x+"\t");
	        	MainTable[y][x]=L;
	        	x++;
	        }
	        x=0;
	        //System.out.println();//line
	        y++;
	      }
	    }
	    finally {
	      scanner.close();
	    }
	  }
	  
	


}
