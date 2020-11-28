package fr.utt.lo02.shapeUp.Joueur;

import fr.utt.lo02.shapeUp.Carte.Carte;
import fr.utt.lo02.shapeUp.Carte.Pioche;
import fr.utt.lo02.shapeUp.Tapis.Tapis;

public class JoueurVirtuel extends Joueur {
	
		private int difficulte;
		private Strategie strategie;

		
	public JoueurVirtuel(String nomJoueur, int numJoueur, boolean commence, Carte carteVictoire, int difficulte) {
		super(nomJoueur, numJoueur, commence, carteVictoire);
		this.difficulte = difficulte;
		if(difficulte == 1) {
			this.strategie = new Strategie1();
		}
		
		if(difficulte == 2) {
			this.strategie = new Strategie2();
		}
	}


	public int getDifficulte() {
		return difficulte;
	}


	public void setDifficulte(int difficulte) {
		this.difficulte = difficulte;
	}




	public void Jouer(Joueur joueur,Tapis tapis, Pioche pioche) {
		this.strategie.jouer(joueur,tapis, pioche); 
		
	}



}