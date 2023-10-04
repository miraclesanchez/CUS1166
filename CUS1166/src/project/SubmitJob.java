package project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public SubmitJob() {
		// variables to set the size of the user interface panels
		int[] panel_dimensions = {10,10,10,10};
		int[] panel_layout = {7,1};

		JFrame submit_frame = CreateFrame("Submit Job Information");
		submit_frame.setSize(400, 300);
		submit_frame.setLocationRelativeTo(null);
		JPanel submit_panel = CreatePanel(submit_frame, panel_dimensions, panel_layout);
		
		JLabel enter_label = CreateTextLabel("Submit New Job:", "No image", 20.0f);
		JLabel duration_label = CreateTextLabel("Enter job duration:", "No image", 10.0f);
		JLabel deadline_label = CreateTextLabel("Enter job deadline:", "No image", 10.0f);
		
		JTextField job_duration = CreateTextField(20.0f);
		JTextField job_deadline = CreateTextField(20.0f);
		
		AddTextLabel(submit_panel, enter_label, 100, 100);
		
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
						(job_duration.getText().equals("")) || 
						(job_deadline.getText().equals(""))
					) {
					JOptionPane.showMessageDialog(null, "Required Field Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				//Clears text fields and displays message letting user know that they registered their vehicle
				else {
					JOptionPane.showMessageDialog(null, "Job Successfully submitted!", "Success!", JOptionPane.PLAIN_MESSAGE);
					//System.out.println(job_duration.getText());
					//TO GET ADDED:
					//Write input from text fields to file
				}
			}
		});
		
		SwitchWindow(submit_frame, "job menu", menu_button);
	}
}
