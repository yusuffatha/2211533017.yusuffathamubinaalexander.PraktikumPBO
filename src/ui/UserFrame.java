package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserRepo;
import model.User;
import table.TableUser;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UserFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTable tableUser;
    private String id; // Perbaikan: Deklarasikan di tingkat kelas

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserFrame frame = new UserFrame();
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
    public UserFrame() {
        UserRepo usr = new UserRepo();
        List<User> ls;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 504, 570);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 21, 470, 239);
        contentPane.add(panel);
        panel.setLayout(null);

        txtName = new JTextField();
        txtName.setBounds(131, 42, 274, 30);
        panel.add(txtName);
        txtName.setColumns(10);

        txtUsername = new JTextField();
        txtUsername.setBounds(131, 82, 274, 30);
        panel.add(txtUsername);
        txtUsername.setColumns(10);

        txtPassword = new JTextField();
        txtPassword.setBounds(131, 122, 274, 30);
        panel.add(txtPassword);
        txtPassword.setColumns(10);

        JLabel lblNewLabel = new JLabel("Nama");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(53, 50, 45, 13);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("username");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(46, 90, 64, 13);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password");
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(40, 130, 73, 13);
        panel.add(lblNewLabel_2);

        JButton btnSave = new JButton("save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setNama(txtName.getText());
                user.setUsername(txtUsername.getText());
                user.setPassword(txtPassword.getText());
                usr.save(user);
                reset();
                loadTable(); // Pastikan loadTable dipanggil
            }
        });
        btnSave.setBounds(53, 188, 85, 36);
        panel.add(btnSave);

        JButton btnUpdate = new JButton("update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                user.setNama(txtName.getText());
                user.setUsername(txtUsername.getText());
                user.setPassword(txtPassword.getText());
                user.setId(id);
                usr.update(user);
                reset();
                loadTable();
            }
        });
        btnUpdate.setBounds(148, 188, 85, 36);
        panel.add(btnUpdate);

        JButton btnDelete = new JButton("delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (id != null) {
                    usr.delete(id);
                    reset();
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di hapus");
                }
            }
        });
        btnDelete.setBounds(243, 188, 96, 36);
        panel.add(btnDelete);

        JButton btnCancel = new JButton("cancel");
        btnCancel.setBounds(352, 187, 85, 36);
        panel.add(btnCancel);

        tableUser = new JTable();
        tableUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                id = tableUser.getValueAt(tableUser.getSelectedRow(), 0).toString();
                txtName.setText(tableUser.getValueAt(tableUser.getSelectedRow(), 1).toString());
                txtUsername.setText(tableUser.getValueAt(tableUser.getSelectedRow(), 2).toString());
                txtPassword.setText(tableUser.getValueAt(tableUser.getSelectedRow(), 3).toString());
            }
        });
        tableUser.setBounds(10, 286, 470, 220);
        contentPane.add(tableUser);
    }

    public void reset() {
        txtName.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
    }

    public void loadTable() {
        UserRepo usr = new UserRepo();
        List<User> ls = usr.show();
        TableUser tu = new TableUser(ls);
        tableUser.setModel(tu);
        tableUser.getTableHeader().setVisible(true);
    }
}
