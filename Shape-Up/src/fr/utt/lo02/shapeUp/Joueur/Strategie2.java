package fr.utt.lo02.shapeUp.Joueur;

import java.util.Map.Entry;

import fr.utt.lo02.shapeUp.Carte.Carte;
import fr.utt.lo02.shapeUp.Carte.Pioche;
import fr.utt.lo02.shapeUp.Carte.PositionCarte;
import fr.utt.lo02.shapeUp.Tapis.Tapis;

public class Strategie2 implements Strategie{

	
	public PositionCarte choixPositionClassique(Joueur joueur, Tapis tapis, Carte carte) {
		PositionCarte position = null;
		boolean memeForme = false;
		boolean memeCouleur = false;
		boolean memePlein = false;
	
		if(carte.getEstPlein() == joueur.getCarteVictoire().getEstPlein()) {
			memePlein = true;
		}
		if(carte.getCouleur() == joueur.getCarteVictoire().getCouleur()) {
			memeCouleur = true;
		}
		if(carte.getForme() == joueur.getCarteVictoire().getForme()) {
			memeForme = true;
		}
		
		
			
		return position;
		
	}
	@Override
	public void joueAdvanced(Joueur joueur, Tapis tapis, Pioche pioche) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jouer(Joueur joueur, Tapis tapis, Pioche pioche) {
		// TODO Auto-generated method stub
		
	}

}
