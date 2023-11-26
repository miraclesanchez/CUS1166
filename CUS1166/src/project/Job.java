package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
/*Project: Vehicular Cloud
 *Class: Job.java
 *By: Yvonne Huang 
 * 
 * */
public class Job implements Serializable {
	private int job_ID;
	private String name;
	private int job_duration;
	private Date job_deadline;
	private boolean isCompleted;
	private boolean inProgress;
	private String[] checkpoints;
	
	public Job(int job_ID, String clientID, int job_duration, Date job_deadline, String[] checkpoints) {
		this.job_ID = job_ID;
		this.name = clientID;
		this.job_duration = job_duration;
		this.job_deadline = job_deadline;
		this.checkpoints = checkpoints;
	}
	
	public int getID() {
		return this.job_ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDuration() {
		return this.job_duration;
	}
	
	public Date getDeadline() {
		return this.job_deadline;
	}
	
	public boolean getStatus() {
		if (isCompleted == false) {
			return this.inProgress;
		}
		
		return this.isCompleted;
	}
	
	public void setName(String firstName, String lastName) {
		this.name = firstName + " " + lastName;
	}
	
	public void setDuration(int duration) {
		this.job_duration = duration;
	}
	
	public void setDeadline(Date deadline) {
		this.job_deadline = deadline;
	}
	
	public void setCompleted(boolean status) {
		this.isCompleted = status;
	}
	
	public void setProgress(boolean status) {
		this.inProgress = status;
	}
    
	// Add vehicle to CSV
	public void saveJob(String filename) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			String data = String.format("%d, %s, %d, %s, %s\n", this.job_ID, this.name, this.job_duration, this.job_deadline, timestamp);
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}