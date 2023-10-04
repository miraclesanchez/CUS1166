package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VehicleHistoryView extends JFrame {
	/* Project: Vehicular Cloud
	 * Class: OwnedVehiclesView.class
	 * Author: Daniel Cohen
	 * Date: October 3rd 2023
	 * This program sets up the user interface for vehicle owners to view their vehicles lot/submission history
	*/

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable vehicle_history_table;

	public VehicleHistoryView() {
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
		scrollPane.setBounds(10, 94, 414, 145);
		contentPane.add(scrollPane);

		vehicle_history_table = new JTable();
		vehicle_history_table.setRowSelectionAllowed(false);
		vehicle_history_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		vehicle_history_table.setColumnSelectionAllowed(true);
		vehicle_history_table.setCellSelectionEnabled(true);
		vehicle_history_table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		vehicle_history_table.setFillsViewportHeight(true);
		vehicle_history_table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Submission ID#", "Model", "Make", "Year", "Plate #", "Submitted Date&Time", "Retrieval Date&Time"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		vehicle_history_table.getColumnModel().getColumn(0).setPreferredWidth(105);
		vehicle_history_table.getColumnModel().getColumn(1).setResizable(false);
		vehicle_history_table.getColumnModel().getColumn(1).setPreferredWidth(157);
		vehicle_history_table.getColumnModel().getColumn(2).setResizable(false);
		vehicle_history_table.getColumnModel().getColumn(2).setPreferredWidth(144);
		vehicle_history_table.getColumnModel().getColumn(3).setResizable(false);
		vehicle_history_table.getColumnModel().getColumn(3).setPreferredWidth(91);
		vehicle_history_table.getColumnModel().getColumn(4).setResizable(false);
		vehicle_history_table.getColumnModel().getColumn(4).setPreferredWidth(125);
		vehicle_history_table.getColumnModel().getColumn(5).setResizable(false);
		vehicle_history_table.getColumnModel().getColumn(5).setPreferredWidth(195);
		vehicle_history_table.getColumnModel().getColumn(6).setResizable(false);
		vehicle_history_table.getColumnModel().getColumn(6).setPreferredWidth(178);
		scrollPane.setViewportView(vehicle_history_table);

		JLabel history_label = new JLabel("Vehicle History");
		history_label.setHorizontalAlignment(SwingConstants.CENTER);
		history_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		history_label.setBounds(121, 11, 187, 31);
		contentPane.add(history_label);

		JButton menu_button = new JButton("Back");
		menu_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu_button.setBounds(10, 11, 68, 23);
		contentPane.add(menu_button);
		GuiManager.SwitchWindow(frame, "owner menu", menu_button);
	}
}
