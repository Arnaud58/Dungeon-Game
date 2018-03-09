package Displayer.Graph;

import java.awt.Image;
import java.util.List;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Characters.Monster;
import Rooms.Direction;
import Rooms.Room;

import java.awt.Graphics;


public class PanelImage extends JPanel {

	private String dirImg;
	
	/**
	 * Create a new image panel with salle1.png as default background image
	 */
	public PanelImage() {
		this.dirImg="salle1.jpg";
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	    try {
		    Image img = ImageIO.read(new File(this.dirImg));      
		    g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }  
	}

	/**
	 * Give the directory to the image in the background of the panel
	 * @return A string that is the directory to the image in the 
	 * background of the panel
	 */
	public String getDirImg() {
		return this.dirImg;
	}
	
	/**
	 * Change the directory to the image in the background of the panel
	 * @param dir A string that is a directory to an image
	 */
	public void setDirImg(String dir) {
		this.dirImg=dir;
	}
	
	/**
	 * Change the background image in function of the current information
	 * @param r The current of the player
	 * @param d The direction the player come from
	 */
	public void updateRoom(Room r,Direction d) {		
		if (r.nbMonster()>0) {
			this.imgMonster(r);
		}
		else {
			this.imgRoom(r,d);
		}	
		this.repaint();
	}

	private void imgMonster(Room r) {
		List<Monster> allMst =r.getListMonster();
		
		String name = allMst.get(0).getName();
		
		if (name.equals("Bile Demon")) {
			this.dirImg="bile_demon.jpg";
			return;
		}
		if (name.equals("Horned Reaper")) {
			this.dirImg="reaper.jpg";
			return;
		}
		if (name.equals("Imp")) {
			this.dirImg="imp.jpg";
			return;
				}
		if (name.equals("Suzanne")) {
			this.dirImg="suzanne.jpg";
			return;
		}
		else {
			this.dirImg="suzanne.jpg";
			return;
		}
	}

	
	private void imgRoom(Room r, Direction d) {
		List<Direction> allDir =r.getDirection();
		
		if (allDir.contains(d.Opposite())) {
			if (allDir.contains(d.Left())) {
				if (allDir.contains(d.Right())) {
					this.dirImg="salle7.jpg";
				}
				else {
					this.dirImg="salle4.jpg";
				}
			}
			else {
				if (allDir.contains(d.Right())) {
					this.dirImg="salle5.jpg";
				}
				else {
					this.dirImg="salle2.jpg";
				}
			}
		}
			
		else {
			if (allDir.contains(d.Left())) {
				if (allDir.contains(d.Right())) {
					this.dirImg="salle6.jpg";
				}
				else {
					this.dirImg="salle1.jpg";
				}
			}
			else {
				if (allDir.contains(d.Right())) {
					this.dirImg="salle3.jpg";
				}
				else {
					this.dirImg="salle0.jpg";
				}
			}
		}
	}
	
}
