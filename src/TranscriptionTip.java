import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TranscriptionTip extends JFrame {
	
	private ImageIcon mainIcon;
	private ImageIcon cripPic;
	private Font font1;
	private Font font2;
	
	private JLabel mainHeadline;
	private JTextArea infoLine;
	private JLabel imageHolder;
	private JTextArea descripLine;
	private JScrollPane descripScroll;
	
	
	TranscriptionTip() {
		
		mainIcon = new ImageIcon(getClass().getResource("./images/title_logo.png"));
		this.setIconImage(mainIcon.getImage());
		
		cripPic = new ImageIcon(getClass().getResource("./images/transcrip.png"));
		
		font1 = new Font("Monospaced", Font.PLAIN, 25);
		font2 = new Font("Monospaced", Font.PLAIN, 15);
		
		mainHeadline = new JLabel();
		mainHeadline.setText(" Transcription");
		mainHeadline.setBounds(150, 35, 225, 50);
		mainHeadline.setFont(font1);
		mainHeadline.setOpaque(true);
		mainHeadline.setBackground(Color.decode("#DC143C"));
		mainHeadline.setForeground(Color.WHITE);
		mainHeadline.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.add(mainHeadline);
		
		infoLine = new JTextArea();
		infoLine.setLineWrap(true);
		infoLine.setEditable(false);
		infoLine.setBackground(Color.BLACK);
		infoLine.setForeground(Color.decode("#DC143C"));
		infoLine.setFocusable(false);
		infoLine.setText("DNA transcription is the process of copying a DNA sequence into a messenger RNA (mRNA) molecule.");
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		infoLine.setBorder(BorderFactory.createCompoundBorder(border1, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		infoLine.setBounds(25, 100, 480, 70);
		infoLine.setFont(font2);
		this.add(infoLine);
		
		imageHolder = new JLabel(cripPic);
		imageHolder.setBounds(-50, 170, 700, 225);
		this.add(imageHolder);
		
		descripLine = new JTextArea();
		descripLine.setLineWrap(true);
		descripLine.setEditable(false);
		descripLine.setBackground(Color.BLACK);
		descripLine.setForeground(Color.decode("#DC143C"));
		descripLine.setCaretColor(Color.BLACK);
		descripLine.setText("The steps of DNA transcription are initiation,\nelongation, and termination.\n\n"
				+ "Initiation\n"
				+ "1. The enzyme RNA polymerase attaches to the DNA at a specific sequence called the promoter.\n"
				+ "2. The DNA unwinds, allowing the RNA polymerase to read the bases in one of the DNA strands.\n\n"
				+ "Elongation\n"
				+ "1. The RNA polymerase moves along the DNA\ntemplate strand in the 3' to 5' direction.\n"
				+ "2. For each nucleotide in the DNA, the RNA\npolymerase adds a matching RNA nucleotide(A,U,G,C) to the 3' end of the RNA strand.\n\n"
				+ "Termination\n"
				+ "1. The RNA polymerase transcribes a sequence of DNA called the terminator.\n"
				+ "2. The newly synthesized mRNA is released from\nthe elongation complex\n");
		descripLine.setBorder(BorderFactory.createCompoundBorder(border1, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		descripLine.setBounds(25, 400, 480, 230);
		descripLine.setFont(font2);
		this.add(descripLine);
		
		descripScroll = new JScrollPane(descripLine);
		descripScroll.setBounds(25, 400, 480, 230);
		descripScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(descripScroll);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#504B38"));
		this.setTitle("Central Dogma");
		this.setBounds(500, 30, 550, 700);
		
	}

}
