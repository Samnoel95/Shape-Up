package fr.utt.lo02.shapeUp.modele.Carte;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;



public class Carte {
	
	private BufferedImage imageCarte;
	private Couleur couleur;
	private Forme forme;
	private boolean estPlein;
	PositionCarte position;
	
	public Carte() {
	}
	
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
			this.imageCarte = ImageIO.read(url);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	
	// main pour tests
	public static void main(String[]args){
		Carte c1 = new Carte(Couleur.BLEU, Forme.CARRE, false);

	
		
		
		System.out.println(c1.toString());
	
		
		PositionCarte position = new PositionCarte(1,2);
		c1.position = position;
		System.out.println(c1.position.toString());
		
	}

}
