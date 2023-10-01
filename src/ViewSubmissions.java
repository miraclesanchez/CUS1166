import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewSubmissions extends JobOwnerView{
	/* Project: Vehicular Cloud
	 * Class: ViewSubmissions.class
	 * Author: Yvonne Huang
	 * Date: September 27th 2023
	 * This program sets up a display of all previous submissions
	*/

	public ViewSubmissions(){		
		// variables to set the size of the user interface panels
		int[] panel_dimensions = {10,10,10,10};
		int[] panel_layout = {5,1};
		
		JFrame view_subs_frame = CreateFrame("View Previous Job Submissions");
		JPanel view_subs_panel = CreatePanel(view_subs_frame, panel_dimensions, panel_layout);
		JLabel submissions_label = CreateTextLabel("Previous submissions:", "No image", 20.0f);
		AddTextLabel(view_subs_panel, submissions_label, 100, 100);
		view_subs_frame.setVisible(true);
		
		JButton menu_button = AddButton(view_subs_panel, "Back to menu");
		SetActionListener(view_subs_frame, "job menu", menu_button);
	}
}
