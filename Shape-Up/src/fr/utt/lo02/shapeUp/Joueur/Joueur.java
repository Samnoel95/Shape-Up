package fr.utt.lo02.shapeUp.Joueur;

import java.util.Scanner;
import java.util.Map.Entry;

import javax.crypto.AEADBadTagException;

import fr.utt.lo02.shapeUp.Carte.Carte;
import fr.utt.lo02.shapeUp.Carte.Pioche;
import fr.utt.lo02.shapeUp.Carte.PositionCarte;
import fr.utt.lo02.shapeUp.Tapis.Tapis;

// test 

public abstract class Joueur {
	// attribut de la classe joueur 
	private String nomJoueur;
	private int numJoueur;
    private boolean commence;
    private Carte carteVictoire;
    

    // constructeur d'une instance de Joueur 
    public Joueur(String nomJoueur, int numJoueur, boolean commence, Carte carteVictoire) {
		this.nomJoueur = nomJoueur;
		this.numJoueur = numJoueur;
		this.commence = commence;
		this.carteVictoire = carteVictoire;
	} 
    

    // debut des getters et des setters
	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public int getNumJoueur() {
		return numJoueur;
	}

	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
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
	

	
	public abstract void Jouer(Joueur joueur,Tapis tapis, Pioche pioche);
	
	public String toString() {
	    StringBuffer sb = new StringBuffer();
	    sb.append(this.nomJoueur);
	    sb.append(", joueur numero ");
	    sb.append(this.numJoueur);
	    sb.append(", ");
	    if(this.commence == true)
	    	sb.append("commence,");
	    else
	    	sb.append("ne commence pas,");
	    sb.append(" carte victoire : ");
	    sb.append(this.carteVictoire.toString());
	    return sb.toString();
	    }  
	
	
   
    public Carte piocherCarte(Pioche pioche) {
    	Carte cartepiochee = new Carte();
    	System.out.println(this.nomJoueur + " pioche une carte.");
    	cartepiochee = pioche.distribuerUneCarte();
    	System.out.println("**************************");
    	System.out.println("Vous avez piochÃ© la carte "+ cartepiochee.toString()+".");
    	return cartepiochee;
    }
    
	
	public boolean isExist(PositionCarte position, Tapis tapis) {
		boolean isExist = false;
		if(tapis.getPlateau().containsKey(position)) {
			isExist = true;
		}
		return isExist;
	}
	
	public boolean isAdjacent(PositionCarte position, Tapis tapis) {
		
		boolean isAdjacent = false;
		PositionCarte position2 = new PositionCarte(position.getX()-1, position.getY());
		PositionCarte position3 = new PositionCarte(position.getX(), position.getY()+1);
		PositionCarte position4 = new PositionCarte(position.getX()+1, position.getY());
		PositionCarte position5 = new PositionCarte(position.getX(), position.getY()-1);
		
		if (tapis.getPlateau().containsKey(position2) 
				|| tapis.getPlateau().containsKey(position3) 
				|| tapis.getPlateau().containsKey(position4) 
				|| tapis.getPlateau().containsKey(position5)) {
			isAdjacent = true;
		}
		return isAdjacent;
	}
  
	public int longueurPlateau(Tapis tapis) {
		// peut utiliser les méthodes de tapis pour trouver les x et les y min/max 
		int longueur;
		int Xmax = 0;
		int Xmin = 0;
		for(Entry<PositionCarte, Carte> entry : tapis.getPlateau().entrySet()) {
			if(entry.getKey().getX() > Xmax) {
				Xmax = entry.getKey().getX();
			}else if(entry.getKey().getX() < Xmin) {
				Xmin = entry.getKey().getX();
			}
		}
		
		longueur = Math.abs(Xmax - Xmin) + 1;
		return longueur;
	}
	
	public int hauteurPlateau(Tapis tapis) {
		int hauteur;
		int Ymax = 0;
		int Ymin = 0;
		for(Entry<PositionCarte, Carte> entry : tapis.getPlateau().entrySet()) {
			if(entry.getKey().getY() > Ymax) {
				Ymax = entry.getKey().getY();
			}else if(entry.getKey().getY() < Ymin) {
				Ymin = entry.getKey().getY();
			}
		}
		
		hauteur = Math.abs(Ymax - Ymin) + 1;
		return hauteur;
	}
	
	public boolean isVertical(int hauteur,int longueur) {
		boolean vertical;
		if ( longueur < 4 && 1 <= longueur  && 1 <= hauteur && hauteur < 6) {
			vertical = true;
		}else {
			vertical=false;
		}
		return vertical;
	}
	
	public boolean isHorizontal(int hauteur, int longueur) {
		boolean horizontal;
		if ( longueur < 6 && 1 <= longueur  && 1 <= hauteur && hauteur < 4) {
			horizontal = true;
		}else {
			horizontal=false;
		}
		return horizontal;
	}
	
	public boolean layoutOk(PositionCarte position,Carte carte, Tapis tapis) {
		// analyse le plateau avec la carte ajouter
		int longueur;
		int hauteur;
		boolean vertical;
		boolean horizontal;
		boolean layoutOk = false;
		longueur = longueurPlateau(tapis);
		hauteur = hauteurPlateau(tapis);
		vertical = isVertical(hauteur, longueur);
		horizontal = isHorizontal(hauteur, longueur);
		if(vertical || horizontal) {
			layoutOk = true;
		}		
		return layoutOk;
	}
	
	public boolean poserCarte(PositionCarte position, Carte carte, Tapis tapis) {
		boolean cartePose = false;
		boolean isExist = isExist(position, tapis);
		boolean adjacent =false;
		boolean layoutOk = false;
		if(!isExist) {
		adjacent = isAdjacent(position, tapis);
		tapis.getPlateau().put(position, carte);
		layoutOk = layoutOk(position, carte, tapis);
		tapis.getPlateau().remove(position);
		}
		
		System.out.println(tapis.toString());
		if(tapis.getPlateau().isEmpty()) {
			System.out.println("c'est la boule empty");
    		position.setX(0);
    		position.setY(0);
    		tapis.getPlateau().put(position, carte);
    		System.out.println("La carte est posee ! en x= "+position.getX()+"et y= "+position.getY());
    		cartePose = true;
		}else if(!isExist && adjacent && layoutOk) {
			System.out.println("c'est la boucle classique");
			tapis.getPlateau().put(position, carte);
			cartePose = true;
			System.out.println("La carte est posee ! en x= "+position.getX()+"et y= "+position.getY());
		}
		return cartePose;
	}
	
	public boolean deplacerCarte(PositionCarte position1,PositionCarte position2, Tapis tapis) {
		boolean carteDeplace = false;
		boolean isExist = isExist(position1, tapis);
		boolean isExist2 = isExist(position2, tapis);
		boolean adjacent = false;
		boolean layoutOk = false;
		if(isExist && !isExist2) {
		tapis.getPlateau().put(position2, tapis.getPlateau().get(position1));
		tapis.getPlateau().remove(position1);
		adjacent = isAdjacent(position2, tapis);
		layoutOk = layoutOk(position2,tapis.getPlateau().get(position1), tapis);
			if(adjacent && layoutOk) {
				carteDeplace = true;
				System.out.println("La carte est deplacee !en x= "+position2.getX()+"et y= "+position2.getY());
			}else {
				tapis.getPlateau().put(position1, tapis.getPlateau().get(position2));
				tapis.getPlateau().remove(position2);
				carteDeplace = false;
			}	
		}
		return carteDeplace;
	}
}


	

	
	