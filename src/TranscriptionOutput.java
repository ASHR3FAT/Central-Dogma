import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private Font font2;
	private Font font1;
	
	private JLabel mainHeadline;
	private JLabel inputHeadline;
	private JLabel outputHeadline;
	private JButton copyInputBtn;
	private JButton copyOutputBtn;
	private JButton tipBtn;
	private JScrollPane inputScroll;
	private JScrollPane outputScroll;
	private JTextArea input;
	private JTextArea output;
	
	public String rna;
	
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
		
		tipIcon = new ImageIcon(getClass().getResource("./images/tip_button.png"));
		
		font2 = new Font("Monospaced", Font.PLAIN, 15);
		font1 = new Font("Monospaced", Font.PLAIN, 25);
		
		tipBtn = new JButton(tipIcon);
		tipBtn.setFocusable(false);
		tipBtn.addActionListener(this);
		tipBtn.setBounds(885, 65, 32, 32);
		tipBtn.setBackground(Color.decode("#DC143C"));
		tipBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(tipBtn);
		
		mainHeadline = new JLabel();
		mainHeadline.setText(" Transcription Output");
		mainHeadline.setBounds(330, 35, 330, 50);
		mainHeadline.setFont(font1);
		mainHeadline.setOpaque(true);
		mainHeadline.setBackground(Color.decode("#DC143C"));
		mainHeadline.setForeground(Color.WHITE);
		mainHeadline.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.add(mainHeadline);
		
		inputHeadline = new JLabel();
		inputHeadline.setText(" DNA Sequence");
		inputHeadline.setBounds(150, 120, 130, 25);
		inputHeadline.setFont(font2);
		inputHeadline.setOpaque(true);
		inputHeadline.setBackground(Color.decode("#DC143C"));
		inputHeadline.setForeground(Color.WHITE);
		inputHeadline.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.add(inputHeadline);
		
		copyInputBtn = new JButton();
		copyInputBtn.setText("Copy");
		copyInputBtn.setBounds(760, 125, 70, 25);
		copyInputBtn.setBackground(Color.decode("#DC143C"));
		copyInputBtn.setForeground(Color.WHITE);
		copyInputBtn.setBorder(BorderFactory.createLineBorder(Color.RED));
		copyInputBtn.addActionListener(this);
		copyInputBtn.setFocusable(false);
		copyInputBtn.setFont(font2);
		this.add(copyInputBtn);
		
		input = new JTextArea(TranscriptionTool.dna);
		input.setLineWrap(true);
		input.setEditable(false);
		input.setBackground(Color.BLACK);
		input.setForeground(Color.decode("#DC143C"));
		input.setFocusable(false);
		Border border1 = BorderFactory.createLineBorder(Color.RED);
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
		outputHeadline.setText(" mRna Sequence");
		outputHeadline.setBounds(150, 340, 140, 25);
		outputHeadline.setFont(font2);
		outputHeadline.setOpaque(true);
		outputHeadline.setBackground(Color.decode("#DC143C"));
		outputHeadline.setForeground(Color.WHITE);
		outputHeadline.setBorder(BorderFactory.createLineBorder(Color.RED));
		this.add(outputHeadline);
		
		copyOutputBtn = new JButton();
		copyOutputBtn.setText("Copy");
		copyOutputBtn.setBounds(760, 345, 70, 25);
		copyOutputBtn.setBackground(Color.decode("#DC143C"));
		copyOutputBtn.setForeground(Color.WHITE);
		copyOutputBtn.setBorder(BorderFactory.createLineBorder(Color.RED));
		copyOutputBtn.addActionListener(this);
		copyOutputBtn.setFocusable(false);
		copyOutputBtn.setFont(font2);
		this.add(copyOutputBtn);
		
		output = new JTextArea(rna);
		output.setLineWrap(true);
		output.setEditable(false);
		output.setBackground(Color.BLACK);
		output.setForeground(Color.decode("#DC143C"));
		output.setFocusable(false);
		Border border = BorderFactory.createLineBorder(Color.RED);
		output.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		output.setBounds(150, 370, 680, 150);
		output.setFont(font2);
		this.add(output);
		
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
	                                      "DNA SEQUENCE HAS BEEN COPIED!");
		}
		
		else if(e.getSource() == copyOutputBtn) {
			String str = input.getText();
	        Clipboard clip = Toolkit.getDefaultToolkit()
	                             .getSystemClipboard();
	        StringSelection strSelect = new StringSelection(str);
	        clip.setContents(strSelect, strSelect);
	        JOptionPane.showMessageDialog(null,
	                                      "mRNA SEQUENCE HAS BEEN COPIED!");
		}
		
		else if(e.getSource() == tipBtn) {
			new TranscriptionTip();
		}
		
	}
	
}
