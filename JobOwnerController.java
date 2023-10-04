import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/*Project: Vehicular Cloud
 *Class: JobOwnerController.java
 *Author: Maria Andia 
 *Date: October 3rd, 2023 
 * */
public class JobOwnerController {
	private JobOwner model;
	private JobOwnerView view;
	private JFrame main_frame;
	        	
	public JobOwnerController(JobOwner model) {
		this.model = new JobOwner();
		this.main_frame = new JFrame("Job Owner View");
		this.view = new JobOwnerView();
        //UI components in JobOwnerView
		// Sets up action listeners for UI components in JobOwnerView
		view.setSubmitJobListener(new SubmitJobListener());
        //view.setExportDataListener(new ExportDataListener());
		
        this.main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.main_frame.setSize(400, 300); 
        
        this.main_frame.add(view.getMainPanel());
        this.main_frame.setVisible(true);
	}
	
	
	
	private class SubmitJobListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //submit job button click event 
            String name = submitJob.getName();
            String status = submitJob.getStatus();
            LocalDate submissionDate = submitJob.getDate();
            Tuple id = submitJob.getId();

            // Creates a new job and submits it to the model
            Job job = new Job(name, status, submissionDate, id);
            model.submitJob(job);

            // Update the view to show the submitted job
            view.updateJobList(model.getJob());
        }
    }
	
	private class ExportDataListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String filename = view.getExportFilename();
            exportData(filename);
        }
	}
	
	//method to export owner data to a csv file
	public void exportData(String filename) {
		try {
			FileWriter fileWriter = new FileWriter(filename);
			// writes owners information to the csv file
			String username = model.getUserName();
			String password = model.getUserPassword();
			String email = model.getUserEmail();
			
			fileWriter.append(username);
			fileWriter.append(",");
			fileWriter.append(password);
			fileWriter.append(",");
			fileWriter.append(email);
			fileWriter.append(" ");
			fileWriter.flush();
			fileWriter.close();
			
			JOptionPane.showMessageDialog(main_frame, "Information exported to " + filename);
		}
		catch (IOException e) {
            e.printStackTrace();
		}
	}
}