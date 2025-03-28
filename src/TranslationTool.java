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

public class TranslationTool extends JFrame implements ActionListener {
	
	private ImageIcon mainIcon;
	private ImageIcon backIcon;
	private ImageIcon homeIcon;
	private Font font1;
	private Font font2;
	private Font font3;
	
	private JButton backBtn;
	private JButton homeBtn;
	private JLabel translationHeadline;
	private JLabel enterHead;
	private JTextArea takeRNA;
	private JTextField takeLength;
	private JScrollPane scrollBar;
	private JButton translate;
	private JButton clear;
	private JLabel cautionLabel;
	private JButton randomizer;
	private JButton random;
	
	public static String rna;
	public String mustrna = "AUGC";
	public int length;
	
	TranslationTool() {
		
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
		backBtn.setBackground(Color.decode("#007FFF"));
		backBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(backBtn);
		
		homeBtn = new JButton(homeIcon);
		homeBtn.setFocusable(false);
		homeBtn.addActionListener(this);
		homeBtn.setBounds(110, 35, 64, 64);
		homeBtn.setBackground(Color.decode("#007FFF"));
		homeBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(homeBtn);
		
		translationHeadline = new JLabel();
		translationHeadline.setText("  Translation Tool");
		translationHeadline.setBounds(330, 35, 300, 50);
		translationHeadline.setFont(font2);
		translationHeadline.setOpaque(true);
		translationHeadline.setBackground(Color.decode("#007FFF"));
		translationHeadline.setForeground(Color.BLACK);
		translationHeadline.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		this.add(translationHeadline);
		
		enterHead = new JLabel();
		enterHead.setText("Enter mRNA sequence: ");
		enterHead.setBounds(150, 125, 300, 50);
		enterHead.setFont(font3);
		enterHead.setForeground(Color.BLACK);
		this.add(enterHead);
		
		takeRNA = new JTextArea();
		takeRNA.setLineWrap(true);
		takeRNA.setBackground(Color.decode("#000000"));
		takeRNA.setForeground(Color.decode("#007FFF"));
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		takeRNA.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		takeRNA.setBounds(150, 250, 680, 150);
		takeRNA.setFont(font1);
		this.add(takeRNA);
		
		scrollBar = new JScrollPane(takeRNA);
		scrollBar.setBounds(150, 230, 680, 150);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollBar);
		
		translate = new JButton();
		translate.setText("Translate!");
		translate.setFocusable(false);
		translate.addActionListener(this);
		translate.setBounds(250, 410, 150, 60);
		translate.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		translate.setBackground(Color.decode("#007FFF"));
		translate.setForeground(Color.BLACK);
		translate.setFont(font1);
		this.add(translate);
		
		clear = new JButton();
		clear.setText("Clear!");
		clear.setFocusable(false);
		clear.addActionListener(this);
		clear.setBounds(575, 410, 150, 60);
		clear.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		clear.setBackground(Color.decode("#007FFF"));
		clear.setForeground(Color.BLACK);
		clear.setFont(font1);
		this.add(clear);
		
		cautionLabel = new JLabel();
		cautionLabel.setText("Strand must not include other characters than \'A\' or \'C\' or \'U\' or \'G\'.");
		cautionLabel.setBounds(150, 490, 680, 50);
		cautionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cautionLabel.setVerticalAlignment(SwingConstants.CENTER);
		cautionLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		cautionLabel.setOpaque(true);
		cautionLabel.setBackground(Color.decode("#007FFF"));
		cautionLabel.setForeground(Color.BLACK);
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
		randomizer.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		randomizer.setBackground(Color.decode("#007FFF"));
		randomizer.setForeground(Color.BLACK);
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
		random.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		random.setBackground(Color.decode("#007FFF"));
		random.setForeground(Color.BLACK);
		random.setFont(font1);
		this.add(random);
		
		takeLength = new JTextField();
		takeLength.setBounds(575, 160, 100, 60);
		Border border1 = BorderFactory.createLineBorder(Color.BLUE);
		takeLength.setBorder(BorderFactory.createCompoundBorder(border1, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		takeLength.setBackground(Color.BLACK);
		takeLength.setForeground(Color.decode("#007FFF"));
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
	
	public boolean checkString(String rna) {
		int len = rna.length();
		if(len==0) {
			return false;
		}
		for(int i=0;i<len;i++) {
			if(rna.charAt(i)=='A' || rna.charAt(i)=='U' || rna.charAt(i)=='G' ||rna.charAt(i)=='C') {
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
			random += mustrna.charAt((int) Math.floor(Math.random() * mustrna.length()));
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
			takeRNA.selectAll();
			takeRNA.replaceSelection("");
		}
		
		else if(e.getSource() == backBtn) {
			this.dispose();
			new ToolPage();
		}
		
		else if(e.getSource() == homeBtn) {
			this.dispose();
			new LaunchPage();
		}
		
		else if(e.getSource() == translate) {
			rna = takeRNA.getText();
			if(checkString(rna)==false) {
				cautionLabel.setVisible(true);
			}
			else {
				new TranslationOutput(rna);
			}
		}
		
		else if(e.getSource() == randomizer) {
			randomizer.setVisible(false);
			takeLength.setVisible(true);
			random.setVisible(true);
		}
		
		else if(e.getSource() == random) {
			length = Integer.parseInt(takeLength.getText());
			takeRNA.setText(randomMake(length));
		}
		
	}
	
}
