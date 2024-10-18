package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
	
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		UserFrame frame = new UserFrame();
		frame.setVisible(true);
		frame.loadTable();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Laundry Apps");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(0, 64, 128));
		lblNewLabel.setBounds(154, 23, 113, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("PESANAN");
		btnNewButton.setBounds(50, 90, 100, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PESANAN");
		btnNewButton_1.setBounds(167, 90, 100, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("PESANAN");
		btnNewButton_2.setBounds(291, 90, 100, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("PESANAN");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(50, 150, 100, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("PESANAN");
		btnNewButton_4.setBounds(167, 150, 100, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("PESANAN");
		btnNewButton_5.setBounds(291, 150, 100, 40);
		contentPane.add(btnNewButton_5);
		
		JButton btnKeluar = new JButton("KELUAR");
		btnKeluar.setBounds(50, 200, 341, 33);
		contentPane.add(btnKeluar);
		
		
	}
	
}
