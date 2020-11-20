package Classes;

import java.util.HashMap;

public class Tapis {
	
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
	
	public Tapis(HashMap<PositionCarte, Carte> plateau,formePlateau forme, boolean estPlein) {
		this.setPlateau(plateau);
		this.setForme(forme);
		this.setEstPlein(estPlein);
		
	}
	
	public Tapis(formePlateau forme) {
		this.setForme(forme);
		System.out.println("Un tapis de forme "+this.forme+ " a été créé !");
	}
	
	
   // setters And Getters
	public formePlateau getForme() {
		return forme;
	}


	public void setForme(formePlateau forme) {
		this.forme = forme;
	}


	public boolean isEstPlein() {
		return estPlein;
	}


	public void setEstPlein(boolean estPlein) {
		this.estPlein = estPlein;
	}


	public HashMap<PositionCarte, Carte> getPlateau() {
		return plateau;
	}


	public void setPlateau(HashMap<PositionCarte, Carte> plateau) {
		this.plateau = plateau;
	}
	 
}
