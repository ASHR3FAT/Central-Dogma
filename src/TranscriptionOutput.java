import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TranscriptionOutput extends JFrame implements ActionListener {
	
	private ImageIcon mainIcon;
	private ImageIcon tipIcon;
	private ImageIcon copyIcon;
	private Font font2;
	private Font font1;
	
	private JLabel mainHeadline;
	private JLabel seqHeadline;
	private JLabel outputHeadline;
	private JButton copyOutputBtn;
	private JButton tipBtn;
	private JScrollPane outputScroll;
	private JTextArea output;
	private JTextArea seqArea;
	private JTextArea summaryArea;
	
	public String rna;
	public int countA;
	public int countU;
	public int countG;
	public int countC;
	
	TranscriptionOutput(String dna) {
		
		rna = "";
		for(int i=0;i<dna.length();i++) {
			if(dna.charAt(i)=='T') {
				rna += 'U';
			}
			else {
				rna += dna.charAt(i);
			}
		}

		mainIcon = new ImageIcon(getClass().getResource("./images/title_logo.png"));
		this.setIconImage(mainIcon.getImage());
		
		tipIcon = new ImageIcon(getClass().getResource("./images/info.png"));
		copyIcon = new ImageIcon(getClass().getResource("./images/copy.png"));
		
		font2 = new Font("Monospaced", Font.PLAIN, 15);
		font1 = new Font("Monospaced", Font.BOLD, 25);
		
		tipBtn = new JButton(tipIcon);
		tipBtn.setFocusable(false);
		tipBtn.addActionListener(this);
		tipBtn.setBounds(885, 65, 40, 40);
		tipBtn.setBackground(Color.decode("#DC143C"));
		tipBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(tipBtn);
		
		mainHeadline = new JLabel();
		mainHeadline.setText(" Transcription Output");
		mainHeadline.setBounds(330, 35, 330, 50);
		mainHeadline.setFont(font1);
		mainHeadline.setOpaque(true);
		mainHeadline.setForeground(Color.decode("#DC143C"));
		mainHeadline.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.add(mainHeadline);
		
		seqHeadline = new JLabel();
		seqHeadline.setText("Sequence ID: ");
		seqHeadline.setBounds(150, 150, 130, 25);
		seqHeadline.setFont(font2);
		seqHeadline.setForeground(Color.decode("#EAEFEF"));
		this.add(seqHeadline);
		
		seqArea = new JTextArea(TranscriptionTool.header);
		seqArea.setLineWrap(true);
		seqArea.setEditable(false);
		seqArea.setFocusable(false);
		seqArea.setBackground(Color.decode("#EAEFEF"));
		seqArea.setForeground(Color.RED);
		Border border = BorderFactory.createLineBorder(Color.RED);
		seqArea.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		seqArea.setBounds(150, 180, 680, 40);
		seqArea.setFont(font2);
		this.add(seqArea);
		
		outputHeadline = new JLabel();
		outputHeadline.setText("mRna Sequence: ");
		outputHeadline.setBounds(150, 240, 160, 25);
		outputHeadline.setFont(font2);
		outputHeadline.setForeground(Color.WHITE);
		this.add(outputHeadline);
		
		copyOutputBtn = new JButton(copyIcon);
		copyOutputBtn.setBounds(810, 240, 20, 20);
		copyOutputBtn.setBackground(Color.decode("#EAEFEF"));
		copyOutputBtn.setBorder(BorderFactory.createLineBorder(Color.decode("#537D5D")));
		copyOutputBtn.addActionListener(this);
		copyOutputBtn.setFocusable(false);
		copyOutputBtn.setFont(font2);
		copyOutputBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {
				copyOutputBtn.setBackground(Color.decode("#537D5D"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				copyOutputBtn.setBackground(Color.WHITE);
			}
			
		});
		this.add(copyOutputBtn);
		
		output = new JTextArea(rna);
		output.setLineWrap(true);
		output.setEditable(false);
		output.setBackground(Color.decode("#EAEFEF"));
		output.setForeground(Color.decode("#DC143C"));
		output.setFocusable(false);
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		output.setBorder(BorderFactory.createCompoundBorder(border2, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		output.setBounds(150, 270, 680, 150);
		output.setFont(font2);
		this.add(output);
		
		outputScroll = new JScrollPane(output);
		outputScroll.setBounds(150, 270, 680, 150);
		outputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(outputScroll);
		
		summaryArea = new JTextArea();
		summaryArea.setLineWrap(true);
		summaryArea.setEditable(false);
		summaryArea.setText("Length of the mRNA: " + rna.length() + "\n"
				+ "GC Content: " + calGC(rna) + "\n"
				+ "Codon Count: " + (rna.length())/3 + "\n"
				+ "Estimated Molecular Weight: " + molWt(rna) + " g/mol");
		summaryArea.setFocusable(false);
		summaryArea.setBackground(Color.decode("#504B38"));
		summaryArea.setForeground(Color.WHITE);
		summaryArea.setBounds(150, 430, 680, 150);
		summaryArea.setFont(font2);
		this.add(summaryArea);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#504B38"));
		this.setTitle("Central Dogma");
		this.setBounds(180, 75, 1000, 615);
		
	}
	
	public int calGC(String rna) {
		countG=0;
		countC=0;
		if(rna.length()==0) {
			return 0;
		}
		for(int i=0;i<rna.length();i++) {
			if(rna.charAt(i)=='G') {
				countG++;
			}
			else if(rna.charAt(i)=='C') {
				countC++;
			}
		}
		double gcContent = ((double)(countG + countC) / rna.length()) * 100;
	    return (int)Math.round(gcContent);
	}
	
	public int molWt(String rna) {
		countA=0;
		countU=0;
		countG=0;
		countC=0;
		if(rna.length()==0) {
			return 0;
		}
		for(int i=0;i<rna.length();i++) {
			if(rna.charAt(i)=='A') {
				countA++;
			}
			else if(rna.charAt(i)=='U') {
				countU++;
			}
			else if(rna.charAt(i)=='G') {
				countG++;
			}
			else if(rna.charAt(i)=='C') {
				countC++;
			}
		}
		return ((countA*313 + countU*290 + countG*329 + countC*289) - (rna.length()-1)*18);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == copyOutputBtn) {
			String str = output.getText();
	        Clipboard clip = Toolkit.getDefaultToolkit()
	                             .getSystemClipboard();
	        StringSelection strSelect = new StringSelection(str);
	        clip.setContents(strSelect, strSelect);
		}
		
		else if(e.getSource() == tipBtn) {
			new TranscriptionTip();
		}
		
	}
	
}
