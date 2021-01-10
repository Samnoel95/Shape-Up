package fr.utt.lo02.shapeUp.controleur;

import java.util.Iterator;

import fr.utt.lo02.shapeUp.modele.Joueur.Joueur;
import fr.utt.lo02.shapeUp.modele.Partie.Partie;
import fr.utt.lo02.shapeUp.vue.Parametres;
import fr.utt.lo02.shapeUp.vue.Plateau;

public class ControleurPlateau {
	
	public Partie partie;
	public Plateau plateau;
	
	public ControleurPlateau(Partie partie, Plateau plateau) {
		this.partie = partie;

			//instancier à la partie pour chaque cas, faire piocher une carte victoire par joueur
			//méthode attribuer carte victoire si version classique
				Iterator<Joueur> it11 = partie.getListeJ().listIterator();
				Iterator<Joueur> it5 = partie.getListeJ().listIterator();
				Iterator<Joueur> it4 = partie.getListeJ().listIterator();
				Iterator<Joueur> it3 = partie.getListeJ().listIterator();
				while(it3.hasNext()) {
					System.out.println(it3.next().getNomJoueur()+" pioche sa carte victoire.");
					it11.next().setCarteVictoire(it4.next().piocherCarte(partie.getPioche()));
	
			
			//jouer pour la version classique
			while(partie.getTapis().getEstPlein()==false) {
				//System.out.println(ShapeUp.getTapis().getPlateau().size());
				Iterator<Joueur> it8 = partie.getListeJ().listIterator();
				Iterator<Joueur> it7 = partie.getListeJ().listIterator();
				Iterator<Joueur> it2 = partie.getListeJ().listIterator();
				Iterator<Joueur> it = partie.getListeJ().listIterator();
				while(it.hasNext() && partie.getTapis().getEstPlein()==false) {
					plateau.getLblNewLabel_1().setText(it.next().getNomJoueur());
					System.out.println("");
					System.out.println("**************************");
					System.out.println("");
					System.out.println("C'est au tour de : ");
					System.out.println(it.next().getNomJoueur()+" // carte victoire : "+it2.next().getCarteVictoire());
					it7.next().jouer(it8.next(), partie.getTapis(), partie.getPioche(), partie.getCompteur());
					
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

}
