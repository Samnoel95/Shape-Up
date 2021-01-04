package fr.utt.lo02.shapeUp.modele.Joueur;

import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;

public interface Strategie {

	public void joueAdvanced(Joueur joueur,Tapis tapis, Pioche pioche,Visiteur compteur);
	public void jouer(Joueur joueur,Tapis tapis, Pioche pioche, Visiteur compteur);
}
