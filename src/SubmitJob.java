import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SubmitJob extends JobOwnerView{
	/* Project: Vehicular Cloud
	 * Class: SubmitJob.class
	 * Author: Yvonne Huang
	 * Date: September 27th 2023
	 * This program sets up the interface to submit job information
	*/
	
	public SubmitJob() {
		// variables to set the size of the user interface panels
		int[] panel_dimensions = {10,10,10,10};
		int[] panel_layout = {5,1};

		JFrame submit_frame = CreateFrame("Submit Job Information");
		JPanel submit_panel = CreatePanel(submit_frame, panel_dimensions, panel_layout);
		JLabel enter_label = CreateTextLabel("Enter information here:", "No image", 20.0f);
		AddTextLabel(submit_panel, enter_label, 100, 100);
		submit_frame.setVisible(true);
		
		JButton menu_button = AddButton(submit_panel, "Back to menu");
		SetActionListener(submit_frame, "job menu", menu_button);
	}
}
