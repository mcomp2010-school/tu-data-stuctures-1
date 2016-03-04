package sql.main;

import java.util.*; // to import the class Scanner
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import shared.Formatting;

//==============================================================
// Program 1 – Vehicle Rental Agency Program (MAIN)
//==============================================================
// Emanuel Rivera
// COSC 336-101
// September 22,2010
//--------------------------------------------------------------

public class Controller {

    public static void main(String[] args) {
	Initialize_Program(); // This will start the Program
    }

    public static void Initialize_Program() {
	System.out.println("1-Display Vehicle Types");
	System.out.println("2-Check rental prices for a given vehicle type");
	System.out
		.println("3-Check available vehicle for a given vehicle type");
	System.out.println("4-Reserve a given vehicle (By VIN)");
	System.out.println("5-Change reservation (By VIN)");
	System.out.println("6-Cancel a given vehicle reservation (By VIN)");
	System.out.println("7-Quit");
	System.out.println("");

	Scanner conInput = new Scanner(System.in);
	System.out.println("Please Enter Number:");

	int intMenuItem = 7;
	try { // This will catch if something other than a Int was entered
	    intMenuItem = conInput.nextInt();
	} catch (Exception e) {
	    System.out
		    .println("\nInput Mismatch-Please enter a Number between 1-7\n\n");
	    Initialize_Program(); // This will call Initialize_Program(); again
	}

	switch (intMenuItem) {
	case 1:
	    Display_Vehicle_Types(true);// true= will divide it
	    break;
	case 2:
	    Check_rental_prices();
	    break;
	case 3:
	    Check_available_vehicle();
	    break;
	case 4:
	    Reserve_vehicle();
	    break;
	case 5:
	    Change_reservation();
	    break;
	case 6:
	    Cancel_reservation();
	    break;
	case 7:
	    Exit_Program();// Nothing to Do(Will quit)
	    break;

	default: {
	    System.out.println("\n\nInvalid Choice\n\n");
	    Initialize_Program(); // This will call Initialize_Program(); again
	    break;
	}
	}

    }

    // ///////////////////////////////////////////////////////////////////
    // ///////////////////////////////////////////////////////////////////
    public static void Display_Vehicle_Types(Boolean Inti) {
	if (Inti == true) {
	    System.out.println("\n------------------");
	}

	System.out.println("Vehicle Types");
	// ///////////////////
	// ///////////////////INNER CODE

	try {
	    Class.forName("org.sqlite.JDBC");
	    Connection con = DriverManager
		    .getConnection("jdbc:sqlite:.//data//database.db");
	    Statement stat = con.createStatement();
	    // ///////////////////////////////////////////////////////////////////////////////
	    ResultSet rs = stat
		    .executeQuery("SELECT Rates_ID,Type FROM Rates ORDER BY Rates_ID");
	    while (rs.next()) {
		System.out.println(rs.getString("Rates_ID") + ")"
			+ rs.getString("Type"));
	    }
	    rs.close();
	    con.close();
	    // ///////////////////////////////////////////////////////////////////////////////

	} catch (Exception e) {
	    System.out.println("Error : " + e);
	}

	// ///////////////////END INNER CODE
	// ///////////////////
	if (Inti == true) {
	    System.out.println("\n------------------\n");
	    Initialize_Program();
	}

    }

    public static void Check_rental_prices() {
	Formatting SFor = new Formatting();

	System.out.println("\n------------------");
	System.out.println("Check rental prices for a given vehicle type");
	// ///////////////////
	Display_Vehicle_Types(false); // Calling Display_Vehicle_Types();

	Scanner conInput = new Scanner(System.in);
	System.out.println("Please Enter Number:");

	int intVehicle_Types = 0;
	try { // This will catch if something other than a Int was entered
	    intVehicle_Types = conInput.nextInt();
	    if (intVehicle_Types <= 0)
		throw new Exception(); // Make sure number is between 1-3
	    else if (intVehicle_Types >= 4)
		throw new Exception();
	} catch (Exception e) {
	    System.out
		    .println("\nInput Mismatch-Please enter a Number between 1-3\n\n");
	    Check_rental_prices(); // This will call Initialize_Method(); again
	}
	// ///////////////////INNER CODE
	try {
	    Class.forName("org.sqlite.JDBC");
	    Connection con = DriverManager
		    .getConnection("jdbc:sqlite:.//data//database.db");
	    Statement stat = con.createStatement();
	    // ///////////////////////////////////////////////////////////////////////////////
	    System.out.println(SFor.STab("Type", 6)
		    + SFor.STab("Daily Rate", 12)
		    + SFor.STab("Weekly Rate", 13)
		    + SFor.STab("Weekend Rate", 14)
		    + SFor.STab("Unlimited Milage", 18)
		    + SFor.STab("Free Miles-Day", 16)
		    + SFor.STab("Per Mile Charge", 17)
		    + SFor.STab("Insurance-Day", 13));

	    ResultSet rs = stat
		    .executeQuery("Select Rates_ID,Type,Daily_Rate,"
			    + "Weekly_Rate,Weekend_Rate,Unlimited_Milage,FreeMilesPerDay,"
			    + "PerMileCharge,Insurance from Rates WHERE Rates_ID like "
			    + intVehicle_Types + "");
	    while (rs.next()) {
		String Type = rs.getString("Type");
		String Daily_Rate = rs.getString("Daily_Rate");
		String Weekly_Rate = rs.getString("Weekly_Rate");
		String Weekend_Rate = rs.getString("Weekend_Rate");
		String Unlimited_Milage = rs.getString("Unlimited_Milage");
		String FreeMilesPerDay = rs.getString("FreeMilesPerDay");
		String PerMileCharge = rs.getString("PerMileCharge");
		String Insurance = rs.getString("Insurance");
		System.out.println(SFor.STab(Type, 6)
			+ SFor.STab(Daily_Rate, 12)
			+ SFor.STab(Weekly_Rate, 13)
			+ SFor.STab(Weekend_Rate, 14)
			+ SFor.STab(Unlimited_Milage, 18)
			+ SFor.STab(FreeMilesPerDay, 16)
			+ SFor.STab(PerMileCharge, 17)
			+ SFor.STab(Insurance, 13));

		System.out.println();
	    }
	    rs.close();
	    con.close();
	    // ///////////////////////////////////////////////////////////////////////////////

	} catch (Exception e) {
	    System.out.println("Error : " + e);
	}
	// ///////////////////END INNER CODE
	// ///////////////////
	System.out.println("\n------------------\n");
	Initialize_Program();
    }

    public static void Check_available_vehicle() {
	System.out.println("\n------------------");
	System.out.println("Check available vehicle for a given vehicle type");
	// ///////////////////
	Display_Vehicle_Types(false); // Calling Display_Vehicle_Types();
	Scanner conInput = new Scanner(System.in);
	System.out.println("Please Enter Number:");

	int intVehicle_Types = 0;
	String StrVehicle_Type = null;

	try { // This will catch if something other than a Int was entered
	    intVehicle_Types = conInput.nextInt();
	    if (intVehicle_Types <= 0)
		throw new Exception(); // Make sure number is between 1-3
	    else if (intVehicle_Types >= 4)
		throw new Exception();

	    if (intVehicle_Types == 1)
		StrVehicle_Type = "car";
	    else if (intVehicle_Types == 2)
		StrVehicle_Type = "suv";
	    else if (intVehicle_Types == 3)
		StrVehicle_Type = "truck";

	} catch (Exception e) {
	    System.out
		    .println("\nInput Mismatch-Please enter a Number between 1-3\n\n");
	    Check_available_vehicle(); // This will call Initialize_Method;
				       // again
	}

	Formatting Sfor = new Formatting();// Formatting Object

	System.out.println("Please enter the day you want to pickup the "
		+ StrVehicle_Type + "(mm/dd/yy):");
	String Pickupdate = conInput.next();
	if (Sfor.ConvertDatetoSqlDate(Pickupdate).equalsIgnoreCase("*Error*")) {
	    System.out.println("You type the date format wrong");
	    Check_available_vehicle();
	} else
	    Pickupdate = Sfor.ConvertDatetoSqlDate(Pickupdate);

	System.out.println("Please enter the day you want to dropoff the "
		+ StrVehicle_Type + "(mm/dd/yy):");
	String Dropoffdate = conInput.next();
	if (Sfor.ConvertDatetoSqlDate(Dropoffdate).equalsIgnoreCase("*Error*")) {
	    System.out.println("You type the date format wrong");
	    Check_available_vehicle();
	} else
	    Dropoffdate = Sfor.ConvertDatetoSqlDate(Dropoffdate);

	// ///////////////////INNER CODE
	available_Vehicles CheckAvil = new available_Vehicles();
	CheckAvil.Init(Pickupdate, Dropoffdate, StrVehicle_Type);
	CheckAvil.GetAvailableVehicles();

	// ///////////////////END INNER CODE
	// ///////////////////
	System.out.println("\n------------------\n");
	Initialize_Program();
    }

    public static void Reserve_vehicle() {
	System.out.println("\n------------------");
	System.out.println("Reserve a given vehicle (By VIN)");
	// ///////////////////
	Display_Vehicle_Types(false); // Calling Display_Vehicle_Types();
	Scanner conInput = new Scanner(System.in);
	System.out.println("Please Enter Number:");

	int intVehicle_Types = 0;
	String StrVehicle_Type = null;

	try { // This will catch if something other than a Int was entered
	    intVehicle_Types = conInput.nextInt();
	    if (intVehicle_Types <= 0)
		throw new Exception(); // Make sure number is between 1-3
	    else if (intVehicle_Types >= 4)
		throw new Exception();

	    if (intVehicle_Types == 1)
		StrVehicle_Type = "car";
	    else if (intVehicle_Types == 2)
		StrVehicle_Type = "suv";
	    else if (intVehicle_Types == 3)
		StrVehicle_Type = "truck";

	} catch (Exception e) {
	    System.out
		    .println("\nInput Mismatch-Please enter a Number between 1-3\n\n");
	    Check_available_vehicle(); // This will call Initialize_Method;
				       // again
	}

	Formatting Sfor = new Formatting();// Formatting Object

	System.out.println("Please enter the day you want to pickup the "
		+ StrVehicle_Type + "(mm/dd/yy):");
	String Pickupdate = conInput.next();
	if (Sfor.ConvertDatetoSqlDate(Pickupdate).equalsIgnoreCase("*Error*")) {
	    System.out.println("You type the date format wrong");
	    Check_available_vehicle();
	} else
	    Pickupdate = Sfor.ConvertDatetoSqlDate(Pickupdate);

	System.out.println("Please enter the day you want to dropoff the "
		+ StrVehicle_Type + "(mm/dd/yy):");
	String Dropoffdate = conInput.next();
	if (Sfor.ConvertDatetoSqlDate(Dropoffdate).equalsIgnoreCase("*Error*")) {
	    System.out.println("You type the date format wrong");
	    Check_available_vehicle();
	} else
	    Dropoffdate = Sfor.ConvertDatetoSqlDate(Dropoffdate);

	// ///////////////////INNER CODE
	available_Vehicles CheckAvil = new available_Vehicles();
	CheckAvil.Init(Pickupdate, Dropoffdate, StrVehicle_Type);
	CheckAvil.GetAvailableVehicles();
	System.out.println("Please enter your first Name:");
	String Cust_First = conInput.next();
	System.out.println("Please enter your last Name:");
	String Cust_last = conInput.next();
	System.out
		.println("Please enter the  VIN number to make a Reservation:");
	String in_VIN = conInput.next();

	CheckAvil.MakeReservation(Cust_last, Cust_First, Pickupdate,
		Dropoffdate, in_VIN);

	// ///////////////////END INNER CODE
	// ///////////////////
	System.out.println("\n------------------\n");
	Initialize_Program();
    }

    public static void Change_reservation() {
	System.out.println("\n------------------");
	System.out.println("Change reservation (By VIN)");
	// ///////////////////
	Scanner conInput = new Scanner(System.in);
	System.out.println("Please enter the VIN:");
	String inVIN = conInput.next();
	inVIN = inVIN.trim();

	System.out.println("Please enter your last Name:");
	String inLastName = conInput.next();
	inLastName = inLastName.trim();

	available_Vehicles CheckAvil = new available_Vehicles();
	System.out.println("Your Reservations");
	CheckAvil.GetReservationbyVIN(inLastName, inVIN);

	// ///////////////////INNER CODE
	if (CheckAvil.GetReservationbyVIN_isEmpty == true) {
	    System.out.println("Sorry you don't have a Reservation");
	} else {
	    System.out
		    .println("Please enter the Reservation ID you want to change");
	    String inUserVIN = conInput.next();
	    CheckAvil.DeleteReservation(inUserVIN);
	    Reserve_vehicle();
	}

	// ///////////////////END INNER CODE
	// ///////////////////
	System.out.println("\n------------------\n");
	Initialize_Program();
    }

    public static void Cancel_reservation() {
	System.out.println("\n------------------");
	System.out.println("Cancel vehicle reservation (By VIN)");
	// ///////////////////
	Scanner conInput = new Scanner(System.in);
	System.out.println("Please enter the VIN:");
	String inVIN = conInput.next();
	inVIN = inVIN.trim();

	System.out.println("Please enter your last Name:");
	String inLastName = conInput.next();
	inLastName = inLastName.trim();

	available_Vehicles CheckAvil = new available_Vehicles();
	System.out.println("Your Reservations");
	CheckAvil.GetReservationbyVIN(inLastName, inVIN);

	// ///////////////////INNER CODE
	if (CheckAvil.GetReservationbyVIN_isEmpty == true) {
	    System.out.println("Sorry you don't have a Reservation");
	} else {
	    System.out
		    .println("Please enter the Reservation ID you want to cancel");
	    String inUserVIN = conInput.next();
	    CheckAvil.DeleteReservation(inUserVIN);

	}

	// ///////////////////END INNER CODE
	// ///////////////////
	System.out.println("\n------------------\n");
	Initialize_Program();
    }

    public static void Exit_Program() {
	// DELETE FROM Reservations
	// ///////////////////
	// ///////////////////INNER CODE
	available_Vehicles CheckAvil = new available_Vehicles();
	CheckAvil.FlushReservation();// Will Flush All the Data from
				     // Reservations
	// ///////////////////END INNER CODE
	// ///////////////////
    }

}
