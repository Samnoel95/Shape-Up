package fr.utt.lo02.shapeUp.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	
/*
	public Partie partie;
	public Parametres param;
	public JSlider sliderJp;
	public JLabel LabelNJp;
	public JSlider sliderJv;
	public JComboBox comboBox_1;
	public JComboBox comboBox;
	public JComboBox choixCompteur;
	public JButton btnNewButton;
	public JLabel LabelNJv;
	public JComboBox comboBox_1_1;
	*/
	
	public Controleur(Parametres param) {
		param.commencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Commencer !");
			}
		});
	}
		/*
		Partie ShapeUp = new Partie();
		partie = ShapeUp;
		sliderJp = param.sliderJp;
		LabelNJp = param.LabelNJp;
		sliderJv = param.sliderJv;
		comboBox_1 = param.comboBox_1;
		comboBox = param.comboBox;
		choixCompteur = param.comboBox_1_1;
		btnNewButton = param.btnNewButton;
		LabelNJv = param.LabelNJv;
		

		choixCompteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choixCompteur.getSelectedItem() == "Normal")
					System.out.println("Compteur normal"); //ensuite relier à Partie
				else if(choixCompteur.getSelectedItem() == "Inverse")
					System.out.println("Compteur inverse"); //ensuite relier à Partie
			}
		});
		
		
		btnNewButton.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {			
			}
			public void mouseReleased(MouseEvent e) {	
			}
			public void mouseEntered(MouseEvent e) {	
			}
			public void mouseExited(MouseEvent e) {	
			}
			public void mousePressed(MouseEvent e) {
				test();
			}
		});
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(param.comboBox_1.getSelectedItem() == "Classique")
					System.out.println("Variante classique"); //ensuite relier à Partie
				else if(param.comboBox_1.getSelectedItem() == "Avance")
					System.out.println("Variante avance"); //ensuite relier à Partie
			}
		});
		
		sliderJv.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				LabelNJv.setText(Integer.toString(sliderJv.getValue()));
				if(sliderJv.getValue() == 0)
					System.out.println("0 joueur virtuel"); //ensuite relier à Partie
				else if(sliderJv.getValue() == 1)
					System.out.println("1 joueur virtuel"); //ensuite relier à Partie
				else if(sliderJv.getValue() == 2)
					System.out.println("2 joueurs virtuels"); //ensuite relier à Partie
				else if(sliderJv.getValue() == 3)
					System.out.println("3 joueurs virtuels"); //ensuite relier à Partie
			}
		});
		
		sliderJp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				LabelNJp.setText(Integer.toString(sliderJp.getValue()));
				if(sliderJp.getValue() == 0)
					System.out.println("0 joueur physique"); //ensuite relier à Partie
				else if(sliderJp.getValue() == 1)
					System.out.println("1 joueur physique"); //ensuite relier à Partie
				else if(sliderJp.getValue() == 2)
					System.out.println("2 joueurs physiques"); //ensuite relier à Partie
				else if(sliderJp.getValue() == 3)
					System.out.println("3 joueurs physiques"); //ensuite relier à Partie
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() == "Rectangle")
					System.out.println("Tapis rectangulaire"); //ensuite relier à Partie
				else if(comboBox.getSelectedItem() == "Triangle")
					System.out.println("Tapis triangulaire"); //ensuite relier à Partie
			}
		});
		
		
		
		
	}
	
	
	public void runClassique() {
		for(int i=0; i<4;i++) {
			Pioche nouvellePioche = new Pioche();
			nouvellePioche.melangerJeu();
			partie.setPioche(nouvellePioche);
			Tapis nouveautapis = new Tapis(partie.getTapis().getForme());
			partie.setTapis(nouveautapis);
			partie.partieClassique(partie);
			System.out.println("Comptons les scores !");
			partie.compterPoints(partie);
			System.out.println("Fin du round !");
		}
	}
	
	public void runAdvanced() {
		for(int i=0; i<4;i++) {
				Pioche nouvellePioche = new Pioche();
				nouvellePioche.melangerJeu();
				partie.setPioche(nouvellePioche);
				Tapis nouveautapis = new Tapis(partie.getTapis().getForme());
				partie.setTapis(nouveautapis);
				partie.partieAdvanced(partie);
				System.out.println("Comptons les scores !");
				partie.compterPoints(partie);
				System.out.println("Fin du round !");
		}
	}
	
	public void addJp() {
		for(int i=0; i<sliderJp.getValue(); i++) {
			String nom = JOptionPane.showInputDialog( "Entrez le nom du joueur : " );
			JoueurPhysique joueur = new JoueurPhysique(nom, true);
			partie.ajouterUnJoueur(joueur);
		}
	}
	
	public void addJv() {
		for(int i=0; i<sliderJv.getValue(); i++) {
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
		    partie.ajouterUnJoueur(joueur);
		}
	}
	
	public void choixPlateau(){
		if(comboBox.getSelectedItem() == "Rectangle") {
			System.out.println("Tapis rectangulaire"); //ensuite relier à Partie
			Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
			partie.setTapis(tapis);;
		}
			
		else if(comboBox.getSelectedItem() == "Triangle")
			System.out.println("Tapis triangulaire"); //ensuite relier à Partie
		Tapis tapis = new Tapis(formePlateau.TRIANGLE);
		partie.setTapis(tapis);;
	}
	
	public void choixCompteur() {
		if(comboBox_1_1.getSelectedItem() == "Normal")
		{
			System.out.println("Compteur normal"); //ensuite relier à Partie
			CompteurNormal compt = new CompteurNormal();
			partie.setCompteur(compt);
		}
			
		else if(comboBox_1_1.getSelectedItem() == "Inverse") {
			System.out.println("Compteur inverse"); //ensuite relier à Partie
			CompteurInverse compt = new CompteurInverse();
			partie.setCompteur(compt);
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
	
	
*/	
	
	public void test() {
		System.out.println("Reçu par le controleur");
	}
	
public static void main(String[] args) {
	Partie partie = new Partie();
	Parametres param = new Parametres();
	Controleur contr = new Controleur(param);
	contr.test();
	
	
}

	
}


	
