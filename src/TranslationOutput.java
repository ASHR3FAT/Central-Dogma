import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private Font font2;
	private Font font1;
	
	private JLabel mainHeadline;
	private JLabel inputHeadline;
	private JLabel outputHeadline;
	private JScrollPane inputScroll;
	private JScrollPane outputScroll;
	private JTextArea input;
	private JTextArea output;
	private JButton copyInputBtn;
	private JButton copyOutputBtn;
	private JButton tipBtn;
	
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
		
		tipIcon = new ImageIcon(getClass().getResource("./images/tip_button.png"));
		
		font2 = new Font("Monospaced", Font.PLAIN, 15);
		font1 = new Font("Monospaced", Font.PLAIN, 25);
		
		tipBtn = new JButton(tipIcon);
		tipBtn.setFocusable(false);
		tipBtn.addActionListener(this);
		tipBtn.setBounds(885, 65, 32, 32);
		tipBtn.setBackground(Color.decode("#007FFF"));
		tipBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(tipBtn);
		
		mainHeadline = new JLabel();
		mainHeadline.setText("  Translation Output");
		mainHeadline.setBounds(330, 35, 330, 50);
		mainHeadline.setFont(font1);
		mainHeadline.setOpaque(true);
		mainHeadline.setBackground(Color.decode("#007FFF"));
		mainHeadline.setForeground(Color.BLACK);
		mainHeadline.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		this.add(mainHeadline);
		
		inputHeadline = new JLabel();
		inputHeadline.setText(" mRNA Sequence");
		inputHeadline.setBounds(150, 120, 140, 25);
		inputHeadline.setFont(font2);
		inputHeadline.setOpaque(true);
		inputHeadline.setBackground(Color.decode("#007FFF"));
		inputHeadline.setForeground(Color.BLACK);
		inputHeadline.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		this.add(inputHeadline);
		
		copyInputBtn = new JButton();
		copyInputBtn.setText("Copy");
		copyInputBtn.setBounds(760, 125, 70, 25);
		copyInputBtn.setBackground(Color.decode("#007FFF"));
		copyInputBtn.setForeground(Color.BLACK);
		copyInputBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		copyInputBtn.addActionListener(this);
		copyInputBtn.setFocusable(false);
		copyInputBtn.setFont(font2);
		this.add(copyInputBtn);
		
		input = new JTextArea(TranslationTool.rna);
		input.setLineWrap(true);
		input.setEditable(false);
		input.setBackground(Color.BLACK);
		input.setForeground(Color.decode("#007FFF"));
		input.setFocusable(false);
		Border border1 = BorderFactory.createLineBorder(Color.BLUE);
		input.setBorder(BorderFactory.createCompoundBorder(border1, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		input.setBounds(150, 150, 680, 150);
		input.setFont(font2);
		this.add(input);
		
		inputScroll = new JScrollPane(input);
		inputScroll.setBounds(150, 150, 680, 150);
		inputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(inputScroll);
		
		outputHeadline = new JLabel();
		outputHeadline.setText(" Protein Sequence");
		outputHeadline.setBounds(150, 340, 165, 25);
		outputHeadline.setFont(font2);
		outputHeadline.setOpaque(true);
		outputHeadline.setBackground(Color.decode("#007FFF"));
		outputHeadline.setForeground(Color.BLACK);
		outputHeadline.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		this.add(outputHeadline);
		
		output = new JTextArea(protein);
		output.setLineWrap(true);
		output.setEditable(false);
		output.setBackground(Color.BLACK);
		output.setForeground(Color.decode("#007FFF"));
		output.setCaretColor(Color.BLACK);
		Border border = BorderFactory.createLineBorder(Color.BLUE);
		output.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		output.setBounds(150, 370, 680, 150);
		output.setFont(font2);
		this.add(output);
		
		copyOutputBtn = new JButton();
		copyOutputBtn.setText("Copy");
		copyOutputBtn.setBounds(760, 345, 70, 25);
		copyOutputBtn.setBackground(Color.decode("#007FFF"));
		copyOutputBtn.setForeground(Color.BLACK);
		copyOutputBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		copyOutputBtn.addActionListener(this);
		copyOutputBtn.setFocusable(false);
		copyOutputBtn.setFont(font2);
		this.add(copyOutputBtn);
		
		outputScroll = new JScrollPane(output);
		outputScroll.setBounds(150, 370, 680, 150);
		outputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add(outputScroll);
		
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
		if(e.getSource() == copyInputBtn) {
			String str = input.getText();
	        Clipboard clip = Toolkit.getDefaultToolkit()
	                             .getSystemClipboard();
	        StringSelection strSelect = new StringSelection(str);
	        clip.setContents(strSelect, strSelect);
	        JOptionPane.showMessageDialog(null,
	                                      "mRNA SEQUENCE HAS BEEN COPIED!");
		}
		
		else if(e.getSource() == copyOutputBtn) {
			String str = input.getText();
	        Clipboard clip = Toolkit.getDefaultToolkit()
	                             .getSystemClipboard();
	        StringSelection strSelect = new StringSelection(str);
	        clip.setContents(strSelect, strSelect);
	        JOptionPane.showMessageDialog(null,
	                                      "PROTEIN SEQUENCE HAS BEEN COPIED!");
		}
		
		else if(e.getSource() == tipBtn) {
			new TranslationTip();
		}
		
	}
	
}