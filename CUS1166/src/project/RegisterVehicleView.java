package project;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RegisterVehicleView extends JFrame {
	/* Project: Vehicular Cloud
	 * Class: RegisterVehicleView.class
	 * Author: Daniel Cohen
	 * Date: October 2nd 2023
	 * This program sets up the user interface for vehicle owners to register their vehicles
	*/
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField first_name;
	private JTextField last_name;
	private JTextField make;
	private JTextField plate;
	private JTextField model;
	private JTextField year;
	private JTextField residency;

	public RegisterVehicleView() {
		
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 400));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Register Vehicle");
		
		
		setTitle("Register Vehicle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		frame.getContentPane().add(contentPane);
		frame.pack();
		frame.setVisible(true);
		
		JLabel fname_label = new JLabel("First Name");
		fname_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fname_label.setHorizontalAlignment(SwingConstants.CENTER);
		fname_label.setBounds(10, 98, 151, 14);
		contentPane.add(fname_label);
		
		JLabel lname_label = new JLabel("Last Name");
		lname_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lname_label.setHorizontalAlignment(SwingConstants.CENTER);
		lname_label.setBounds(323, 98, 151, 14);
		contentPane.add(lname_label);
		
		JLabel model_label = new JLabel("Model");
		model_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		model_label.setHorizontalAlignment(SwingConstants.CENTER);
		model_label.setBounds(136, 201, 89, 14);
		contentPane.add(model_label);
		
		JLabel make_label = new JLabel("Make");
		make_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		make_label.setHorizontalAlignment(SwingConstants.CENTER);
		make_label.setBounds(20, 201, 89, 14);
		contentPane.add(make_label);
		
		JLabel year_label = new JLabel("Year");
		year_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		year_label.setHorizontalAlignment(SwingConstants.CENTER);
		year_label.setBounds(259, 201, 46, 14);
		contentPane.add(year_label);
		
		JLabel plate_label = new JLabel("License Plate");
		plate_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		plate_label.setHorizontalAlignment(SwingConstants.CENTER);
		plate_label.setBounds(354, 201, 89, 14);
		contentPane.add(plate_label);
		
		JLabel owner_label = new JLabel("Vehicle Owner");
		owner_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		owner_label.setHorizontalAlignment(SwingConstants.CENTER);
		owner_label.setBounds(140, 62, 200, 14);
		contentPane.add(owner_label);
		
		JLabel description_label = new JLabel("Vehicle Description");
		description_label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		description_label.setHorizontalAlignment(SwingConstants.CENTER);
		description_label.setBounds(140, 165, 200, 14);
		contentPane.add(description_label);
		
		first_name = new JTextField();
		first_name.setHorizontalAlignment(SwingConstants.CENTER);
		first_name.setBounds(10, 123, 151, 20);
		contentPane.add(first_name);
		first_name.setColumns(10);
		
		last_name = new JTextField();
		last_name.setHorizontalAlignment(SwingConstants.CENTER);
		last_name.setBounds(323, 123, 151, 20);
		contentPane.add(last_name);
		last_name.setColumns(10);
		
		JLabel register_label = new JLabel("Register Vehicle");
		register_label.setHorizontalAlignment(SwingConstants.CENTER);
		register_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		register_label.setBounds(140, 11, 200, 40);
		contentPane.add(register_label);
		
		make = new JTextField();
		make.setColumns(10);
		make.setBounds(20, 226, 89, 20);
		contentPane.add(make);
		
		plate = new JTextField();
		plate.setColumns(10);
		plate.setBounds(354, 226, 89, 20);
		contentPane.add(plate);
		
		model = new JTextField();
		model.setColumns(10);
		model.setBounds(136, 226, 89, 20);
		contentPane.add(model);
		
		year = new JTextField();
		year.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (year.getText().equals("YYYY")) {
					year.setText("");
				}
			}
		});
		year.setHorizontalAlignment(SwingConstants.CENTER);
		year.setText("YYYY");
		year.setColumns(10);
		year.setBounds(259, 226, 46, 20);
		contentPane.add(year);
		
		
		JButton register_button = new JButton("Register");
		register_button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		//Method to write text in input fields to a file.
		register_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Only writes if all text fields contain an input
				if (
						(first_name.getText().equals("")) || 
						(last_name.getText().equals("")) ||
						(make.getText().equals("")) ||
						(model.getText().equals("")) ||
						(year.getText().equals("")) ||
						(plate.getText().equals("")) ||
						(residency.getText().equals(""))
					) {
					JOptionPane.showMessageDialog(null, "Required Field Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				//Clears text fields and displays message letting user know that they registered their vehicle
				else {
					String first_name_text = first_name.getText();
					String last_name_text = last_name.getText();
					String make_text = make.getText();
					String model_text = model.getText();
					String year_text = year.getText();
					String plate_text = plate.getText();
					String residency_text = residency.getText();
					Vehicle vehicle = new Vehicle(first_name_text, last_name_text, make_text, model_text, year_text, plate_text, residency_text);
					vehicle.saveVehicle("VehicleRegistry");
					JOptionPane.showMessageDialog(null, "Vehicle Successfully Registered", "Success!", JOptionPane.PLAIN_MESSAGE);
					first_name.setText("");
					last_name.setText("");
					model.setText("");
					make.setText("");
					year.setText("YYYY");
					plate.setText("");
					residency.setText("");
					//TO GET ADDED:
					//Write input from text fields to file
				}
			}
		});
		register_button.setBounds(72, 327, 89, 23);
		contentPane.add(register_button);
		
		JButton exit_button = new JButton("Exit");
		exit_button.setBounds(333, 327, 89, 23);
		contentPane.add(exit_button);
		//Returns to vehicle owner menu
		GuiManager.SwitchWindow(frame, "owner menu", exit_button);
		
		residency = new JTextField();
		residency.setColumns(10);
		residency.setBounds(20, 285, 89, 20);
		contentPane.add(residency);
		
		JLabel residency_label = new JLabel("Expected Residency (hours)");
		residency_label.setHorizontalAlignment(SwingConstants.CENTER);
		residency_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		residency_label.setBounds(20, 259, 126, 23);
		contentPane.add(residency_label);
	}
}