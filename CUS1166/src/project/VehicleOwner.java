package project;

/*Project: Vehicular Cloud
 *Class: VehicleOwner.java
 *By: Miracle Sanchez
 * 
 * */

public class VehicleOwner extends User {
	int time_vehicle;
	static Vehicle vehicle;
	
	public VehicleOwner(String firstName, String lastName, String password, int clientID, String userType) {
		super(firstName, lastName, password, clientID, userType);
		// TODO Auto-generated constructor stub
	}
	

	public static void registerVehicle (String model, String make, int year, int vehicleId, String license_plate, String residency){
		vehicle = new Vehicle(model, make, year, vehicleId, license_plate, residency);
	}
	
	
}
