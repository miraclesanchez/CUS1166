package project;

import java.awt.EventQueue;

public class TestProject {

	public static void main(String[] args) {
		//Allows components to properly load.
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
				//IntroGUI login = new IntroGUI();
				//RegisterVehicleView d = new RegisterVehicleView();
				//VehicleOwnerView d = new VehicleOwnerView();
	        	ViewSubmissions a = new ViewSubmissions();
	        }
		});
	}
}
	
