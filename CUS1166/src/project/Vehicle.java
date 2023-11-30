package project;

import java.sql.Timestamp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;


public class Vehicle implements Serializable {
	private int vehicle_ID;
	private String vehicle_make;
	private String license_plate;
	private String vehicle_model;
	private int year;	
    private String residency;
    private String clientID;

	
	public Vehicle(String clientID,String model, String make, int year, int vehicleId, String license_plate, String residency) {
		
		this.vehicle_model = model;
		this.vehicle_make = make;
		this.year = year;
		this.vehicle_ID = vehicleId;
		this.license_plate = license_plate;
		this.residency = residency;
		this.clientID = clientID;
	}
	
	public int getVehicleId() {
		return this.vehicle_ID;
	}
	
	public void setVehicleID(int vehicle_ID) {
		this.vehicle_ID = vehicle_ID;
	}
	
	public String getclientId() {
		return this.clientID;
	}
	
	public void setclientID(String clientID) {
		this.clientID = clientID;
	}
	
	
	public String getModel() {
		return this.vehicle_model;
	}
	
	public void setModel(String model) {
		this.vehicle_model = model;
	}
	
	public String getMake() {
		return this.vehicle_make;
	}
	
	public void setMake(String vehicle_make) {
		this.vehicle_make = vehicle_make;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getResidency() {
		return this.residency;
	}
	
	public void setResidency(String residency) {
		this.residency = residency;
	}
	
	public String getLicense() {
		return this.license_plate;
	}
	
	public void setLicense(String license_plate) {
		this.license_plate = license_plate;
	}

	
	// Add vehicle to CSV
	public void registerVehicle(String filename, String first_name, String last_name) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			String data = String.format("%s, %s, %s, %s, %d, %s, %d, %s, %s\n", first_name, last_name, this.vehicle_model, this.vehicle_make, this.year, this.license_plate, this.vehicle_ID, this.residency, timestamp);
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
//	Commented out this method for now; need to revise CSV format
//	// Get vehicles
//	public static List<Vehicle> getAllVehiclesFromCSV(String filename) {
//		List<Vehicle> vehicles = new ArrayList<>();
//		
//		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//			String line = br.readLine();
//			while ((line = br.readLine()) != null) {
//				String[] fields = line.split(",");
//				if (fields.length >= 3) {
//					String model = fields[0];
//					String make = fields[1];
//					int year = Integer.parseInt(fields[2]);
//					Vehicle vehicle = new Vehicle(model, make, year, vehicleID);
//					vehicles.add(vehicle);
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		return vehicles;
//	}
//}
