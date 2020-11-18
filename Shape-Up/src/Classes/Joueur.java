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
    // début des getters et des setters
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
    	
    	// choisir un nbr aléatoire
    	// sélectionne la carte dans le tableau de carte prédéfini 
    	// tri du tableau qui passe de 18 à 17 case 
    	
    }
    
   
    
    public boolean poserCarte(PositionCarte position, Carte carte, Tapis tapis) {
    	
    	boolean bienPlacé = false;
    	// test pour savoir si c'est la première carte joué 
    	if(tapis.getPlateau().isEmpty()){
    		position.setX(0);
    		position.setY(0);
    		tapis.getPlateau().put(position, carte);
    		System.out.println("La carte est placé en x = 0, y = 0");
    	}else {
    		// test pour savoir si la position est libre
    		if(tapis.getPlateau().containsKey(position)) {
    			bienPlacé = false;
    		}else {
    			// test règle des cartes adjacentes
    			PositionCarte position2 = new PositionCarte(position.getX()-1, position.getY());
    			PositionCarte position3 = new PositionCarte(position.getX(), position.getY()+1);
    			PositionCarte position4 = new PositionCarte(position.getX()+1, position.getY());
    			PositionCarte position5 = new PositionCarte(position.getX(), position.getY()-1);
    		
    			if (tapis.getPlateau().containsKey(position2) || tapis.getPlateau().containsKey(position3) || tapis.getPlateau().containsKey(position4) || tapis.getPlateau().containsKey(position5)) {
    				
    				// test règle layout
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
    					bienPlacé = true;
    				}else {
    					bienPlacé=false;
    				}
    				
    				if ( longueur < 4 && 1 < longueur  && 1 < hauteur && hauteur < 6) {
    					bienPlacé = true;
    				}else {
    					bienPlacé=false;
    				}
    				
    				if(!bienPlacé) {
    					tapis.getPlateau().remove(position);
    				}
    				
    			}else {
    				bienPlacé = false;
    			}		
    		}
    	}
    return bienPlacé;
    }   
    
    public boolean déplacerCarte(PositionCarte position1, PositionCarte position2, Tapis tapis) {
    	// position1 : carte a déplacer
    	// position2 : emplacement de déplacement 
    	boolean carteDéplacé;
    	// test si la carte à déplacer existe
    	
    	if(tapis.getPlateau().containsKey(position1)) {
    		// test pour savoir si la position est libre pour déplacer la carte
    		
    		if(tapis.getPlateau().containsKey(position2)) {
    			carteDéplacé = false;
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
    					carteDéplacé = true;
    				}else {
    					carteDéplacé=false;
    				}
    				
    				if ( longueur < 4 && 1 < longueur  && 1 < hauteur && hauteur < 6) {
    					carteDéplacé = true;
    				}else {
    					carteDéplacé=false;
    				}
    				
    				if(!carteDéplacé) {
    					tapis.getPlateau().put(position1, tapis.getPlateau().get(position2));
        				tapis.getPlateau().remove(position2);
        				
    				}
    			}else {
    				carteDéplacé = false;
    			}
    		}
    	}else {
    		carteDéplacé = false;
    	}
    }
}