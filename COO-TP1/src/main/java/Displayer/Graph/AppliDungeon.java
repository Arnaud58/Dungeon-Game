package Displayer.Graph;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Characters.Player;
import Displayer.Graph.ActionButton;


public class AppliDungeon {
	
	protected JFrame window;
	protected JPanel panel;
	
	protected PanelImage imgPanel;
	protected infoPanel lifePanel;
	protected infoPanel powerPanel;
	protected infoPanel goldPanel;
	protected TextPanel textPanel;
	protected JPanel ButtonP;
	
	protected GridBagConstraints gbc;
	
	/**
	 * Create a new interface to play with the dungeon
	 * @param str The name of the window
	 * @param x The position x in the screen
	 * @param y The position x in the screen
	 */
	public AppliDungeon(String str,int x,int y) {
		
		this.window= new JFrame();
	
		this.window.setTitle(str);
		this.window.setSize(600, 700);
		this.window.setLocation(x, y);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.panel = new JPanel();
		this.panel.setBackground(Color.WHITE);
		
		this.imgPanel = new PanelImage();
		this.imgPanel.setPreferredSize(new Dimension(600,400));  
		this.imgPanel.setOpaque(false);
		
		lifePanel = new infoPanel(0,Color.red);
		lifePanel.setPreferredSize(new Dimension(165, 40));      

	    powerPanel = new infoPanel(0,Color.orange);
	    powerPanel.setPreferredSize(new Dimension(165, 40));

	    goldPanel = new infoPanel(0,Color.yellow);
	    goldPanel.setPreferredSize(new Dimension(165, 40));
	    
	    ButtonP = new JPanel();
	    ButtonP.setBackground(Color.WHITE);
	    
	    this.textPanel=new TextPanel("Donjon en construction...");
	    this.textPanel.setBackground(Color.WHITE);
	
		this.panel.setLayout(new GridBagLayout());
		this.PlaceAllPanel();
		
		this.window.add(this.panel);
	}

	/**
	 * Place diferent panels : information about life, power and gold,
	 * room image and chose button in the window
	 */
	public void PlaceAllPanel() {
		gbc = new GridBagConstraints();
	    
	    gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.gridheight = 5;		
		
		this.panel.add(this.imgPanel,gbc);

		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.panel.add(lifePanel,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		this.panel.add(powerPanel,gbc);

		gbc.gridx = 2;
		gbc.gridy = 6;
		this.panel.add(goldPanel,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		this.panel.add(this.textPanel,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		this.panel.add(ButtonP,gbc);
	}
	
	/**
	 * Delete the old button panel and replace it by a new one
	 */
	public void newBP() {
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.gridwidth = 3;
		gbc.gridheight = 1;
		
		ButtonP.setVisible(false);
		this.panel.remove(ButtonP);
		ButtonP = new JPanel();
		ButtonP.setBackground(Color.WHITE);
		
		GridLayout gl = new GridLayout(3,3);
		gl.setColumns(3);
		gl.setRows(3);
		gl.setHgap(10);
		gl.setVgap(10);
		ButtonP.setLayout(gl);
		
		this.panel.add(ButtonP,gbc);			
	}
	
	/**
	 * Add a button to the button panel
	 * need to be a action button because this panel is 
	 * use to make a chose
	 * @param b The button we want to put in the panel
	 */
	public void addButton(ActionButton b) {
		ButtonP.add(b);	
	}
	
	/**
	 * Change text of the information panel
	 * @param txt The text we want to put in the interface
	 */
	public void changeText(String txt) {
		this.textPanel.setValue(txt);
	}
		
	/**
	 * Force the repaint of all panel == redraw all information in panel
	 * @param p The Player in the dungeon
	 */
	public void update(Player p) {	
		lifePanel.setValue(p.getLife());
		powerPanel.setValue(p.getPower());
		goldPanel.setValue(p.getGold());
		
		lifePanel.repaint();
		powerPanel.repaint();
		goldPanel.repaint();
		textPanel.repaint();

		ButtonP.setVisible(false);
		ButtonP.setVisible(true);
		
		this.imgPanel.updateRoom(p.getRoom(),p.getComeFrom());
	}

	/**
	 * Set the interface visible
	 */
	public void display() {
		this.window.setVisible(true);
	}
	
	/**
	 * Set the interface invisible
	 */
	public void remove() {
		this.window.setVisible(false);
	}
}
