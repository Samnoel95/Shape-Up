package fr.utt.lo02.shapeUp.vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.JButton;

import fr.utt.lo02.shapeUp.modele.Carte.PositionCarte;

public class ButtonCard extends JButton {
	
	private Image cardImage;
	private PositionCarte positionCarte;

	
	public ButtonCard(int x, int y) {
		this.positionCarte = new PositionCarte(x, y);
		
	}

	public PositionCarte getPositionCarte() {
		return positionCarte;
	}

	public void setPositionCarte(PositionCarte positionCarte) {
		this.positionCarte = positionCarte;
	}

	public Image getCardImage() {
		return cardImage;
	}

	public void setCardImage(Image cardImage) {
		this.cardImage = cardImage;
	}
	

}
