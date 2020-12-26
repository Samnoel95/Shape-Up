package fr.utt.lo02.shapeUp.Joueur;

import java.util.Random;
import java.util.Map.Entry;

import fr.utt.lo02.shapeUp.Carte.Carte;
import fr.utt.lo02.shapeUp.Carte.Pioche;
import fr.utt.lo02.shapeUp.Carte.PositionCarte;
import fr.utt.lo02.shapeUp.CompteurScore.CompteurInverse;
import fr.utt.lo02.shapeUp.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.Tapis.Tapis;

public class Strategie2 implements Strategie{

	

	
	public PositionCarte choixPositionClassique(Joueur joueur, Tapis tapis, Carte carte,Visiteur compteur) {
		int scoreSauv = 0;
		PositionCarte positionSauv = new PositionCarte (-9,9);
		PositionCarte position = new PositionCarte(-8, 8);
		
		for( int i = tapis.getXMin() -1 ; i <= tapis.getXMax() + 1 ; i++) {
			for(int j = tapis.getYMin() -1 ; j <= tapis.getYMax()+1; j++) {
				position.setX(i);
				position.setY(j);
				if(!(tapis.isExist(position))) {
					if(tapis.isAdjacent(position)) {
						tapis.getPlateau().put(position, carte);
						if(tapis.layoutOk(position)) {
							if(scoreSauv <= compteur.compterScore(tapis, joueur.getCarteVictoire())) {
								scoreSauv = compteur.compterScore(tapis, joueur.getCarteVictoire());
								positionSauv.setX(i);
								positionSauv.setY(j);
								
							}
						}
						tapis.getPlateau().remove(position);
					}
				}
			}
		}	
		return positionSauv;
		
	}
	
	public int choisirCarte(Joueur joueur) {
		int i = 0;
		if(joueur.carteEnMain.size() == 3) {
			i = 1 + (int)(Math.random() * ((2 - 1) + 1));
		}
		
		if(joueur.carteEnMain.size() == 2) {
			i = 1; 
		}
		
		return i;		
	}
	
	public PositionCarte choixPositionAdvanced(Joueur joueur, Tapis tapis, Carte carte,Visiteur compteur) {
		int scoreSauv = 0;
		PositionCarte positionSauv = new PositionCarte (-9,9);
		PositionCarte position = new PositionCarte(-8, 8);
		
		for( int i = tapis.getXMin() -1 ; i <= tapis.getXMax() + 1 ; i++) {
			for(int j = tapis.getYMin() -1 ; j <= tapis.getYMax()+1; j++) {
				position.setX(i);
				position.setY(j);
				if(!(tapis.isExist(position))) {
					if(tapis.isAdjacent(position)) {
						tapis.getPlateau().put(position, carte);
						if(tapis.layoutOk(position)) {
							if(scoreSauv <= compteur.compterScore(tapis, joueur.getCarteEnMain().get(0))) {
								scoreSauv = compteur.compterScore(tapis, joueur.getCarteEnMain().get(0));
								positionSauv.setX(i);
								positionSauv.setY(j);
								
							}
						}
						tapis.getPlateau().remove(position);
					}
				}
			}
		}	
		return positionSauv;
		
	}
	
	
	
	@Override
	public void joueAdvanced(Joueur joueur, Tapis tapis, Pioche pioche,Visiteur compteur) {
		int i = this.choisirCarte(joueur);
		System.out.println(joueur.getNomJoueur()+" c'est ton tour !");
		PositionCarte position = choixPositionAdvanced(joueur, tapis, joueur.getCarteEnMain().get(i), compteur);
		joueur.poserCarte(position, joueur.getCarteEnMain().get(i), tapis);
        joueur.carteEnMain.remove(i);
        if(!pioche.getPioche().isEmpty()) {
        Carte cartePiocher = new Carte();
        cartePiocher = joueur.piocherCarte(pioche);
        joueur.carteEnMain.add(cartePiocher);
        }
	}

	@Override
	public void jouer(Joueur joueur,Tapis tapis, Pioche pioche, Visiteur compteur) {
			Carte carteAJouer = new Carte();
	        carteAJouer = joueur.piocherCarte(pioche);
	        System.out.println(joueur.getNomJoueur()+" c'est ton tour !");  
	        PositionCarte position = choixPositionClassique(joueur, tapis, carteAJouer, compteur);
	        joueur.poserCarte(position, carteAJouer, tapis);
	 }
}


