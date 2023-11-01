package project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/*Project: Vehicular Cloud
 *Class: VehicleCloudController.java
 *By: Maria Andia 
 * 
 * */
public class VehicleCloudController {
	
	int redundancy;
	int id_counter;
	static ArrayList<Job> jobList = new ArrayList<Job>();
	static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	public VehicleCloudController() {
		redundancy = 0;
		id_counter = 0;
	}
	
	public static void registerVehicle(Vehicle vehicle) {
		vehicleList.add(vehicle);
		
	}
	
	public static void registerJob(Job job) {
		jobList.add(job);
		
	}
	
	private static FIFO(int job_duration, int job_id) {
		int currentCompletionTime =0;
		for(Job job: jobList) {
			int duration = Integer.parseInt(job_duration);// correct it
			
			int arrivalTime = Integer.parseInt(job_deadline);// correct it
			
			 if (arrivalTime <= currentCompletionTime) {// If the job has already arrived, calculate its completion time
				 currentCompletionTime += duration;
	         } 
			 else {// If the job hasn't arrived yet, wait until it arrives and then calculate its completion time
				 currentCompletionTime = arrivalTime + duration;
	         }
			 return currentCompletionTime;
	}
	public static int completionTime(int job_duration, int job_id) {
		int completiontime = 0;
		
		int completiontime = FIFO(job_duration, job_id);
        //completionTime = currentCompletionTime;
		}
		return completionTime;
	}
	
	public static int GenerateID(){
		int newID;
		private static Set<Integer> usedIds = new HashSet<>();
		private static Random random = new Random();
		do {
	        // Generates a random id
	        newID = random.nextInt(Integer.MAX_VALUE);
	    } 
		while (usedIds.contains(newID)); // Ensure the ID is unique
	    
	    // Add the new ID to the set to mark it as used
		usedIds.add(newID);
		return newID;
	}

}
