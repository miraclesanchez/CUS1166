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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
//	private JTextField first_name_input;
//	private JTextField last_name_input;
	private JTextField clientID_input;
	private JTextField make_input;
	private JTextField plate_input;
	private JTextField model_input;
	private JTextField year_input;
	private JTextField residency_input;
	private JTextField vehicle_ID_input;

	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;

	public RegisterVehicleView() {
		
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(500, 400));
		frame.setSize(400, 300);
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
		
		
		JLabel clientID = new JLabel("Client ID: ");
		clientID.setFont(new Font("Tahoma", Font.PLAIN, 10));
		clientID.setHorizontalAlignment(SwingConstants.CENTER);
		clientID.setBounds(10, 98, 151, 14);
		contentPane.add(clientID);
		
//		JLabel fname_label = new JLabel("First Name");
//		fname_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
//		fname_label.setHorizontalAlignment(SwingConstants.CENTER);
//		fname_label.setBounds(10, 98, 151, 14);
//		contentPane.add(fname_label);
//		
//		JLabel lname_label = new JLabel("Last Name");
//		lname_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
//		lname_label.setHorizontalAlignment(SwingConstants.CENTER);
//		lname_label.setBounds(323, 98, 151, 14);
//		contentPane.add(lname_label);
		
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
		
		clientID_input = new JTextField();
		clientID_input.setHorizontalAlignment(SwingConstants.CENTER);
		clientID_input.setBounds(10, 123, 151, 20);
		contentPane.add(clientID_input);
		clientID_input.setColumns(10);
		
//		first_name_input = new JTextField();
//		first_name_input.setHorizontalAlignment(SwingConstants.CENTER);
//		first_name_input.setBounds(10, 123, 151, 20);
//		contentPane.add(first_name_input);
//		first_name_input.setColumns(10);
//		
//		last_name_input = new JTextField();
//		last_name_input.setHorizontalAlignment(SwingConstants.CENTER);
//		last_name_input.setBounds(323, 123, 151, 20);
//		contentPane.add(last_name_input);
//		last_name_input.setColumns(10);
		
		JLabel register_label = new JLabel("Register Vehicle");
		register_label.setHorizontalAlignment(SwingConstants.CENTER);
		register_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		register_label.setBounds(140, 11, 200, 40);
		contentPane.add(register_label);
		
		make_input = new JTextField();
		make_input.setColumns(10);
		make_input.setBounds(20, 226, 89, 20);
		contentPane.add(make_input);
		
		plate_input = new JTextField();
		plate_input.setColumns(10);
		plate_input.setBounds(354, 226, 89, 20);
		contentPane.add(plate_input);
		
		model_input = new JTextField();
		model_input.setColumns(10);
		model_input.setBounds(136, 226, 89, 20);
		contentPane.add(model_input);
		
		year_input = new JTextField();
		year_input.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (year_input.getText().equals("YYYY")) {
					year_input.setText("");
				}
			}
		});
		
		year_input.setHorizontalAlignment(SwingConstants.CENTER);
		year_input.setText("YYYY");
		year_input.setColumns(10);
		year_input.setBounds(259, 226, 46, 20);
		contentPane.add(year_input);
		
		JButton exit_button = new JButton("Exit");
		exit_button.setBounds(333, 327, 89, 23);
		contentPane.add(exit_button);
		//Returns to vehicle owner menu
		GuiManager.SwitchWindow(frame, "owner menu", exit_button);
		
		residency_input = new JTextField();
		residency_input.setColumns(10);
		residency_input.setBounds(20, 285, 89, 20);
		contentPane.add(residency_input);
		
		JLabel residency_label = new JLabel("Expected Residency (hours)");
		residency_label.setHorizontalAlignment(SwingConstants.CENTER);
		residency_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		residency_label.setBounds(20, 259, 126, 23);
		contentPane.add(residency_label);
		
		vehicle_ID_input = new JTextField();
		vehicle_ID_input.setHorizontalAlignment(SwingConstants.CENTER);
		vehicle_ID_input.setColumns(10);
		vehicle_ID_input.setBounds(179, 285, 62, 20);
		contentPane.add(vehicle_ID_input);
		
		JLabel vehicle_ID_label = new JLabel("ID");
		vehicle_ID_label.setHorizontalAlignment(SwingConstants.CENTER);
		vehicle_ID_label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		vehicle_ID_label.setBounds(179, 263, 62, 14);
		contentPane.add(vehicle_ID_label);
		JButton register_button = new JButton("Register");
		register_button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		//Method to write text in input fields to a file.
		register_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Only writes if all text fields contain an input
				if (
//						(first_name_input.getText().equals("")) || 
//						(last_name_input.getText().equals("")) ||
						clientID_input.getText().equals("")||
						(make_input.getText().equals("")) ||
						(model_input.getText().equals("")) ||
						(year_input.getText().equals("")) ||
						(plate_input.getText().equals("")) ||
						(vehicle_ID_input.getText().equals("")) ||
						(residency_input.getText().equals(""))
					) {
					JOptionPane.showMessageDialog(null, "Required Field Empty", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				//Clears text fields and displays message letting user know that they registered their vehicle
				else {
//					String first_name = first_name_input.getText();
//					String last_name = last_name_input.getText();
					String clientID = clientID_input.getText();
					String vehicle_make = make_input.getText();
					String vehicle_model = model_input.getText();
					String year_text = year_input.getText();
					int vehicle_year = Integer.parseInt(year_text);
					String vehicle_ID_text = vehicle_ID_input.getText();
					int vehicle_ID = Integer.parseInt(vehicle_ID_text);
					String license_plate = plate_input.getText();
					String residency_text = residency_input.getText();
					Vehicle vehicle = new Vehicle(clientID,vehicle_model, vehicle_make, vehicle_year, vehicle_ID, license_plate, residency_text);
					//client connecting to server
					connectVehicleOwner(vehicle, "hello", "hello", clientID);
					
					
//					first_name_input.setText("");
//					last_name_input.setText("");
					clientID_input.setText("");
					model_input.setText("");
					make_input.setText("");
					year_input.setText("YYYY");
					plate_input.setText("");
					residency_input.setText("");
					vehicle_ID_input.setText("");
				}
			}
		});
		register_button.setBounds(72, 327, 89, 23);
		contentPane.add(register_button);
		
		
	}
	
	public static void connectVehicleOwner(Vehicle vehicle, String fname, String lname,String clientID) {
		String messageIn = "";
		
		try {

			//connect the client socket to vcc
			Socket socket = new Socket("localhost", 9805);
			
			
			// client reads a message from vcc
			inputStream = new DataInputStream(socket.getInputStream());
			// client sends object to vcc
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			
			// notify vcc that user is registering a vehicle
			String vcc_choice = "vehicle";
			
			// client sends vehicle registration info to vcc
			oos.writeObject(vcc_choice);
			oos.writeObject(fname);
			oos.writeObject(lname);
			oos.writeObject(vehicle);
			
	        // read vcc messages until vcc notifies client "data received"
			while (!messageIn.equals("data received")) {
				messageIn = inputStream.readUTF();	
			}
			
			// close socket connection and streams
			System.out.println("data received");
			System.out.println("closing client connection");	
			socket.close();
			inputStream.close();
			oos.close();

		} catch (Exception e) {
			
			e.printStackTrace();

		}
	}
}