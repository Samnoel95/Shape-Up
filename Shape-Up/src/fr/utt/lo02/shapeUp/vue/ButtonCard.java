package fr.utt.lo02.shapeUp.vue;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.JButton;

import fr.utt.lo02.shapeUp.modele.Carte.PositionCarte;

/**
 * Classe qui décrit un bouton sur le plateau
 * 
 * @author Sam Noel
 *
 */

public class ButtonCard extends JButton {

	private Image cardImage;
	private PositionCarte positionCarte;

	/**
	 * Constructeur de la classe ButtonCard
	 * 
	 * @param x, la ligne
	 * @param y, la colonne
	 */
	public ButtonCard(int x, int y) {
		this.positionCarte = new PositionCarte(x, y);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("x=" + positionCarte.getX());
				System.out.println("y=" + positionCarte.getY());

			}
		});

	}

	/**
	 * Méthode qui renvoie la position d'une carte
	 */
	public PositionCarte getPositionCarte() {
		return positionCarte;
	}

	/**
	 * Méthode qui définit la position d'une carte
	 * 
	 * @param positionCarte, la position qu'on veut donner à la carte
	 */
	public void setPositionCarte(PositionCarte positionCarte) {
		this.positionCarte = positionCarte;
	}

	/**
	 * Méthode qui renvoie l'image d'un bouton
	 */
	public Image getCardImage() {
		return cardImage;
	}

	/**
	 * Méthode qui définit l'image
	 * 
	 * @param cardImage, l'image que l'on veut donner au bouton
	 */
	public void setCardImage(Image cardImage) {
		this.cardImage = cardImage;
	}

}
