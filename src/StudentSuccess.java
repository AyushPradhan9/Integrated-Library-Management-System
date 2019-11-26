import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class StudentSuccess {

	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSuccess window = new StudentSuccess();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StudentSuccess() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblStudentSection = new JLabel("STUDENT SECTION");
		lblStudentSection.setForeground(Color.GRAY);
		lblStudentSection.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBookForm.main(new String[]{});
				frame.dispose();
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.main(new String[]{});
				frame.dispose();
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("");
		Image img5=new ImageIcon(this.getClass().getResource("/student1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img5));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(251)
					.addComponent(lblNewLabel)
					.addContainerGap(221, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(208, Short.MAX_VALUE)
					.addComponent(lblStudentSection)
					.addGap(171))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(237)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReturnBook, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(btnIssueBook, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
					.addGap(181))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(284, Short.MAX_VALUE)
					.addComponent(btnLogOut)
					.addGap(241))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStudentSection)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnIssueBook)
					.addGap(18)
					.addComponent(btnReturnBook)
					.addGap(26)
					.addComponent(btnLogOut)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
