package Displayer.Graph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TextPanel extends JPanel {
	
	private String txt;
	
	/**
	 * Create a new panel that print an string information to the player
	 * @param v The information we want to print in the panel
	 */
	public TextPanel(String v) {
		this.setPreferredSize(new Dimension(500,50));
		this.txt=v;
	}
	
	/**
	 * Reset the value of the information given
	 * @param newV The new value of the information
	 */
	public void setValue(String newV) {
		this.txt=newV;
	}
	
	public void paintComponent(Graphics g){
		Font font = new Font("Courier", Font.BOLD, 18);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500,50);
	    g.setFont(font);
	    g.setColor(Color.black);      
	    g.drawString(this.txt, 0, 20);       
	}

}
