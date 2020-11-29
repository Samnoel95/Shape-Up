package fr.utt.lo02.shapeUp.Joueur;

import fr.utt.lo02.shapeUp.Carte.Pioche;
import fr.utt.lo02.shapeUp.Tapis.Tapis;

public interface Strategie {

	public void joueAdvanced(Joueur joueur,Tapis tapis, Pioche pioche);
	public void jouer(Joueur joueur,Tapis tapis, Pioche pioche);
}
