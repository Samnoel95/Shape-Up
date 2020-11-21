package Classes;

import java.util.HashMap;
import java.util.Map;

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
