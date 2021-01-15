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

// test 
/**
 * La classe joueur est abstraite. Elle decrit les méthodes qui seront utilisées par les joueurs physiques ou virtuels.
 * @author Sam Noel 
 *
 */
public abstract class Joueur extends Observable {
	// attribut de la classe joueur 
	private int score;
	private String nomJoueur;
    private boolean commence;
    private Carte carteVictoire;
    protected LinkedList<Carte> carteEnMain;
    protected Carte cartePiochee;
    

    // constructeur d'une instance de Joueur 
    
    
    public Carte getCartePiochee() {
		return cartePiochee;
	}

	public void setCartePiochee(Carte cartePiochee) {
		this.cartePiochee = cartePiochee;
		this.setChanged();
		this.notifyObservers();
	}

	public Joueur(String nomJoueur, boolean commence, Carte carteVictoire) {
		this.nomJoueur = nomJoueur;
		this.commence = commence;
		this.carteVictoire = carteVictoire;
		this.carteEnMain = null;
	} 
    
    public Joueur(String nomJoueur, boolean commence) {
		this.nomJoueur = nomJoueur;
		this.commence = commence;
		this.carteVictoire = null;
		this.carteEnMain = new LinkedList<>();
	} 
    

    // debut des getters et des setters
    public LinkedList<Carte> getCarteEnMain(){
    	return carteEnMain;
    }
    
    public void setCarteEnMain(LinkedList<Carte> carteEnMain){
    	this.carteEnMain = carteEnMain;
    }
    
    public int getScore() {
    	return score;
    }
    
    public void setScore(int score) {
    	this.score=score;
    }
    
	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}


	public boolean getCommence() {
		return commence;
	}

	public void setCommence(boolean commence) {
		this.commence = commence;
	}

	public Carte getCarteVictoire() {
		return carteVictoire;
	}

	public void setCarteVictoire(Carte carteVictoire) {
		this.carteVictoire = carteVictoire;
	}
	

	// fin des getters et des setters 
	
/**
 * Cette méthode décrit un tour de jeu de la version avancée du jeu Shape-UP pour le joueur qui l'utilise. 
 * @param joueur C'est le joueur qui joue son tour de jeu
 * @param tapis C'est le plateau du jeu 
 * @param pioche On y trouve les cartes de la partie
 * @param compteur C'est le compteur de la partie.
 */
	public abstract void jouerAdvanced(Joueur joueur,Tapis tapis, Pioche pioche, Visiteur compteur);
	
/**
 * Cette méthode décrit un tour de jeu de la version classique du jeu Shape-UP pour le joueur qui l'utilise.
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
    * Cette méthode permet de piocher une carte dans la pioche.
    * @param pioche On y trouve les cartes de la partie. 
    * @return La première carte de la pioche. 
    */
    public Carte piocherCarte(Pioche pioche) {
    	Carte cartepiochee = new Carte();
    	cartepiochee = pioche.distribuerUneCarte();
    	System.out.println(this.nomJoueur+" a piochÃ© la carte "+ cartepiochee.toString()+".");
    	System.out.println("");
    	System.out.println("**************************");
    	System.out.println("");
    	return cartepiochee;
    }
    

	/**
	 * Cette méthode permet de poser une carte sur le tapis. 
	 * @param position C'est la position où l'on souhaite placer la carte.
	 * @param carte C'est la carte à placer. 
	 * @param tapis 
	 * @return Un booléen qui confirme ou non si la carte est posée 
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
	 * Cette méthode permet de déplacer une carte du tapis. 
	 * @param position1 C'est la position de la carte à déplacer.
	 * @param position2 C'est la position où l'on souhaite déplacer la carte.
	 * @param tapis C'est le plateau du jeu. 
	 * @return Un booléen qui confirme le déplacement de la carte. 
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


	

	
	