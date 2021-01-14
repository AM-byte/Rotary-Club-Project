import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class Timings_Screen extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextField;
	private JTextField badgeNumtextField;
	private JTextField photoINtextField;
	private JTextField fitmenttextField;
	private JTextField approvaltextField;
	private JTextField trainingtextField;
	private JTextField counsellingtextField;
	private JTextField photoOUTtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timings_Screen frame = new Timings_Screen();
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
	public Timings_Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Record for Timings");
		lblNewLabel.setBounds(6, 6, 174, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Number");
		lblNewLabel_1.setBounds(6, 50, 68, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Badge Number");
		lblNewLabel_2.setBounds(6, 100, 91, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Photo-IN Photo Number");
		lblNewLabel_3.setBounds(6, 150, 152, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fitment");
		lblNewLabel_4.setBounds(6, 200, 48, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("P and O Approval");
		lblNewLabel_5.setBounds(6, 250, 108, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Training");
		lblNewLabel_6.setBounds(6, 300, 52, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Counselling");
		lblNewLabel_7.setBounds(6, 350, 75, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Photo-OUT - Photo Number");
		lblNewLabel_8.setBounds(6, 400, 177, 16);
		contentPane.add(lblNewLabel_8);
		
		IDtextField = new JTextField();
		IDtextField.setBounds(6, 62, 130, 26);
		contentPane.add(IDtextField);
		IDtextField.setColumns(10);
		
		badgeNumtextField = new JTextField();
		badgeNumtextField.setBounds(6, 112, 130, 26);
		contentPane.add(badgeNumtextField);
		badgeNumtextField.setColumns(10);
		
		photoINtextField = new JTextField();
		photoINtextField.setBounds(6, 162, 130, 26);
		contentPane.add(photoINtextField);
		photoINtextField.setColumns(10);
		
		fitmenttextField = new JTextField();
		fitmenttextField.setBounds(6, 212, 130, 26);
		contentPane.add(fitmenttextField);
		fitmenttextField.setColumns(10);
		
		approvaltextField = new JTextField();
		approvaltextField.setBounds(6, 262, 130, 26);
		contentPane.add(approvaltextField);
		approvaltextField.setColumns(10);
		
		trainingtextField = new JTextField();
		trainingtextField.setBounds(6, 312, 130, 26);
		contentPane.add(trainingtextField);
		trainingtextField.setColumns(10);
		
		counsellingtextField = new JTextField();
		counsellingtextField.setBounds(6, 362, 130, 26);
		contentPane.add(counsellingtextField);
		counsellingtextField.setColumns(10);
		
		photoOUTtextField = new JTextField();
		photoOUTtextField.setBounds(6, 412, 130, 26);
		contentPane.add(photoOUTtextField);
		photoOUTtextField.setColumns(10);
		
		JButton findbtnNewButton = new JButton("Search");
		findbtnNewButton.setBounds(19, 474, 117, 29);
		contentPane.add(findbtnNewButton);
		
		JButton savebtnNewButton = new JButton("Save");
		savebtnNewButton.setBounds(149, 474, 117, 29);
		contentPane.add(savebtnNewButton);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
