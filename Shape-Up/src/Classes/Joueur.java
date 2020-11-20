package Classes;

import java.util.Scanner;
import java.util.Map.Entry;

// test 

public class Joueur {
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
    
    public Joueur(String nomJoueur, int numJoueur) {
		this.nomJoueur = nomJoueur;
		this.numJoueur = numJoueur;
	}
    
    public Joueur(String nomJoueur, int numJoueur, boolean commence) {
		this.nomJoueur = nomJoueur;
		this.numJoueur = numJoueur;
		this.commence = commence;
	}
    
    public Joueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
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
    	System.out.println("Vous avez pioché la carte "+ cartepiochee.toString()+".");
    	return cartepiochee;
    }
    
   
    
    public boolean poserCarte(PositionCarte position, Carte carte, Tapis tapis) {
    	
    	boolean bienPlace = false;
    	// test pour savoir si c'est la premi�re carte jou� 
    	if(tapis.getPlateau().isEmpty()){
    		position.setX(0);
    		position.setY(0);
    		tapis.getPlateau().put(position, carte);
    		System.out.println("La carte est placee en x = 0, y = 0");
    	}else {
    		// test pour savoir si la position est libre
    		if(tapis.getPlateau().containsKey(position)) {
    			bienPlace = false;
    		}else {
    			// test r�gle des cartes adjacentes
    			PositionCarte position2 = new PositionCarte(position.getX()-1, position.getY());
    			PositionCarte position3 = new PositionCarte(position.getX(), position.getY()+1);
    			PositionCarte position4 = new PositionCarte(position.getX()+1, position.getY());
    			PositionCarte position5 = new PositionCarte(position.getX(), position.getY()-1);
    		
    			if (tapis.getPlateau().containsKey(position2) || tapis.getPlateau().containsKey(position3) || tapis.getPlateau().containsKey(position4) || tapis.getPlateau().containsKey(position5)) {
    				
    				// test r�gle layout
    				int Xmax = position.getX();
    				int Xmin = position.getX();
    				int Ymax = position.getY();
    				int Ymin = position.getY();
    				int longueur;
    				int hauteur;
    				
    				tapis.getPlateau().put(position, carte);
    				for(Entry<PositionCarte, Carte> entry : tapis.getPlateau().entrySet()) {
    					if(entry.getKey().getX() > Xmax) {
    						Xmax = entry.getKey().getX();
    					}else if(entry.getKey().getX() < Xmin) {
    						Xmin = entry.getKey().getX();
    					}
    					
    					if(entry.getKey().getY() > Ymax) {
    						Ymax = entry.getKey().getY();
    					}else if(entry.getKey().getY() < Ymin) {
    						Ymin = entry.getKey().getY();
    					}
    				}
    				
    				longueur = Math.abs(Xmax) - Math.abs(Xmin);
    				hauteur = Math.abs(Ymax) - Math.abs(Ymin);
    				
    				if ( longueur < 6 && 1 < longueur  && 1 < hauteur && hauteur < 4) {
    					bienPlace = true;
    				}else {
    					bienPlace=false;
    				}
    				
    				if ( longueur < 4 && 1 < longueur  && 1 < hauteur && hauteur < 6) {
    					bienPlace = true;
    				}else {
    					bienPlace=false;
    				}
    				
    				if(!bienPlace) {
    					tapis.getPlateau().remove(position);
    				}
    				
    			}else {
    				bienPlace = false;
    			}		
    		}
    	}
    return bienPlace;
    }   
    
    public boolean deplacerCarte(PositionCarte position1, PositionCarte position2, Tapis tapis) {
    	// position1 : carte a d�placer
    	// position2 : emplacement de d�placement 
    	boolean carteDeplace;
    	// test si la carte � d�placer existe
    	
    	if(tapis.getPlateau().containsKey(position1)) {
    		// test pour savoir si la position est libre pour d�placer la carte
    		
    		if(tapis.getPlateau().containsKey(position2)) {
    			carteDeplace = false;
    		}else {
    			PositionCarte position3 = new PositionCarte(position2.getX()-1, position2.getY());
    			PositionCarte position4 = new PositionCarte(position2.getX(), position2.getY()+1);
    			PositionCarte position5 = new PositionCarte(position2.getX()+1, position2.getY());
    			PositionCarte position6 = new PositionCarte(position2.getX(), position2.getY()-1);
    			if (tapis.getPlateau().containsKey(position3) || tapis.getPlateau().containsKey(position4) || tapis.getPlateau().containsKey(position5) || tapis.getPlateau().containsKey(position6)) {
    				
    				tapis.getPlateau().put(position2, tapis.getPlateau().get(position1));
    				tapis.getPlateau().remove(position1);
    				
    				
    				int Xmax = position2.getX();
    				int Xmin = position2.getX();
    				int Ymax = position2.getY();
    				int Ymin = position2.getY();
    				int longueur;
    				int hauteur;
    				for(Entry<PositionCarte, Carte> entry : tapis.getPlateau().entrySet()) {
    					if(entry.getKey().getX() > Xmax) {
    						Xmax = entry.getKey().getX();
    					}else if(entry.getKey().getX() < Xmin) {
    						Xmin = entry.getKey().getX();
    					}
    					
    					if(entry.getKey().getY() > Ymax) {
    						Ymax = entry.getKey().getY();
    					}else if(entry.getKey().getY() < Ymin) {
    						Ymin = entry.getKey().getY();
    					}
    				}
    				
    				longueur = Math.abs(Xmax) - Math.abs(Xmin);
    				hauteur = Math.abs(Ymax) - Math.abs(Ymin);
    				
    				if ( longueur < 6 && 1 < longueur  && 1 < hauteur && hauteur < 4) {
    					carteDeplace = true;
    				}else {
    					carteDeplace=false;
    				}
    				
    				if ( longueur < 4 && 1 < longueur  && 1 < hauteur && hauteur < 6) {
    					carteDeplace = true;
    				}else {
    					carteDeplace=false;
    				}
    				
    				if(!carteDeplace) {
    					tapis.getPlateau().put(position1, tapis.getPlateau().get(position2));
        				tapis.getPlateau().remove(position2);
        				
    				}
    			}else {
    				carteDeplace = false;
    			}
    		}
    	}else {
    		carteDeplace = false;
    	}
    	return carteDeplace;
    }

//main de tests
	public static void main(String[]args){
		
		Pioche pioche = new Pioche();
		pioche.melangerJeu();
		/*
		Joueur lolo = new Joueur("Lorène");
		lolo.setNumJoueur(1);
		
		Scanner in = new Scanner(System.in);
        System.out.println("Est ce que Lolo souhaite commencer? (1=OUI; 0=NON)");
        int reponse = in.nextInt();
        if(reponse==1)
        	lolo.setCommence(true);
        else 
        	lolo.setCommence(false);
        System.out.println("Lolo commence : "+ lolo.commence);
        lolo.setNumJoueur(1);
        lolo.setCarteVictoire(pioche.distribuerUneCarte());
        System.out.println("La carte victoire de Lolo est :");
        System.out.println(lolo.carteVictoire.toString());
        
        Joueur sam = new Joueur("Sam");
        if(lolo.commence==true)
        	sam.setCommence(false);
        else
        	sam.setCommence(true);
        sam.setNumJoueur(2);
        sam.setCarteVictoire(pioche.distribuerUneCarte());
        System.out.println("La carte victoire de Sam est :");
        System.out.println(sam.carteVictoire.toString());
        */
		
		Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
		Joueur lolo = new Joueur("Lorene", 1, false);
		lolo.setCarteVictoire(pioche.distribuerUneCarte());
		System.out.println(lolo.toString());
		
		Carte carteAJouer = new Carte();
		carteAJouer = lolo.piocherCarte(pioche);
		
		PositionCarte position = new PositionCarte(1,1);
		
		System.out.println("Test 1");
		
		lolo.poserCarte(position, carteAJouer, tapis);
		
	}
}
	
	