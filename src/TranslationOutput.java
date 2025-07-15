import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TranslationOutput extends JFrame implements ActionListener {
	
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
	
	private String protein;
	
	TranslationOutput(String rna) {
		
		protein = "";
		
		Map<String, String> pm = new HashMap<String, String>();
		
        pm.put("UUU", "F");
        pm.put("UUC", "F");
        pm.put("UUA", "L");
        pm.put("UUG", "L");
        pm.put("CUU", "L");
        pm.put("CUC", "L");
        pm.put("CUA", "L");
        pm.put("CUG", "L");
        pm.put("AUU", "I");
        pm.put("AUC", "I");
        pm.put("AUA", "I");
        pm.put("AUG", "M");
        pm.put("GUU", "V");
        pm.put("GUC", "V");
        pm.put("GUA", "V");
        pm.put("GUG", "V");
        pm.put("UCU", "S");
        pm.put("UCC", "S");
        pm.put("UCA", "S");
        pm.put("UCG", "S");
        pm.put("AGU", "S");
        pm.put("AGC", "S");
        pm.put("CCU", "P");
        pm.put("CCC", "P");
        pm.put("CCA", "P");
        pm.put("CCG", "P");
        pm.put("ACU", "T");
        pm.put("ACC", "T");
        pm.put("ACA", "T");
        pm.put("ACG", "T");
        pm.put("GCU", "A");
        pm.put("GCC", "A");
        pm.put("GCA", "A");
        pm.put("GCG", "A");
        pm.put("UAU", "Y");
        pm.put("UAC", "Y");
        pm.put("UAA", ".");
        pm.put("UAG", ".");
        pm.put("UGA", ".");
        pm.put("CAU", "H");
        pm.put("CAC", "H");
        pm.put("CAA", "Q");
        pm.put("CAG", "Q");
        pm.put("AAU", "N");
        pm.put("AAC", "N");
        pm.put("AAA", "K");
        pm.put("AAG", "K");
        pm.put("GAU", "D");
        pm.put("GAC", "D");
        pm.put("GAA", "E");
        pm.put("GAG", "E");
        pm.put("UGU", "C");
        pm.put("UGC", "C");
        pm.put("UGG", "W");
        pm.put("CGU", "R");
        pm.put("CGC", "R");
        pm.put("CGA", "R");
        pm.put("CGG", "R");
        pm.put("AGA", "R");
        pm.put("AGG", "R");
        pm.put("GGU", "G");
        pm.put("GGC", "G");
        pm.put("GGA", "G");
        pm.put("GGG", "G");
        
        int i=0;
        while(i<rna.length()) {
        	if(rna.length()-i>=3) {
        		String codon = rna.substring(i, i+3);
        		if(pm.containsKey(codon)) {
        			protein += pm.get(codon);
        		}
        		else {
        			protein += "?";
        		}
        		i+=3;
        	}
        	else {
        		break;
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
		tipBtn.setBackground(Color.decode("#007FFF"));
		tipBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(tipBtn);
		
		mainHeadline = new JLabel();
		mainHeadline.setText("  Translation Output");
		mainHeadline.setBounds(330, 35, 330, 50);
		mainHeadline.setFont(font1);
		mainHeadline.setOpaque(true);
		mainHeadline.setForeground(Color.decode("#007FFF"));
		mainHeadline.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		this.add(mainHeadline);
		
		seqHeadline = new JLabel();
		seqHeadline.setText("Sequence ID: ");
		seqHeadline.setBounds(150, 150, 130, 25);
		seqHeadline.setFont(font2);
		seqHeadline.setForeground(Color.decode("#EAEFEF"));
		this.add(seqHeadline);
		
		seqArea = new JTextArea(TranslationTool.header);
		seqArea.setLineWrap(true);
		seqArea.setEditable(false);
		seqArea.setFocusable(false);
		seqArea.setBackground(Color.decode("#EAEFEF"));
		seqArea.setForeground(Color.BLUE);
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		seqArea.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		seqArea.setBounds(150, 180, 680, 40);
		seqArea.setFont(font2);
		this.add(seqArea);
		
		outputHeadline = new JLabel();
		outputHeadline.setText("Protein Sequence: ");
		outputHeadline.setBounds(150, 230, 165, 25);
		outputHeadline.setFont(font2);
		outputHeadline.setForeground(Color.WHITE);
		this.add(outputHeadline);
		
		copyOutputBtn = new JButton(copyIcon);
		copyOutputBtn.setBounds(810, 240, 20, 20);
		copyOutputBtn.setBackground(Color.decode("#EAEFEF"));
		copyOutputBtn.setForeground(Color.BLACK);
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
		
		output = new JTextArea(protein);
		output.setLineWrap(true);
		output.setEditable(false);
		output.setBackground(Color.decode("#EAEFEF"));
		output.setForeground(Color.decode("#007FFF"));
		output.setCaretColor(Color.decode("#EAEFEF"));
		Border border2 = BorderFactory.createLineBorder(Color.BLUE);
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
		summaryArea.setText("Length of the Protein: " + protein.length());
		summaryArea.setFocusable(false);
		summaryArea.setBackground(Color.decode("#444444"));
		summaryArea.setForeground(Color.WHITE);
		summaryArea.setBounds(150, 430, 680, 150);
		summaryArea.setFont(font2);
		this.add(summaryArea);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#444444"));
		this.setTitle("Central Dogma");
		this.setBounds(180, 75, 1000, 615);
		
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
			new TranslationTip();
		}
		
	}
	
}