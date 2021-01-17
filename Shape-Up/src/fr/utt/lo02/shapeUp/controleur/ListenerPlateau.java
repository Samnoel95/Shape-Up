package fr.utt.lo02.shapeUp.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import fr.utt.lo02.shapeUp.vue.Parametres;
import fr.utt.lo02.shapeUp.vue.Plateau;
import fr.utt.lo02.shapeUp.vue.Regle;

/**
 * Classe qui agit au clic de la souris
 * 
 * 
 * @author Lorène Bergougnoux
 *
 */

public class ListenerPlateau implements MouseListener {

	/**
	 * Constructeur de la classe ListenerPlateau
	 * 
	 */

	public ListenerPlateau() {
		super();
	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	/**
	 * Méthode qui permet l'ouverture d'une page plateau au clic
	 * 
	 * @param arg0, un évènement lié à la souris
	 */

	public void mousePressed(MouseEvent arg0) {
		Plateau plate = new Plateau();
		plate.frame.setVisible(true);

	}

	public void mouseReleased(MouseEvent arg0) {

	}

}