import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.image.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Color;
public class Library {

	private JFrame frame;
	private final Action action = new SwingAction();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library window = new Library();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Library() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLogin.main(new String[]{});											//Calling LibrarianLogin
				frame.dispose();
			}
		});
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnLibrarian = new JButton("Librarian");
		btnLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LibrarianLogin.main(new String[]{});											//Calling LibrarianLogin
				frame.dispose();
			}
		});
		
		JLabel lblIntegratedLibrarySystem = new JLabel("Integrated Library System - (ILS-ReD)");
		lblIntegratedLibrarySystem.setBackground(Color.GRAY);
		lblIntegratedLibrarySystem.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/logo1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[]{});											//Calling LibrarianLogin
				frame.dispose();
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(124, Short.MAX_VALUE)
					.addComponent(lblIntegratedLibrarySystem, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
					.addGap(79))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(97)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(211)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdmin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(btnLibrarian, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
						.addComponent(btnStudent, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
					.addGap(201))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIntegratedLibrarySystem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStudent, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLibrarian, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
