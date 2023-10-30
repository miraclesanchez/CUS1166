package project;

import java.util.ArrayList;

public class VehicleCloudController {
	
	int redundancy;
	int id_counter;
	static ArrayList<Job> jobList = new ArrayList<Job>();

	
	public VehicleCloudController() {
		
	}
	
	
	public static void registerJob(Job job) {
		jobList.add(job);
		
	}
	public static int completionTime(int job_duration, int job_id) {
		return 0;
	}
	

}
