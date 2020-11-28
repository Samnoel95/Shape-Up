package fr.utt.lo02.shapeUp.Carte;

public class Carte {
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
		Carte c1 = new Carte(Couleur.BLEU, Forme.CARRE, true);
		Carte c2 = new Carte(Couleur.ROUGE, Forme.CERCLE, false);
		Carte c3 = new Carte(Couleur.VERT, Forme.TRIANGLE, true);
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		
		PositionCarte position = new PositionCarte(1,2);
		c1.position = position;
		System.out.println(c1.position.toString());
		
	}

}
