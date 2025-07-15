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

public class TranscriptionTool extends JFrame implements ActionListener {
	
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
	private JLabel transcribtionHeadline;
	private JLabel enterHead;
	private JTextArea takeHeader;
	private JLabel enterDNA;
	private JTextArea takeDNA;
	private JScrollPane scrollBar;
	private JButton transcripe;
	private JButton clear;
	private JLabel cautionLabel;
	
	public static String dna;
	public static String header;
	public String mustdna = "ATGC";
	public int length;
	
	TranscriptionTool() {
		
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
		backBtn.setBackground(Color.decode("#DC143C"));
		backBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(backBtn);
		
		homeBtn = new JButton(homeIcon);
		homeBtn.setFocusable(false);
		homeBtn.addActionListener(this);
		homeBtn.setBounds(110, 35, 40, 40);
		homeBtn.setBackground(Color.decode("#DC143C"));
		homeBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(homeBtn);
		
		transcribtionHeadline = new JLabel();
		transcribtionHeadline.setText(" Transcription Tool");
		transcribtionHeadline.setBounds(330, 35, 300, 50);
		transcribtionHeadline.setFont(font2);
		transcribtionHeadline.setOpaque(true);
		transcribtionHeadline.setForeground(Color.decode("#DC143C"));
		transcribtionHeadline.setBackground(Color.decode("#727D73"));
		this.add(transcribtionHeadline);
		
		enterHead = new JLabel();
		enterHead.setText("Sequence ID: ");
		enterHead.setBounds(150, 110, 300, 50);
		enterHead.setFont(font3);
		enterHead.setForeground(Color.WHITE);
		this.add(enterHead);
		
		takeHeader = new JTextArea();
		takeHeader.setLineWrap(true);
		takeHeader.setBackground(Color.decode("#EAEFEF"));
		takeHeader.setForeground(Color.RED);
		Border border = BorderFactory.createLineBorder(Color.RED);
		takeHeader.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		takeHeader.setBounds(150, 160, 680, 40);
		takeHeader.setFont(font1);
		this.add(takeHeader);
		
		enterDNA = new JLabel();
		enterDNA.setText("Sequence: ");
		enterDNA.setBounds(150, 210, 300, 50);
		enterDNA.setFont(font3);
		enterDNA.setForeground(Color.WHITE);
		this.add(enterDNA);
		
		takeDNA = new JTextArea();
		takeDNA.setLineWrap(true);
		takeDNA.setBackground(Color.decode("#EAEFEF"));
		takeDNA.setForeground(Color.decode("#DC143C"));
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		takeDNA.setBorder(BorderFactory.createCompoundBorder(border2, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		takeDNA.setBounds(150, 260, 680, 150);
		takeDNA.setFont(font1);
		this.add(takeDNA);
		
		scrollBar = new JScrollPane(takeDNA);
		scrollBar.setBounds(150, 260, 680, 150);
		scrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(scrollBar);
		
		transcripe = new JButton();
		transcripe.setText("Transcripe");
		transcripe.setFocusable(false);
		transcripe.addActionListener(this);
		transcripe.setBounds(420, 420, 130, 50);
		transcripe.setBorder(BorderFactory.createLineBorder(Color.RED));
		transcripe.setBackground(Color.decode("#DC143C"));
		transcripe.setForeground(Color.WHITE);
		transcripe.setFont(font1);
		this.add(transcripe);
		
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
		
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#727D73"));
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == clear) {
			cautionLabel.setVisible(false);
			takeHeader.setText("");
			takeDNA.setText("");
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
			        takeDNA.setText(sequence.toString());
			        
			    } catch (IOException e1) {
			        e1.printStackTrace();
			    }
			}
			
		}
		
	}
	
}
