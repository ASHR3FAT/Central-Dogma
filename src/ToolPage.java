import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ToolPage extends JFrame implements ActionListener{
	
	private ImageIcon mainIcon;
	private ImageIcon homeIcon;
	private Font font1;
	private Font font2;
	
	private JLabel chooseLabel;
	private JButton transcribBtn;
	private JButton translateBtn;
	private JButton homeBtn;
	
	ToolPage() {
		
		mainIcon = new ImageIcon(getClass().getResource("./images/title_logo.png"));
		this.setIconImage(mainIcon.getImage());
		
		homeIcon = new ImageIcon(getClass().getResource("./images/home_button.png"));
		
		font1 = new Font("Monospaced", Font.PLAIN, 20);
		font2 = new Font("Monospaced", Font.PLAIN, 30);
		
		homeBtn = new JButton(homeIcon);
		homeBtn.setFocusable(false);
		homeBtn.addActionListener(this);
		homeBtn.setBounds(875, 35, 64, 64);
		homeBtn.setBackground(Color.decode("#003EFF"));
		homeBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(homeBtn);
		
		chooseLabel = new JLabel();
		chooseLabel.setText("Find your solution");
		chooseLabel.setBounds(75, 100, 450, 40);
		chooseLabel.setForeground(Color.decode("#7DF9FF"));
		chooseLabel.setFont(font2);
		this.add(chooseLabel);
		
		transcribBtn = new JButton();
		transcribBtn.setText("Transcription");
		transcribBtn.setFocusable(false);
		transcribBtn.addActionListener(this);
		transcribBtn.setBounds(350, 250, 300, 60);
		transcribBtn.setBorder(BorderFactory.createLineBorder(Color.RED));
		transcribBtn.setBackground(Color.decode("#DC143C"));
		transcribBtn.setForeground(Color.WHITE);
		transcribBtn.setFont(font1);
		this.add(transcribBtn);
		
		translateBtn = new JButton();
		translateBtn.setText("Translation");
		translateBtn.setFocusable(false);
		translateBtn.addActionListener(this);
		translateBtn.setBounds(350, 320, 300, 60);
		translateBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		translateBtn.setBackground(Color.decode("#007FFF"));
		translateBtn.setForeground(Color.BLACK);
		translateBtn.setFont(font1);
		this.add(translateBtn);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#333333"));
		this.setTitle("Central Dogma");
		this.setBounds(180, 75, 1000, 615);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == transcribBtn) {
			this.dispose();
			new TranscriptionTool();
		}
		
		else if(e.getSource() == translateBtn) {
			this.dispose();
			new TranslationTool();
		}
		
		else if(e.getSource() == homeBtn) {
			this.dispose();
			new LaunchPage();
		}
		
	}
	
}
