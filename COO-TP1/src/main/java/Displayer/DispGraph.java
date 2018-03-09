package Displayer;


import java.util.List;

import javax.swing.JOptionPane;

import Characters.Player;
import Displayer.Graph.ActionButton;
import Displayer.Graph.AppliDungeon;

public class DispGraph implements Display {

	private static AppliDungeon jeux;
	private static int actList;
	
	public void displayMessage(String txt) {
		JOptionPane.showMessageDialog(null,txt, "Message", JOptionPane.PLAIN_MESSAGE);	
	}

	
	public <T> T choose(String txt, String listText, List<T> listElm,Player p) {
		int listSize = listElm.size();
		ActionButton b1;
		
		DispGraph.actList=-1;
		DispGraph.jeux.changeText(txt);	
		DispGraph.jeux.newBP();
		b1=new ActionButton(0,"Nothing");
		DispGraph.jeux.addButton(b1);
		
		for (int i=0;i<listSize;i++) {
			b1 = new ActionButton(i+1,listElm.get(i).toString());
			DispGraph.jeux.addButton(b1);
		}
		
		DispGraph.jeux.update(p);
		
		while (DispGraph.actList==-1) {
			try {Thread.sleep(200);} 
			catch(InterruptedException e) {}
		}
		
		
		if (DispGraph.actList==0) {return null;}
		return listElm.get(DispGraph.actList-1);
	}
	
	public void beginning() {
		JOptionPane.showMessageDialog(null,"Présentation 1/5 : Vous allez jouer au jeux du donjon de Arnaud & Rodolphe.", "Presentation 1/5", JOptionPane.PLAIN_MESSAGE);

		JOptionPane.showMessageDialog(null,"Vous êtes perdu dans un donjon en forme de labyrinthe dans un rectangle, vous vous trouvé dans la salle la plus au nord-ouest et la sortie se trouve dans la salle le plus au sud-est. Le donjon est de taille 5*5.", "Presentation 2/5", JOptionPane.PLAIN_MESSAGE);

		JOptionPane.showMessageDialog(null,"En utilisant l'action look, vous pouvez obtenir vos coordonnée à n'importe quel moment.  Trouvez une des cartes pour avoir un plan et vous aidez à sortir ou utilisé la règle de la main droite.", "Presentation 3/5", JOptionPane.PLAIN_MESSAGE);

		JOptionPane.showMessageDialog(null,"Le champs en rouge représente la vie, celui en orange vos P.A. (= dégat que vous infligé) et le jeune votre or.", "Presentation 4/5", JOptionPane.PLAIN_MESSAGE);

	JOptionPane.showMessageDialog(null,"Vous pouvez sauvegardé l'état d'un donjon en appuyé sur save et le rechargé en appuyant sur chargé. Attention votre sauvegarde est suprimé si vous mourrez. Une partie seras automatique généré si vous mourez ou trouvez la sortie. Fermer la fenetre pour quité le jeu.", "Presentation 5/5", JOptionPane.PLAIN_MESSAGE);

		jeux = new AppliDungeon("My pet dungeon", 200,200);
		jeux.display();
	}
	
	/**
	 * Change the value of the current Action choosen by the player
	 * @param newV The new value of the action choosen
	 */
	public static void setActList(int newV)  {
		actList=newV;
	}

}
