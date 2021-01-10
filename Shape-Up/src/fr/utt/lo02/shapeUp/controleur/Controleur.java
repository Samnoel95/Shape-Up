package fr.utt.lo02.shapeUp.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
	
	public Partie partie;
	public Parametres param;
	
	
	public Controleur(Parametres param) {
		
		Partie ShapeUp = new Partie();
		partie = ShapeUp;
		

		param.getCommencer().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Commencer !");
					// ajout JP
					for(int i=0; i<param.getSliderJp().getValue(); i++) {
						String nom = JOptionPane.showInputDialog( "Entrez le nom du joueur : " );
						JoueurPhysique joueur = new JoueurPhysique(nom, true);
						partie.ajouterUnJoueur(joueur);
					}
					// ajout JV
					for(int i=0; i<param.getSliderJv().getValue(); i++) {
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
					// choix plateau
					    if(param.getComboBox().getSelectedItem() == "Rectangle") {
							System.out.println("Tapis rectangulaire"); //ensuite relier à Partie
							Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
							partie.setTapis(tapis);;
						}
							
						else if(param.getComboBox().getSelectedItem() == "Triangle")
							System.out.println("Tapis triangulaire"); //ensuite relier à Partie
						Tapis tapis = new Tapis(formePlateau.TRIANGLE);
						partie.setTapis(tapis);
					// choix compteur
						if(param.getComboBox_1_1().getSelectedItem() == "Normal")
						{
							System.out.println("Compteur normal"); //ensuite relier à Partie
							CompteurNormal compt = new CompteurNormal();
							partie.setCompteur(compt);
						}
							
						else if(param.getComboBox_1_1().getSelectedItem() == "Inverse") {
							System.out.println("Compteur inverse"); //ensuite relier à Partie
							CompteurInverse compt = new CompteurInverse();
							partie.setCompteur(compt);
						}
					}
						if(param.getComboBox_1().getSelectedItem() == "Classique") {
					System.out.println("Lancement d'une partie classique !");
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
				
					else if(param.getComboBox_1().getSelectedItem() == "Avance") {
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

			
		}
		
		});
		
		param.getComboBox_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(param.getComboBox_1().getSelectedItem() == "Classique")
					System.out.println("Variante classique"); //ensuite relier à Partie
				else if(param.getComboBox_1().getSelectedItem() == "Avance")
					System.out.println("Variante avance"); //ensuite relier à Partie
			}
		});
		
		param.getSliderJv().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				param.getLabelNJv().setText(Integer.toString(param.getSliderJv().getValue()));
			}
		});
		
		param.getSliderJp().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				param.getLabelNJp().setText(Integer.toString(param.getSliderJp().getValue()));
			}
		});
		

	
	}
}
	
