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

public class Fine {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fine window = new Fine();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Fine() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblFine = new JLabel("FINE");
		lblFine.setForeground(Color.GRAY);
		lblFine.setBackground(Color.GRAY);
		lblFine.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JLabel lblEnterStudentId = new JLabel("Enter Student ID :");
		lblEnterStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEnterFinePaid = new JLabel("Enter fine paid :");
		lblEnterFinePaid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnPaid = new JButton("PAID");
		btnPaid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPaid.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String sid=textField.getText();
				int studentid=Integer.parseInt(sid);
				String fi=textField_1.getText();
				if(StudentDao.checkstud(studentid)) {
				int fine=Integer.parseInt(fi);
				int i=StudentDao.finer(studentid, fine);
				if(i>0) {
					JOptionPane.showMessageDialog(StudentDao.frame,"Fine paid successfully!");
					LibrarianSuccess.main(new String[]{});
					frame.dispose();
				}
				else{
					JOptionPane.showMessageDialog(StudentDao.frame,"Sorry, unable to repay!");
				}
				
				}else{
					JOptionPane.showMessageDialog(StudentDao.frame,"Sorry, Student Id doesn't exist!");
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		Image img6=new ImageIcon(this.getClass().getResource("/fine.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img6));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(248, Short.MAX_VALUE)
					.addComponent(btnPaid, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(196)
					.addComponent(btnBack)
					.addGap(39))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(269)
							.addComponent(lblFine))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(136)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterStudentId)
								.addComponent(lblEnterFinePaid))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))))
					.addGap(153))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(210)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(112))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblFine)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterStudentId)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterFinePaid)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnPaid)
					.addGap(22))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(375, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
