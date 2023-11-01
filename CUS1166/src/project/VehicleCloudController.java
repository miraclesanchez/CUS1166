package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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


