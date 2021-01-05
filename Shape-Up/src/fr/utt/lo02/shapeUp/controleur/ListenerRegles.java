package fr.utt.lo02.shapeUp.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import fr.utt.lo02.shapeUp.vue.Parametres;
import fr.utt.lo02.shapeUp.vue.Regle;


public class ListenerRegles implements MouseListener{

	
	public ListenerRegles() {
		super();
	}


	public void mouseClicked(MouseEvent arg0) {
	
	}


	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}


	public void mousePressed(MouseEvent arg0) {
		Regle regle = new Regle();
		regle.frame.setVisible(true);
		
	}


	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	

}
