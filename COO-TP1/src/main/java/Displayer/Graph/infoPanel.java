package Displayer.Graph;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class infoPanel extends JPanel {
	
	private int value;
	private Color c;
	
	/**
	 * Create a new panel that give an int information to the player
	 * @param v The value of the information we want to give/print in the panel
	 * @param c The background color of the panel
	 */
	public infoPanel(int v,Color c) {
		this.c=c;
		value=v;
	}
	
	/**
	 * Reset the value of the information given
	 * @param newV The new value of the information
	 */
	public void setValue(int newV) {
		value=newV;
	}
	
	public void paintComponent(Graphics g){
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setColor(c);
		g.fillRect(0, 0, 120, 40);
	    g.setFont(font);
	    g.setColor(Color.black);      
	    g.drawString(""+value, 70, 20);       
	}
}
