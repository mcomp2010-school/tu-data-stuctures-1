package sql.main;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import shared.Formatting;

//==============================================================
//Program 1 – Vehicle Rental Agency Program
//==============================================================
//Emanuel Rivera
//COSC 336-101
//September 22,2010
//--------------------------------------------------------------

class Car {
    String Description = null;
    String Mileage = null;
    String NumSeats = null;
    String NumBenchSeats = null;
    String VIN = null;

    public Car(String description, String mileage, String numSeats,
	    String numBenchSeats, String vIN) {
	Description = description;
	Mileage = mileage;
	NumSeats = numSeats;
	NumBenchSeats = numBenchSeats;
	VIN = vIN;
    }

    public Car(String vIN) {
	Description = null;
	Mileage = null;
	NumSeats = null;
	NumBenchSeats = null;
	VIN = vIN;
    }

    public String getVIN() {
	return VIN;
    }

    public void setVIN(String vIN) {
	VIN = vIN;
    }

    @Override
    public String toString() {
	return "Description=" + Description + ", Mileage=" + Mileage
		+ ", NumSeats=" + NumSeats + ", NumBenchSeats=" + NumBenchSeats
		+ ", VIN=" + VIN + "";
    }

}

public class available_Vehicles {
    static ArrayList<Car> AllVehicle = new ArrayList<Car>();
    static ArrayList<Car> ExcludeVehicle = new ArrayList<Car>();
    static Formatting TFor = new Formatting();

    public static void main(String[] args) {
	// AllVehicle.add(new Car("Honda Civic S","29 mgp","n/a","n/a","A01"));
	// AllVehicle.add(new Car("Honda Civic LE","29 mgp","n/a","n/a","D02"));
	// AllVehicle.add(new
	// Car("Honda Civic XLE","29 mgp","n/a","n/a","A06"));
	// AllVehicle.add(new
	// Car("Honda Civic Grand","29 mgp","n/a","n/a","G45"));
	// AllVehicle.add(new Car("Honda Accent","29 mgp","n/a","n/a","Z04"));
	// ExcludeVehicle.add(new Car("A06"));
	// ExcludeVehicle.add(new Car("Z04"));
	// GetAvailableVehicles();
	// System.out.println(TFor.ConvertDatetoSqlDate("12/5/10"));
	// Init(TFor.ConvertDatetoSqlDate("09/20/10"),TFor.ConvertDatetoSqlDate("09/30/10"),"car");
	// GetAvailableVehicles();
	// MakeReservation("time","time","time","time","time");
	// GetReservationbyVIN("rivera","GF1TG6");
	DeleteReservation("5");
    }

    public static void Init(String In_PickupDate, String In_ReturnDate,
	    String In_TypeVehicle) {
	/*
	 * SELECT VehicleID,Description,Mileage,Num_Seats FROM
	 * Reservation,Vehicles WHERE (Date_Pickup BETWEEN '2010-09-20' AND
	 * '2010-09-30' OR Date_Return BETWEEN '2010-09-20' AND '2010-09-30')
	 * AND (VehicleID == res_Vehicle_ID) AND (TypeVehicle like 'car')
	 * 
	 * SELECT VehicleID,Description,Mileage,Num_Seats FROM Vehicles WHERE
	 * (TypeVehicle like 'car')
	 */
	AllVehicle.clear();
	ExcludeVehicle.clear();

	String Out_PickupDate = In_PickupDate;
	String Out_ReturnDate = In_ReturnDate;

	// ///////////////////
	// ///////////////////INNER CODE

	try {
	    Class.forName("org.sqlite.JDBC");
	    Connection cona = DriverManager
		    .getConnection("jdbc:sqlite:.//data//database.db");
	    Statement stata = cona.createStatement();
	    // ///////////////////////////////////////////////////////////////////////////////
	    ResultSet rsa = stata
		    .executeQuery("SELECT Description,Mileage,Num_Seats,Num_Bench_Seats,VehicleID FROM Reservation,Vehicles WHERE "
			    + "(Date_Pickup BETWEEN '"
			    + Out_PickupDate
			    + "' AND '"
			    + Out_ReturnDate
			    + "' OR Date_Return BETWEEN '"
			    + Out_PickupDate
			    + "' AND '"
			    + Out_ReturnDate
			    + "') AND "
			    + " VehicleID == res_Vehicle_ID AND"
			    + " TypeVehicle like '" + In_TypeVehicle + "'");

	    while (rsa.next()) {
		ExcludeVehicle.add(new Car(rsa.getString("VehicleID")));

	    }
	    rsa.close();
	    cona.close();
	    // ///////////////////////////////////////////////////////////////////////////////

	} catch (Exception e) {
	    System.out.println("Error2: " + e);
	}

	try {
	    Class.forName("org.sqlite.JDBC");
	    Connection con = DriverManager
		    .getConnection("jdbc:sqlite:.//data//database.db");
	    Statement stat = con.createStatement();
	    // ///////////////////////////////////////////////////////////////////////////////
	    ResultSet rs = stat
		    .executeQuery("SELECT Description,Mileage,Num_Seats,Num_Bench_Seats,VehicleID  FROM Vehicles WHERE TypeVehicle like '"
			    + In_TypeVehicle + "'");

	    while (rs.next()) {

		AllVehicle.add(new Car(rs.getString("Description"), rs
			.getString("Mileage"), rs.getString("Num_Seats"), rs
			.getString("Num_Bench_Seats"), rs
			.getString("VehicleID")));
	    }
	    rs.close();
	    con.close();
	    // ///////////////////////////////////////////////////////////////////////////////

	} catch (Exception e) {
	    System.out.println("Error1 : " + e);
	}

	// ///////////////////END INNER CODE
	// ///////////////////

    }

    public static void MakeReservation(String in_Customer_Last,
	    String in_Customer_First, String in_PickupDate,
	    String in_ReturnDate, String in_VIN) {
	try {
	    Class.forName("org.sqlite.JDBC");
	    Connection con = DriverManager
		    .getConnection("jdbc:sqlite:.//data//database.db");
	    Statement stat = con.createStatement();
	    // ///////////////////////////////////////////////////////////////////////////////
	    boolean rs = stat
		    .execute("INSERT INTO Reservation(Customer_FirstName,Customer_LastName,"
			    + "Date_Pickup,Date_Return,res_Vehicle_ID) VALUES('"
			    + in_Customer_First
			    + "','"
			    + in_Customer_Last
			    + "','"
			    + in_PickupDate
			    + "','"
			    + in_ReturnDate
			    + "','" + in_VIN.toUpperCase() + "')");

	    con.close();
	    // ///////////////////////////////////////////////////////////////////////////////

	} catch (Exception e) {
	    System.out.println("Error_Make: " + e);
	}
    }

    public static boolean GetReservationbyVIN_isEmpty = true;

    public static void GetReservationbyVIN(String LastName, String inVIN) {
	try {
	    Class.forName("org.sqlite.JDBC");
	    Connection con = DriverManager
		    .getConnection("jdbc:sqlite:.//data//database.db");
	    Statement stat = con.createStatement();
	    // ///////////////////////////////////////////////////////////////////////////////
	    ResultSet rs = stat
		    .executeQuery("SELECT Reservation_ID,Description,VehicleID,Date_Pickup,Date_Return "
			    + "FROM Reservation,Vehicles "
			    + "WHERE (VehicleID like res_Vehicle_id) and Customer_Lastname like '"
			    + LastName + "' AND VehicleID like '" + inVIN + "'");

	    while (rs.next()) {
		GetReservationbyVIN_isEmpty = false;
		System.out.println("Reservation_ID="
			+ rs.getString("Reservation_ID") + "   " + "Car="
			+ rs.getString("Description") + "   " + "Vin="
			+ rs.getString("VehicleID") + "   " + "Pickup Date="
			+ rs.getString("Date_Pickup") + "   " + "Return Date="
			+ rs.getString("Date_Return"));
	    }
	    rs.close();
	    con.close();
	    // ///////////////////////////////////////////////////////////////////////////////

	} catch (Exception e) {
	    System.out.println("Error1 : " + e);
	}
    }

    public static void DeleteReservation(String Res_ID) {
	try {
	    Class.forName("org.sqlite.JDBC");
	    Connection con = DriverManager
		    .getConnection("jdbc:sqlite:.//data//database.db");
	    Statement stat = con.createStatement();
	    // ///////////////////////////////////////////////////////////////////////////////
	    boolean rs = stat.execute("DELETE FROM Reservation "
		    + "Where Reservation_ID like " + Res_ID);

	    con.close();
	    // ///////////////////////////////////////////////////////////////////////////////

	} catch (Exception e) {
	    System.out.println("Error_Make: " + e);
	}
    }

    public static void FlushReservation() {
	try {
	    Class.forName("org.sqlite.JDBC");
	    Connection con = DriverManager
		    .getConnection("jdbc:sqlite:.//data//database.db");
	    Statement stat = con.createStatement();
	    // ///////////////////////////////////////////////////////////////////////////////
	    boolean rs = stat.execute("DELETE FROM Reservation");

	    con.close();
	    // ///////////////////////////////////////////////////////////////////////////////

	} catch (Exception e) {
	    System.out.println("Error_Make: " + e);
	}
    }

    public static void GetAvailableVehicles() {
	Car AllVehicleCar = new Car(null);
	Car ExcludeVehicleCar = new Car(null);

	for (int i = 0; i <= AllVehicle.size() - 1; i++) {
	    for (int j = 0; j < ExcludeVehicle.size(); j++) {
		AllVehicleCar = (Car) AllVehicle.get(i);
		ExcludeVehicleCar = (Car) ExcludeVehicle.get(j);

		// System.out.println(ExcludeVehicleCar.getVIN()==AllVehicleCar.getVIN());

		if (AllVehicleCar.getVIN().equalsIgnoreCase(
			ExcludeVehicleCar.getVIN())) {
		    // System.out.println(AllVehicleCar.getVIN());
		    AllVehicle.remove(i);
		}
		// System.out.println(AllVehicleCar.toString());
	    }
	}

	for (int i = 0; i <= AllVehicle.size() - 1; i++) {
	    AllVehicleCar = (Car) AllVehicle.get(i);
	    System.out.println(AllVehicleCar.toString());
	}

    }

    public String toString() {
	return "USE OTHER GETs";
    }

}
