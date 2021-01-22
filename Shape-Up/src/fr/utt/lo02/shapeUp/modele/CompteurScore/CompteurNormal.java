package fr.utt.lo02.shapeUp.modele.CompteurScore;

import java.util.*;

import fr.utt.lo02.shapeUp.modele.Carte.Carte;
import fr.utt.lo02.shapeUp.modele.Carte.Couleur;
import fr.utt.lo02.shapeUp.modele.Carte.Forme;
import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.Carte.PositionCarte;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;
import fr.utt.lo02.shapeUp.modele.Tapis.formePlateau;

/**
 * Classe qui permet de compter les points comme proposé dans les règles du jeu
 * 
 * @author Lorène Bergougnoux
 *
 */

public class CompteurNormal implements Visiteur {
	/**
	 * Constructeur de la classe CompteurNormal
	 */
	public CompteurNormal() {

	}

	/**
	 * Méthode qui permet de compter les points associé à la forme d'une carte, sur
	 * une ligne
	 * 
	 * @param tapis : le tapis associé à la partie
	 * @param forme : c'est la forme de la carte qui vient de l'�num�ration Forme
	 * @param ligne : c'est la ligne pour laquelle on compte les points
	 */
	@Override
	public int compterLigneForme(Tapis tapis, Forme forme, int ligne) {

		int colonne = tapis.getYMin();
		int x = 0;
		int y = 0;
		PositionCarte position = new PositionCarte(ligne, colonne);
		PositionCarte positionDroite = new PositionCarte(ligne, colonne + 1);

		for (int i = tapis.getYMin(); i < tapis.getYMax(); i++) {
			if (tapis.getPlateau().get(positionDroite) == null) {
				positionDroite = new PositionCarte(ligne, colonne + 1);
				break;
			} else if (tapis.getPlateau().get(position) == null) {
				break;
			} else {
				if (tapis.getPlateau().get(position).getForme() == tapis.getPlateau().get(positionDroite).getForme()
						&& tapis.getPlateau().get(position).getForme() == forme) {
					x += 1;
				} else if (tapis.getPlateau().get(position).getForme() != tapis.getPlateau().get(positionDroite)
						.getForme() && y == 0) {
					y = x;
					x = 0;
				}
			}
		}
		colonne++;
		position = new PositionCarte(ligne, colonne);
		positionDroite = new PositionCarte(ligne, colonne + 1);
		if (x < 1 && y < 1) {
			return 0;
		}
		if (x > y) {
			return x;
		}
		return y;
	}

	/**
	 * Méthode qui permet de compter les points associé à la forme d'une carte, sur
	 * une colonne
	 * 
	 * @param tapis   : le tapis associé à la partie
	 * @param forme   : c'est la forme de la carte qui vient de l'�num�ration Forme
	 * @param colonne : c'est la colonne pour laquelle on compte les points
	 */

	@Override
	public int compterColonneForme(Tapis tapis, Forme forme, int colonne) {
		int ligne = tapis.getXMin();
		int x = 0;
		int y = 0;
		PositionCarte position = new PositionCarte(ligne, colonne);
		PositionCarte positionBas = new PositionCarte(ligne + 1, colonne);

		for (int i = tapis.getXMin(); i < tapis.getXMax(); i++) {
			if (tapis.getPlateau().get(positionBas) == null) {
				positionBas = new PositionCarte(ligne, colonne + 1);
				break;
			} else if (tapis.getPlateau().get(position) == null) {
				break;
			} else {
				if (tapis.getPlateau().get(position).getForme() == tapis.getPlateau().get(positionBas).getForme()
						&& tapis.getPlateau().get(position).getForme() == forme) {
					x += 1;
				} else if (tapis.getPlateau().get(position).getForme() != tapis.getPlateau().get(positionBas).getForme()
						&& y == 0) {
					y = x;
					x = 0;
				}
			}
			ligne++;
			position = new PositionCarte(ligne, colonne);
			positionBas = new PositionCarte(ligne + 1, colonne);
		}
		if (x < 1 && y < 1)
			return 0;
		if (x > y) {
			return x;
		}
		return y;

	}

	/**
	 * Méthode qui permet de compter les points associé à la couleur d'une carte,
	 * sur une ligne
	 * 
	 * @param tapis : le tapis associé à la partie
	 * @param couleur : c'est la couleur de la carte qui vient de l'�num�ration
	 *              Couleur
	 * @param ligne : c'est la ligne pour laquelle on compte les points
	 */
	@Override
	public int compterLigneCouleur(Tapis tapis, Couleur couleur, int ligne) {
		int colonne = tapis.getYMin();
		int x = 1;
		int y = 0;
		PositionCarte position = new PositionCarte(ligne, colonne);
		PositionCarte positionDroite = new PositionCarte(ligne, colonne + 1);

		for (int i = tapis.getYMin(); i < tapis.getYMax(); i++) {
			if (tapis.getPlateau().get(positionDroite) == null) {
				positionDroite = new PositionCarte(ligne, colonne + 1);
				break;
			} else if (tapis.getPlateau().get(position) == null) {
				break;
			} else {
				if (tapis.getPlateau().get(position).getCouleur() == tapis.getPlateau().get(positionDroite).getCouleur()
						&& tapis.getPlateau().get(position).getCouleur() == couleur) {
					x += 1;
				} else if (tapis.getPlateau().get(position).getCouleur() != tapis.getPlateau().get(positionDroite)
						.getCouleur() && y == 0) {
					y = x;
					x = 1;
				}
			}
			colonne++;
			position = new PositionCarte(ligne, colonne);
			positionDroite = new PositionCarte(ligne, colonne + 1);
		}
		if (y > x) {
			x = y;
		}

		if (x < 3) {
			return 0;
		}
		return x + 1;
	}

	/**
	 * Méthode qui permet de compter les points associé à la couleur d'une carte,
	 * sur une colonne
	 * 
	 * @param tapis   : le tapis associé à la partie
	 * @param couleur : c'est la couleur de la carte qui vient de l'�num�ration
	 *                Couleur
	 * @param colonne : c'est la colonne pour laquelle on compte les points
	 */

	@Override
	public int compterColonneCouleur(Tapis tapis, Couleur couleur, int colonne) {
		int ligne = tapis.getXMin();
		int x = 1;
		int y = 0;
		PositionCarte position = new PositionCarte(ligne, colonne);
		PositionCarte positionBas = new PositionCarte(ligne + 1, colonne);

		for (int i = tapis.getXMin(); i < tapis.getXMax(); i++) {
			if (tapis.getPlateau().get(positionBas) == null) {
				positionBas = new PositionCarte(ligne, colonne + 1);
				break;
			} else if (tapis.getPlateau().get(position) == null) {
				break;
			} else {
				if (tapis.getPlateau().get(position).getCouleur() == tapis.getPlateau().get(positionBas).getCouleur()
						&& tapis.getPlateau().get(position).getCouleur() == couleur) {
					x += 1;
				} else if (tapis.getPlateau().get(position).getCouleur() != tapis.getPlateau().get(positionBas)
						.getCouleur() && y == 0) {
					y = x;
					x = 1;
				}
			}
			ligne++;
			position = new PositionCarte(ligne, colonne);
			positionBas = new PositionCarte(ligne + 1, colonne);
		}
		if (y > x) {
			x = y;
		}

		if (x < 3) {
			return 0;
		}
		return x + 1;

	}

	/**
	 * Méthode qui permet de compter les points associé au remplissage d'une carte,
	 * sur une ligne
	 * 
	 * @param tapis    : le tapis associé à la partie
	 * @param estPlein : c'est le booléen qui est associé au remplissage de la carte
	 * @param ligne    : c'est la ligne pour laquelle on compte les points
	 */

	@Override
	public int compterLigneEstPlein(Tapis tapis, boolean estPlein, int ligne) {
		int colonne = tapis.getYMin();
		int x = 1;
		int y = 0;
		PositionCarte position = new PositionCarte(ligne, colonne);
		PositionCarte positionDroite = new PositionCarte(ligne, colonne + 1);

		for (int i = tapis.getYMin(); i < tapis.getYMax(); i++) {
			if (tapis.getPlateau().get(positionDroite) == null) {
				positionDroite = new PositionCarte(ligne, colonne + 1);
				break;
			} else if (tapis.getPlateau().get(position) == null) {
				break;
			} else {
				if (tapis.getPlateau().get(position).getEstPlein() == tapis.getPlateau().get(positionDroite)
						.getEstPlein() && tapis.getPlateau().get(position).getEstPlein() == estPlein) {
					x += 1;
				} else if (tapis.getPlateau().get(position).getEstPlein() != tapis.getPlateau().get(positionDroite)
						.getEstPlein() && y == 0) {
					y = x;
					x = 1;
				}
			}
			colonne++;
			position = new PositionCarte(ligne, colonne);
			positionDroite = new PositionCarte(ligne, colonne + 1);
		}
		if (y > x) {
			x = y;
		}
		if (x < 3) {
			return 0;
		}
		return x;

	}

	/**
	 * Méthode qui permet de compter les points associé au remplissage d'une carte,
	 * sur une colonne
	 * 
	 * @param tapis    : le tapis associé à la partie
	 * @param estPlein : c'est le booléen qui est associé au remplissage de la carte
	 * @param colonne  : c'est la colonne pour laquelle on compte les points
	 */
	@Override
	public int compterColonneEstPlein(Tapis tapis, boolean estPlein, int colonne) {
		int ligne = tapis.getXMin();
		int x = 1;
		int y = 0;
		PositionCarte position = new PositionCarte(ligne, colonne);
		PositionCarte positionBas = new PositionCarte(ligne + 1, colonne);

		for (int i = tapis.getXMin(); i < tapis.getXMax(); i++) {
			if (tapis.getPlateau().get(positionBas) == null) {
				positionBas = new PositionCarte(ligne, colonne + 1);
				break;
			} else if (tapis.getPlateau().get(position) == null) {
				break;
			} else {
				if (tapis.getPlateau().get(position).getEstPlein() == tapis.getPlateau().get(positionBas).getEstPlein()
						&& tapis.getPlateau().get(position).getEstPlein() == estPlein) {
					x += 1;
				} else if (tapis.getPlateau().get(position).getEstPlein() != tapis.getPlateau().get(positionBas)
						.getEstPlein() && y == 0) {
					y = x;
					x = 1;
				}
			}
			ligne++;
			position = new PositionCarte(ligne, colonne);
			positionBas = new PositionCarte(ligne + 1, colonne);
		}
		if (y > x) {
			x = y;
		}
		if (x < 3) {
			return 0;
		}
		return x;

	}

	/**
	 * Méthode qui permet de compter les points sur l'ensemble d'un tapis
	 * 
	 * @param tapis  : le tapis associé à la partie
	 * @param carteV : la carte victoire du joueur
	 */
	@Override
	public int compterScore(Tapis tapis, Carte carteV) {
		int score = 0;

		for (int i = tapis.getXMin(); i <= tapis.getXMax(); i++) {
			score += compterLigneForme(tapis, carteV.getForme(), i);
			score += compterLigneCouleur(tapis, carteV.getCouleur(), i);
			score += compterLigneEstPlein(tapis, carteV.getEstPlein(), i);
		}

		for (int j = tapis.getYMin(); j <= tapis.getYMax(); j++) {
			score += compterColonneForme(tapis, carteV.getForme(), j);
			score += compterColonneCouleur(tapis, carteV.getCouleur(), j);
			score += compterColonneEstPlein(tapis, carteV.getEstPlein(), j);
		}

		System.out.println("Score à ce round : " + score);
		return score;
	}

}