package fr.utt.lo02.shapeUp.modele.Joueur;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Observable;

import javax.crypto.AEADBadTagException;

import fr.utt.lo02.shapeUp.modele.Carte.Carte;
import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.Carte.PositionCarte;
import fr.utt.lo02.shapeUp.modele.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;

/**
 * La classe joueur est abstraite. Elle decrit les m�thodes qui seront utilis�es par les joueurs physiques ou virtuels.
 * @author Sam Noel 
 *
 */
public abstract class Joueur extends Observable {
	
	private int score;
	private String nomJoueur;
	private boolean commence;
	private Carte carteVictoire;
	protected LinkedList<Carte> carteEnMain;
	protected Carte cartePiochee;

/**
 * Constructeur de la classe Joueur avec carte de victoire
 * @param nomJoueur Le nom du joueur
 * @param commence Un bool�en qui confirme que le joueur commence 
 * @param carteVictoire La carte de victoire du joueur dans la partie 
 */
	public Joueur(String nomJoueur, boolean commence, Carte carteVictoire) {
		this.nomJoueur = nomJoueur;
		this.commence = commence;
		this.carteVictoire = carteVictoire;
		this.carteEnMain = null;
	} 
/**
 * Constructeur de la classe Joueur sans carte de victoire
 * @param nomJoueur Le nom du joueur
 * @param commence Un bool�en qui confirme que le joueur commence 
 */
	public Joueur(String nomJoueur, boolean commence) {
		this.nomJoueur = nomJoueur;
		this.commence = commence;
		this.carteVictoire = null;
		this.carteEnMain = new LinkedList<>();
	} 

/**
 * Getter des cartes en main du joueur
 * @return Une LinkedList avec les cartes en main du joueur
 */
	public LinkedList<Carte> getCarteEnMain(){
		return carteEnMain;
	}
/**
 * setter des cartes en main du joueur
 * @param carteEnMain Une linkedList avec des cartes
 */
	public void setCarteEnMain(LinkedList<Carte> carteEnMain){
		this.carteEnMain = carteEnMain;
	}
/**
 * Getter du score du joueur
 * @return Un Score : Int 
 */
	public int getScore() {
		return score;
	}
/**
 * Setter du score du joueur
 * @param score Un score : Int
 */
	public void setScore(int score) {
		this.score=score;
	}
/**
 * Getter du nom du joueur
 * @return Le nom du joueur : String 
 */
	public String getNomJoueur() {
		return nomJoueur;
	}
/**
 * Setter du nom du joueur
 * @param nomJoueur Un nom de joueur : String 
 */
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

/**
 * Getter du bool�en : commence 
 * @return Le bool�en commence du joueur 
 */
	public boolean getCommence() {
		return commence;
	}
/**
 * Setter du bool�en : commence 
 * @param commence Un bool�en 
 */
	public void setCommence(boolean commence) {
		this.commence = commence;
	}
/**
 * Getter de la carte victoire du joueur 
 * @return La carte victoire du joueur : Carte 
 */
	public Carte getCarteVictoire() {
		return carteVictoire;
	}
/**
 * Setter de la carte victoire du joueur 
 * @param carteVictoire Une carte : Carte 
 */
	public void setCarteVictoire(Carte carteVictoire) {
		this.carteVictoire = carteVictoire;
	}
	/**
	 * Getter de la carte pioch�e du joueur
	 * @return La carte pioch�e : Carte 
	 */
	public Carte getCartePiochee() {
		return cartePiochee;
	}
/**
 * Setter de la carte pioch�e du joueur
 * @param cartePiochee Une carte : Carte 
 */
	public void setCartePiochee(Carte cartePiochee) {
		this.cartePiochee = cartePiochee;
		this.setChanged();
		this.notifyObservers();
	}


	/**
	 * Cette m�thode d�crit un tour de jeu de la version avanc�e du jeu Shape-UP pour le joueur qui l'utilise. 
	 * @param joueur C'est le joueur qui joue son tour de jeu
	 * @param tapis C'est le plateau du jeu 
	 * @param pioche On y trouve les cartes de la partie
	 * @param compteur C'est le compteur de la partie.
	 */
	public abstract void jouerAdvanced(Joueur joueur,Tapis tapis, Pioche pioche, Visiteur compteur);

	/**
	 * Cette m�thode d�crit un tour de jeu de la version classique du jeu Shape-UP pour le joueur qui l'utilise.
	 * @param joueur C'est le joueur qui joue son tour de jeu
	 * @param tapis C'est le plateau du jeu 
	 * @param pioche On y trouve les cartes de la partie
	 * @param compteur C'est le compteur de la partie.
	 * */
	public abstract void jouer(Joueur joueur,Tapis tapis, Pioche pioche, Visiteur compteur);

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.nomJoueur);
		sb.append(", ");
		if(this.commence == true)
			sb.append("commence,");
		else
			sb.append("ne commence pas,");
		sb.append(" carte victoire : ");
		sb.append(this.carteVictoire.toString());
		return sb.toString();
	}  


	/**
	 * Cette m�thode permet de piocher une carte dans la pioche.
	 * @param pioche On y trouve les cartes de la partie. 
	 * @return La premi�re carte de la pioche. 
	 */
	public Carte piocherCarte(Pioche pioche) {
		Carte cartepiochee = pioche.distribuerUneCarte();
		System.out.println(this.nomJoueur+" a pioché la carte "+ cartepiochee.toString()+".");
		System.out.println("");
		System.out.println("**************************");
		System.out.println("");
		return cartepiochee;
	}


	/**
	 * Cette m�thode permet de poser une carte sur le tapis. 
	 * @param position C'est la position o� l'on souhaite placer la carte.
	 * @param carte C'est la carte � placer. 
	 * @param tapis Le tapis de la partie
	 * @return Un bool�en qui confirme ou non si la carte est pos�e 
	 */
	public boolean poserCarte(PositionCarte position, Carte carte, Tapis tapis) {
		boolean cartePose = false;
		boolean isExist = tapis.isExist(position);
		boolean adjacent =false;
		boolean layoutOk = false;
		if(!isExist) {
			adjacent = tapis.isAdjacent(position);
			tapis.getPlateau().put(position, carte);
			layoutOk = tapis.layoutOk(position);
			tapis.getPlateau().remove(position);
		}

		//System.out.println(tapis.toString());
		if(tapis.getPlateau().isEmpty()) {
			//System.out.println("c'est la boule empty");
			position.setX(0);
			position.setY(0);
			tapis.getPlateau().put(position, carte);
			System.out.println("La carte est posee en x = "+position.getX()+" et y = "+position.getY()+".");
			cartePose = true;
		}else if(!isExist && adjacent && layoutOk) {
			//System.out.println("c'est la boucle classique");
			tapis.getPlateau().put(position, carte);
			cartePose = true;
			System.out.println("La carte est posee en   x = "+position.getX()+" et y = "+position.getY()+".");
		}
		//System.out.println(tapis.toString());
		return cartePose;
	}

	/**
	 * Cette m�thode permet de d�placer une carte du tapis. 
	 * @param position1 C'est la position de la carte � d�placer.
	 * @param position2 C'est la position o� l'on souhaite d�placer la carte.
	 * @param tapis C'est le plateau du jeu. 
	 * @return Un bool�en qui confirme le d�placement de la carte. 
	 */
	public boolean deplacerCarte(PositionCarte position1,PositionCarte position2, Tapis tapis) {
		boolean carteDeplace = false;
		boolean isExist = tapis.isExist(position1);
		boolean isExist2 = tapis.isExist(position2);
		boolean adjacent = false;
		boolean layoutOk = false;
		if(isExist && !isExist2) {
			tapis.getPlateau().put(position2, tapis.getPlateau().get(position1));
			tapis.getPlateau().remove(position1);
			adjacent = tapis.isAdjacent(position2);
			layoutOk = tapis.layoutOk(position2);
			if(adjacent && layoutOk) {
				carteDeplace = true;
				System.out.println("La carte est deplacee en x = "+position2.getX()+" et y = "+position2.getY()+".");
			}else {
				tapis.getPlateau().put(position1, tapis.getPlateau().get(position2));
				tapis.getPlateau().remove(position2);
				carteDeplace = false;
			}	
		}
		return carteDeplace;
	}
}





