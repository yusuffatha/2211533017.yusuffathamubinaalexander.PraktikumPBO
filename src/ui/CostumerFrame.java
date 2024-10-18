package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Costumer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CostumerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNama;
	private JTextField txtAlamat;
	private JTextField txtNohp;
	private JTable tableCostumer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostumerFrame frame = new CostumerFrame();
					frame.setVisible(true);
					frame.loadTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void reset() {
		txtNama.setText("");
		txtAlamat.setText("");
		txtNohp.setText("");
	}
	
	CostumerRepo cst = new CostumerRepo();
	List<Costumer> ls;
	public String id;
	
	public void loadTable() {
		ls = cst.show();
		TableCostumer tc = new TableCostumer(ls);
		tableCostumer.setModel(tc);
		tableCostumer.getTableHeader().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public CostumerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 567, 227);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nama Pelanggan");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(38, 47, 94, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alamat");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(38, 81, 61, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("No.HP");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(38, 119, 45, 13);
		panel.add(lblNewLabel_2);
		
		txtNama = new JTextField();
		txtNama.setBounds(154, 51, 316, 19);
		panel.add(txtNama);
		txtNama.setColumns(10);
		
		txtAlamat = new JTextField();
		txtAlamat.setBounds(154, 85, 316, 19);
		panel.add(txtAlamat);
		txtAlamat.setColumns(10);
		
		txtNohp = new JTextField();
		txtNohp.setBounds(154, 117, 316, 19);
		panel.add(txtNohp);
		txtNohp.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Costumer costumer = new Costumer();
				costumer.setNama(txtNama.getText());
				costumer.setAlamat(txtAlamat.getText());
				costumer.setNohp(txtNohp.getText());
				cst.save(costumer);
				reset();
				loadTable();
			}
		});
		btnSave.setBounds(38, 173, 85, 24);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Costumer costumer = new Costumer();
				costumer.setNama(txtNama.getText());
				costumer.setAlamat(txtAlamat.getText());
				costumer.setNohp(txtNohp.getText());
				costumer.setId(id);
				cst.update(costumer);
				reset();
				loadTable();
			}
		});
		btnUpdate.setBounds(133, 173, 85, 24);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					cst.delete(id);
					reset();
					loadTable();
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan dihapus");
				}
			}
		});
		btnDelete.setBounds(228, 173, 85, 24);
		panel.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(385, 173, 85, 24);
		panel.add(btnCancel);
		
		tableCostumer = new JTable();
		tableCostumer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableCostumer.getValueAt(tableCostumer.getSelectedRow(), 0).toString();
				txtNama.setText(tableCostumer.getValueAt(tableCostumer.getSelectedRow(), 1).toString());
				txtAlamat.setText(tableCostumer.getValueAt(tableCostumer.getSelectedRow(), 2).toString());
				txtNohp.setText(tableCostumer.getValueAt(tableCostumer.getSelectedRow(), 3).toString());	
			}
		});
		tableCostumer.setBounds(10, 247, 567, 205);
		contentPane.add(tableCostumer);
	}
}
