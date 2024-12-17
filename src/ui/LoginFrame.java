package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import error.ValidationException;
import model.User;
import service.LoginService;
import util.ValidationUtil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Laundry Apps");
		lblNewLabel.setBounds(171, 10, 94, 20);
		lblNewLabel.setForeground(new Color(64, 128, 128));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(114, 94, 199, 28);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(114, 132, 199, 28);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Masukkan data Anda");
		lblNewLabel_1.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		lblNewLabel_1.setBounds(94, 40, 248, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(User.login(txtUsername.getText(), txtPassword.getText())) {
					JOptionPane.showMessageDialog(null,  "Yeyy berhasil login");
//					cara 1 : pindah dari login ke main frame
					MainFrame mf = new MainFrame();
					mf.setVisible(true);
					dispose();
					
//					cara 2 : pindah dari login ke main frame
					new MainFrame().setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Login Gagal");
				}
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 12));
		btnNewButton.setBounds(171, 178, 85, 21);
		contentPane.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		String userValue = txtUsername.getText();
		String passValue = txtPassword.getText();

		// Create user object
		User user = new User(userValue, passValue);

		try {
			ValidationUtil.validate(user);
			LoginService loginService = new LoginService();
			if (loginService.authenticate(user)) {
				System.out.println("Login successful!");
				new MainFrame().setVisible(true);
				dispose();
			} else {
				System.out.println("Invalid username or password.");
				JOptionPane.showMessageDialog(null, "Login Gagal, Invalid username or password.");
			}
		} catch (ValidationException | NullPointerException exception) {
			System.out.println("Data tidak valid : " + exception.getMessage());
			JOptionPane.showMessageDialog(null, "Login Gagal: " + exception.getMessage());
		} finally {
			System.out.println("Selalu di eksekusi");
		}
	}

}
