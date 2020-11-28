package fr.utt.lo02.shapeUp.CompteurScore;

import Classes.Carte;
import Classes.Couleur;
import Classes.Forme;
import Classes.Tapis;

public interface Visiteur {
	
	public int compterLigneForme(Tapis tapis, Forme forme, int ligne);
	public int compterLigneCouleur(Tapis tapis, Couleur couleur, int ligne);
	public int compterLigneEstPlein(Tapis tapis, boolean estPlein, int ligne);
	public int compterColonneForme(Tapis tapis, Forme forme,int colonne);
	public int compterColonneCouleur(Tapis tapis, Couleur couleur, int colonne);
	public int compterColonneEstPlein(Tapis tapis, boolean estPlein, int colonne);
	public int compterScore(Tapis tapis, Carte carteV);

}
