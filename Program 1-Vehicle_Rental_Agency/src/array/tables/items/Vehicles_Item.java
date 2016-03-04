package array.tables.items;

public class Vehicles_Item {
	String TypeVehicle;
	String Description;
	String Mileage;
	String Num_Seats;
	String Num_Bench_Seats;
	String VehicleID;

	public Vehicles_Item() {
		
	}
	
	public Vehicles_Item(String typeVehicle, String description,
			String mileage, String num_Seats, String num_Bench_Seats,
			String vehicleID) {
		super();
		TypeVehicle = typeVehicle;
		Description = description;
		Mileage = mileage;
		Num_Seats = num_Seats;
		Num_Bench_Seats = num_Bench_Seats;
		VehicleID = vehicleID;
	}
	


	public String getTypeVehicle() {
		return TypeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		TypeVehicle = typeVehicle;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMileage() {
		return Mileage;
	}

	public void setMileage(String mileage) {
		Mileage = mileage;
	}

	public String getNum_Seats() {
		return Num_Seats;
	}

	public void setNum_Seats(String num_Seats) {
		Num_Seats = num_Seats;
	}

	public String getNum_Bench_Seats() {
		return Num_Bench_Seats;
	}

	public void setNum_Bench_Seats(String num_Bench_Seats) {
		Num_Bench_Seats = num_Bench_Seats;
	}

	public String getVehicleID() {
		return VehicleID;
	}

	public void setVehicleID(String vehicleID) {
		VehicleID = vehicleID;
	}

	@Override
	public String toString() {
		return "Vehicles [TypeVehicle=" + TypeVehicle + ", Description="
				+ Description + ", Mileage=" + Mileage + ", Num_Seats="
				+ Num_Seats + ", Num_Bench_Seats=" + Num_Bench_Seats
				+ ", VehicleID=" + VehicleID + "]";
	}

}
