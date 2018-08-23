import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TeamGen {

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	void initializeTeam(JFrame frmTeamGenerator) {

		Integer [] noTeams = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8};
		
		frmTeamGenerator.setTitle("Team Generator");
		frmTeamGenerator.setResizable(false);
		frmTeamGenerator.setBounds(100, 100, 639, 371);
		frmTeamGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeamGenerator.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 80, 205, 233);
		frmTeamGenerator.getContentPane().add(scrollPane_1);
		
		JTextArea inputArea = new JTextArea();
		scrollPane_1.setViewportView(inputArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(245, 80, 205, 232);
		frmTeamGenerator.getContentPane().add(scrollPane);
		
		JTextArea outputArea = new JTextArea();
		scrollPane.setViewportView(outputArea);
		
		JComboBox<Integer> comboBox = new JComboBox<>(noTeams);
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(487, 85, 123, 35);
		frmTeamGenerator.getContentPane().add(comboBox);
		
		JLabel lblOutputTeam = new JLabel("");
		lblOutputTeam.setBounds(311, 85, 46, 14);
		frmTeamGenerator.getContentPane().add(lblOutputTeam);
		
		JButton btnNewButton = new JButton("Generate!");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputArea.setText("");
				HashSet<Integer> used = new HashSet<Integer>();
				Random rand = new Random();
				int randomNum = 0;
				int j = 0;
				String s = inputArea.getText();
				String lines[] = s.split("\\r?\\n");
				
				int teamNum = (int)comboBox.getSelectedItem();
				int maxInTeam = (lines.length/teamNum);
				
				if(lines.length%teamNum!=0){
					outputArea.setText("Invalid number of players to fit into teams");
				}
				else{	
				for(int i=1;i<=teamNum;i++){
					if(i>1){
					outputArea.append("===== \n");
					}
					outputArea.append("Team" + i + "\n");
					for (j=0;j<maxInTeam;j++){
						 	randomNum = rand.nextInt(((lines.length-1)-0)+1) + 0;
						while(used.contains(randomNum)){
							randomNum = rand.nextInt(((lines.length-1)-0)+1) + 0;
						}
						outputArea.append(lines[randomNum] + "\n");
						used.add(randomNum);
						if(j>=maxInTeam){ 
							break;
							}
					}
				}
				}
			}
		});
		
		btnNewButton.setBounds(487, 290, 123, 23);
		frmTeamGenerator.getContentPane().add(btnNewButton);
		
		JLabel lblPlayerName = new JLabel("Enter names of players");
		lblPlayerName.setBounds(11, 50, 247, 28);
		frmTeamGenerator.getContentPane().add(lblPlayerName);
		
		JLabel lblOutputTeams = new JLabel("Output Teams");
		lblOutputTeams.setBounds(244, 50, 247, 28);
		frmTeamGenerator.getContentPane().add(lblOutputTeams);
		
		JLabel lblNewLabel = new JLabel("No. of teams");
		lblNewLabel.setBounds(487, 50, 247, 28);
		frmTeamGenerator.getContentPane().add(lblNewLabel);
	}
	}
