package fr.utt.lo02.shapeUp.modele.Joueur;

import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;

/**
 * Cette interface décrit les méthodes de jeu pour les joueurs virtuels 
 * @author Sam Noel 
 *
 */
public interface Strategie {
	/**
	 * Cette classe permet au joueur virtuel de choisir une carte dans sa main. 
	 * @param joueur Le joueur virtuel qui joue son tour de jeu.
	 * @return Un int qui donne la place de la carte dans la main du joueur. 
	 */
	public int choisirCarte(Joueur joueur);
/**
 * Cette méthode permet au joueur virtuel de jouer un tour de jeu en version avancée.
 * @param joueur Le joueur virtuel qui joue son tour de jeu 
 * @param tapis Le tapis de la partie 
 * @param pioche La pioche de la partie 
 * @param compteur Le compteur de la partie 
 */
	public void joueAdvancedV(Joueur joueur,Tapis tapis, Pioche pioche,Visiteur compteur);
	
/**
 * Cette méthode permet au joueur virtuel de jouer un tour de jeu en version classique.
 * @param joueur Le joueur virtuel qui joue son tour de jeu
 * @param tapis Le tapis de la partie 
 * @param pioche La pioche de la partie 
 * @param compteur Le compteur de la partie 
 */
	public void jouerV(Joueur joueur,Tapis tapis, Pioche pioche, Visiteur compteur);
}
