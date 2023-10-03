package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import project.GuiManager;

public class IntroGUI extends JFrame{
	
	/* Project: Vehicular Cloud
	 * Class: IntroGUI.java
	 * Author: Miracle Sanchez
	 * Date: September 29, 2023
	 * This class displays the welcome frame and includes buttons to allow the user to log in or register as a new user. The buttons 	   will then lead to new frames that will allow them to enter their information to our CSV file
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
		lblNewLabel.setBounds(143, 30, 61, 16);
		getContentPane().add(lblNewLabel);
		
		ImageIcon img = new ImageIcon("images/car.png"); //i changed this so that it works with the images folder -yvonne
		JLabel imageLabel = new JLabel(img);
		imageLabel.setVisible(true);
		imageLabel.setBounds(204, 16, 61, 52);
		getContentPane().add(imageLabel);
		
		JButton loginBut = new JButton("Login");
		loginBut.setBounds(60, 94, 117, 29);
		getContentPane().add(loginBut);
		
		JButton registerBut = new JButton("Register");
		registerBut.setBounds(219, 94, 117, 29);
		getContentPane().add(registerBut);
		
		JRadioButton taskOwnerBut = new JRadioButton("Task Owner");
		taskOwnerBut.setBounds(124, 147, 141, 23);
		getContentPane().add(taskOwnerBut);
		taskOwnerBut.setVisible(false);
		
		JRadioButton vehicleOwnerBut = new JRadioButton("Vehicle Owner");
		vehicleOwnerBut.setBounds(124, 182, 141, 23);
		getContentPane().add(vehicleOwnerBut);
		vehicleOwnerBut.setVisible(false);

//--------------------------------------------------------------------------------------------------------------------------------//
		
//Create and add input fields and buttons to our Login Frame
		loginFrame.setSize(400, 300);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.getContentPane().setLayout(null);
		loginFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		
		JLabel username = new JLabel("Username:");
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
		
		registerBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userType="register";
				vehicleOwnerBut.setVisible(true);
				taskOwnerBut.setVisible(true);
				
			}
		});

//Once selecting their role, the frame will switch to the proper frame with their role indicated in the title		
		vehicleOwnerBut.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    if(vehicleOwnerBut.isSelected()&&userType.equalsIgnoreCase("login")) {
			setVisible(false);
			loginFrame.setVisible(true);
			loginFrame.setTitle("Login: Vehicle Owner");
		}else if(vehicleOwnerBut.isSelected()&&userType.equalsIgnoreCase("register")) {
			setVisible(false);
			registerFrame.setVisible(true);
		}
		    }
		});
		
		taskOwnerBut.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 if(taskOwnerBut.isSelected()&&userType.equalsIgnoreCase("login")) {
		 			setVisible(false);
		 			loginFrame.setVisible(true);
		 			loginFrame.setTitle("Login: Task Owner");
		 		}else if(taskOwnerBut.isSelected()&&userType.equalsIgnoreCase("register")) {
		 			setVisible(false);
		 			registerFrame.setVisible(true);
		 		}
		    }
		});
		

		
//This action listener will allow the user to go to the next frame and register
		backBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(false);
				new IntroGUI();
			}
		});
		
		//Adding this just for testing purposes for my GUI
		GuiManager.SetActionListener(loginFrame, "job menu", loginButton);
	
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

//--------------------------------------------------------------------------------------------------------------------------------//
}