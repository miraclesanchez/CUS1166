package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Vehicle {
	private String model;
	private String make;
	private int year;	
	
	public Vehicle(String model, String make, int year) {
		this.model = model;
		this.make = make;
		this.year = year;
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
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	
	// Add vehicle to CSV
	public void saveVehicle(String filename) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			String data = String.format("%s, %s, %d\n", this.model, this.make, this.year);
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Get vehicles
	public static List<Vehicle> getAllVehiclesFromCSV(String filename) {
		List<Vehicle> vehicles = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields.length >= 3) {
					String model = fields[0];
					String make = fields[1];
					int year = Integer.parseInt(fields[2]);
					Vehicle vehicle = new Vehicle(model, make, year);
					vehicles.add(vehicle);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return vehicles;
	}
}
