package fr.utt.lo02.shapeUp.modele.Tapis;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;

import fr.utt.lo02.shapeUp.modele.Carte.Carte;
import fr.utt.lo02.shapeUp.modele.Carte.PositionCarte;
/**
 * Classe qui donne les propri�t�s du plateau du jeu.
 * @author Sam Noel 
 *
 */
public class  Tapis extends Observable {


	private HashMap<PositionCarte, Carte>plateau;
	private formePlateau forme;
	private boolean estPlein;
	Map<PositionCarte, Carte> tapis = new HashMap<PositionCarte, Carte>();

	/**
	 * Constructeur de la classe  Tapis 
	 * @param forme La forme du plateau : formePlateau
	 */
	public Tapis(formePlateau forme) {
		HashMap<PositionCarte, Carte> tapis = new HashMap<PositionCarte, Carte>();
		this.setPlateau(tapis);
		this.setForme(forme);
		this.setEstPlein(false);

	}
/**
 * Getter de la forme du plateau du tapis 
 * @return La forme du plateau du tapis : formePlateau
 */
	public formePlateau getForme() {
		return forme;		
	}

/**
 * Setter de la forme du plateau du tapis 
 * @param forme Une forme de plateau : formePlateau
 */
	public void setForme(formePlateau forme) {
		this.forme = forme;
	}

/**
 * Getter du bool�en estPlein du tapis 
 * @return Le bool�en estPlein du tapis 
 */
	public boolean getEstPlein() {
		return estPlein;
	}

/**
 * Setter du bool�en estPLein du tapis 
 * @param estPlein Un bool�en, 1 pour un tapis plein, 0 pour un tapis vide
 */
	public void setEstPlein(boolean estPlein) {
		this.estPlein = estPlein;
	}

/**
 * Getter de la HashMap du tapis 
 * @return la HashMap du tapis
 */
	public HashMap<PositionCarte, Carte> getPlateau() {
		return plateau;
	}

/**
 * Setter de la HashMap du tapis 
 * @param tapis Une HashMap avec en cl� une PositionCarte et une valeur de Carte 
 */
	public void setPlateau(HashMap<PositionCarte, Carte> tapis) {
		this.plateau = tapis;
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

	/**
	 * Cette m�thode permet de r�cup�rer la valeur minimale de X du plateau. 
	 * @return La valeur minimale de X du plateau 
	 */
	public int getXMin() {
		int xMin = 7;
		for(Entry<PositionCarte, Carte> entry : this.plateau.entrySet()) {
			if(entry.getKey().getX() < xMin) {
				xMin = entry.getKey().getX();
			}
		}
		return xMin;
	}
	/**
	 * Cette m�thode permet de r�cup�rer la valeur maximale de X du plateau.
	 * @return La valeur maximale de X du plateau 
	 */
	public int getXMax() {
		int xMax = -7;
		for(Entry<PositionCarte, Carte> entry : this.plateau.entrySet()) {
			if(entry.getKey().getX() > xMax) {
				xMax = entry.getKey().getX();
			}
		}
		return xMax;
	}

	/**
	 * Cette m�thode permet de r�cup�rer la valeur minimale de Y du plateau. 
	 * @return La valeur minimale de Y du plateau
	 */
	public int getYMin() {
		int yMin = 7;
		for(Entry<PositionCarte, Carte> entry : this.plateau.entrySet()) {
			if(entry.getKey().getY() < yMin) {
				yMin = entry.getKey().getY();
			}
		}
		return yMin;
	}

	/**
	 * Cette m�thode permet de r�cup�rer la valeur maximale de Y du plateau.
	 * @return La valeur maximale de Y du plateau
	 */
	public int getYMax() {
		int yMax = -7;
		for(Entry<PositionCarte, Carte> entry : this.plateau.entrySet()) {
			if(entry.getKey().getY() > yMax) {
				yMax = entry.getKey().getY();
			}
		}
		return yMax;
	}

	/**
	 * Cette m�thode permet de calculer la longueur du plateau. 
	 * @return La longueur du plateau 
	 */
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

	/**
	 * Cette m�thode permet de calculer la hauteur du plateau
	 * @return La hauteur du plateau 
	 */
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

	/**
	 * Cette m�thode test la verticalit� du plateau 
	 * @param hauteur La hauteur du plateau
	 * @param longueur la longueur du plateau
	 * @return un bool�en qui confirme la verticalit� du plateau
	 */
	public boolean isVertical(int hauteur,int longueur) {
		boolean vertical;
		if ( longueur < 4 && 1 <= longueur  && 1 <= hauteur && hauteur < 6) {
			vertical = true;
		}else {
			vertical=false;
		}
		return vertical;
	}

	/**
	 * Cette m�thode test l'horizontalit� du plateau
	 * @param hauteur La hauteur du plateau
	 * @param longueur La longueur du plateau
	 * @return Un bool�en qui confirme l'horizontalit� du plateau
	 */
	public boolean isHorizontal(int hauteur, int longueur) {
		boolean horizontal;
		if ( longueur < 6 && 1 <= longueur  && 1 <= hauteur && hauteur < 4) {
			horizontal = true;
		}else {
			horizontal=false;
		}
		return horizontal;
	}
	/**
	 * Cette m�thode test si une position est d�ja utilis�e dans le plateau. 
	 * @param position La position � tester
	 * @return Un bool�en qui confirme si la position est utilis�e 
	 */
	public boolean isExist(PositionCarte position) {
		boolean isExist = false;
		if(this.getPlateau().containsKey(position)) {
			isExist = true;
		}
		return isExist;
	}
	/**
	 * Cette m�thode test si une position est adjacente � d'autres position de carte sur le plateau
	 * @param position La position � tester 
	 * @return Un bool�en qui confirme si la position est adjacente � d'autres positions de carte 
	 */
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

	/**
	 * Cette m�thode permet de v�rifier, apr�s l'ajout d'une carte sur le plateau, si la disposition des cartes est valide 
	 * @param position La position � rajouter sur le plateau 
	 * @return Un bool�en qui confirme la validit� de disposition 
	 */
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
}
