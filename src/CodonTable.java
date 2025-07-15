import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CodonTable extends JFrame {
	
	private ImageIcon mainIcon;
	
	private JTable codonTable;
	private JScrollPane codonScroll;
	
	CodonTable() {
		
		String[][] data = {
			    { "UUU", "Phenylalanine", "P" },
			    { "UUC", "Phenylalanine", "P" },
			    { "UUA", "Leucine", "L" },
			    { "UUG", "Leucine", "L" },
			    { "CUU", "Leucine", "L" },
			    { "CUC", "Leucine", "L" },
			    { "CUA", "Leucine", "L" },
			    { "CUG", "Leucine", "L" },
			    { "AUU", "Isoleucine", "I" },
			    { "AUC", "Isoleucine", "I" },
			    { "AUA", "Isoleucine", "I" },
			    { "AUG", "Methionine", "M" },
			    { "GUU", "Valine", "V" },
			    { "GUC", "Valine", "V" },
			    { "GUA", "Valine", "V" },
			    { "GUG", "Valine", "V" },
			    { "UCU", "Serine", "S" },
			    { "UCC", "Serine", "S" },
			    { "UCA", "Serine", "S" },
			    { "UCG", "Serine", "S" },
			    { "CCU", "Proline", "P" },
			    { "CCC", "Proline", "P" },
			    { "CCA", "Proline", "P" },
			    { "CCG", "Proline", "P" },
			    { "ACU", "Threonine", "T" },
			    { "ACC", "Threonine", "T" },
			    { "ACA", "Threonine", "T" },
			    { "ACG", "Threonine", "T" },
			    { "GCU", "Alanine", "A" },
			    { "GCC", "Alanine", "A" },
			    { "GCA", "Alanine", "A" },
			    { "GCG", "Alanine", "A" },
			    { "UAU", "Tyrosine", "T" },
			    { "UAC", "Tyrosine", "T" },
			    { "UAA", "Stop", "." },
			    { "UAG", "Stop", "." },
			    { "CAU", "Histidine", "H" },
			    { "CAC", "Histidine", "H" },
			    { "CAA", "Glutamine", "G" },
			    { "CAG", "Glutamine", "G" },
			    { "AAU", "Asparagine", "A" },
			    { "AAC", "Asparagine", "A" },
			    { "AAA", "Lysine", "L" },
			    { "AAG", "Lysine", "L" },
			    { "GAU", "Aspartic Acid", "A" },
			    { "GAC", "Aspartic Acid", "A" },
			    { "GAA", "Glutamic Acid", "G" },
			    { "GAG", "Glutamic Acid", "G" },
			    { "UGU", "Cysteine", "C" },
			    { "UGC", "Cysteine", "C" },
			    { "UGA", "Stop", "." },
			    { "UGG", "Tryptophan", "W" },
			    { "CGU", "Arginine", "A" },
			    { "CGC", "Arginine", "A" },
			    { "CGA", "Arginine", "A" },
			    { "CGG", "Arginine", "A" },
			    { "AGU", "Serine", "S" },
			    { "AGC", "Serine", "S" },
			    { "AGA", "Arginine", "A" },
			    { "AGG", "Arginine", "A" },
			    { "GGU", "Glycine", "G" },
			    { "GGC", "Glycine", "G" },
			    { "GGA", "Glycine", "G" },
			    { "GGG", "Glycine", "G" }
			};
		
		String[] column = {"Codon", "Protein", "Short"};
		
		mainIcon = new ImageIcon(getClass().getResource("./images/title_logo.png"));
		this.setIconImage(mainIcon.getImage());
		
		codonTable = new JTable(data,column);
		codonTable.setBounds(30, 40, 200, 300);
		codonTable.setBackground(Color.DARK_GRAY);
		codonTable.setForeground(Color.WHITE);
		
		codonScroll = new JScrollPane(codonTable);
		this.add(codonScroll);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#444444"));
		this.setTitle("Central Dogma");
		this.setBounds(180, 75, 500, 615);
		
	}
}
