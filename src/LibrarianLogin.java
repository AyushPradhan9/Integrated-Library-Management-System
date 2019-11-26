import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LibrarianLogin {

	private static JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianLogin window = new LibrarianLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public LibrarianLogin() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLibrarianLoginForm = new JLabel("Librarian Login Form");
		lblLibrarianLoginForm.setForeground(Color.GRAY);
		lblLibrarianLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 31));
		
		JLabel lblEnterName = new JLabel("Enter Name :");
		lblEnterName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEnterPasword = new JLabel("Enter Password :");
		lblEnterPasword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("");
		Image img1=new ImageIcon(this.getClass().getResource("/login1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				String password=String.valueOf(passwordField.getPassword());
				if(LibrarianDao.validate(name, password)){
					LibrarianSuccess.main(new String[]{});
					frame.dispose();
				}else{
					JOptionPane.showMessageDialog(LibrarianLogin.frame, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					passwordField.setText("");
				}	
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		passwordField = new JPasswordField();
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterPasword)
								.addComponent(lblEnterName))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLibrarianLoginForm, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
					.addGap(26))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(552, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblLibrarianLoginForm, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterName)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(64)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnterPasword))
							.addGap(59)
							.addComponent(btnLogin))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
