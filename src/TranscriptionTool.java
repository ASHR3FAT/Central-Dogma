import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TranscriptionTool extends JFrame implements ActionListener {
	
	private ImageIcon mainIcon;
	private ImageIcon backIcon;
	private ImageIcon homeIcon;
	private Font font1;
	private Font font2;
	private Font font3;
	
	private JButton backBtn;
	private JButton homeBtn;
	private JLabel transcribtionHeadline;
	private JLabel enterHead;
	private JTextArea takeDNA;
	private JTextField takeLength;
	private JScrollPane scrollBar;
	private JButton transcripe;
	private JButton clear;
	private JLabel cautionLabel;
	private JButton randomizer;
	private JButton random;
	
	public static String dna;
	public String mustdna = "ATGC";
	public int length;
	
	TranscriptionTool() {
		
		mainIcon = new ImageIcon(getClass().getResource("./images/title_logo.png"));
		this.setIconImage(mainIcon.getImage());
		
		backIcon = new ImageIcon(getClass().getResource("./images/back_button.png"));
		homeIcon = new ImageIcon(getClass().getResource("./images/home_button.png"));
		
		font1 = new Font("Monospaced", Font.PLAIN, 15);
		font2 = new Font("Monospaced", Font.PLAIN, 25);
		font3 = new Font("Monospaced", Font.PLAIN, 20);
		
		backBtn = new JButton(backIcon);
		backBtn.setFocusable(false);
		backBtn.addActionListener(this);
		backBtn.setBounds(35, 35, 64, 64);
		backBtn.setBackground(Color.decode("#DC143C"));
		backBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(backBtn);
		
		homeBtn = new JButton(homeIcon);
		homeBtn.setFocusable(false);
		homeBtn.addActionListener(this);
		homeBtn.setBounds(110, 35, 64, 64);
		homeBtn.setBackground(Color.decode("#DC143C"));
		homeBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(homeBtn);
		
		transcribtionHeadline = new JLabel();
		transcribtionHeadline.setText(" Transcription Tool");
		transcribtionHeadline.setBounds(330, 35, 300, 50);
		transcribtionHeadline.setFont(font2);
		transcribtionHeadline.setOpaque(true);
		transcribtionHeadline.setBackground(Color.decode("#DC143C"));
		transcribtionHeadline.setForeground(Color.WHITE);
		transcribtionHeadline.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.add(transcribtionHeadline);
		
		enterHead = new JLabel();
		enterHead.setText("Enter DNA sequence: ");
		enterHead.setBounds(150, 125, 300, 50);
		enterHead.setFont(font3);
		enterHead.setForeground(Color.WHITE);
		this.add(enterHead);
		
		takeDNA = new JTextArea();
		takeDNA.setLineWrap(true);
		takeDNA.setBackground(Color.decode("#000000"));
		takeDNA.setForeground(Color.decode("#DC143C"));
		Border border = BorderFactory.createLineBorder(Color.RED);
		takeDNA.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		takeDNA.setBounds(150, 250, 680, 150);
		takeDNA.setFont(font1);
		this.add(takeDNA);
		
		scrollBar = new JScrollPane(takeDNA);
		scrollBar.setBounds(150, 230, 680, 150);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollBar);
		
		transcripe = new JButton();
		transcripe.setText("Transcripe!");
		transcripe.setFocusable(false);
		transcripe.addActionListener(this);
		transcripe.setBounds(250, 410, 150, 60);
		transcripe.setBorder(BorderFactory.createLineBorder(Color.RED));
		transcripe.setBackground(Color.decode("#DC143C"));
		transcripe.setForeground(Color.WHITE);
		transcripe.setFont(font1);
		this.add(transcripe);
		
		clear = new JButton();
		clear.setText("Clear!");
		clear.setFocusable(false);
		clear.addActionListener(this);
		clear.setBounds(575, 410, 150, 60);
		clear.setBorder(BorderFactory.createLineBorder(Color.RED));
		clear.setBackground(Color.decode("#DC143C"));
		clear.setForeground(Color.WHITE);
		clear.setFont(font1);
		this.add(clear);
		
		cautionLabel = new JLabel();
		cautionLabel.setText("Strand must not include other characters than \'A\' or \'C\' or \'T\' or \'G\'.");
		cautionLabel.setBounds(150, 490, 680, 50);
		cautionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cautionLabel.setVerticalAlignment(SwingConstants.CENTER);
		cautionLabel.setBorder(BorderFactory.createLineBorder(Color.RED));
		cautionLabel.setOpaque(true);
		cautionLabel.setBackground(Color.decode("#DC143C"));
		cautionLabel.setForeground(Color.WHITE);
		cautionLabel.setFont(font1);
		cautionLabel.setVisible(false);
		this.add(cautionLabel);
		
		randomizer = new JButton();
		randomizer.setText("Randomizer");
		randomizer.setBounds(680, 160, 150, 60);
		randomizer.setFocusable(false);
		randomizer.addActionListener(this);
		randomizer.setHorizontalAlignment(SwingConstants.CENTER);
		randomizer.setVerticalAlignment(SwingConstants.CENTER);
		randomizer.setBorder(BorderFactory.createLineBorder(Color.RED));
		randomizer.setBackground(Color.decode("#DC143C"));
		randomizer.setForeground(Color.WHITE);
		randomizer.setFont(font1);
		this.add(randomizer);
		
		random = new JButton();
		random.setText("Random");
		random.setBounds(680, 160, 150, 60);
		random.setFocusable(false);
		random.setVisible(false);
		random.addActionListener(this);
		random.setHorizontalAlignment(SwingConstants.CENTER);
		random.setVerticalAlignment(SwingConstants.CENTER);
		random.setBorder(BorderFactory.createLineBorder(Color.RED));
		random.setBackground(Color.decode("#DC143C"));
		random.setForeground(Color.WHITE);
		random.setFont(font1);
		this.add(random);
		
		takeLength = new JTextField();
		takeLength.setBounds(575, 160, 100, 60);
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		takeLength.setBorder(BorderFactory.createCompoundBorder(border1, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		takeLength.setBackground(Color.BLACK);
		takeLength.setForeground(Color.decode("#DC143C"));
		takeLength.setFont(font1);
		takeLength.setVisible(false);
		this.add(takeLength);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#444444"));
		this.setTitle("Central Dogma");
		this.setBounds(180, 75, 1000, 615);
		
	}
	
	public boolean checkString(String dna) {
		int len = dna.length();
		if(len==0) {
			return false;
		}
		for(int i=0;i<len;i++) {
			if(dna.charAt(i)=='A' || dna.charAt(i)=='T' || dna.charAt(i)=='G' || dna.charAt(i)=='C') {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public String randomMake(int length) {
		String random = "";
		
		for(int i=0;i<length;i++) {
			random += mustdna.charAt((int) Math.floor(Math.random() * mustdna.length()));
		}
		return random;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clear) {
			cautionLabel.setVisible(false);
			random.setVisible(false);
			takeLength.setVisible(false);
			randomizer.setVisible(true);
			takeDNA.selectAll();
			takeDNA.replaceSelection("");
		}
		
		else if(e.getSource() == backBtn) {
			this.dispose();
			new ToolPage();
		}
		
		else if(e.getSource() == homeBtn) {
			this.dispose();
			new LaunchPage();
		}
		
		else if(e.getSource() == transcripe) {
			dna = takeDNA.getText();
			if(checkString(dna)==false) {
				cautionLabel.setVisible(true);
			}
			else {
				new TranscriptionOutput(dna);
			}
		}
		
		else if(e.getSource() == randomizer) {
			randomizer.setVisible(false);
			takeLength.setVisible(true);
			random.setVisible(true);
		}
		
		else if(e.getSource() == random) {
			length = Integer.parseInt(takeLength.getText());
			takeDNA.setText(randomMake(length));
		}
		
	}
	
}
