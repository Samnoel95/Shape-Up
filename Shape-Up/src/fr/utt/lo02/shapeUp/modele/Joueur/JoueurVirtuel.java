package fr.utt.lo02.shapeUp.modele.Joueur;


import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;

/** 
 * Cette classe permet d'instancier des joueurs virtuels dans la partie et de lui donner une strat�gie. 
 * @author Sam Noel 
 *
 */

public class JoueurVirtuel extends Joueur {

	private int difficulte;
	private Strategie strategie;
/**
 * Constructeur de la classe JoueurVirtuel
 * @param nomJoueur Un nom de joueur : String
 * @param commence Un bool�en pour savoir si le joueur commence, true pour commencer
 * @param difficulte Un int qui d�finit la difficult� du joueur, 1 pour facile, 2 pour difficile 
 */
	public JoueurVirtuel(String nomJoueur, boolean commence, int difficulte) {
		super(nomJoueur,commence);
		this.difficulte = difficulte;
		if(difficulte == 1) {
			this.strategie = new StrategieFacile();
		}

		if(difficulte == 2) {
			this.strategie = new StrategieDifficile();
		}
	}

/**
 * Getter de la difficult� du joueur 
 * @return La diffcult� du joueur : un int, 1 pour facile, 2 pour difficile 
 */
	public int getDifficulte() {
		return difficulte;
	}

/**
 * Setter de la difficult� du joueur 
 * @param difficulte  un int, 1 pour facile, 2 pour difficile 
 */
	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}

	@Override
	public void jouerAdvanced(Joueur joueur,Tapis tapis, Pioche pioche, Visiteur compteur) {
		this.strategie.joueAdvancedV(joueur, tapis, pioche, compteur );
	}
	@Override
	public void jouer(Joueur joueur,Tapis tapis, Pioche pioche,Visiteur compteur) {
		this.strategie.jouerV(joueur,tapis, pioche, compteur); 

	}



}
