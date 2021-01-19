package fr.utt.lo02.shapeUp.modele.Carte;

import java.util.*;

/**
 * Classe qui définie les propriétés de la pioche et qui permet d'instancier une pioche 
 * @author Lorène Bergougnoux
 *
 */
public class Pioche {

	private LinkedList<Carte> pioche; 
	public static final int nbrCartes = Forme.values().length * Couleur.values().length * 2;

	/**
	 * Constructeur de la classe Pioche. La pioche va instancier les cartes de la classe Carte dans une liste
	 */

	public Pioche(){
		pioche = new LinkedList<Carte>();
		Couleur[] c = Couleur.values();
		Forme[] f = Forme.values();

		for(int i=0; i<f.length; i++)
		{
			for(int j=0; j<c.length; j++)
			{
				Carte carte = new Carte(c[j],f[i], true);
				pioche.add(carte);
				Carte carte2 = new Carte(c[j],f[i], false);
				pioche.add(carte2);
			}
		}
	}
	/**
	 * Getter de la liste des cartes de la pioche 
	 * @return La liste des cartes de la pioche 
	 */
	public LinkedList<Carte> getPioche(){
		return pioche;
	}
	/**
	 * Méthode qui permet de tirer une carte de la pioche 
	 * @return
	 */
	public Carte distribuerUneCarte() {
		return pioche.poll();
	}
	/**
	 * Méthode qui permet de mélanger la pioche 
	 */
	public void melangerJeu(){
		// MÃ©lange le tas de cartesâ€¦voir la classe Collectionsâ€¦.mÃ©thode shuffle() ;)
		Collections.shuffle(pioche);
	}	
}
