import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LaunchPage extends JFrame implements ActionListener {
	
	private ImageIcon mainIcon;
	private ImageIcon coverIcon;
	private Font font;
	
	private JLabel coverLabel;
	private JLabel creditLabel;
	private JButton startBtn;
	
	LaunchPage() {
		
		mainIcon = new ImageIcon(getClass().getResource("./images/title_logo.png"));
		this.setIconImage(mainIcon.getImage());
		
		coverIcon = new ImageIcon(getClass().getResource("./images/central_dogma_logo.png"));
		
		font = new Font("Monospaced", Font.CENTER_BASELINE, 20);
		
		coverLabel = new JLabel(coverIcon);
		coverLabel.setBounds(115, 75, 815, 340);
		this.add(coverLabel);
		
		creditLabel = new JLabel("Developed by: Mohammad Ashraful Alam ", SwingConstants.CENTER);
		creditLabel.setBounds(0, 547, 1000, 30);
		creditLabel.setFont(font);
		creditLabel.setOpaque(true);
		creditLabel.setBackground(Color.decode("#006A71"));
		creditLabel.setForeground(Color.decode("#2C2C2C"));
		this.add(creditLabel);
		
		startBtn = new JButton();
		startBtn.setText("Start");
		startBtn.setFocusable(false);
		startBtn.addActionListener(this);
		startBtn.setBounds(410, 460, 150, 50);
		startBtn.setFont(font);
		startBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		startBtn.setBackground(Color.decode("#003EFF"));
		startBtn.setForeground(Color.BLACK);
		this.add(startBtn);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#727D73"));
		this.setTitle("Central Dogma");
		this.setBounds(180, 75, 1000, 615);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startBtn) {
			this.dispose();
			new ToolPage();
		}
		
	}

}
