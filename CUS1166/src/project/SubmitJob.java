package project;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		SetActionListener(submit_frame, "job menu", menu_button);
	}
}
