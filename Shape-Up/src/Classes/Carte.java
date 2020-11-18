package Classes;

public class Carte {
	Couleur couleur;
	Forme forme;
	boolean estPlein;
	
	public Carte(Couleur couleur, Forme forme, boolean estPlein){
		this.couleur = couleur;
		this.forme = forme;
		this.estPlein = false;
	}

}
