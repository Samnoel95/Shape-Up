package fr.utt.lo02.shapeUp.modele.Joueur;

import java.util.Random;

import fr.utt.lo02.shapeUp.modele.Carte.Carte;
import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.Carte.PositionCarte;
import fr.utt.lo02.shapeUp.modele.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;
/**
 * Cette méthode décrit les méthodes de jeu du joueur virtuel facile. 
 * @author Sam Noel
 *
 */
public class StrategieFacile implements Strategie {

	@Override
	public int choisirCarte(Joueur joueur) {
		int i = 0;
		if(joueur.carteEnMain.size() == 3) {
			Random generator = new Random();
			i = 2 - generator.nextInt(2);
		}

		if(joueur.carteEnMain.size() == 2) {
			Random generator = new Random();
			i = 1 - generator.nextInt(1);
		}

		return i;		
	}
	/**
	 * Cette classe permet de calculer un X aléatoire en fonction de la taille du tapis du jeu 
	 * @param tapis Le plateau du jeu
	 * @return Une valeur X aléatoire 
	 */
	public int randomX(Tapis tapis) {
		int xMin = tapis.getXMin()-1;
		int xMax = tapis.getXMax()+1;
		int longueur = Math.abs(xMax - xMin) + 1;
		Random generator = new Random();
		int x = xMax - generator.nextInt(longueur);
		return x;
	}

	/**
	 * Cette classe permet de calculer un Y aléatoire en fonction de la taille du tapis du jeu
	 * @param tapis Le plateau du jeu 
	 * @return Une valeur Y aléatoire
	 */
	public int randomY(Tapis tapis) {
		int yMin = tapis.getYMin()-1;
		int yMax = tapis.getYMax()+1;
		int hauteur = Math.abs(yMax - yMin) + 1;
		Random generator = new Random();
		int y = yMax - generator.nextInt(hauteur);
		return y;
	}

	/**
	 * Cette méthode permet de renvoyer un booléen aléatoire 
	 * @return Un bouléen aléatoire 
	 */
	public boolean randomBoolean() {
		int bool = (int)(Math.random()*2);
		boolean randomBoolean = false;
		if(bool == 0) {
			randomBoolean = false;
		}else if(bool == 1) {
			randomBoolean = true;
		}
		return randomBoolean;
	}

	@Override
	public void joueAdvancedV(Joueur joueur,Tapis tapis, Pioche pioche,Visiteur compteur) {
		int x;
		int y;
		boolean veutDeplacer = false;
		boolean aDeplace = false;
		System.out.println(joueur.getNomJoueur()+" c'est ton tour !");
		if (!tapis.getPlateau().isEmpty() && tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {

			veutDeplacer = randomBoolean();

		}

		if(veutDeplacer && aDeplace == false) {

			x = randomX(tapis);
			y = randomY(tapis);

			PositionCarte position1 = new PositionCarte(x,y);

			x = randomX(tapis);
			y = randomY(tapis);
			//System.out.println("x2 = "+x);
			//System.out.println("y2 = "+y);
			PositionCarte position2 = new PositionCarte(x,y);

			aDeplace = joueur.deplacerCarte(position1, position2, tapis);
			while(!aDeplace) {
				// position de la carte a deplacer
				x = randomX(tapis);
				y = randomY(tapis);

				PositionCarte position12 = new PositionCarte(x,y);

				// position ou dï¿½placer la carte 
				x = randomX(tapis);
				y = randomY(tapis);

				position2.setX(x);
				position2.setY(y);
				//System.out.println("x2 = "+x);
				//System.out.println("y2 = "+y);


				aDeplace = joueur.deplacerCarte(position12, position2, tapis);	
			}
		} 

		int i = this.choisirCarte(joueur);
		x = randomX(tapis);
		y = randomY(tapis);

		//System.out.println("x = "+x);
		//System.out.println("y = "+y);

		PositionCarte position = new PositionCarte(x,y);

		boolean cartePose = joueur.poserCarte(position, joueur.carteEnMain.get(i), tapis);

		while (!cartePose) {

			x = randomX(tapis);
			y = randomY(tapis);
			System.out.println("x = "+x);
			System.out.println("y = "+y);

			position.setX(x);
			position.setY(y);
			cartePose = joueur.poserCarte(position, joueur.carteEnMain.get(i), tapis);
		}
		joueur.carteEnMain.remove(i);
		if(!pioche.getPioche().isEmpty()) {
			Carte cartePiocher = joueur.piocherCarte(pioche);
			joueur.carteEnMain.add(cartePiocher);
		}


		if( aDeplace == false  && tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {

			//System.out.println("test");
			veutDeplacer = randomBoolean();


			if(veutDeplacer) {

				x = randomX(tapis);
				y = randomY(tapis);

				PositionCarte position1 = new PositionCarte(x,y);


				x = randomX(tapis);
				y = randomY(tapis);

				PositionCarte position2 = new PositionCarte(x,y);

				aDeplace = joueur.deplacerCarte(position1, position2, tapis);
				while(!aDeplace) {
					//System.out.println("test2");
					x = randomX(tapis);
					y = randomY(tapis);

					PositionCarte position12 = new PositionCarte(x,y);


					x = randomX(tapis);
					y = randomY(tapis);

					position2.setX(x);
					position2.setY(y);


					aDeplace = joueur.deplacerCarte(position12, position2, tapis);	
				}
			}
		}
	}

	@Override
	public void jouerV(Joueur joueur,Tapis tapis, Pioche pioche, Visiteur compteur) {
		joueur.cartePiochee = joueur.piocherCarte(pioche);
		int x;
		int y;
		boolean veutDeplacer = false;
		boolean aDeplace = false;
		System.out.println(joueur.getNomJoueur()+" c'est ton tour !");

		if (!tapis.getPlateau().isEmpty() && tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {

			veutDeplacer = randomBoolean();

		}

		if(veutDeplacer && aDeplace == false) {

			x = randomX(tapis);
			y = randomY(tapis);

			PositionCarte position1 = new PositionCarte(x,y);

			x = randomX(tapis);
			y = randomY(tapis);
			//System.out.println("x2 = "+x);
			//System.out.println("y2 = "+y);
			PositionCarte position2 = new PositionCarte(x,y);

			aDeplace = joueur.deplacerCarte(position1, position2, tapis);
			while(!aDeplace) {
				// position de la carte a deplacer
				x = randomX(tapis);
				y = randomY(tapis);

				PositionCarte position12 = new PositionCarte(x,y);

				// position ou dï¿½placer la carte 
				x = randomX(tapis);
				y = randomY(tapis);

				position2.setX(x);
				position2.setY(y);

				//System.out.println("x2 = "+x);
				//System.out.println("y2 = "+y);


				aDeplace = joueur.deplacerCarte(position12, position2, tapis);	
			}
		} 

		x = randomX(tapis);
		y = randomY(tapis);

		//System.out.println("x = "+x);
		//System.out.println("y = "+y);

		PositionCarte position = new PositionCarte(x,y);

		boolean cartePose = joueur.poserCarte(position, joueur.cartePiochee, tapis);

		while (!cartePose) {

			x = randomX(tapis);
			y = randomY(tapis);
			//System.out.println("x = "+x);
			//System.out.println("y = "+y);

			position.setX(x);
			position.setY(y);
			cartePose = joueur.poserCarte(position, joueur.cartePiochee, tapis);
		}

		if( aDeplace == false &&  tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {

			//System.out.println("test");
			veutDeplacer = randomBoolean();


			if(veutDeplacer) {

				x = randomX(tapis);
				y = randomY(tapis);

				PositionCarte position1 = new PositionCarte(x,y);


				x = randomX(tapis);
				y = randomY(tapis);

				PositionCarte position2 = new PositionCarte(x,y);

				aDeplace = joueur.deplacerCarte(position1, position2, tapis);
				while(!aDeplace) {
					//System.out.println("test2");
					x = randomX(tapis);
					y = randomY(tapis);

					PositionCarte position12 = new PositionCarte(x,y);


					x = randomX(tapis);
					y = randomY(tapis);

					position2.setX(x);
					position2.setY(y);


					aDeplace = joueur.deplacerCarte(position12, position2, tapis);	
				}
			}
		}
	}
}







