package fr.utt.lo02.shapeUp.modele.Joueur;

import java.util.Scanner;

import fr.utt.lo02.shapeUp.modele.Carte.Carte;
import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.Carte.PositionCarte;
import fr.utt.lo02.shapeUp.modele.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;

/**
 * Cette classe JoueurPhysique permet l'instanciation d'un joueur physique dans la partie et décris les requêtes pour le déplacement et le placement de carte.
 * @author Sam Noel 
 *
 */

public class JoueurPhysique extends Joueur {

	public JoueurPhysique(String nomJoueur, int numJoueur, boolean commence, Carte carteVictoire) {
		super(nomJoueur,commence, carteVictoire);

	}

	public JoueurPhysique(String nomJoueur, boolean commence) {
		super(nomJoueur,commence);

	}

	/**
	 * Cette méthode demande au joueur si il veut déplacer une carte. 
	 * @return Un booléen qui retourne la décision du joueur.
	 */

	public boolean chooseMove() {
		boolean veutDeplacer;
		Scanner in = new Scanner(System.in);
		System.out.println(getNomJoueur()+" veux tu deplacer une carte ? (true=OUI, false=NON)");
		veutDeplacer = in.nextBoolean();
		return veutDeplacer;
	}

	/**
	 * Cette méthode demande de rentrer une valeur de x dans la console 
	 * @return La valeur de x rentrer dans la console
	 */
	public int askX() {
		Scanner in = new Scanner(System.in);
		System.out.println("Entrez x.");
		int x = in.nextInt();

		return x;
	}

	/** 
	 * Cette méthode demande de rentrer une valeur de y dans la console
	 * @return La valeur de y rentrer dans la console 
	 */
	public  int askY() {
		Scanner in = new Scanner(System.in);
		System.out.println("Entrez y.");
		int y = in.nextInt();

		return y;
	}

	@Override
	public void jouerAdvanced(Joueur joueur, Tapis tapis, Pioche pioche, Visiteur compteur) {
		int longueur;
		int hauteur;
		int x;
		int y;
		boolean veutDeplacer = false;
		boolean aDeplace = false;
		//System.out.println(this.getNomJoueur()+" c'est ton tour !");

		/*
        longueur = tapis.longueurPlateau();
        hauteur = tapis.hauteurPlateau();
        System.out.println("La longueur du plateau est  "+longueur);
        System.out.println("La hauteur du plateau est "+hauteur);
		 */
		System.out.println("Voici le plateau actuel :");
		System.out.println(tapis.toString());
		if (!tapis.getPlateau().isEmpty() && tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {

			veutDeplacer = chooseMove();

		}

		if(veutDeplacer && aDeplace == false) {
			System.out.println("Coordonnees de la carte a deplacer : ");

			x = askX();
			y = askY();

			PositionCarte position1 = new PositionCarte(x,y);

			System.out.println( "Ou voulez vous deplacer la carte ?");

			x = askX();
			y = askY();

			PositionCarte position2 = new PositionCarte(x,y);

			aDeplace = deplacerCarte(position1, position2, tapis);
			while(!aDeplace) {
				System.out.println("Deplacement invalide ! recommence : ");
				System.out.println("Coordonnees de la carte a deplacer : ");

				x = askX();
				y = askY();

				position1.setX(x);
				position1.setY(y);

				System.out.println( "Ou voulez vous deplacer la carte ?");

				x = askX();
				y = askY();

				position2.setX(x);
				position2.setY(y);


				aDeplace = deplacerCarte(position1, position2, tapis);	
			}
		} 

		System.out.println("Quelle carte veux-tu jouer ? (0,1 ou 2)");
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();

		System.out.println("Voici le plateau actuel :");
		System.out.println(tapis.toString());

		System.out.println("Ou voulez vous poser la carte ?");
		x = askX();
		y = askY();

		PositionCarte position = new PositionCarte(x,y);

		boolean cartePose = poserCarte(position, carteEnMain.get(i), tapis);

		while (!cartePose) {
			System.out.println("La carte est mal placee ! Recommence : ");

			x = askX();
			y = askY();

			position.setX(x);
			position.setY(y);
			cartePose = poserCarte(position, carteEnMain.get(i), tapis);
		}

		carteEnMain.remove(i);
		if(!pioche.getPioche().isEmpty()) {

			joueur.cartePiochee = piocherCarte(pioche);
			carteEnMain.add(cartePiochee);
		}

		/*
          longueur = tapis.longueurPlateau();
          hauteur = tapis.hauteurPlateau();
          System.out.println("La longueur du plateau est  "+longueur);
          System.out.println("La hauteur du plateau est "+hauteur);
		 */
		System.out.println("Voici le plateau actuel :");
		System.out.println(tapis.toString());
		if( aDeplace == false && tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {

			veutDeplacer = chooseMove();


			if(veutDeplacer) {
				// on deplace
				System.out.println("Coordonnees de la carte a deplacer : ");

				x = askX();
				y = askY();

				PositionCarte position1 = new PositionCarte(x,y);

				System.out.println( "Ou voulez vous deplacer la carte ?");

				x = askX();
				y = askY();

				PositionCarte position2 = new PositionCarte(x,y);

				aDeplace = deplacerCarte(position1, position2, tapis);
				while(!aDeplace) {
					System.out.println("Deplacement invalide ! recommence : ");
					System.out.println("Coordonnees de la carte a deplacer : ");

					x = askX();
					y = askY();

					position1.setX(x);
					position1.setY(y);

					System.out.println( "Ou voulez vous deplacer la carte ?");

					x = askX();
					y = askY();

					position2.setX(x);
					position2.setY(y);


					aDeplace = deplacerCarte(position1, position2, tapis);	
				}
			}
		}
	}

	@Override
	public void jouer( Joueur joueur,Tapis tapis, Pioche pioche, Visiteur compteur) { // a Refinir dans dans joueurPhysique et joueur virtuel. 
		this.cartePiochee = piocherCarte(pioche);
		int longueur;
		int hauteur;
		int x;
		int y;
		boolean veutDeplacer = false;
		boolean aDeplace = false;
		//System.out.println(this.getNomJoueur()+" c'est ton tour !");

		/*
        longueur = tapis.longueurPlateau();
        hauteur = tapis.hauteurPlateau();
        System.out.println("La longueur du plateau est  "+longueur);
        System.out.println("La hauteur du plateau est "+hauteur);
		 */
		System.out.println("Voici le plateau actuel :");
		System.out.println(tapis.toString());
		if (!tapis.getPlateau().isEmpty() && tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {
			veutDeplacer = chooseMove();    
		}

		if(veutDeplacer && aDeplace == false) {

			System.out.println("Coordonnees de la carte a deplacer : ");

			x = askX();
			y = askY();

			PositionCarte position1 = new PositionCarte(x,y);

			System.out.println( "Ou voulez vous deplacer la carte ?");

			x = askX();
			y = askY();

			PositionCarte position2 = new PositionCarte(x,y);

			aDeplace = deplacerCarte(position1, position2, tapis);
			while(!aDeplace) {
				System.out.println("Deplacement invalide ! recommence : ");
				System.out.println("Coordonnees de la carte a deplacer : ");

				x = askX();
				y = askY();

				position1.setX(x);
				position1.setY(y);

				System.out.println( "Ou voulez vous deplacer la carte ?");

				x = askX();
				y = askY();

				position2.setX(x);
				position2.setY(y);


				aDeplace = deplacerCarte(position1, position2, tapis);	
			}

		} 

		System.out.println("Ou voulez vous poser la carte "+cartePiochee+"?");
		x = askX();
		y = askY();

		PositionCarte position = new PositionCarte(x,y);

		boolean cartePose = poserCarte(position, cartePiochee, tapis);

		while (!cartePose) {
			System.out.println("La carte est mal placee ! Recommence : ");

			x = askX();
			y = askY();

			position.setX(x);
			position.setY(y);
			cartePose = poserCarte(position, cartePiochee, tapis);
		}


		/*
          longueur = tapis.longueurPlateau();
          hauteur = tapis.hauteurPlateau();
          System.out.println("La longueur du plateau est  "+longueur);
          System.out.println("La hauteur du plateau est "+hauteur);
		 */

		if( aDeplace == false &&  tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {

			veutDeplacer = chooseMove();


			if(veutDeplacer) {
				// on deplace

				System.out.println("Coordonnees de la carte a deplacer : ");

				x = askX();
				y = askY();

				PositionCarte position1 = new PositionCarte(x,y);

				System.out.println( "Ou voulez vous deplacer la carte ?");

				x = askX();
				y = askY();

				PositionCarte position2 = new PositionCarte(x,y);

				aDeplace = deplacerCarte(position1, position2, tapis);
				while(!aDeplace) {
					System.out.println("Deplacement invalide ! recommence : ");
					System.out.println("Coordonnees de la carte a deplacer : ");

					x = askX();
					y = askY();

					position1.setX(x);
					position1.setY(y);

					System.out.println( "Ou voulez vous deplacer la carte ?");

					x = askX();
					y = askY();

					position2.setX(x);
					position2.setY(y);


					aDeplace = deplacerCarte(position1, position2, tapis);	
				}
			}
		}
	}
}




