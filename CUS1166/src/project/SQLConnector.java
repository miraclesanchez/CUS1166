package project;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLConnector {

	
	String url = "jdbc:mysql://localhost:3306/SWE";
	String username = "softwareengineering";
	String password = "CompSciRocks46$";
	Connection conn;
	Statement word;
	ResultSet results;
	
	String allJobs = "select * from JobRegistry";
	
	//this method can be used for both Vehicle and Job Owner
	//they have the same attributes
	public void InsertOwnerData(String owner_type, String clientID, String firstName, String lastName, String clientPassword) {
		String insert_query = "insert into "
				+ owner_type
				+ " (clientID, firstName, lastName, clientPassword)" 
				+ " values (?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement prepared_query = conn.prepareStatement(insert_query);
			prepared_query.setString(1, clientID);
			prepared_query.setString(2, firstName);
			prepared_query.setString(3, lastName);
			prepared_query.setString(4, clientPassword);
			
			prepared_query.execute();
			conn.close();
			System.out.println("Data Inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void InsertVehicleData(String clientID, String make, String model, int carYear, String licensePlate, String residency, int vehicleID) {
		String insert_query = "insert into VehicleRegistry "
				+ "(clientID, make, model, carYear, licensePlate, residency, vehicleID)" 
				+ " values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement prepared_query = conn.prepareStatement(insert_query);
			prepared_query.setString(1, clientID);
			prepared_query.setString(2, make);
			prepared_query.setString(3, model);
			prepared_query.setInt(4, carYear);
			prepared_query.setString(5, licensePlate);
			prepared_query.setString(6, residency);
			prepared_query.setInt(7, vehicleID);
			
			prepared_query.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void InsertJobData(int jobID, String clientID, int jobDuration, Date jobDeadline) {
		String insert_query = "insert into JobRegistry "
				+ "(jobID, clientID, jobDuration, jobDeadline, jobDescription)" 
				+ " values (?, ?, ?, ?, ?)";
		
		try {
			java.util.Date utilDate = jobDeadline; // Assuming jobDeadline is a java.util.Date
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement prepared_query = conn.prepareStatement(insert_query);
			prepared_query.setInt(1, jobID);
			prepared_query.setString(2, clientID);
			prepared_query.setInt(3, jobDuration);
			prepared_query.setDate(4, sqlDate);
			prepared_query.setString(5, null); //replace later if we're adding descriptions
			
			prepared_query.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Job> getJobs(){
		
		ArrayList <Job> Jobs= new ArrayList<>();
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(url, username, password);
			word = conn.createStatement();
			results = word.executeQuery(allJobs);
			
			while(results.next()) {
				int jobID = results.getInt("jobID");
				String clientID = results.getString("clientID");
				int jobDuration = results.getInt("jobDuration");
				Date jobDeadline= results.getDate("jobDeadline");
				String[] checkpoints = {};
				
				Job job = new Job(jobID, clientID, jobDuration, jobDeadline, checkpoints);
				Jobs.add(job);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Jobs;
	}

}
