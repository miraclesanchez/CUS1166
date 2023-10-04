package project;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class OwnedVehiclesView extends JFrame {
	/* Project: Vehicular Cloud
	 * Class: OwnedVehiclesView.class
	 * Author: Daniel Cohen
	 * Date: October 3rd 2023
	 * This program sets up the user interface for vehicle owners to view their registered vehicles
	*/

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable owned_vehicles_table;
	private JLabel heading_label;
	private JButton menu_button;

	public OwnedVehiclesView() {
		
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(450, 300));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Vehicle Lot History");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		frame.pack();
		frame.setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 414, 156);
		contentPane.add(scrollPane);
		
		owned_vehicles_table = new JTable();
		owned_vehicles_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		owned_vehicles_table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"First Name", "Last Name", "Model", "Make", "Year", "Plate #"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		owned_vehicles_table.getColumnModel().getColumn(0).setPreferredWidth(96);
		owned_vehicles_table.getColumnModel().getColumn(1).setPreferredWidth(99);
		owned_vehicles_table.getColumnModel().getColumn(2).setPreferredWidth(98);
		owned_vehicles_table.getColumnModel().getColumn(3).setPreferredWidth(95);
		owned_vehicles_table.getColumnModel().getColumn(4).setPreferredWidth(71);
		owned_vehicles_table.getColumnModel().getColumn(5).setPreferredWidth(97);
		scrollPane.setViewportView(owned_vehicles_table);
		
		heading_label = new JLabel("Registered Vehicles");
		heading_label.setHorizontalAlignment(SwingConstants.CENTER);
		heading_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		heading_label.setBounds(121, 11, 187, 31);
		contentPane.add(heading_label);
		
		menu_button = new JButton("Back");
		menu_button.setBounds(10, 11, 68, 23);
		contentPane.add(menu_button);
		GuiManager.SwitchWindow(frame, "owner menu", menu_button);
	}
}
