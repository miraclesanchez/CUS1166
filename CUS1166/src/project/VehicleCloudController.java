package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VehicleCloudController {
	
	int redundancy;
	int id_counter;
	static Queue <Job> jobQueue = new LinkedList<>();
	static ArrayList <Integer> jobID = new ArrayList <>();
	static ArrayList <Integer> jobDuration = new ArrayList <>();
	static int job_int;	
	static int job_dur;
		
	public VehicleCloudController () {
		JFrame frame=new JFrame();
		frame.setTitle("Vehicle Cloud Controller");
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton computeBut = new JButton("Computation");
		computeBut.setBounds(219, 94, 117, 29);
		frame.getContentPane().add(computeBut);
		
		
		computeBut.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Create strings for Job ID and Job Duration
		        String jobIDString = "Job ID: " + jobID.toString();
		        String jobDurationString = "Job Duration: " + jobDuration.toString();

		        // Call the completionTime method to calculate completion times
		        ArrayList<Integer> completion_time = completionTime();

		        // Create a string for Completion Time
		        String completionTimeString = "Completion Time: " + completion_time.toString();

		        // Display the information in a JOptionPane message
		        JOptionPane.showMessageDialog(null, jobIDString + "\n" + jobDurationString + "\n" + completionTimeString);
		    }
		});
	}
	
	public static void registerJob(Job job) {
		jobQueue.add(job);
		
	}
	
	public static ArrayList<Integer> completionTime() {
		
		
		ArrayList <Integer> completion_time = new ArrayList <>();
		int totalDuration =0;
		
		//This enhanced for loop will return the jobID's and jobDuration's for each job in the QUEUE and add them to the arraylist of jobIDs
		for(Job job: jobQueue) {
			job_int=job.getID();
			jobID.add(job_int);
			
			job_dur = job.getDuration();
			jobDuration.add(job_dur);
			
			totalDuration+=job_dur;
			
			System.out.print(job_int);
			System.out.print(job_dur);	
	}
		
		int currentCompletionTime = 0;
		for (int duration: jobDuration) {
			currentCompletionTime += duration;
			completion_time.add(currentCompletionTime);
		}
		
		return completion_time;
	
		
	}
//	private class SubmitJobListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            //submit job button click event 
//            String name = view.getName();
//            String status = view.getStatus();
//            String date = view.getDate();
//            String id = view.getId();
//
//            // Creates a new job and submits it to the model
//            Job job = new Job(name, status, submissionDate, id);
//            model.submitJob(job);
//
//            // Optionally, update the view to reflect the submitted job
//            view.updateJobList(model.getJob());
//        }
//    }
//	
//	private class ExportDataListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String filename = view.getExportFilename();
//            exportData(filename);
//        }
//	}
//	
//	//method to export owner data to a csv file
//	public void exportData(String filename) {
//		try {
//			FileWriter fileWriter = new FileWriter(filename);
//			// writes owners information to the csv file
//			String username = model.getUserName();
//			String password = model.getUserPassword();
//			String email = model.getUserEmail();
//			
//			fileWriter.append(username);
//			fileWriter.append(",");
//			fileWriter.append(password);
//			fileWriter.append(",");
//			fileWriter.append(email);
//			fileWriter.append(" ");
//			fileWriter.flush();
//			fileWriter.close();
//			
//			JOptionPane.showMessageDialog(main_frame, "Information exported to " + filename);
//		}
//		catch (IOException e) {
//            e.printStackTrace();
//		}
	}


