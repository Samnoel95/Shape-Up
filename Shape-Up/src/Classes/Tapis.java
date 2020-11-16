package Classes;

import java.util.HashMap;

public class Tapis {
	
	private HashMap<PositionCarte, Carte>plateau;
	private formePlateau forme;
	private boolean estPlein;
	
	public Tapis(HashMap<PositionCarte, Carte> plateau,formePlateau forme, boolean estPlein) {
		this.setPlateau(plateau);
		this.setForme(forme);
		this.setEstPlein(estPlein);
		
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
