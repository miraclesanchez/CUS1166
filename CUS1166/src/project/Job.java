package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
/*Project: Vehicular Cloud
 *Class: Job.java
 *By: Maria Andia 
 * 
 * */
public class Job {
	//private String name;
	//private String status;
	private String duration;
	private String deadline;
	//private LocalDate submissionDate;
	//private Tuple id;
	
	public Job(String duration, String deadline) {
		this.duration= duration;
		this.deadline = deadline;
		//this.submissionDate = submissionDate;
		//this.id = id;
	}
	
	public String getDuration() {
		return this.duration;
	}
	
	public String getDeadline() {
		return this.deadline;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	/*
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public LocalDate getDate() {
        return submissionDate;
    }

    public void setDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Tuple getId() {
        return id;
    }

    public void setId(Tuple id) {
        this.id = id;
    }*/
    
	// Add vehicle to CSV
	public void saveJob(String filename) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
			String data = String.format("%s, %s, %s\n", this.duration, this.deadline, timestamp);
			bw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}