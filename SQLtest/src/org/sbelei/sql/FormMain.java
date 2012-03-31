package org.sbelei.sql;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumn;

public class FormMain {

	private JFrame frame;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTable table;
	
	private AccessDataManager adm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMain window = new FormMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormMain() {
		initialize();
		adm = new AccessDataManager();
		try { 
			adm.initConnection();
			ResultSet rs = adm.select("SELECT * FROM Employees");
			String[] headers;
			headers = adm.composeHeaders(rs);
			for (int i=0;i<headers.length;i++){
				TableColumn newCol =new TableColumn();
				newCol.setHeaderValue(headers[i]);
				table.addColumn(newCol);
			}
			table.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane);
		
		textField = new JTextField();
		splitPane.setLeftComponent(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
