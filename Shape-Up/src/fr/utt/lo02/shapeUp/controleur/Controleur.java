package fr.utt.lo02.shapeUp.controleur;

import java.awt.event.ActionEvent;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;

import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.CompteurScore.CompteurInverse;
import fr.utt.lo02.shapeUp.modele.CompteurScore.CompteurNormal;
import fr.utt.lo02.shapeUp.modele.Joueur.JoueurPhysique;
import fr.utt.lo02.shapeUp.modele.Joueur.JoueurVirtuel;
import fr.utt.lo02.shapeUp.modele.Partie.Partie;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;
import fr.utt.lo02.shapeUp.modele.Tapis.formePlateau;
import fr.utt.lo02.shapeUp.vue.Parametres;

public class Controleur {
	Partie partie;
	Parametres param;
	
	public Controleur(Parametres param) {
		Partie partie = new Partie();
		this.partie = partie;
	}
	
	public void runClassique() {
		for(int i=0; i<4;i++) {
			Pioche nouvellePioche = new Pioche();
			nouvellePioche.melangerJeu();
			this.partie.setPioche(nouvellePioche);
			Tapis nouveautapis = new Tapis(this.partie.getTapis().getForme());
			this.partie.setTapis(nouveautapis);
			this.partie.partieClassique(this.partie);
			System.out.println("Comptons les scores !");
			this.partie.compterPoints(this.partie);
			System.out.println("Fin du round !");
		}
	}
	
	public void runAdvanced() {
		for(int i=0; i<4;i++) {
				Pioche nouvellePioche = new Pioche();
				nouvellePioche.melangerJeu();
				this.partie.setPioche(nouvellePioche);
				Tapis nouveautapis = new Tapis(this.partie.getTapis().getForme());
				this.partie.setTapis(nouveautapis);
				this.partie.partieAdvanced(this.partie);
				System.out.println("Comptons les scores !");
				this.partie.compterPoints(this.partie);
				System.out.println("Fin du round !");
		}
	}
	
	public void addJp() {
		for(int i=0; i<param.sliderJp.getValue(); i++) {
			String nom = JOptionPane.showInputDialog( "Entrez le nom du joueur : " );
			JoueurPhysique joueur = new JoueurPhysique(nom, true);
			this.partie.ajouterUnJoueur(joueur);
		}
	}
	
	public void addJv() {
		for(int i=0; i<param.sliderJv.getValue(); i++) {
			String difficulte;
			int diff;
			Scanner in = new Scanner(System.in);
			difficulte = JOptionPane.showInputDialog("Quelle difficulté souhaitez vous attribuer au joueur virtuel "+(i+1)+" (possibilité : 1 (facile) ou 2 (difficile))");
			diff = Integer.parseInt(difficulte);
			StringBuffer sb = new StringBuffer();
			sb.append("Joueur virtuel numéro ");
		    sb.append(i+1);
		    String nom = sb.toString();
		    JoueurVirtuel joueur = new JoueurVirtuel(nom, true, diff);
		    this.partie.ajouterUnJoueur(joueur);
		}
	}
	
	public void choixPlateau(){
		if(param.comboBox.getSelectedItem() == "Rectangle") {
			System.out.println("Tapis rectangulaire"); //ensuite relier à Partie
			Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
			partie.setTapis(tapis);;
		}
			
		else if(param.comboBox.getSelectedItem() == "Triangle")
			System.out.println("Tapis triangulaire"); //ensuite relier à Partie
		Tapis tapis = new Tapis(formePlateau.TRIANGLE);
		this.partie.setTapis(tapis);;
	}
	
	public void choixCompteur() {
		if(param.comboBox_1_1.getSelectedItem() == "Normal")
		{
			System.out.println("Compteur normal"); //ensuite relier à Partie
			CompteurNormal compt = new CompteurNormal();
			this.partie.setCompteur(compt);
		}
			
		else if(param.comboBox_1_1.getSelectedItem() == "Inverse") {
			System.out.println("Compteur inverse"); //ensuite relier à Partie
			CompteurInverse compt = new CompteurInverse();
			this.partie.setCompteur(compt);
		}
	}
	
	public void run() {
		if(this.param.comboBox_1.getSelectedItem() == "Classique") {
			System.out.println("3");
			param.getControleur().addJp();
			param.getControleur().addJv();
			param.getControleur().choixPlateau();
			param.getControleur().choixCompteur();
			System.out.println("Lancement d'une partie classique !");
			param.getControleur().runClassique();
		}
		
		System.out.println("4");
		if(this.param.comboBox_1.getSelectedItem() == "Avance") {
			param.getControleur().addJp();
			param.getControleur().addJv();
			param.getControleur().choixPlateau();
			param.getControleur().choixCompteur();
			System.out.println("Lancement d'une partie avancee !");
			param.getControleur().runAdvanced();
			
		}
	}
	
	public void test() {
		System.out.println("Reçu par le controleur");
	}
	
public static void main(String[] args) {
	Partie partie = new Partie();
	Parametres param = new Parametres();
	Controleur contr = new Controleur(param);
	contr.run();
	
}
}



	
