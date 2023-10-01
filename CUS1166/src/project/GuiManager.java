package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GuiManager{
	/* Project: Vehicular Cloud
	 * Class: GuiManager.class
	 * Author: Yvonne Huang
	 * Date: September 27th 2023
	 * This program has all the methods needed to create user interface objects
	*/
	
	// ---------------------------------------------------------------
	// This method creates a a new frame
	public JFrame CreateFrame(String title) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(400,300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(title);
		
		return frame;
	}
	
	// ---------------------------------------------------------------
	// This method creates a a new panel
	public JPanel CreatePanel(JFrame frame, int[] dimensions, int[] grid_layout) {
		JPanel panel = new JPanel();
		int top_border = dimensions[0];
		int bottom_border = dimensions[1];
		int left_border = dimensions[2];
		int right_border = dimensions[3];
		
		panel.setBorder(BorderFactory.createEmptyBorder(top_border, left_border, bottom_border, right_border));
		panel.setLayout(new GridLayout(grid_layout[0],grid_layout[1]));
		
		frame.getContentPane().add(panel);
		frame.pack();
		
		return panel;
	}
	
	// ---------------------------------------------------------------
	// This method creates a text label with or without images
	public JLabel CreateTextLabel(String text, String hasImage, float text_size) {
		JLabel label;
		if (hasImage.equals("No image")) {
			label = new JLabel(text,
					SwingConstants.CENTER);
		}
		else {
			label = new JLabel(text,
					new ImageIcon(hasImage),
					SwingConstants.CENTER);	
			label.setIconTextGap(10);
		}
		
		label.setFont(label.getFont().deriveFont(text_size));
		
		return label;
	}
	
	// ---------------------------------------------------------------
	// This method adds a text label to a panel
	public void AddTextLabel(JPanel panel, JLabel label, int width, int height) {
		panel.add(label);
		label.setSize(width, height);
	}
	
	// ---------------------------------------------------------------
	// This method creates a button
	public static JButton AddButton(JPanel panel, String text) {
		JButton button = new JButton(text);
		panel.add(button);
		return button;
	}
	
	public void SetActionListener(JFrame current_frame, String button_type, JButton button) {
		button.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (e.getSource().equals(button)) {
							current_frame.dispose(); //deletes the current frame once button is pressed
							
							//switch windows (add your buttons if needed)
							//don't know if there's a better way of doing this LOL
							switch(button_type.toLowerCase()) {
								case "submit job":
									SubmitJob submit_view = new SubmitJob();
									break;
								case "view submissions":
									ViewSubmissions view_subs = new ViewSubmissions();
									break;
								case "job menu":
									JobOwnerView job_view = new JobOwnerView();
									break;
							}	
						}
					}
				});
	}
}
