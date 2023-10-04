package project;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class VehicleOwnerView extends GuiManager{
	/* Project: Vehicular Cloud
	 * Class: VehicleOwnerView.class
	 * Author: Daniel Cohen
	 * Date: October 2nd 2023
	 * This program sets up the main user interface for vehicle owners
	*/
	
	public VehicleOwnerView(){
		int[] panel_dimensions = {10,10,10,10};
		int[] panel_layout = {6,1};
		
		JFrame main_frame = CreateFrame("Vehicle Owner View");
		JPanel main_panel = CreatePanel(main_frame, panel_dimensions, panel_layout);
		main_frame.setVisible(true);

		String menu_image_path = "images/car.png";
		JLabel menu_label = CreateTextLabel("MENU", menu_image_path, 40.0f);
		AddTextLabel(main_panel, menu_label, 200, 100);
		
		JLabel welcome_label = CreateTextLabel("Welcome, {user}!", "No image", 20.0f);
		AddTextLabel(main_panel, welcome_label, 100, 100);
		
		//adding buttons
		JButton register_button = AddButton(main_panel, "Register Vehicle");
		JButton vehicles_button = AddButton(main_panel, "View Registered Vehicles");
		JButton history_button = AddButton(main_panel, "View Lot History");
		JButton signout_button = AddButton(main_panel, "Sign Out");
		
		SwitchWindow(main_frame, "register vehicle", register_button);
		SwitchWindow(main_frame, "owned vehicles", vehicles_button);
		SwitchWindow(main_frame, "vehicle history", history_button);
		SwitchWindow(main_frame, "login", signout_button);
		//TO GET ADDED:
		//view registered vehicles listener
	}

}
