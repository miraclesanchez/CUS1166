package project;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ViewSubmissions extends GuiManager{
	/* Project: Vehicular Cloud
	 * Class: ViewSubmissions.class
	 * Author: Yvonne Huang
	 * Date: September 27th 2023
	 * This program sets up a display of all previous submissions
	*/
	
	public ViewSubmissions(){		
		// variables to set the size of the user interface panels
		int[] panel_dimensions = {10,10,10,10};
		int[] panel_layout = {3,1};
		
		JFrame view_subs_frame = CreateFrame("View Previous Job Submissions");
		JPanel view_subs_panel = CreatePanel(view_subs_frame, panel_dimensions, panel_layout);
		JLabel submissions_label = CreateTextLabel("Previous job submissions:", "No image", 20.0f);
		AddTextLabel(view_subs_panel, submissions_label, 100, 100);
		view_subs_frame.setVisible(true);
		
		JScrollPane scrollWindow = new JScrollPane();
		scrollWindow.setBounds(10, 10, 10, 10);
		view_subs_panel.add(scrollWindow);
		
		JTable prev_jobs = new JTable();
		prev_jobs.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		prev_jobs.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
					{null, null},
				},
				new String[] {
					"Job Duration", "Job Deadline"
				}
			) {
				private static final long serialVersionUID = 1L;
				
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});

		prev_jobs.getColumnModel().getColumn(0).setPreferredWidth(150);
		prev_jobs.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollWindow.setViewportView(prev_jobs);
		
		JButton menu_button = AddButton(view_subs_panel, "Back to menu");
		SwitchWindow(view_subs_frame, "job menu", menu_button);
	}
}
