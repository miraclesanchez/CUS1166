package project;

/*Project: Vehicular Cloud
 *Class: VehicleOwner.java
 *By: Miracle Sanchez
 * 
 * */

public class VehicleOwner extends User {
	int time_vehicle;
	static Vehicle vehicle;
	
	public VehicleOwner(String firstName, String lastName, String password, String clientID, String userType) {
		super(firstName, lastName, password, clientID, userType);
		// TODO Auto-generated constructor stub
	}
	

	public static void registerVehicle (String clientID,String model, String make, int year, int vehicleId, String license_plate, String residency){
		vehicle = new Vehicle(clientID,model, make, year, vehicleId, license_plate, residency);
	}
	
	
}