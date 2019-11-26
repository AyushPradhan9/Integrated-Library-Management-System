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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IssueBookForm {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBookForm window = new IssueBookForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public IssueBookForm() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setForeground(Color.GRAY);
		lblIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel lblBookCallNumber = new JLabel("Book Call Number :");
		lblBookCallNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String bookcallno=textField.getText();
				String sid=textField_1.getText();
				int studentid=Integer.parseInt(sid);
				if(IssueBookDao.checkBook(bookcallno)) {
					int i=IssueBookDao.save(bookcallno, studentid);
					if(i>0) {
						JOptionPane.showMessageDialog(IssueBookForm.frame,"Book issued successfully!");
						StudentSuccess.main(new String[]{});
						frame.dispose();
					}
					else{
						JOptionPane.showMessageDialog(IssueBookForm.frame,"Sorry, unable to issue!");
					}
					
					}else{
						JOptionPane.showMessageDialog(IssueBookForm.frame,"Sorry, Callno doesn't exist!");
					}
			}
		});
		btnIssue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblStudentId = new JLabel("Student ID :");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		Image img7=new ImageIcon(this.getClass().getResource("/book1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img7));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(225)
							.addComponent(lblIssueBook))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(18, 273, Short.MAX_VALUE)
										.addComponent(btnBack))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(18)
										.addComponent(btnIssue, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(86)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblBookCallNumber)
									.addComponent(lblStudentId))
								.addGap(44)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField_1)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))))
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIssueBook)
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentId)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookCallNumber)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btnIssue, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(137)
							.addComponent(btnBack))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)))
					.addGap(38))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
