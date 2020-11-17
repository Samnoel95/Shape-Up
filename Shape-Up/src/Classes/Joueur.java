package Classes;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    	
    	Carte carteAjouer = new Carte();
    		
    	return carteAjouer;
    }
    
   
    
    public boolean poserCarte(PositionCarte position, Carte carte, Tapis tapis) {
    	
    	boolean bienPlac�;
    	
    	if(tapis.getPlateau().isEmpty()){
    		position.setX(0);
    		position.setY(0);
    		tapis.getPlateau().put(position, carte);
    		System.out.println("La carte est plac� en x = 0, y = 0");
    	}else {
    	
    		if(tapis.getPlateau().containsKey(position)) {
    			bienPlac� = false;
    		}else {
    			PositionCarte position2 = new PositionCarte(position.getX()-1, position.getY());
    			PositionCarte position3 = new PositionCarte(position.getX(), position.getY()+1);
    			PositionCarte position4 = new PositionCarte(position.getX()+1, position.getY());
    			PositionCarte position5 = new PositionCarte(position.getX(), position.getY()-1);
    		
    			if (tapis.getPlateau().containsKey(position2) | tapis.getPlateau().containsKey(position3) | tapis.getPlateau().containsKey(position4) | tapis.getPlateau().containsKey(position5)) {
    				
    				// il faut ajouter la contrainte de layout mais je ne sais pas comment. 

    			}else {
    				bienPlac� = false;
    			}		
    		}
    	}
    }  
    
    public boolean d�placerCarte(PositionCarte position1, PositionCarte position2, Tapis tapis) {
    	// position1 : carte a d�placer
    	// position2 : emplacement de d�placement 
    	boolean carteD�plac�;
    	
    	if(tapis.getPlateau().containsKey(position1)) {
    		if(tapis.getPlateau().containsKey(position2)) {
    			carteD�plac� = false;
    		}else {
    			PositionCarte position2 = new PositionCarte(position2.getX()-1, position2.getY());
    			PositionCarte position3 = new PositionCarte(position2.getX(), position2.getY()+1);
    			PositionCarte position4 = new PositionCarte(position2.getX()+1, position2.getY());
    			PositionCarte position5 = new PositionCarte(position2.getX(), position2.getY()-1);
    			if (tapis.getPlateau().containsKey(position2) | tapis.getPlateau().containsKey(position3) | tapis.getPlateau().containsKey(position4) | tapis.getPlateau().containsKey(position5)) {
    				// r�gle du layout a r�diger
    			}else {
    				carteD�plac� = false;
    			}
    		}
    	}else {
    		carteD�plac� = false;
    	}
    }
}