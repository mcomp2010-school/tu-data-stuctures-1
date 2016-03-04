package array.tables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import array.tables.items.Vehicles_Item;


public class Vehicles_Table {
	static ArrayList<Vehicles_Item> Vehicles_ArrayList = new ArrayList<Vehicles_Item>();
	Vehicles_Item Vehicles_Item = new Vehicles_Item();

	public static void main(String[] args) {
	    try {
		InitializeFromCVC("cvs/Vehicle_table.csv");
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    
	    //DisplayTable();
	    DisplayVehicleTypes();
	}

	public static void Add_Vehicle(String typeVehicle, String description,
			String mileage, String num_Seats, String num_Bench_Seats,
			String vehicleID) {
		Vehicles_ArrayList.add(new Vehicles_Item(typeVehicle, description,
				mileage, num_Seats, num_Bench_Seats, vehicleID));

	}

	public void Delete_Vehicle(int Index) {
		Vehicles_ArrayList.remove(Index);
	}

	public void Clear_Vehicle() {
		Vehicles_ArrayList.clear();
	}

	public static void DisplayTable(){
	    for(int i =0 ; i<Vehicles_ArrayList.size();i++){
		Vehicles_Item a=(Vehicles_Item)Vehicles_ArrayList.get(i);
		System.out.println(a);
	    }
	}
	@Override
	public String toString() {
	    return "Vehicles_Table [Vehicles_Item=" + Vehicles_Item + "]";
	}

	public static void InitializeFromCVC(String inputFilePath) throws IOException{
		File file = new File(inputFilePath);
		BufferedReader bufRdr = new BufferedReader(new FileReader(file));
		String line = null;
		int linenum = 1;
		
		//read each line of text file
		
		while((line = bufRdr.readLine()) != null){
			StringTokenizer st = new StringTokenizer(line,",");
			while (st.hasMoreTokens()){
				//get next token and store it in the array
			    
				String Vehicles_Id=st.nextToken();
				String typeVehicle=st.nextToken();
				String description=st.nextToken();
				String mileage=st.nextToken();
				String num_Seats=st.nextToken();
				String num_Bench_Seats=st.nextToken();
				String vehicleID=st.nextToken();
				
				if(linenum==1){
				    //skip header    
				}
				else{
				    Add_Vehicle(typeVehicle.replaceAll("\"", ""),description.replaceAll("\"", ""),mileage.replaceAll("\"", ""),
					    num_Seats.replaceAll("\"", ""),num_Bench_Seats.replaceAll("\"", ""),vehicleID.replaceAll("\"", ""));
				}
				    
				
				//System.out.println();
				
			}
		linenum++;
		}
		//close the file
		bufRdr.close();
	}
	//==================================
	//Unique
	//==================================
	public static void DisplayVehicleTypes(){
		ArrayList TempStorage1 = (ArrayList)Vehicles_ArrayList.clone();
		//Vehicles_Item Vehicles_Item = new Vehicles_Item();
		
		for(int i=0;i<TempStorage1.size();i++)
		{
			for(int j=i+1;j<TempStorage1.size();j++)
			{
			    Vehicles_Item a=(Vehicles_Item)TempStorage1.get(i);
			    Vehicles_Item b=(Vehicles_Item)TempStorage1.get(j);
			    
			    	if(a.getTypeVehicle().equalsIgnoreCase(b.getTypeVehicle())){
			    	    TempStorage1.remove(j);
			    	    i=0;
			    	    j=0;
			    	}
				
			}
		}
		
		for(int i = 0 ; i<TempStorage1.size();i++){
		    Vehicles_Item a=(Vehicles_Item)TempStorage1.get(i);
			System.out.println((i+1)+")"+a.getTypeVehicle());
		}
	}
}
