package project;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VehicleCloudController {
	
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
		
		JButton jauthBut = new JButton("Authorize Job Submissions");
		jauthBut.setBounds(95, 129, 201, 36);
		frame.getContentPane().add(jauthBut);
		
		JButton vauthBut = new JButton("Authorize Vehicle Registrations");
		vauthBut.setBounds(95, 179, 201, 36);
		frame.getContentPane().add(vauthBut);
		
		JLabel vccMenuLabel = new JLabel("VCC Menu");
		vccMenuLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		vccMenuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vccMenuLabel.setBounds(95, 11, 201, 36);
		frame.getContentPane().add(vccMenuLabel);
		
		
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
	}


