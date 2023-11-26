package project;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLConnector {

	
	String url = "jdbc:mysql://localhost:3306/arcade";
	String username = "";
	String password = "";
	Connection conn;
	Statement word;
	ResultSet results;
	
	String allJobs = "select * from JobRegistry";
	


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
			{
			}
		}
} catch (SQLException e) {
	e.printStackTrace();
}
	return Jobs;
}

}