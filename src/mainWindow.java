import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainWindow {

	private JFrame frmProject = new JFrame();
	PingChecker ping = new PingChecker();
	TeamGen team = new TeamGen();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frmProject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProject.setTitle("Tiger Project");
		frmProject.setBounds(100, 100, 450, 300);
		frmProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProject.getContentPane().setLayout(null);
		
		JButton btnTeamGenerator = new JButton("Team Generator");
		btnTeamGenerator.setBackground(new Color(255, 255, 255));
		btnTeamGenerator.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTeamGenerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProject.getContentPane().removeAll();
				team.initializeTeam(frmProject);
				backButton();
				frmProject.revalidate();
				frmProject.repaint();
			}
		});
		btnTeamGenerator.setBounds(133, 152, 158, 45);
		frmProject.getContentPane().add(btnTeamGenerator);
		
		JButton btnPingChecker = new JButton("Ping Checker");
		btnPingChecker.setBackground(new Color(255, 255, 255));
		btnPingChecker.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPingChecker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmProject.getContentPane().removeAll();
				ping.initializePing(frmProject);
				backButton();
				frmProject.revalidate();
				frmProject.repaint();
			}
		});
		btnPingChecker.setBounds(133, 57, 158, 45);
		frmProject.getContentPane().add(btnPingChecker);
	}
	
	private void backButton(){
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmProject.getContentPane().removeAll();
				initialize();
				frmProject.revalidate();
				frmProject.repaint();
			}
		});
		btnBack.setBounds(10, 11, 89, 35);
		frmProject.getContentPane().add(btnBack);
	}
}
