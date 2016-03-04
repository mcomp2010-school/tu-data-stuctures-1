package classes;

import java.util.ArrayList;

public class Graph_matrix {
	
	static ArrayList<String> Heading = new ArrayList<String>();
	static Double[][] Matrixa= new Double[2][2];
	
	
	public static void main(String[] args) {
		Insert_Directional("a","b",6.0);
		printMatrix();
		
	}
	
	public static void Insert_Directional(String Source,String Destination,double Weight){
		if(Heading.size()==0){
			Heading.add(Source);
			Heading.add(Destination);
			Matrixa[0][1]=Weight;	
		}
	}
	
	public static void printMatrix(){
		for(int i=0;i<=Heading.size()-1;i++){
				System.out.print("\t"+Heading.get(i));
		}
		System.out.println();
		
		for(int row=0;row<=Matrixa.length-1;row++){
			System.out.print(Heading.get(row)+"\t");
			for(int column=0;column<=Matrixa.length-1;column++){
				System.out.print(Matrixa[row][column]+"\t");
			}
			System.out.println();
			
		}
	}
	
}
