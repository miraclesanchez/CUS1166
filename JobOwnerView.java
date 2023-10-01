package project;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JobOwnerView {
	/* Project: Vehicular Cloud
	 * Class: JobOwnerView.class
	 * Author: Yvonne Huang
	 * Date: September 27th 2023
	 * This program displays the user interface for people who want to submit a job and have logged in through the login interface
	*/
	
	// ---------------------------------------------------------------
	// This method creates a text label with or without images
	public static JLabel CreateTextLabel(String text, String hasImage, float text_size) {
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
	// This method creates a button
	public static void AddButton(JPanel panel, String text) {
		JButton button = new JButton(text);
		panel.add(button);
	}
	
	// ---------------------------------------------------------------
	// This method adds a text label to a panel
	public static void AddTextLabel(JPanel panel, JLabel label, int width, int height) {
		panel.add(label);
		label.setSize(width, height);
	}
	
	// ---------------------------------------------------------------
	// This method creates an object that will hold the user interface
	public JobOwnerView() {
		// variables to set the size of the user interface panel
		final int TOP_BORDER = 10;
		final int BOTTOM_BORDER = 10;
		final int LEFT_BORDER = 10;
		final int RIGHT_BORDER = 10;
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(TOP_BORDER, LEFT_BORDER, BOTTOM_BORDER, RIGHT_BORDER));
		panel.setLayout(new GridLayout(5,1));
		
		//frame setup
		JFrame main_frame = new JFrame();
		main_frame.add(panel, BorderLayout.CENTER);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setTitle("Job Owner View");
		main_frame.pack();
		main_frame.setVisible(true);
		
		//setting text labels
		String menu_image_path = "images/job_icon.png";
		JLabel menu_label = CreateTextLabel("MENU", menu_image_path, 40.0f);
		AddTextLabel(panel, menu_label, 200, 100);
		
		JLabel welcome_label = CreateTextLabel("Welcome, {user}!", "No image", 20.0f);
		AddTextLabel(panel, welcome_label, 100, 100);
		
		//adding buttons
		AddButton(panel, "View user details");
		AddButton(panel, "View previous job submissions");
		AddButton(panel, "Back to login");
	}

	public static void main(String[] args) {
		new JobOwnerView();
	}
}
