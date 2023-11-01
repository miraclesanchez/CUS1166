package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/*Project: Vehicular Cloud
 *Class: JobOwner.java
 *By: Maria Andia
 *
 * By: Miracle Sanchez 
 * October 28, 2023
 * 
 * */


public class JobOwner extends User{
	private List<Job> jobs;
	//private JobOwnerView view;
	//public JobOwner(JobOwnerView view){
	

//----------------------------------------------------------------------------------------------------------------//
	//This method is used to create the job owner, using the same attributes from its super class "user" - Miracle
	public JobOwner(String firstName, String lastName, String password, int clientID, String userType) {
		super(firstName, lastName, password, clientID, userType);
		jobs = new ArrayList<>();
	}
	
//----------------------------------------------------------------------------------------------------------------------//	
	//This method is used to create and submit the job using the attributes from the Job class 	
	public void submitJob(String name, String status, LocalDate submissionDate, int id, String job_duration, String job_deadline,boolean isCompleted,boolean inProgress, String[] checkpoints) {
		Job job = new Job(id, job_deadline, id, job_deadline, checkpoints);
		jobs.add(job);
		
		//sends job to the VCC -- Miracle
		VehicleCloudController.registerJob(job);
		
		 //should probably modify the JobOwnerView Im not sure 
		//view.updateView();
	}
	
	//----------------------------------------------------------------------------------------------------------------------//	
	//This method returns the job by its ID
	public Job getJob(int ID) {
		for(int i=0; i<jobs.size(); i++) {
			if(jobs.get(i).getID()==ID) {
				return jobs.get(i);
			}
		}
		return null;
	}
//	public Job getJob(int i) {
//		if (i >= 0 && i < jobs.size()) {
//            return jobs.get(i);
//        }
//        return null;
//	}
	
	//----------------------------------------------------------------------------------------------------------------------//	
//This method returns all of the jobs
	public List<Job> getJobs(){
		return jobs;
	}
}
