package fr.utt.lo02.shapeUp.modele.Carte;
/**
 * Classe qui décrit la position d'une carte 
 * @author Sam Noel 
 *
 */
public class PositionCarte{

	int posX;
	int posY;
	/**
	 * Constructeur de la classe PositionCarte 
	 * @param x La position x de la carte sur le plateau
	 * @param y La position y de la carte sur le plateau
	 */
	public PositionCarte(int x, int y) {
		this.posX=x;
		this.posY=y;
	}
	/**
	 * Setter du x de la position 
	 * @param x Un int 
	 */
	public void setX(int x) {
		this.posX=x;
	}
	/**
	 * Setter du y de la position
	 * @param y Un int
	 */
	public void setY(int y) {
		this.posY=y;
	}

	/**
	 * Getter du x de la position 
	 * @return Le x de la position 
	 */
	public int getX() {
		return this.posX;
	}
	/**
	 * Getter du y de la position 
	 * @return Le y de la position 
	 */
	public int getY() {
		return this.posY;
	}
}

