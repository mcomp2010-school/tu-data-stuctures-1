package array.tables.items;

public class Rates_Item {
	String Type;
	String Daily_Rate;
	String Weekly_Rate;
	String Weekend_Rate;
	String Unlimited_Mileage;
	String FreeMilesPerDay;
	String PerMileCharge;
	String Insurance;

	public Rates_Item(String type, String daily_Rate, String weekly_Rate,
			String weekend_Rate, String unlimited_Mileage,
			String freeMilesPerDay, String perMileCharge, String insurance) {
		super();
		Type = type;
		Daily_Rate = daily_Rate;
		Weekly_Rate = weekly_Rate;
		Weekend_Rate = weekend_Rate;
		Unlimited_Mileage = unlimited_Mileage;
		FreeMilesPerDay = freeMilesPerDay;
		PerMileCharge = perMileCharge;
		Insurance = insurance;
	}
	

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getDaily_Rate() {
		return Daily_Rate;
	}

	public void setDaily_Rate(String daily_Rate) {
		Daily_Rate = daily_Rate;
	}

	public String getWeekly_Rate() {
		return Weekly_Rate;
	}

	public void setWeekly_Rate(String weekly_Rate) {
		Weekly_Rate = weekly_Rate;
	}

	public String getWeekend_Rate() {
		return Weekend_Rate;
	}

	public void setWeekend_Rate(String weekend_Rate) {
		Weekend_Rate = weekend_Rate;
	}

	public String getUnlimited_Mileage() {
		return Unlimited_Mileage;
	}

	public void setUnlimited_Mileage(String unlimited_Mileage) {
		Unlimited_Mileage = unlimited_Mileage;
	}

	public String getFreeMilesPerDay() {
		return FreeMilesPerDay;
	}

	public void setFreeMilesPerDay(String freeMilesPerDay) {
		FreeMilesPerDay = freeMilesPerDay;
	}

	public String getPerMileCharge() {
		return PerMileCharge;
	}

	public void setPerMileCharge(String perMileCharge) {
		PerMileCharge = perMileCharge;
	}

	public String getInsurance() {
		return Insurance;
	}

	public void setInsurance(String insurance) {
		Insurance = insurance;
	}

	@Override
	public String toString() {
		return "RateItem [Type=" + Type + ", Daily_Rate=" + Daily_Rate
				+ ", Weekly_Rate=" + Weekly_Rate + ", Weekend_Rate="
				+ Weekend_Rate + ", Unlimited_Mileage=" + Unlimited_Mileage
				+ ", FreeMilesPerDay=" + FreeMilesPerDay + ", PerMileCharge="
				+ PerMileCharge + ", Insurance=" + Insurance + "]";
	}
}
