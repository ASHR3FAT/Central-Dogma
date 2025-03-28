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
import javax.swing.border.Border;

public class TranslationTip extends JFrame implements ActionListener {
	
	private ImageIcon mainIcon;
	private ImageIcon lationPic;
	private Font font1;
	private Font font2;
	private Font font3;
	
	private JLabel mainHeadline;
	private JTextArea infoLine;
	private JLabel imageHolder;
	private JButton codonBtn;
	
	TranslationTip() {
		
		mainIcon = new ImageIcon(getClass().getResource("./images/title_logo.png"));
		this.setIconImage(mainIcon.getImage());
		
		lationPic = new ImageIcon(getClass().getResource("./images/translate.png"));
		
		font1 = new Font("Monospaced", Font.PLAIN, 25);
		font2 = new Font("Monospaced", Font.PLAIN, 15);
		font3 = new Font("Monospaced", Font.PLAIN, 20);
		
		mainHeadline = new JLabel();
		mainHeadline.setText(" Translation");
		mainHeadline.setBounds(230, 35, 200, 50);
		mainHeadline.setFont(font1);
		mainHeadline.setOpaque(true);
		mainHeadline.setBackground(Color.decode("#007FFF"));
		mainHeadline.setForeground(Color.BLACK);
		mainHeadline.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		this.add(mainHeadline);
		
		infoLine = new JTextArea();
		infoLine.setLineWrap(true);
		infoLine.setEditable(false);
		infoLine.setBackground(Color.BLACK);
		infoLine.setForeground(Color.decode("#007FFF"));
		infoLine.setFocusable(false);
		infoLine.setText("DNA translation involves decoding a messenger RNA(mRNA) and using\nits information to build a polypeptide or chain of amino acids.");
		Border border1 = BorderFactory.createLineBorder(Color.BLUE);
		infoLine.setBorder(BorderFactory.createCompoundBorder(border1, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		infoLine.setBounds(25, 150, 630, 65);
		infoLine.setFont(font2);
		this.add(infoLine);
		
		imageHolder = new JLabel(lationPic);
		imageHolder.setBounds(-25, 165, 700, 340);
		this.add(imageHolder);
		
		codonBtn = new JButton();
		codonBtn.setText("Codon Table");
		codonBtn.setFocusable(false);
		codonBtn.addActionListener(this);
		codonBtn.setBounds(270, 500, 150, 50);
		codonBtn.setFont(font3);
		codonBtn.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		codonBtn.setBackground(Color.decode("#007FFF"));
		codonBtn.setForeground(Color.BLACK);
		this.add(codonBtn);
		
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#444444"));
		this.setTitle("Central Dogma");
		this.setBounds(500, 50, 700, 650);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == codonBtn) {
			new CodonTable();
		}
		
	}
}
