
import java.util.*;

import java.io.*;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Search_Screen extends JFrame {

	private JPanel contentPane;
	private JTextField IDtextField;

	static ArrayList<Beneficiary_Data> sortedBenList = new ArrayList<Beneficiary_Data>();

	/**
	 * Create the frame.
	 */

	public void searchbtnActionPerformed() {
		int ID = 0;
		try {
			ID = Integer.parseInt(IDtextField.getText());
			binarySearch(sortedBenList, ID);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(rootPane, e);
		}
	}

	public void exitbtnNewButtonactionPerformed() {
		this.dispose();
		Home_Menu.benData();
	}

	public void binarySearch(ArrayList<Beneficiary_Data> benList, int ID) {

        int index = -1;
        int low = 0;
        int high = benList.size() - 1;
        while (low <= high && index == -1) {
            int mid = (low + high) / 2;
            if (benList.get(mid).getID() == ID) {
                index = mid;
            } else if (benList.get(mid).getID() > ID) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (index >= 0) {

            this.setVisible(false);
            Edit_Screen s = new Edit_Screen(index);
            s.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(rootPane, "ID not found");
        }

    }

	// taking the last element as a pivot, places the pivot element at its correct
	// position in sorted array places all elements before or after the pivot
	// depending on whether or not it is larger
	private int partition(ArrayList<Beneficiary_Data> arr, int low, int high) {
		Beneficiary_Data pivot = arr.get(high);
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than the pivot
			if (arr.get(j).getID() < pivot.getID()) {
				i++;

				// swap arr.get(i) and arr.get(j)
				Beneficiary_Data temp = arr.get(i);
				arr.set(i, arr.get(j));
				arr.set(j, temp);
			}
		}

		// swap arr.get(i+1) and arr.get(high) (or pivot)
		Beneficiary_Data temp = arr.get(i + 1);
		arr.set(i + 1, arr.get(high));
		arr.set(high, temp);

		return i + 1;
	}

	public void quickSort(ArrayList<Beneficiary_Data> arr, int low, int high) { // sorting the benList array
		if (low >= high) {
			return; // base case
		}
		if (low < high) {
			/*
			 * pi is partitioning index, arr.get(pi) is now at right place
			 */
			int pi = partition(arr, low, high);

			// Recursively sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}

		sortedBenList = arr;
	}

	public Search_Screen() {

		initComponents();
		quickSort(Home_Menu.benList, 0, Home_Menu.benList.size() - 1);

	}

	private void initComponents() {
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
		IDtextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					searchbtnActionPerformed();
				}
			}
		});
		IDtextField.setBounds(111, 56, 130, 26);
		contentPane.add(IDtextField);
		IDtextField.setColumns(10);

		JButton searchbtn = new JButton("Search");

		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchbtnActionPerformed();
			}
		});
		searchbtn.setBounds(19, 118, 117, 29);
		contentPane.add(searchbtn);

		JButton exitbtnNewButton = new JButton("Exit Search");
		exitbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitbtnNewButtonactionPerformed();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		exitbtnNewButton.setBounds(159, 118, 117, 29);
		contentPane.add(exitbtnNewButton);

		this.setAlwaysOnTop(true);
		setResizable(false);
		this.setAlwaysOnTop(true);
		this.repaint(20);

	}
}
