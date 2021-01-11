package fr.utt.lo02.shapeUp.controleur;

import java.util.Iterator;

import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.Joueur.Joueur;
import fr.utt.lo02.shapeUp.modele.Partie.Partie;
import fr.utt.lo02.shapeUp.vue.Parametres;
import fr.utt.lo02.shapeUp.vue.Plateau;

public class ControleurPlateau {
	
	public Partie partie;
	public Plateau plateau;
	
	
	public ControleurPlateau(Partie part, Plateau plateau) {
		this.partie = part;

			//instancier à la partie pour chaque cas, faire piocher une carte victoire par joueur
			//méthode attribuer carte victoire si version classique
				partie.setNombreDeJoueur(partie.getNbreJPhysiques()+partie.getNbreJVirtuels());
				for(int i=0; i<partie.getNombreDeJoueur(); i++) {
					System.out.println(partie.getListeJ().get(i).getNomJoueur()+" pioche sa carte victoire.");
					partie.getListeJ().get(i).setCarteVictoire(partie.getListeJ().get(i).piocherCarte(partie.getPioche()));
				}
			//jouer pour la version classique	
			while(partie.getTapis().getEstPlein()==false) {
				//System.out.println(ShapeUp.getTapis().getPlateau().size());
				for(int j=0; j<partie.getNombreDeJoueur(); j++) {
					/*
					System.out.println("Affichage nouveau plateau !");
				Plateau nvPlateau = new Plateau();
				nvPlateau.getLblNewLabel_1().setText(partie.getListeJ().get(j).getNomJoueur());
				nvPlateau.setVisible(true);
				*/
				while(partie.getTapis().getEstPlein()==false) {
					System.out.println("");
					System.out.println("**************************");
					System.out.println("");
					System.out.println("C'est au tour de : ");
					System.out.println(partie.getListeJ().get(j).getNomJoueur()+" // carte victoire : "+partie.getListeJ().get(j).getCarteVictoire());
					
					partie.getListeJ().get(j).jouer(partie.getListeJ().get(j), partie.getTapis(), partie.getPioche(), partie.getCompteur());
					System.out.println("5");
					if(partie.getTapis().getPlateau().size()==15 && partie.getNombreDeJoueur()==2) {
						partie.getTapis().setEstPlein(true);
						System.out.println("Le tapis est rempli !");
					}
					else if(partie.getTapis().getPlateau().size()==14 && partie.getNombreDeJoueur()==3) {
						partie.getTapis().setEstPlein(true);
						System.out.println("Le tapis est rempli !");
					}
					
				}
				}

			}
		}
		
	public void jouerTour(Joueur joueur) {
		joueur.piocherCarte(this.partie.getPioche());
	}
	}


