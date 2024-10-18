package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ServiceRepo;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ServiceFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtJenis;
	private JTextField txtStatus;
	private JTextField txtHarga;
	private JTable tableService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServiceFrame frame = new ServiceFrame();
					frame.setVisible(true);
					frame.loadTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void reset() {
		txtJenis.setText("");
		txtStatus.setText("");
		txtHarga.setText("");
	}
	
	ServiceRepo srv = new ServiceRepo();
	List<Service> ls;
	public String id;
	
	public void loadTable() {
		ls = srv.show();
		TableService ts = new TableService(ls);
		tableService.setModel(ts);
		tableService.getTableHeader().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ServiceFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Jenis");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(50, 42, 35, 24);
		panel.add(lblNewLabel_1);
		
		txtJenis = new JTextField();
		txtJenis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtJenis.setBounds(110, 42, 374, 23);
		panel.add(txtJenis);
		txtJenis.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Status");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(50, 87, 35, 24);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Harga");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(50, 136, 45, 13);
		panel.add(lblNewLabel);
		
		txtStatus = new JTextField();
		txtStatus.setBounds(110, 86, 374, 24);
		panel.add(txtStatus);
		txtStatus.setColumns(10);
		
		txtHarga = new JTextField();
		txtHarga.setBounds(110, 129, 374, 24);
		panel.add(txtHarga);
		txtHarga.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service service = new Service();
				service.setJenis(txtJenis.getText());
				service.setStatus(txtStatus.getText());
				service.setHarga(Integer.parseInt(txtHarga.getText()));
				srv.save(service);
				reset();
				loadTable();
			}
		});
		btnSave.setBounds(50, 197, 85, 33);
		panel.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Service service = new Service();
				service.setJenis(txtJenis.getText());
				service.setStatus(txtStatus.getText());
				service.setHarga(Integer.parseInt(txtHarga.getText()));
				service.setId(id);
				srv.update(service);
				reset();
				loadTable();
			}
		});
		btnUpdate.setBounds(156, 197, 85, 33);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id != null) {
					srv.delete(id);
					reset();
					loadTable();
				}else {
					JOptionPane.showMessageDialog(null, "Silahkan piluh data yang akan dihapus");
				}
			}
		});
		btnDelete.setBounds(258, 197, 85, 33);
		panel.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(399, 197, 85, 33);
		panel.add(btnCancel);
		
		tableService = new JTable();
		tableService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id = tableService.getValueAt(tableService.getSelectedRow(), 0).toString();
				txtJenis.setText(tableService.getValueAt(tableService.getSelectedRow(), 1).toString());
				txtStatus.setText(tableService.getValueAt(tableService.getSelectedRow(), 2).toString());
				txtHarga.setText(tableService.getValueAt(tableService.getSelectedRow(), 3).toString());
			}
		});
		tableService.setBounds(0, 255, 576, 248);
		panel.add(tableService);
	}
}
