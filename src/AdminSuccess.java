import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminSuccess {

	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSuccess window = new AdminSuccess();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AdminSuccess() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAdminSection = new JLabel("ADMIN SECTION");
		lblAdminSection.setForeground(Color.GRAY);
		lblAdminSection.setFont(new Font("Tahoma", Font.PLAIN, 28));
		
		JButton btnAddLibrarian = new JButton("Add Librarian");
		btnAddLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianForm.main(new String[]{});
				frame.dispose();
			}
		});
		btnAddLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnViewLibrarian = new JButton("View Librarian");
		btnViewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLibrarian.main(new String[]{});
			}
		});
		btnViewLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnDeleteLibrarian = new JButton("Delete Librarian");
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteLibrarian.main(new String[]{});
				frame.dispose();
			}
		});
		btnDeleteLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(214)
					.addComponent(lblAdminSection)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(203)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddLibrarian, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
							.addGap(181))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnDeleteLibrarian, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnViewLibrarian, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
							.addContainerGap(181, Short.MAX_VALUE))))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(266, Short.MAX_VALUE)
					.addComponent(btnLogOut)
					.addGap(259))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblAdminSection)
					.addGap(35)
					.addComponent(btnAddLibrarian, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnViewLibrarian, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnDeleteLibrarian, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addComponent(btnLogOut)
					.addGap(30))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
