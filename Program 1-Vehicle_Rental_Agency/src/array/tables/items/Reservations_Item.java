package array.tables.items;

public class Reservations_Item{
	String Customer_Firstname;
	String Customer_Lastname;
	String Date_Pickup;
	String Date_Return;
	String res_Vehicle_ID;
	
	public String getCustomer_Firstname() {
		return Customer_Firstname;
	}

	public void setCustomer_Firstname(String customer_Firstname) {
		Customer_Firstname = customer_Firstname;
	}

	public String getCustomer_Lastname() {
		return Customer_Lastname;
	}

	public void setCustomer_Lastname(String customer_Lastname) {
		Customer_Lastname = customer_Lastname;
	}

	public String getDate_Pickup() {
		return Date_Pickup;
	}

	public void setDate_Pickup(String date_Pickup) {
		Date_Pickup = date_Pickup;
	}

	public String getDate_Return() {
		return Date_Return;
	}

	public void setDate_Return(String date_Return) {
		Date_Return = date_Return;
	}

	public String getRes_Vehicle_ID() {
		return res_Vehicle_ID;
	}

	public void setRes_Vehicle_ID(String res_Vehicle_ID) {
		this.res_Vehicle_ID = res_Vehicle_ID;
	}
	
	@Override
	public String toString() {
		return "Reservation [Customer_Firstname=" + Customer_Firstname
				+ ", Customer_Lastname=" + Customer_Lastname + ", Date_Pickup="
				+ Date_Pickup + ", Date_Return=" + Date_Return
				+ ", res_Vehicle_ID=" + res_Vehicle_ID + "]";
	}
}

