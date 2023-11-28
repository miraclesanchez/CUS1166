package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class IntroGUI extends JFrame{
	
	/* Project: Vehicular Cloud
	 * Class: IntroGUI.java
	 * Author: Miracle Sanchez
	 * Date: September 29, 2023
	 * This class displays the welcome frame and includes buttons to allow the user to log in or register as a new user. The buttons will then lead to new frames that will allow them to enter their information to our CSV file
	 * 
	 */
	
//---------------------------------------------------------------------------------------------------------------------------------//

	
//GLOBAL VARIABLES	
	//Our main frame is a global variable and can be accessed anywhere
	JFrame frame;
	
	//Frames that will be used in this program
	JFrame loginFrame = new JFrame();
	JFrame registerFrame = new JFrame();
	
	//This variable will hold the user type selected by the user (vehicle owner or task owner) and it will affect the login screen or register screen that they see next
	String userType;
	
	SQLConnector sql = new SQLConnector();
	
//---------------------------------------------------------------------------------------------------------------------------------//
	

//This is our main frame which is the first thing that will open. 	
	IntroGUI(){
		// set the title, size and location of our main frame
		this.setTitle("Welcome");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		
		//Create and add lables,buttons, and image to our main frame
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(204, 32, 61, 16);
		getContentPane().add(lblNewLabel);
		
		ImageIcon img = new ImageIcon("images/car.png"); //i changed this so that it works with the images folder -yvonne
		JLabel imageLabel = new JLabel(img);
		imageLabel.setVisible(true);
		imageLabel.setBounds(131, 18, 61, 52);
		getContentPane().add(imageLabel);
		
		JTextArea description = new JTextArea ("Within this program, the user will "
				+ "be able to register a job or vehicle and see the "
				+ "computation time of the job.");
		description.setVisible(true);
		description.setWrapStyleWord(true);
		description.setEditable(false);
		description.setBounds(90,70,250,50);
		description.setLineWrap(true);
		
		getContentPane().add(description);
		
		JButton loginBut = new JButton("Login");
		loginBut.setBounds(60, 130, 117, 29);
		getContentPane().add(loginBut);
		
		JButton registerBut = new JButton("Register");
		registerBut.setBounds(219, 130, 117, 29);
		getContentPane().add(registerBut);
		
		JRadioButton taskOwnerBut = new JRadioButton("Task Owner");
		taskOwnerBut.setBounds(124, 160, 141, 23);
		getContentPane().add(taskOwnerBut);
		taskOwnerBut.setVisible(false);
		
		JRadioButton vehicleOwnerBut = new JRadioButton("Vehicle Owner");
		vehicleOwnerBut.setBounds(124, 200, 141, 23);
		getContentPane().add(vehicleOwnerBut);
		vehicleOwnerBut.setVisible(false);

//--------------------------------------------------------------------------------------------------------------------------------//
		
//Create and add input fields and buttons to our Login Frame
		loginFrame.setSize(400, 300);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.getContentPane().setLayout(null);
		loginFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		
		JLabel username = new JLabel("Client ID:");
		username.setBounds(114, 59, 70, 16);
		loginFrame.getContentPane().add(username);
		
		JLabel password = new JLabel("Password:");
		password.setBounds(114, 102, 70, 16);
		loginFrame.getContentPane().add(password);
		
		JTextField usernametxt = new JTextField();
		usernametxt.setBounds(189, 54, 130, 26);
		loginFrame.getContentPane().add(usernametxt);
		usernametxt.setColumns(10);
		
		JTextField passtxt = new JTextField();
		passtxt.setBounds(189, 97, 130, 26);
		loginFrame.getContentPane().add(passtxt);
		passtxt.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(140, 154, 117, 29);
		loginFrame.getContentPane().add(loginButton);
		
		JButton backBut = new JButton("Back");
		backBut.setBounds(6, 224, 117, 29);
		loginFrame.getContentPane().add(backBut);
		

//--------------------------------------------------------------------------------------------------------------------------------//
		
//Create and add input fields to our registration frame
		registerFrame.setSize(400, 300);
		registerFrame.setLocationRelativeTo(null);
		registerFrame.getContentPane().setLayout(null);
		registerFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		registerFrame.setResizable(false);
		
		JLabel fName = new JLabel("First Name:");
		fName.setBounds(26, 21, 78, 16);
		registerFrame.add(fName);
		
		JLabel lName = new JLabel("Last Name:");
		lName.setBounds(26, 54, 78, 16);
		registerFrame.add(lName);
		
//		JLabel email = new JLabel("Email: ");
//		email.setBounds(26, 92, 64, 16);
//		registerFrame.add(email);
		
		JLabel announcement = new JLabel("UserID must be 10 characters long");
		announcement.setBounds(26, 92, 400, 16);
		registerFrame.add(announcement);
		
		JLabel userID = new JLabel("User ID: ");
		userID.setBounds(26, 132, 61, 16);
		registerFrame.add(userID);
		
		JLabel passwordCreate = new JLabel("Password: ");
		passwordCreate.setBounds(26, 179, 78, 16);
		registerFrame.add(passwordCreate);
	
		JTextField fnameTxt= new JTextField();
		fnameTxt.setBounds(108, 16, 130, 26);
		registerFrame.add(fnameTxt);
		fnameTxt.setColumns(10);
		
		JTextField lNameTxt = new JTextField();
		lNameTxt.setBounds(108, 49, 130, 26);
		registerFrame.add(lNameTxt);
		lNameTxt.setColumns(10);
		
//		JTextField emailTxt = new JTextField();
//		emailTxt.setBounds(108, 87, 130, 26);
//		registerFrame.add(emailTxt);
//		emailTxt.setColumns(10);
		
		JTextField userIDtxt = new JTextField();
		userIDtxt.setBounds(108, 127, 130, 26);
		registerFrame.add(userIDtxt);
		userIDtxt.setColumns(10);
		
		JTextField passwordTxt = new JTextField();
		passwordTxt.setBounds(108, 174, 130, 26);
		registerFrame.add(passwordTxt);
		passwordTxt.setColumns(10);
		
		backBut = new JButton("Back");
		backBut.setBounds(6, 224, 117, 29);
		registerFrame.getContentPane().add(backBut);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(265, 224, 117, 29);
		registerFrame.add(registerButton);

		
//--------------------------------------------------------------------------------------------------------------------------------//

//ACTION LISTENERS//
//When clicking either "register" or "login", the user will be prompted to select whether they are a vehicle owner or a task owner
		loginBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				userType="login";
				vehicleOwnerBut.setVisible(true);
				taskOwnerBut.setVisible(true);
				
			}
		});
		
		//this is the button in the login frame
		registerBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userType="register";
				vehicleOwnerBut.setVisible(true);
				taskOwnerBut.setVisible(true);
			}
		});
		
		//this is the button in the registration frame
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//pull the information from the register frame
				String clientID = userIDtxt.getText();
				String fname = fnameTxt.getText();
				String lname = lNameTxt.getText();
				String password = passwordTxt.getText();
			
				//put info in database
			sql.InsertOwnerData(userType, clientID, fname, lname, password);
				
				
				
				if(userType.equalsIgnoreCase("JobOwner")) {
					registerFrame.setVisible(false);
					JobOwnerView job_view = new JobOwnerView();
				}
				if(userType.equalsIgnoreCase("VehicleOwner")) {
					VehicleOwnerView owner_view=new VehicleOwnerView();
					registerFrame.setVisible(false);
				}
				
				System.out.println(userType);
			}
		});

//Once selecting their role, the frame will switch to the proper frame with their role indicated in the title		
		vehicleOwnerBut.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    if(vehicleOwnerBut.isSelected()&&userType.equalsIgnoreCase("login")) {
		    userType="VehicleOwner";
			setVisible(false);
//			VehicleOwnerView owner_view=new VehicleOwnerView();
			
			loginFrame.setVisible(true); 
			loginFrame.setTitle("Login: Vehicle Owner"); 
			
		}else if(vehicleOwnerBut.isSelected()&&userType.equalsIgnoreCase("register")) {
			userType="VehicleOwner";
			setVisible(false);
			registerFrame.setVisible(true);
			registerFrame.setTitle("Register: Vehicle Owner");
		}
		    }
		});
		
		taskOwnerBut.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 if(taskOwnerBut.isSelected()&&userType.equalsIgnoreCase("login")) {
		 			setVisible(false);
//		 			JobOwnerView job_view = new JobOwnerView();
		 			userType="JobOwner";
		 			loginFrame.setVisible(true);
		 			loginFrame.setTitle("Login: Task Owner");
		 		}else if(taskOwnerBut.isSelected()&&userType.equalsIgnoreCase("register")) {
		 			setVisible(false);
		 			userType="JobOwner";
		 			registerFrame.setVisible(true);
		 			registerFrame.setTitle("Register: Job Owner");
		 		}
		    }
		});
		

		
//This action listener will allow the user to go back to the last frame
		
		backBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(registerFrame.isVisible()) {
					registerFrame.setVisible(false);
//					loginFrame.setVisible(true);
				
				}
				new IntroGUI();
			}
		});
		
		//Adding this just for testing purposes for my GUI
		
//		GuiManager.SetActionListener(loginFrame, "job menu", loginButton);
		//commented this this out in order to skip the log in frame in the meantime
		
//		if(this.isVisible()) {
//			GuiManager.SwitchWindow(frame, "job menu", taskOwnerBut);
//			GuiManager.SwitchWindow(frame, "job menu", vehicleOwnerBut);
//		}
//		
//		if(registerFrame.isVisible()) { //this is not opening menu frame
//			GuiManager.SwitchWindow(registerFrame, "job menu", registerButton);
//		}
		
	
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

//--------------------------------------------------------------------------------------------------------------------------------//
}