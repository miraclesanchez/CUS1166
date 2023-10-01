package project;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JobOwnerView extends GuiManager{
	/* Project: Vehicular Cloud
	 * Class: JobOwnerView.class
	 * Author: Yvonne Huang
	 * Date: September 27th 2023
	 * This program sets up the main user interface for job owners
	*/

	public JobOwnerView() {
		/*TODO: 
		 * add back button for login interface
		 * bug with two windows appearing at the same time
		 */
		
		// variables to set the size of the user interface panels
		int[] panel_dimensions = {10,10,10,10};
		int[] panel_layout = {5,1};
		
		JFrame main_frame = CreateFrame("Job Owner View");
		JPanel main_panel = CreatePanel(main_frame, panel_dimensions, panel_layout);
		main_frame.setVisible(true);

		String menu_image_path = "images/job_icon.png";
		JLabel menu_label = CreateTextLabel("MENU", menu_image_path, 40.0f);
		AddTextLabel(main_panel, menu_label, 200, 100);
		
		JLabel welcome_label = CreateTextLabel("Welcome, {user}!", "No image", 20.0f);
		AddTextLabel(main_panel, welcome_label, 100, 100);
		
		//adding buttons
		JButton submit_job = AddButton(main_panel, "Submit job information");
		JButton view_sub = AddButton(main_panel, "View previous job submissions");
		JButton login_button = AddButton(main_panel, "Back to login");
		
		SetActionListener(main_frame, "submit job", submit_job);
		SetActionListener(main_frame, "view submissions", view_sub);
		SetActionListener(main_frame, "login", login_button);
	}
}
