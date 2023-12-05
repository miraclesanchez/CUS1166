package project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubmitJob extends GuiManager{
	/* Project: Vehicular Cloud
	 * Class: SubmitJob.class
	 * Author: Yvonne Huang
	 * Date: September 27th 2023
	 * This program sets up the interface to submit job information
	*/

	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;
	
	
	public SubmitJob() {
		// variables to set the size of the user interface panels
		int[] panel_dimensions = {10,10,10,10};
		int[] panel_layout = {12,1};

		JFrame submit_frame = CreateFrame("Submit Job Information");
		submit_frame.setSize(400, 300);
		submit_frame.setLocationRelativeTo(null);
		JPanel submit_panel = CreatePanel(submit_frame, panel_dimensions, panel_layout);
		
		JLabel enter_label = CreateTextLabel("Submit New Job:", "No image", 20.0f);
		JLabel job_id_label = CreateTextLabel("Enter job ID (Ex/ 12345):", "No image", 10.0f);
		JLabel name_label = CreateTextLabel("Enter your clientID:", "No image", 10.0f);
		JLabel duration_label = CreateTextLabel("Enter job duration (hours):", "No image", 10.0f);
		JLabel deadline_label = CreateTextLabel("Enter job deadline (mm/dd/yyyy):", "No image", 10.0f);

		JTextField job_id = CreateTextField(10.0f);
		JTextField name = CreateTextField(10.0f);
		JTextField job_duration = CreateTextField(10.0f);
		JTextField job_deadline = CreateTextField(10.0f);
		
		AddTextLabel(submit_panel, enter_label, 100, 100);
		
		AddTextLabel(submit_panel, job_id_label, 100, 100);
		AddTextField(submit_panel, job_id, 100, 100);
		
		AddTextLabel(submit_panel, name_label, 100, 100);
		AddTextField(submit_panel, name, 100, 100);
		
		AddTextLabel(submit_panel, duration_label, 100, 100);
		AddTextField(submit_panel, job_duration, 100, 100);
		
		AddTextLabel(submit_panel, deadline_label, 100, 100);
		AddTextField(submit_panel, job_deadline, 100, 100);
		
		submit_frame.setVisible(true);
		
		JButton submit_button = AddButton(submit_panel, "Submit job information"); //save information to file
		JButton menu_button = AddButton(submit_panel, "Back to menu");
		
		//Method to write text in input fields to a file.
		submit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Only writes if all text fields contain an input
				if (
						(job_id.getText().equals("")) || 
						(name.getText().equals("")) ||
						(job_duration.getText().equals("")) || 
						(job_deadline.getText().equals(""))
					) {
					JOptionPane.showMessageDialog(null, "Required Field Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				//Clears text fields and displays message letting user know that they registered their vehicle
				else {
					try {
						int jobID = Integer.parseInt(job_id.getText());
						String jobName = name.getText();
						int jobDur = Integer.parseInt(job_duration.getText());
						
						//changed the type of the deadline to Date. included a parser for it since it is originally in String form when taken from the GUI
						String dateString = job_deadline.getText();
						SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Date jobDead = null;
						
						try {
							jobDead = dateFormat.parse(dateString);
						}catch (ParseException e1) {
							e1.printStackTrace();
						}
						
						String[] checkpoints = {};
						Job newJob = new Job(jobID, jobName, jobDur, jobDead, checkpoints);
						
						connectJobOwner(newJob);
					}
					catch(Exception e3) {
						JOptionPane.showMessageDialog(null, "Invalid input. Try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
						e3.printStackTrace();
					}
					
					job_id.setText("");
					name.setText("");
					job_duration.setText("");
					job_deadline.setText("");
				}
			}
		});
		
		SwitchWindow(submit_frame, "job menu", menu_button);
		
		
	}
	
	public static void connectJobOwner(Job job) {
		String messageIn = "";
		
		try {
			// connect the client socket to vcc
			Socket socket = new Socket("localhost", 9805);
			
			
			// client reads a message from Server
			inputStream = new DataInputStream(socket.getInputStream());
			// client sends object to vcc
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			
			// notify vcc that user is submitting a job
			String vcc_choice = "Job";
			
			// client sends job submission info to vcc
			oos.writeObject(vcc_choice);
			oos.writeObject(job);
			
			// read vcc messages until vcc notifies client "data received"
			while (!messageIn.equals("data received")) {
				messageIn = inputStream.readUTF();	
			}
			
			// close socket connection and streams
			System.out.println("data received");
			System.out.println("closing client connection");	
			socket.close();
			inputStream.close();
			oos.close();

		} catch (Exception e) {
			
			e.printStackTrace();

		}
	}
}
