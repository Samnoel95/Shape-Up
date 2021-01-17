package fr.utt.lo02.shapeUp.lanceur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.utt.lo02.shapeUp.controleur.Controleur;
import fr.utt.lo02.shapeUp.vue.Accueil;
import fr.utt.lo02.shapeUp.vue.Parametres;
import fr.utt.lo02.shapeUp.vue.Plateau;

/**
 * Classe qui lance le jeu
 * 
 * @author Sam Noel
 *
 */

public class Lanceur {

	public static void main(String[] args) {

		Accueil accueil = new Accueil();
		accueil.frame.setVisible(true);

	}
}
