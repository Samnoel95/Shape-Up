package Classes;

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
    // d�but des getters et des setters
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

	public boolean isCommence() {
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
	
	
	
	
   
    public Carte piocherCarte() {
    	Carte cartePiochee;
    	// choisir un nbr al�atoire
    	// récupérer le nombre de cartes disponibles dans la pioche grace à une méthode pioche
    	// int x = (int) (Math.random()*(0 - 18));
    	// s�lectionne la carte dans le tableau de carte pr�d�fini 
    	// trouver comment relier la pioche à cette méthode -> créer des méthodes d'accès à pioche dans pioche
    	// cartePiochee = pioche[x];
    	// tri du tableau qui passe de 18 � 17 case 
    	return cartePiochee;
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
}