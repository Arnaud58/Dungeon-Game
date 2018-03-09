package Displayer.Graph;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Displayer.DispGraph;

/**
 * A button that link to a action (with a int)
 * @author rougetet and lefevere
 *
 */
public class ActionButton extends JButton implements ActionListener {
	
	private int theAction;	
	
	/**
	 * Create a new button that represent an action
	 * @param a The int corresponding to the action
	 * @param txt A description of the action
	 */
	public ActionButton(int a,String txt) {
		super(txt);
		this.setPreferredSize(new Dimension(150, 50));
		this.theAction=a;
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
			DispGraph.setActList(theAction);
	}

}
