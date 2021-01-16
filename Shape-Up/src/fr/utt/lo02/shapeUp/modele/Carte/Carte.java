package fr.utt.lo02.shapeUp.modele.Carte;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Classe qui décrit les propriétés d'une carte dans le jeu 
 * @author Sam Noel 
 *
 */

public class Carte {

	private BufferedImage imageCarte;
	private Couleur couleur;
	private Forme forme;
	private boolean estPlein;
	PositionCarte position;

	/**
	 * Constructeur de la classe carte. Dans ce constructeur, la carte est relié à une image du package imageCarte 
	 * @param couleur C'est la couleur de la carte qui vient de l'énumération Couleur 
	 * @param forme C'est la forme de la carte qui vient de l'énumération Forme 
	 * @param estPlein Booléen qui indique si la carte est pleine ou vide 
	 */
	public Carte(Couleur couleur, Forme forme, boolean estPlein){
		this.setCouleur(couleur);
		this.setForme(forme);
		this.setEstPlein(estPlein);

		String string1;
		if(this.estPlein) {
			string1 = "plein";
		}else {
			string1 = "vide";
		}


		try {
			URL url = getClass().getResource("../../imageCarte/"+forme+"_"+couleur+"_"+string1+".png");
			this.setImageCarte(ImageIO.read(url));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}


	public void setPosition(int x, int y) {
		this.position.setX(x);
		this.position.setY(y);
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

	public boolean getEstPlein() {
		return estPlein;
	}

	public void setEstPlein(boolean estPlein) {
		this.estPlein = estPlein;
	}


	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.forme);
		sb.append(", ");
		sb.append(this.couleur);
		sb.append(", ");
		if(this.estPlein == true)
			sb.append("PLEIN");
		else
			sb.append("VIDE");
		return sb.toString();
	}  



	public BufferedImage getImageCarte() {
		return imageCarte;
	}

	public void setImageCarte(BufferedImage imageCarte) {
		this.imageCarte = imageCarte;
	}

}
