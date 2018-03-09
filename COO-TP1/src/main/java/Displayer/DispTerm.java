
package Displayer;

import java.util.List;

import Characters.Player;

public class DispTerm implements Display{



	public void displayMessage(String txt) {
		System.out.print(txt);
		
	}


	public <T> T choose(String txt, String listText, List<T> listElm,Player p) {
		int listSize = listElm.size();
		System.out.println(txt+"\n");

		System.out.println("\t0) Do nothing \n");

		for (int i=0;i<listSize;i++) {
			System.out.println("\t"+(i+1)+") "+listText+" "+listElm.get(i)+"\n");
		}

		int j = ScannerInt.readInt(listSize+1);

		if (j==0) {
			return null;
		}

		return listElm.get(j-1);
	}


	public void beginning() {
		System.out.println("Your are in a dungeon and you must to escape !\n");
		
	}
	

}
