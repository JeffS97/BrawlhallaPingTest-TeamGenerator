import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PingChecker {

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	void initializePing(JFrame frmProject) {
		
		frmProject.getContentPane().setForeground(Color.CYAN);
		frmProject.setForeground(Color.WHITE);
		frmProject.setTitle("AUSSEA Ping Checker");
		frmProject.setBounds(100, 100, 454, 318);
		frmProject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProject.getContentPane().setLayout(null);
		
		JLabel lblSeaServers = new JLabel("SEA Servers");
		lblSeaServers.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeaServers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeaServers.setBounds(32, 61, 128, 45);
		frmProject.getContentPane().add(lblSeaServers);
		
		JLabel lblAusServers = new JLabel("AUS Servers");
		lblAusServers.setHorizontalAlignment(SwingConstants.CENTER);
		lblAusServers.setBackground(Color.WHITE);
		lblAusServers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAusServers.setBounds(32, 117, 128, 45);
		frmProject.getContentPane().add(lblAusServers);
		
		JLabel lblJpnServers = new JLabel("JPN Servers");
		lblJpnServers.setHorizontalAlignment(SwingConstants.CENTER);
		lblJpnServers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJpnServers.setBounds(32, 173, 128, 45);
		frmProject.getContentPane().add(lblJpnServers);
				
		JLabel lblSEAPing = new JLabel("");
		lblSEAPing.setHorizontalAlignment(SwingConstants.CENTER);
		lblSEAPing.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSEAPing.setBounds(152, 61, 96, 45);
		frmProject.getContentPane().add(lblSEAPing);
		lblSEAPing.setText("0");
		
		JLabel lblAusPing = new JLabel("");
		lblAusPing.setHorizontalAlignment(SwingConstants.CENTER);
		lblAusPing.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAusPing.setBounds(152, 117, 96, 45);
		frmProject.getContentPane().add(lblAusPing);
		lblAusPing.setText("0");
		
		JLabel lblJPNPing = new JLabel("");
		lblJPNPing.setHorizontalAlignment(SwingConstants.CENTER);
		lblJPNPing.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJPNPing.setBounds(152, 173, 96, 45);
		frmProject.getContentPane().add(lblJPNPing);
		lblJPNPing.setText("0");
		
		JButton btnRefreshSEA = new JButton("Refresh");
		btnRefreshSEA.setBackground(new Color(255, 255, 255));
		btnRefreshSEA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRefreshSEA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSEAPing.setText(pingSEA());
			}
		});
		btnRefreshSEA.setBounds(258, 64, 128, 39);
		frmProject.getContentPane().add(btnRefreshSEA);
		
		JButton btnRefreshAus = new JButton("Refresh");
		btnRefreshAus.setBackground(new Color(255, 255, 255));
		btnRefreshAus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRefreshAus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAusPing.setText(pingAus());
			}
		});
		btnRefreshAus.setBounds(258, 120, 128, 39);
		frmProject.getContentPane().add(btnRefreshAus);
		
		JButton btnRefreshJPN = new JButton("Refresh");
		btnRefreshJPN.setBackground(new Color(255, 255, 255));
		btnRefreshJPN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRefreshJPN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblJPNPing.setText(pingJPN());
			}
		});
		btnRefreshJPN.setBounds(258, 176, 128, 39);
		frmProject.getContentPane().add(btnRefreshJPN);
		
		JButton btnRefreshAll = new JButton("Refresh All");
		btnRefreshAll.setBackground(new Color(255, 255, 255));
		btnRefreshAll.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRefreshAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSEAPing.setText(pingSEA());
				lblAusPing.setText(pingAus());
				lblJPNPing.setText(pingJPN());
			}
		});
		btnRefreshAll.setBounds(32, 229, 367, 39);
		frmProject.getContentPane().add(btnRefreshAll);
	}
	
	private String pingSEA() {
		
		String ipAddress1 = "13.229.8.251";
		String rttSEA = "";
		
		try {
		     InetAddress inet = InetAddress.getByName(ipAddress1);
		 
		     System.out.println("Sending Ping Request to " + ipAddress1);
		 
		     long finish = 0;
		     long start = new GregorianCalendar().getTimeInMillis();
		 
		     if (inet.isReachable(5000)){
		       finish = new GregorianCalendar().getTimeInMillis()-1;
		       rttSEA = (finish - start + "ms");
		       
		     } else {
		       rttSEA = "???";
		     }
		   } catch ( Exception e1 ) {
		     System.out.println("Exception:" + e1.getMessage());
		   }
		return rttSEA;
	}
	
	private String pingAus() {
		
		String ipAddress2 = "137.59.252.69";
		String rttAus = "";
		
		try {
		     InetAddress inet = InetAddress.getByName(ipAddress2);
		 
		     System.out.println("Sending Ping Request to " + ipAddress2);
		 
		     long finish = 0;
		     long start = new GregorianCalendar().getTimeInMillis();
		 
		     if (inet.isReachable(5000)){
		       finish = new GregorianCalendar().getTimeInMillis()-1;
		       rttAus = (finish - start + "ms");
		       
		     } else {
		       rttAus = "???";
		     }
		   } catch ( Exception e2 ) {
		     System.out.println("Exception:" + e2.getMessage());
		   }
		return rttAus;
	}
	
private String pingJPN() {
		
		String ipAddress1 = "103.194.164.48";
		String rttJPN = "";
		
		try {
		     InetAddress inet = InetAddress.getByName(ipAddress1);
		 
		     System.out.println("Sending Ping Request to " + ipAddress1);
		 
		     long finish = 0;
		     long start = new GregorianCalendar().getTimeInMillis();
		 
		     if (inet.isReachable(5000)){
		       finish = new GregorianCalendar().getTimeInMillis()-1;
		       rttJPN = (finish - start + "ms");
		       
		     } else {
		       rttJPN = "???";
		     }
		   } catch ( Exception e1 ) {
		     System.out.println("Exception:" + e1.getMessage());
		   }
		return rttJPN;
	}

	}
