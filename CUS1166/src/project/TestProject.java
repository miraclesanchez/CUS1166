package project;

import java.awt.EventQueue;

public class TestProject {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
//		IntroGUI login = new IntroGUI();
//		RegisterVehicleView d = new RegisterVehicleView();
		VehicleOwnerView d = new VehicleOwnerView();
		
	        }
		});
	}
}
	
