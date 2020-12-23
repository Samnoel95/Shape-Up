package fr.utt.lo02.shapeUp.Tapis;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import fr.utt.lo02.shapeUp.Carte.Carte;
import fr.utt.lo02.shapeUp.Carte.PositionCarte;

public class  Tapis {
	
	/*
	  	Map<String,Integer> map = new TreeMap<String, Integer>();
        map.put("1", new Integer(10));
        map.put("2", new Integer(20));
        map.put("3", new Integer(30));
        map.put("4", new Integer(10));       
       
        System.out.println(map.get("1"));
        System.out.println(map.size());
        map.remove("1");
        System.out.println(map.get("1"));
        System.out.println(map.size());       
       
	 */
	
	private HashMap<PositionCarte, Carte>plateau;
	private formePlateau forme;
	private boolean estPlein;
	Map<PositionCarte, Carte> tapis = new HashMap<PositionCarte, Carte>();
	
	public Tapis(formePlateau forme) {
		HashMap<PositionCarte, Carte> tapis = new HashMap<PositionCarte, Carte>();
		this.setPlateau(tapis);
		this.setForme(forme);
		this.setEstPlein(false);
		
	}
	
	public int getXMin() {
		int xMin = 7;
		for(Entry<PositionCarte, Carte> entry : this.plateau.entrySet()) {
			if(entry.getKey().getX() < xMin) {
				xMin = entry.getKey().getX();
			}
		}
		return xMin;
	}
	
	public int getXMax() {
		int xMax = -7;
		for(Entry<PositionCarte, Carte> entry : this.plateau.entrySet()) {
			if(entry.getKey().getX() > xMax) {
				xMax = entry.getKey().getX();
			}
		}
		return xMax;
	}
	
	public int getYMin() {
		int yMin = 7;
		for(Entry<PositionCarte, Carte> entry : this.plateau.entrySet()) {
			if(entry.getKey().getY() < yMin) {
				yMin = entry.getKey().getY();
			}
		}
		return yMin;
	}
	
	public int getYMax() {
		int yMax = -7;
		for(Entry<PositionCarte, Carte> entry : this.plateau.entrySet()) {
			if(entry.getKey().getY() > yMax) {
				yMax = entry.getKey().getY();
			}
		}
		return yMax;
	}
	
	public int longueurPlateau() {
		// peut utiliser les m�thodes de tapis pour trouver les x et les y min/max 
		int longueur;
		if(getPlateau().isEmpty()) {
			longueur = 0;
		}else {
		int Xmax = -7;
		int Xmin = 7;
		for(Entry<PositionCarte, Carte> entry : getPlateau().entrySet()) {
			if(entry.getKey().getX() > Xmax) {
				Xmax = entry.getKey().getX();
			}
			if(entry.getKey().getX() < Xmin) {
				Xmin = entry.getKey().getX();
			}
		}
		
		longueur = Math.abs(Xmax - Xmin) + 1;
		}
		return longueur;
	}
	
	public int hauteurPlateau() {
		int hauteur;
		if(getPlateau().isEmpty()) {
			hauteur = 0;
		}else {
		int Ymax = -7;
		int Ymin = 7;
		for(Entry<PositionCarte, Carte> entry : getPlateau().entrySet()) {
			if(entry.getKey().getY() > Ymax) {
				Ymax = entry.getKey().getY();
			}
			if(entry.getKey().getY() < Ymin) {
				Ymin = entry.getKey().getY();
			}
		}
		
		hauteur = Math.abs(Ymax - Ymin) + 1;
		}
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
	
	public boolean isExist(PositionCarte position) {
		boolean isExist = false;
		if(this.getPlateau().containsKey(position)) {
			isExist = true;
		}
		return isExist;
	}
	
	public boolean isAdjacent(PositionCarte position) {
		
		boolean isAdjacent = false;
		PositionCarte position2 = new PositionCarte(position.getX()-1, position.getY());
		PositionCarte position3 = new PositionCarte(position.getX(), position.getY()+1);
		PositionCarte position4 = new PositionCarte(position.getX()+1, position.getY());
		PositionCarte position5 = new PositionCarte(position.getX(), position.getY()-1);
		
		if (this.getPlateau().containsKey(position2) 
				|| this.getPlateau().containsKey(position3) 
				|| this.getPlateau().containsKey(position4) 
				|| this.getPlateau().containsKey(position5)) {
			isAdjacent = true;
		}
		return isAdjacent;
	}
	
	public boolean layoutOk(PositionCarte position) {
		// analyse le plateau avec la carte ajouter
		boolean layoutOk = false;
		if(forme == formePlateau.PLATEAUCLASSIQUE) {
			int longueur;
			int hauteur;
			boolean vertical;
			boolean horizontal;
			longueur = longueurPlateau();
			hauteur = hauteurPlateau();
			vertical = isVertical(hauteur, longueur);
			horizontal = isHorizontal(hauteur, longueur);
			if(vertical || horizontal) {
			layoutOk = true;
			}		
		}
		
		if(forme == formePlateau.TRIANGLE) {
			if(position.getX() == 0 && position.getY() >= 0 && position.getY() <=4) {
				layoutOk = true;
			}
			if(position.getX() == 1 && position.getY() >= 0 && position.getY() <=3) {
				layoutOk = true;
			}
			if(position.getX() == 2 && position.getY() >= 0 && position.getY() <=2) {
				layoutOk = true;
			}
			if(position.getX() == 3 && position.getY() >= 0 && position.getY() <=1) {
				layoutOk = true;
			}
			if(position.getX() == 4 && position.getY() == 0) {
				layoutOk = true;
			}
		
		}
		return layoutOk;
	}

	
	
   // setters And Getters
	public formePlateau getForme() {
		return forme;
	}


	public void setForme(formePlateau forme) {
		this.forme = forme;
	}


	public boolean getEstPlein() {
		return estPlein;
	}


	public void setEstPlein(boolean estPlein) {
		this.estPlein = estPlein;
	}


	public HashMap<PositionCarte, Carte> getPlateau() {
		return plateau;
	}


	public void setPlateau(HashMap<PositionCarte, Carte> tapis) {
		this.plateau = tapis;
	}
	
	public static void main(String[] args) {
	 Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
	} 
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Il y a ");
	    sb.append(this.plateau.size());
	    sb.append(" cartes posées sur le plateau.");
	    sb.append(" // ");
	    sb.append(this.plateau.entrySet());
	    return sb.toString();
	}
}
