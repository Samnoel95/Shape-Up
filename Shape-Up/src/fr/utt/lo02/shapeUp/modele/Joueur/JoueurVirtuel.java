package fr.utt.lo02.shapeUp.modele.Joueur;

import fr.utt.lo02.shapeUp.modele.Carte.Carte;

import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;

/** 
 * Cette classe permet d'instancier des joueurs virtuels dans la partie et de lui donner une stratégie. 
 * @author Sam Noel 
 *
 */

public class JoueurVirtuel extends Joueur {

	private int difficulte;
	private Strategie strategie;

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

	public JoueurVirtuel(String nomJoueur, boolean commence, Carte carteVictoire, int difficulte) {
		super(nomJoueur,commence, carteVictoire);
		this.difficulte = difficulte;
		if(difficulte == 1) {
			this.strategie = new StrategieFacile();
		}

		if(difficulte == 2) {
			this.strategie = new StrategieDifficile();
		}
	}


	public int getDifficulte() {
		return difficulte;
	}


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
