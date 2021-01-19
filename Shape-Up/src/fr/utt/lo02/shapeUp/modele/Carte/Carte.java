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
	/**
	 * Getter de la couleur de la carte 
	 * @return La couleur de la carte : Couleur
	 */
	public Couleur getCouleur() {
		return couleur;
	}
	/**
	 * Setter de la couleur de la carte 
	 * @param couleur Une couleur : Couleur 
	 */
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	/**
	 * Getter de la forme de la carte 
	 * @return La forme de la carte : Forme
	 */
	public Forme getForme() {
		return forme;
	}
	/**
	 * Setter de la forme de la carte 
	 * @param forme Une forme : Forme
	 */
	public void setForme(Forme forme) {
		this.forme = forme;
	}
	/**
	 * Getter du booléen estPLein 
	 * @return Un booléen qui qui prend true si la carte est pleine ou false si la carte est vide 
	 */
	public boolean getEstPlein() {
		return estPlein;
	}
	/**
	 * Setter du booléen estPlein 
	 * @param estPlein Un booléen qui qui prend true si la carte est pleine ou false si la carte est vide 
	 */
	public void setEstPlein(boolean estPlein) {
		this.estPlein = estPlein;
	}
	/**
	 * Getter de l'image de la carte 
	 * @return L'image de la carte 
	 */
	public BufferedImage getImageCarte() {
		return imageCarte;
	}
	/**
	 * Setter de l'image de la carte 
	 * @param imageCarte Une image 
	 */
	public void setImageCarte(BufferedImage imageCarte) {
		this.imageCarte = imageCarte;
	}
/**
 * Affiche les caractéristiques de la carte 
 */
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
}
