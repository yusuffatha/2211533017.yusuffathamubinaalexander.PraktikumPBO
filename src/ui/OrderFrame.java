package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtOrderID;
	private JTextField txtTgl;
	private JTextField txtTglPengembalian;
	private JTable tableLayanan;
	private JTextField txtHarga;
	private JTextField txtJumlah;
	private JTextField txtTotal;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame();
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
	public OrderFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 240, 649);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order ID");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 20, 50, 20);
		panel.add(lblNewLabel);
		
		txtOrderID = new JTextField();
		txtOrderID.setBounds(10, 45, 220, 26);
		panel.add(txtOrderID);
		txtOrderID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pelanggan");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(15, 92, 62, 20);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 118, 220, 26);
		panel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Tanggal");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 167, 50, 20);
		panel.add(lblNewLabel_2);
		
		txtTgl = new JTextField();
		txtTgl.setBounds(10, 190, 220, 26);
		panel.add(txtTgl);
		txtTgl.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tanggal Pengembalian");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 244, 145, 20);
		panel.add(lblNewLabel_3);
		
		txtTglPengembalian = new JTextField();
		txtTglPengembalian.setBounds(10, 268, 220, 26);
		panel.add(txtTglPengembalian);
		txtTglPengembalian.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Status");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 317, 50, 20);
		panel.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 337, 220, 26);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("Total");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 394, 50, 20);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Rp. 10.000");
		lblNewLabel_6.setFont(new Font("Script MT Bold", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 410, 67, 20);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Pembayaran");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(10, 440, 97, 20);
		panel.add(lblNewLabel_7);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(10, 461, 220, 26);
		panel.add(comboBox_2);
		
		JLabel lblNewLabel_8 = new JLabel("Status Pembayaran");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 504, 121, 20);
		panel.add(lblNewLabel_8);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(10, 525, 220, 26);
		panel.add(comboBox_3);
		
		JButton btnSimpan1 = new JButton("Simpan");
		btnSimpan1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSimpan1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnSimpan1.setBounds(10, 594, 97, 32);
		panel.add(btnSimpan1);
		
		JButton btnBatal1 = new JButton("Batal");
		btnBatal1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBatal1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnBatal1.setBounds(133, 594, 97, 32);
		panel.add(btnBatal1);
		
		JLabel lblNewLabel_9 = new JLabel("Layanan");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(274, 10, 69, 20);
		contentPane.add(lblNewLabel_9);
		
		tableLayanan = new JTable();
		tableLayanan.setBounds(274, 30, 422, 199);
		contentPane.add(tableLayanan);
		
		JLabel lblNewLabel_10 = new JLabel("Harga/Kg");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(274, 252, 62, 20);
		contentPane.add(lblNewLabel_10);
		
		txtHarga = new JTextField();
		txtHarga.setBounds(274, 276, 182, 26);
		contentPane.add(txtHarga);
		txtHarga.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Jumlah");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(274, 312, 62, 20);
		contentPane.add(lblNewLabel_11);
		
		txtJumlah = new JTextField();
		txtJumlah.setBounds(274, 335, 182, 26);
		contentPane.add(txtJumlah);
		txtJumlah.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Total");
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(498, 316, 52, 16);
		contentPane.add(lblNewLabel_12);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(498, 335, 188, 26);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnSimpan2 = new JButton("Simpan");
		btnSimpan2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSimpan2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnSimpan2.setBounds(270, 380, 85, 32);
		contentPane.add(btnSimpan2);
		
		table_1 = new JTable();
		table_1.setBounds(274, 450, 422, 209);
		contentPane.add(table_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(260, 239, 436, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHapus.setBounds(191, 142, 75, 32);
		panel_1.add(btnHapus);
		btnHapus.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JButton btnBatal2 = new JButton("Batal");
		btnBatal2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBatal2.setBounds(276, 142, 85, 32);
		panel_1.add(btnBatal2);
		btnBatal2.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		JButton btnUbah = new JButton("Ubah");
		btnUbah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUbah.setBounds(102, 142, 85, 32);
		panel_1.add(btnUbah);
		btnUbah.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
	}
}
