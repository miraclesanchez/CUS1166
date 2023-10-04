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
 *By: Maria Andia 
 * 
 * */
public class JobOwnerController {
	private JobOwner model;
	private JobOwnerView view;
	private JFrame main_frame;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {new JobOwnerController();});
	}
	        	
	public JobOwnerController() {
		this.model = new JobOwner();
		this.main_frame = new JFrame("Job Owner View");
		this.view = new JobOwnerView();
        //UI components in JobOwnerView
		// Sets up action listeners for UI components in JobOwnerView
		//view.setSubmitJobListener(new SubmitJobListener());
        //view.setExportDataListener(new ExportDataListener());
		
        this.main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.main_frame.setSize(400, 300); 
        //will require to modify JobOwnerView
        //this.main_frame.add(view.getMainPanel());
        this.main_frame.setVisible(true);
	}
	
	public String getUserName(){return model.getUserName();}
	public void setUserName(String userName){model.setUserName(userName);}
	
	public String getUserPassword(){return model.getUserPassword();}
	public void setUserPassword(String userPassword){model.setUserPassword(userPassword);}
	
	public String getUserEmail(){model.setUserEmail(userEmail);}
	public void setUserEmail(String userEmail){model.setUserEmail(userEmail);}
	
	public void updateView(){view.displayUserData(model);}
	
	private class SubmitJobListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //submit job button click event 
            String name = view.getName();
            String status = view.getStatus();
            String date = view.getDate();
            String id = view.getId();

            // Creates a new job and submits it to the model
            Job job = new Job(name, status, submissionDate, id);
            model.submitJob(job);

            // Optionally, update the view to reflect the submitted job
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