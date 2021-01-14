import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Search_Screen extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search_Screen frame = new Search_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void searchbtnActionPerformed() {
		int ID = 0;
		try {
			 ID = Integer.parseInt(IDtextField.getText());
			 
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(rootPane, e);
		}
		
		public void binarySearch(ArrayList<Beneficiary_Data> benList, ID) {
			int index = -1;
			int low = 0;
			int high = Home_Menu.benList.size()-1;
			while (low <= high && index == -1) {
				int mid = (low + high) / 2;
				if (Home_Menu.benList.get(mid).getID() == ID) {
					index = mid;
				} else if (Home_Menu.benList.get(mid).getID() > ID) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
				
				if (index >= 0) {
					Data_Entry_Screen s = new Data_Entry_Screen(index);
					s.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(rootPane, "Value not found");
				}
			}
		}
		
		
	}
	
	public Search_Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Beneficiary");
		lblNewLabel.setBounds(85, 6, 113, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID:");
		lblNewLabel_1.setBounds(51, 61, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(111, 56, 130, 26);
		contentPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		JButton searchbtn = new JButton("Search");
		
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbtnActionPerformed();
			}
		});
		searchbtn.setBounds(85, 118, 117, 29);
		contentPane.add(searchbtn);
	}

}
