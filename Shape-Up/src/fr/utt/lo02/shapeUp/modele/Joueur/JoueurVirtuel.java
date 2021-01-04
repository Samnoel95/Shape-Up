package fr.utt.lo02.shapeUp.modele.Joueur;

import fr.utt.lo02.shapeUp.modele.Carte.Carte;
import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;

public class JoueurVirtuel extends Joueur {
	
		private int difficulte;
		private Strategie strategie;

		public JoueurVirtuel(String nomJoueur, boolean commence, int difficulte) {
			super(nomJoueur,commence);
			this.difficulte = difficulte;
			if(difficulte == 1) {
				this.strategie = new Strategie1();
			}
			
			if(difficulte == 2) {
				this.strategie = new Strategie2();
			}
		}
		
	public JoueurVirtuel(String nomJoueur, boolean commence, Carte carteVictoire, int difficulte) {
		super(nomJoueur,commence, carteVictoire);
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


	public void jouerAdvanced(Joueur joueur,Tapis tapis, Pioche pioche, Visiteur compteur) {
		this.strategie.joueAdvanced(joueur, tapis, pioche, compteur );
	}

	public void jouer(Joueur joueur,Tapis tapis, Pioche pioche,Visiteur compteur) {
		this.strategie.jouer(joueur,tapis, pioche, compteur); 
		
	}



}
