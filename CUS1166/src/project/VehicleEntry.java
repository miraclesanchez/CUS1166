package project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class VehicleEntry {
	private Vehicle vehicle; 
	private Date entryDate;
	private Date exitDate;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public Vehicle getVehicle() {
		return this.vehicle;
	}
	
	public Date getEntryDate() {
		return this.entryDate;
	}
	
	public Date getExitDate() {
		return this.exitDate;
	}
		
	public VehicleEntry(Vehicle vehicle, Date entryDate, Date exitDate) {
		this.vehicle = vehicle; 
		this.entryDate = entryDate; 
		this.exitDate = exitDate;
	}
	
	public void saveVehicleHistory(String filename) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			String data = String.format("%s, %s, %d, %s, %s\n", vehicle.getModel(), vehicle.getMake(), vehicle.getYear(), sdf.format(entryDate), sdf.format(exitDate));
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<VehicleEntry> getAllEntriesFromCSV(String filename) {
		List<VehicleEntry> entries = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				if (fields.length >= 5) {
					String model = fields[0];
					String make = fields[1];
					int year = Integer.parseInt(fields[2].trim());
					Date entryDate = sdf.parse(fields[3]);
					Date exitDate = sdf.parse(fields[4]);
					
					Vehicle vehicle = new Vehicle(model, make, year);
					VehicleEntry entry = new VehicleEntry(vehicle, entryDate, exitDate);
					entries.add(entry);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entries; 
	}
}
