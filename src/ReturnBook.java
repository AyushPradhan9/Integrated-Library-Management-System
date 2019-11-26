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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ReturnBook() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setForeground(Color.GRAY);
		lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel lblEnterBookCall = new JLabel("Book Call Num : ");
		lblEnterBookCall.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		Image img8=new ImageIcon(this.getClass().getResource("/book1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img8));
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookcallno=textField.getText();
				int studentid=Integer.parseInt(textField_1.getText());
				int i=ReturnBookDao.delete(bookcallno, studentid);
				if(i>0){
					JOptionPane.showMessageDialog(ReturnBook.frame,"Book returned successfully!");
					StudentSuccess.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(ReturnBook.frame,"Sorry, unable to return book!");
				}
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblEnterStudentId = new JLabel("Student ID :");
		lblEnterStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(232)
							.addComponent(lblReturnBook))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(99)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEnterStudentId)
										.addComponent(lblEnterBookCall))))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
									.addGap(66)
									.addComponent(btnBack))
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textField_1, Alignment.LEADING)
									.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblReturnBook)
									.addGap(87))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblEnterStudentId)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(30)))
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(27)
									.addComponent(btnReturn, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
									.addComponent(btnBack)
									.addGap(31))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEnterBookCall)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(276))))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
