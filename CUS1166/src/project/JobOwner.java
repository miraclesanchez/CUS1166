package project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/*Project: Vehicular Cloud
 *Class: JobOwner.java
 *By: Maria Andia 
 * 
 * */
public class JobOwner {
	private List<Job> jobs;
	//private JobOwnerView view;
	//public JobOwner(JobOwnerView view){
	public JobOwner() { 
		jobs = new ArrayList<>();
		//this.view = view;
	}
	
	public void submitJob(String name, String status, LocalDate submissionDate, Tuple id) {
		Job job = new Job(name, status, submissionDate, id);
		jobs.add(job);
		 //should probably modify the JobOwnerView Im not sure 
		//view.updateView();
	}
	public Job getJob(int i) {
		if (i >= 0 && i < jobs.size()) {
            return jobs.get(i);
        }
        return null;
	}
	public List<Job> getJobs(){
		return jobs;
	}
}
