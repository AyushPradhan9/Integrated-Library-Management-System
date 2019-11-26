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

public class BooksForm {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BooksForm window = new BooksForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public BooksForm() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAddNewBook = new JLabel("Add New Book");
		lblAddNewBook.setForeground(Color.GRAY);
		lblAddNewBook.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel lblBookNumber = new JLabel("Book Number :");
		lblBookNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Author :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Publisher :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_3 = new JLabel("Quantity :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnAddBook = new JButton("ADD BOOK");
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddBook.addActionListener(new ActionListener() {					//invoke actionPerformed() when button is triggered
			public void actionPerformed(ActionEvent e) {						//the callback function for ActionListener
			String callno=textField.getText();									//getting values from the text fields
			String name=textField_1.getText();
			String author=textField_2.getText();
			String publisher=textField_3.getText();
			String squantity=textField_4.getText();
			int quantity=Integer.parseInt(squantity);
			int i=BookDao.save(callno, name, author, publisher, quantity);     		//passing values as arguments to database function
			if(i>0){
				JOptionPane.showMessageDialog(BooksForm.frame,"Books added successfully!");
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(BooksForm.frame,"Sorry, unable to save!");
			}
			}
		});
		
		JButton btnBack = new JButton("Back ");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		Image img6=new ImageIcon(this.getClass().getResource("/book.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img6));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(49, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(55)
									.addComponent(textField_3))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBookNumber)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_2)
										.addComponent(textField_1)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
										.addComponent(lblAddNewBook, Alignment.TRAILING)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3)
									.addGap(59)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAddBook)
										.addComponent(textField_4))))
							.addGap(36)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(34))
						.addComponent(btnBack))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAddNewBook)
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBookNumber)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
							.addComponent(btnAddBook)
							.addGap(21))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(99)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(btnBack)
					.addGap(21))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
