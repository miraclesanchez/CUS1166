package project;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextPane;

public class VehicleCloudController extends GuiManager implements Runnable {
	
	int redundancy;
	int id_counter;
	static Queue <Job> jobQueue = new LinkedList<>();
	static ArrayList <Integer> jobID = new ArrayList <>();
	static ArrayList <Integer> jobDuration = new ArrayList <>();
	static int job_int;	
	static int job_dur;
	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;
		
	public VehicleCloudController() {
		
//		
//		JLabel titleLabel = new JLabel("VCC: Job Submission Authorization");
//		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		titleLabel.setBounds(80, 11, 222, 30);
//		frame.getContentPane().add(titleLabel);
//		
//		JButton acceptButton = new JButton("Accept");
//		acceptButton.setBounds(41, 205, 89, 23);
//		frame.getContentPane().add(acceptButton);
//		
//		JButton decline_button = new JButton("Decline");
//		decline_button.setBounds(249, 205, 89, 23);
//		frame.getContentPane().add(decline_button);
//		
//		JLabel lblNewLabel = new JLabel("The following job has been submitted:");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		lblNewLabel.setBounds(41, 52, 237, 23);
//		frame.getContentPane().add(lblNewLabel);
//		
//		JLabel id_label = new JLabel("Job ID:");
//		id_label.setVerticalAlignment(SwingConstants.TOP);
//		id_label.setBounds(41, 90, 115, 14);
//		frame.getContentPane().add(id_label);
//		
//		JLabel client_name_label = new JLabel("Client Name:");
//		client_name_label.setBounds(41, 115, 115, 14);
//		frame.getContentPane().add(client_name_label);
//		
//		JLabel durration_label = new JLabel("Job Durration:");
//		durration_label.setBounds(41, 140, 115, 14);
//		frame.getContentPane().add(durration_label);
//		
//		JLabel deadline_label = new JLabel("Job Deadline:");
//		deadline_label.setBounds(41, 165, 115, 14);
//		frame.getContentPane().add(deadline_label);
//		
//		JLabel submitted_id_label = new JLabel("USER ID HERE");
//		submitted_id_label.setVerticalAlignment(SwingConstants.TOP);
//		submitted_id_label.setBounds(166, 90, 172, 14);
//		frame.getContentPane().add(submitted_id_label);
//		
//		JLabel submitted_name_label = new JLabel("USER NAME HERE");
//		submitted_name_label.setVerticalAlignment(SwingConstants.TOP);
//		submitted_name_label.setBounds(166, 115, 172, 14);
//		frame.getContentPane().add(submitted_name_label);
//		
//		JLabel submitted_durration_label = new JLabel("USER DURR HERE");
//		submitted_durration_label.setVerticalAlignment(SwingConstants.TOP);
//		submitted_durration_label.setBounds(166, 140, 172, 14);
//		frame.getContentPane().add(submitted_durration_label);
//		
//		JLabel submitted_deadline_label = new JLabel("USER DEADLINE HERE");
//		submitted_deadline_label.setVerticalAlignment(SwingConstants.TOP);
//		submitted_deadline_label.setBounds(166, 165, 172, 14);
//		frame.getContentPane().add(submitted_deadline_label);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JButton computeBut = new JButton("Computation");
//		computeBut.setBounds(95, 80, 201, 36);
//		frame.getContentPane().add(computeBut);
//		
//		JButton jauthBut = new JButton("Authorize Job Submissions");
//		jauthBut.setBounds(95, 129, 201, 36);
//		frame.getContentPane().add(jauthBut);
//		
//		JButton vauthBut = new JButton("Authorize Vehicle Registrations");
//		vauthBut.setBounds(95, 179, 201, 36);
//		frame.getContentPane().add(vauthBut);
//		
//		JLabel vccMenuLabel = new JLabel("VCC Menu");
//		vccMenuLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		vccMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		vccMenuLabel.setBounds(95, 11, 201, 36);
//		frame.getContentPane().add(vccMenuLabel);
//		
//		
//		computeBut.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        // Call the completionTime method to calculate completion times
//		        ArrayList <Integer> jobDur = populateJobDur();
//		        ArrayList <Integer> jobID = populateJobID();
//		         ArrayList <Integer> completion_time=completionTime();
//		         
//		         // Create strings for Job ID and Job Duration
//		        String jobIDString = "Job ID: " + jobID.toString();
//		        String jobDurationString = "Job Duration: " + jobDur.toString();
//
//		        // Create a string for Completion Time
//		        String completionTimeString = "Completion Time: " + completion_time.toString();
//
//		        // Display the information in a JOptionPane message
//		        JOptionPane.showMessageDialog(null, jobIDString + "\n" + jobDurationString + "\n" + completionTimeString);
//		    }
//		});
	}
	
	public static void registerJob(Job job) {
		jobQueue.add(job);
		
	}
	
	public static ArrayList<Integer> completionTime() {
		
		ArrayList <Integer> completion_time = new ArrayList <>();
		
		int currentCompletionTime = 0;
		for (int duration: jobDuration) {
			currentCompletionTime += duration;
			completion_time.add(currentCompletionTime);
		}
		
		return completion_time;
	
		
	}
	
	public static ArrayList <Integer> populateJobID() {
		for (Job job : jobQueue) {
			int jobI = job.getID();
			jobID.add(jobI);
		}
		return jobID;
	}
	

	public static ArrayList<Integer> populateJobDur() {
		for (Job job : jobQueue) {
			int jobI = job.getDuration();
			jobDuration.add(jobI);
		}
		return jobDuration;
	}
	
	public static void authroizeJobs() {
		
		
	}
	
	public static void authorizeVehicles() {
		
	}
	
	public static void vccFrame() {
		JFrame frame=new JFrame();
		frame.setTitle("Vehicle Cloud Controller");
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton computeBut = new JButton("Computation");
		computeBut.setBounds(95, 80, 201, 36);
		frame.getContentPane().add(computeBut);
		
		JButton menu_button = new JButton("Return to Menu");
		menu_button.setBounds(95, 129, 201, 36);
		frame.getContentPane().add(menu_button);
		
		JLabel vccMenuLabel = new JLabel("VCC Menu");
		vccMenuLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vccMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vccMenuLabel.setBounds(95, 11, 201, 36);
		frame.getContentPane().add(vccMenuLabel);
		
		SwitchWindow(frame, "job menu", menu_button);
		
		
		computeBut.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Call the completionTime method to calculate completion times
		        ArrayList <Integer> jobDur = populateJobDur();
		        ArrayList <Integer> jobID = populateJobID();
		         ArrayList <Integer> completion_time=completionTime();
		         
		         // Create strings for Job ID and Job Duration
		        String jobIDString = "Job ID: " + jobID.toString();
		        String jobDurationString = "Job Duration: " + jobDur.toString();

		        // Create a string for Completion Time
		        String completionTimeString = "Completion Time: " + completion_time.toString();

		        // Display the information in a JOptionPane message
		        JOptionPane.showMessageDialog(null, jobIDString + "\n" + jobDurationString + "\n" + completionTimeString);
		    }
		});
	}

	@Override
	public void run() {
		String messageIn = "";
		
		try {

			System.out.println("----------$$$ This is server side $$$--------");
			System.out.println("wating for client to connect...");
			// creating the server
			serverSocket = new ServerSocket(9805);
			// sever accepts connection request from client
			while (true) {
				socket = serverSocket.accept();
				socket.getRemoteSocketAddress();
				System.out.println("client is connected!");
				System.out.println("go to client side and send me a message");
	
				// server sends a message to client
				outputStream = new DataOutputStream(socket.getOutputStream());
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				messageIn = ois.readObject().toString();
				System.out.print(messageIn);
				
				if (messageIn.equals("Job")) {	
					Job job = (Job)ois.readObject();
					System.out.print(job.getID());
					outputStream.writeUTF("data received");
					
					String job_id = Integer.toString(job.getID());
					String job_name = job.getName();
					String job_durration = Integer.toString(job.getDuration());
					String job_deadline = job.getDeadline();
					
					JFrame frame=new JFrame();
					frame.setTitle("Vehicle Cloud Controller");
					frame.setSize(400, 300);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.getContentPane().setLayout(null);
					
					JLabel titleLabel = new JLabel("VCC: Job Submission Authorization");
					titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
					titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
					titleLabel.setBounds(80, 11, 222, 30);
					frame.getContentPane().add(titleLabel);
					
					JButton acceptButton = new JButton("Accept");
					acceptButton.setBounds(41, 205, 89, 23);
					frame.getContentPane().add(acceptButton);
					
					JButton decline_button = new JButton("Decline");
					decline_button.setBounds(249, 205, 89, 23);
					frame.getContentPane().add(decline_button);
					
					JLabel lblNewLabel = new JLabel("The following job has been requested:");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblNewLabel.setBounds(41, 52, 237, 23);
					frame.getContentPane().add(lblNewLabel);
					
					JLabel id_label = new JLabel("Job ID:");
					id_label.setVerticalAlignment(SwingConstants.TOP);
					id_label.setBounds(41, 90, 115, 14);
					frame.getContentPane().add(id_label);
					
					JLabel client_name_label = new JLabel("Client Name:");
					client_name_label.setBounds(41, 115, 115, 14);
					frame.getContentPane().add(client_name_label);
					
					JLabel durration_label = new JLabel("Job Durration:");
					durration_label.setBounds(41, 140, 115, 14);
					frame.getContentPane().add(durration_label);
					
					JLabel deadline_label = new JLabel("Job Deadline:");
					deadline_label.setBounds(41, 165, 115, 14);
					frame.getContentPane().add(deadline_label);
					
					JLabel submitted_id_label = new JLabel(job_id);
					submitted_id_label.setVerticalAlignment(SwingConstants.TOP);
					submitted_id_label.setBounds(166, 90, 172, 14);
					frame.getContentPane().add(submitted_id_label);
					
					JLabel submitted_name_label = new JLabel(job_name);
					submitted_name_label.setVerticalAlignment(SwingConstants.TOP);
					submitted_name_label.setBounds(166, 115, 172, 14);
					frame.getContentPane().add(submitted_name_label);
					
					JLabel submitted_durration_label = new JLabel(job_durration + " hour(s)");
					submitted_durration_label.setVerticalAlignment(SwingConstants.TOP);
					submitted_durration_label.setBounds(166, 140, 172, 14);
					frame.getContentPane().add(submitted_durration_label);
					
					JLabel submitted_deadline_label = new JLabel(job_deadline);
					submitted_deadline_label.setVerticalAlignment(SwingConstants.TOP);
					submitted_deadline_label.setBounds(166, 165, 172, 14);
					frame.getContentPane().add(submitted_deadline_label);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					acceptButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							job.saveJob("JobSubmissions");
							VehicleCloudController.registerJob(job);
							frame.dispose();
							JOptionPane.showMessageDialog(null, "Job Successfully submitted!", "Success!", JOptionPane.PLAIN_MESSAGE);
						}
					});
					decline_button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
						}
					});	
			        
				
				}
				else {
					String fname = ois.readObject().toString();
					String lname = ois.readObject().toString();
					Vehicle vehicle = (Vehicle)ois.readObject();
					outputStream.writeUTF("data received");
					
					JFrame frame=new JFrame();
					frame.setTitle("Vehicle Cloud Controller");
					frame.setSize(400, 400);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.getContentPane().setLayout(null);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					JLabel titleLabel = new JLabel("VCC: Vehicle Registration Authorization");
					titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
					titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
					titleLabel.setBounds(58, 11, 255, 30);
					frame.getContentPane().add(titleLabel);
					
					JButton acceptButton = new JButton("Accept");
					acceptButton.setBounds(41, 311, 89, 23);
					frame.getContentPane().add(acceptButton);
					
					JButton decline_button = new JButton("Decline");
					decline_button.setBounds(249, 311, 89, 23);
					frame.getContentPane().add(decline_button);
					
					JLabel lblNewLabel = new JLabel("The following vehicle has been requested:");
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblNewLabel.setBounds(41, 52, 286, 23);
					frame.getContentPane().add(lblNewLabel);
					
					JLabel fname_label = new JLabel("First Name:");
					fname_label.setVerticalAlignment(SwingConstants.TOP);
					fname_label.setBounds(41, 90, 115, 14);
					frame.getContentPane().add(fname_label);
					
					JLabel lname_label = new JLabel("Last Name:");
					lname_label.setBounds(41, 115, 115, 14);
					frame.getContentPane().add(lname_label);
					
					JLabel make_label = new JLabel("Make:");
					make_label.setBounds(41, 140, 115, 14);
					frame.getContentPane().add(make_label);
					
					JLabel deadline_label = new JLabel("Model:");
					deadline_label.setBounds(41, 165, 115, 14);
					frame.getContentPane().add(deadline_label);
					
					JLabel year_label = new JLabel("Year:");
					year_label.setBounds(41, 190, 115, 14);
					frame.getContentPane().add(year_label);
					
					JLabel id_label = new JLabel("Vehicle ID:");
					id_label.setBounds(41, 215, 115, 14);
					frame.getContentPane().add(id_label);
					
					JLabel plate_label = new JLabel("License Plate:");
					plate_label.setBounds(41, 240, 115, 14);
					frame.getContentPane().add(plate_label);
					
					JLabel residency_label = new JLabel("Residency:");
					residency_label.setBounds(41, 265, 115, 14);
					frame.getContentPane().add(residency_label);
					
					JLabel submitted_fname_label = new JLabel(fname);
					submitted_fname_label.setBounds(223, 90, 115, 14);
					frame.getContentPane().add(submitted_fname_label);
					
					JLabel submitted_lname_label = new JLabel(lname);
					submitted_lname_label.setBounds(223, 115, 115, 14);
					frame.getContentPane().add(submitted_lname_label);
					
					JLabel submitted_make_label = new JLabel(vehicle.getMake());
					submitted_make_label.setBounds(223, 140, 115, 14);
					frame.getContentPane().add(submitted_make_label);
					
					JLabel submitted_model_label = new JLabel(vehicle.getModel());
					submitted_model_label.setBounds(223, 165, 115, 14);
					frame.getContentPane().add(submitted_model_label);
					
					JLabel submitted_year_label = new JLabel(Integer.toString(vehicle.getYear()));
					submitted_year_label.setBounds(223, 190, 115, 14);
					frame.getContentPane().add(submitted_year_label);
					
					JLabel submitted_id_label = new JLabel(Integer.toString(vehicle.getVehicleId()));
					submitted_id_label.setBounds(223, 215, 115, 14);
					frame.getContentPane().add(submitted_id_label);
					
					JLabel submitted_plate_label = new JLabel(vehicle.getLicense());
					submitted_plate_label.setBounds(223, 240, 115, 14);
					frame.getContentPane().add(submitted_plate_label);
					
					JLabel submitted_residency_label = new JLabel(vehicle.getResidency());
					submitted_residency_label.setBounds(223, 265, 115, 14);
					frame.getContentPane().add(submitted_residency_label);
					
					acceptButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							vehicle.registerVehicle("VehicleRegistry", fname, lname);
							frame.dispose();
							JOptionPane.showMessageDialog(null, "Vehicle Successfully Registered", "Success!", JOptionPane.PLAIN_MESSAGE);
						}
					});
					decline_button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
						}
					});	
				}
//			}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
}



