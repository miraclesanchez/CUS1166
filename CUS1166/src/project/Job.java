package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
/*Project: Vehicular Cloud
 *Class: Job.java
 *By: Yvonne Huang 
 * 
 * */
public class Job {
	private int job_ID;
	private String name;
	private String job_duration;
	private String job_deadline;
	private boolean isCompleted;
	private boolean inProgress;
	private String[] checkpoints;
	
	public Job(int job_ID, String name, String job_duration, String job_deadline, boolean isCompleted, boolean inProgress, String[] checkpoints) {
		this.job_ID = job_ID;
		this.name = name;
		this.job_duration = job_duration;
		this.job_deadline = job_deadline;
		this.isCompleted = isCompleted;
		this.inProgress = inProgress;
		this.checkpoints = checkpoints;
	}
	
	public int getID() {
		return this.job_ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDuration() {
		return this.job_duration;
	}
	
	public String getDeadline() {
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
	
	public void setDuration(String duration) {
		this.job_duration = duration;
	}
	
	public void setDeadline(String deadline) {
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
			String data = String.format("%d, %s, %s, %s, %b, %s\n", this.job_ID, this.name, this.job_duration, this.job_deadline, this.isCompleted, timestamp);
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}