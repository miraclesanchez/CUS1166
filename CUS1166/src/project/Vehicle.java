package project;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	private String first_name;
	private String last_name;
	private String model;
	private String make;
	private String year;	
    private String vehicleId;
    private String residency;
//    private static int idCounter = 0;

	
	public Vehicle(String first_name, String last_name, String model, String make, String year, String vehicleId, String residency) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.model = model;
		this.make = make;
		this.year = year;
		this.vehicleId = vehicleId;
		this.residency = residency;
//		this.vehicleId = ++idCounter;
	}
	
	public String getVehicleId() {
		return this.vehicleId;
	}
	
	public String getfirstName() {
		return this.first_name;
	}
	
	public void setfirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastname() {
		return this.last_name;
	}
	
	public void setLastname(String last_name) {
		this.last_name = last_name;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getResidency() {
		return this.residency;
	}
	
	public void setResidency(String residency) {
		this.residency = residency;
	}
	
	
	// Add vehicle to CSV
	public void saveVehicle(String filename) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			String data = String.format("%s, %s, %s, %s, %s, %s, %s, %s\n", this.first_name, this.last_name, this.model, this.make, this.year, this.vehicleId, this.residency, timestamp);
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
