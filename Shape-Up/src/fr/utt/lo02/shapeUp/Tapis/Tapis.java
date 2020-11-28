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
		System.out.println("Un tapis de forme "+this.forme+ " a été créé !");
		
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
	    sb.append(this.plateau.entrySet());
	    return sb.toString();
	}
}
