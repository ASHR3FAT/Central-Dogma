import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
	private ImageIcon deleteIcon;
	private ImageIcon searchIcon;
	private Font font1;
	private Font font2;
	private Font font3;
	
	private JButton backBtn;
	private JButton homeBtn;
	private JButton browseBtn;
	private JLabel translationHeadline;
	private JLabel enterHead;
	private JTextArea takeHeader;
	private JLabel enterRNA;
	private JTextArea takeRNA;
	private JScrollPane scrollBar;
	private JButton translate;
	private JButton clear;
	private JLabel cautionLabel;
	
	public static String rna;
	public String mustrna = "AUGC";
	public static String header;
	
	TranslationTool() {
		
		mainIcon = new ImageIcon(getClass().getResource("./images/title_logo.png"));
		this.setIconImage(mainIcon.getImage());
		
		backIcon = new ImageIcon(getClass().getResource("./images/back.png"));
		homeIcon = new ImageIcon(getClass().getResource("./images/double_back.png"));
		deleteIcon = new ImageIcon(getClass().getResource("./images/del.png"));
		searchIcon = new ImageIcon(getClass().getResource("./images/search.png"));
		
		font1 = new Font("Monospaced", Font.PLAIN, 15);
		font2 = new Font("Monospaced", Font.BOLD, 25);
		font3 = new Font("Monospaced", Font.PLAIN, 20);
		
		backBtn = new JButton(backIcon);
		backBtn.setFocusable(false);
		backBtn.addActionListener(this);
		backBtn.setBounds(68, 35, 40, 40);
		backBtn.setBackground(Color.decode("#007FFF"));
		backBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(backBtn);
		
		homeBtn = new JButton(homeIcon);
		homeBtn.setFocusable(false);
		homeBtn.addActionListener(this);
		homeBtn.setBounds(110, 35, 40, 40);
		homeBtn.setBackground(Color.decode("#007FFF"));
		homeBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(homeBtn);
		
		translationHeadline = new JLabel();
		translationHeadline.setText("  Translation Tool");
		translationHeadline.setBounds(330, 35, 300, 50);
		translationHeadline.setFont(font2);
		translationHeadline.setForeground(Color.BLUE);
		this.add(translationHeadline);
		
		enterHead = new JLabel();
		enterHead.setText("Sequence ID: ");
		enterHead.setBounds(150, 110, 300, 50);
		enterHead.setFont(font3);
		enterHead.setForeground(Color.WHITE);
		this.add(enterHead);
		
		takeHeader = new JTextArea();
		takeHeader.setLineWrap(true);
		takeHeader.setBackground(Color.decode("#EAEFEF"));
		takeHeader.setForeground(Color.BLUE);
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		takeHeader.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		takeHeader.setBounds(150, 160, 680, 40);
		takeHeader.setFont(font1);
		this.add(takeHeader);
		
		enterRNA = new JLabel();
		enterRNA.setText("Sequence: ");
		enterRNA.setBounds(150, 210, 300, 50);
		enterRNA.setFont(font3);
		enterRNA.setForeground(Color.WHITE);
		this.add(enterRNA);
		
		takeRNA = new JTextArea();
		takeRNA.setLineWrap(true);
		takeRNA.setBackground(Color.decode("#EAEFEF"));
		takeRNA.setForeground(Color.BLUE);
		Border border2 = BorderFactory.createLineBorder(Color.BLUE);
		takeRNA.setBorder(BorderFactory.createCompoundBorder(border2, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		takeRNA.setBounds(150, 260, 680, 150);
		takeRNA.setFont(font1);
		this.add(takeRNA);
		
		scrollBar = new JScrollPane(takeRNA);
		scrollBar.setBounds(150, 260, 680, 150);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollBar);
		
		translate = new JButton();
		translate.setText("Translate");
		translate.setFocusable(false);
		translate.addActionListener(this);
		translate.setBounds(420, 420, 130, 50);
		translate.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		translate.setBackground(Color.decode("#007FFF"));
		translate.setForeground(Color.BLACK);
		translate.setFont(font1);
		this.add(translate);
		
		browseBtn = new JButton(searchIcon);
		browseBtn.setFocusable(false);
		browseBtn.addActionListener(this);
		browseBtn.setBounds(740, 110, 40, 40);
		browseBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#27548A")));
		browseBtn.setBackground(Color.WHITE);
		browseBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				browseBtn.setBackground(Color.decode("#27548A"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				browseBtn.setBackground(Color.WHITE);
			}
			
		});
		this.add(browseBtn);
		
		clear = new JButton(deleteIcon);
		clear.setFocusable(false);
		clear.addActionListener(this);
		clear.setBounds(790, 110, 40, 40);
		clear.setBorder(BorderFactory.createLineBorder(Color.decode("#CB0404")));
		clear.setBackground(Color.WHITE);
		clear.setFont(font1);
		clear.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				clear.setBackground(Color.decode("#CB0404"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				clear.setBackground(Color.WHITE);
			}

			
		});
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
		
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#727D73"));
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clear) {
			cautionLabel.setVisible(false);
			takeHeader.setText("");
			takeRNA.setText("");
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
		
		else if(e.getSource() == browseBtn) {
			JFileChooser fileChooser = new JFileChooser();
			int res = fileChooser.showOpenDialog(null);
			
			if(res == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			        header = "";
			        StringBuilder sequence = new StringBuilder();
			        String line;
			        
			        while ((line = reader.readLine()) != null) {
			            if (line.startsWith(">")) {
			                header = line.substring(1);
			            } else {
			                sequence.append(line.trim());
			            }
			        }

			        takeHeader.setText(header);
			        takeRNA.setText(sequence.toString());
			        
			    } catch (IOException e1) {
			        e1.printStackTrace();
			    }
			}
			
		}
		
	}
	
}
