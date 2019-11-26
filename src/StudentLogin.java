import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentLogin {

	private static JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogin window = new StudentLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StudentLogin() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Student Login Form");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel lblEnterName = new JLabel("Enter Student Id :");
		lblEnterName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblEnterPin = new JLabel("Enter PIN :");
		lblEnterPin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img2=new ImageIcon(this.getClass().getResource("/login2.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String sip=textField.getText();
			int studentid=Integer.parseInt(sip);
			String password=String.valueOf(passwordField.getPassword());
			if(StudentDao.validate(studentid, password)){
				StudentSuccess.main(new String[]{});
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(StudentLogin.frame, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			}
			}
		});
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblEnterName)
												.addComponent(lblEnterPin))
											.addGap(42)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(passwordField)
												.addComponent(textField, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
											.addGap(119))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(53)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))
							.addGap(47))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnBack)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(67)
							.addComponent(lblNewLabel)
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterName)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterPin)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
							.addComponent(btnLogin)
							.addGap(28)
							.addComponent(btnBack)))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
