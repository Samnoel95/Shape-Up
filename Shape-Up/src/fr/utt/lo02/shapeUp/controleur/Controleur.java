package fr.utt.lo02.shapeUp.controleur;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.ImageIcon;
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
import fr.utt.lo02.shapeUp.modele.Joueur.Joueur;
import fr.utt.lo02.shapeUp.modele.Joueur.JoueurPhysique;
import fr.utt.lo02.shapeUp.modele.Joueur.JoueurVirtuel;
import fr.utt.lo02.shapeUp.modele.Partie.Partie;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;
import fr.utt.lo02.shapeUp.modele.Tapis.formePlateau;
import fr.utt.lo02.shapeUp.vue.Parametres;
import fr.utt.lo02.shapeUp.vue.Plateau;

/**
 * Classe controleur du patron MVC
 * 
 * @author Lorène Bergougnoux
 *
 */

public class Controleur {

	public Partie partie;
	public Parametres param;
	public Plateau plateau;

	public int indexJoueur;
	public int nbreCoup;

	/**
	 * Constructeur de la classe Controleur. Dans ce constructeur, on trouve les
	 * différentes actionPerformed liés aux boutons des vues.
	 * 
	 * @param param, la vue qui affiche les paramètres
	 */

	public Controleur(Parametres param) {

		Partie ShapeUp = new Partie();
		partie = ShapeUp;

		param.getComboBox_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (param.getComboBox_1().getSelectedItem() == "Classique")
					System.out.println("Variante classique");
				else if (param.getComboBox_1().getSelectedItem() == "Avance")
					System.out.println("Variante avance");
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

		if (param.getComboBox().getSelectedItem() == "Rectangle") {
			System.out.println("Tapis rectangulaire");

		}

		else if (param.getComboBox().getSelectedItem() == "Triangle") {
			System.out.println("Tapis triangulaire");

		}

		if (param.getComboBox_1_1().getSelectedItem() == "Normal") {
			System.out.println("Compteur normal");
		}

		else if (param.getComboBox_1_1().getSelectedItem() == "Inverse") {
			System.out.println("Compteur inverse");
		}

		param.getCommencer().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Commencer !");
				// ajout JP
				for (int i = 0; i < param.getSliderJp().getValue(); i++) {
					String nom = JOptionPane.showInputDialog("Entrez le nom du joueur : ");
					JoueurPhysique joueur = new JoueurPhysique(nom, true);
					ShapeUp.ajouterUnJoueur(joueur);
				}

				for (int i = 0; i < param.getSliderJv().getValue(); i++) {
					String difficulte;
					int diff;
					Scanner in = new Scanner(System.in);
					difficulte = JOptionPane
							.showInputDialog("Quelle difficulté souhaitez vous attribuer au joueur virtuel " + (i + 1)
									+ " (possibilité : 1 (facile) ou 2 (difficile))");
					diff = Integer.parseInt(difficulte);
					StringBuffer sb = new StringBuffer();
					sb.append("Joueur virtuel numéro ");
					sb.append(i + 1);
					String nom = sb.toString();
					JoueurVirtuel joueur = new JoueurVirtuel(nom, true, diff);
					ShapeUp.ajouterUnJoueur(joueur);

					if (param.getComboBox_1_1().getSelectedItem() == "Normal") {
						CompteurNormal compt = new CompteurNormal();
						ShapeUp.setCompteur(compt);
					}

					else if (param.getComboBox_1_1().getSelectedItem() == "Inverse") {
						CompteurInverse compt = new CompteurInverse();
						ShapeUp.setCompteur(compt);
					}
				}

				if (param.getComboBox_1().getSelectedItem() == "Classique") {
					System.out.println("Lancement d'une partie classique !");

					Pioche nouvellePioche = new Pioche();
					nouvellePioche.melangerJeu();
					ShapeUp.setPioche(nouvellePioche);
					ShapeUp.setNbreJPhysiques(param.getSliderJp().getValue());
					ShapeUp.setNbreJVirtuels(param.getSliderJv().getValue());

					if (param.getComboBox().getSelectedItem() == "Rectangle") {
						System.out.println("Tapis rectangulaire");
						Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
						ShapeUp.setTapis(tapis);
						ShapeUp.getTapis().setEstPlein(false);
					}

					else if (param.getComboBox().getSelectedItem() == "Triangle") {
						System.out.println("Tapis triangulaire");
						Tapis tapis = new Tapis(formePlateau.TRIANGLE);
						ShapeUp.setTapis(tapis);
						ShapeUp.getTapis().setEstPlein(false);
					}

					ShapeUp.setNombreDeJoueur(ShapeUp.getNbreJPhysiques() + ShapeUp.getNbreJVirtuels());
					Plateau plateau = new Plateau();

					nbreCoup = 0;

					System.out.println("A toi joueur numero : " + indexJoueur);
					partie.getListeJ().get(indexJoueur).addObserver(plateau);
					System.out.println(
							partie.getListeJ().get(indexJoueur).getNomJoueur() + " a pioche sa carte victoire : ");
					partie.getListeJ().get(indexJoueur)
							.setCarteVictoire((partie.getListeJ().get(indexJoueur).piocherCarte(partie.getPioche())));
					partie.getListeJ().get(indexJoueur).getCarteVictoire().toString();
					System.out.println(partie.getListeJ().get(indexJoueur).getNomJoueur() + " a pioche une carte : ");
					partie.getListeJ().get(indexJoueur)
							.setCartePiochee(partie.getListeJ().get(indexJoueur).piocherCarte(partie.getPioche()));
					partie.getListeJ().get(indexJoueur).getCartePiochee().toString();
					plateau.getLblNewLabel_1().setText(partie.getListeJ().get(indexJoueur).getNomJoueur());

					plateau.btnOK.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							nbreCoup++;
							if (indexJoueur < ShapeUp.getNombreDeJoueur())
								indexJoueur++;
							else {
								indexJoueur = 0;
							}
							System.out.println("indexJoueur = " + indexJoueur);

						}
					});

					plateau.buttonCards[0][0].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[0][0].setIcon(img);
						}
					});
					plateau.buttonCards[0][1].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[0][1].setIcon(img);
						}
					});
					plateau.buttonCards[0][2].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[0][2].setIcon(img);
						}
					});
					plateau.buttonCards[0][3].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[0][3].setIcon(img);
						}
					});
					plateau.buttonCards[0][4].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[0][4].setIcon(img);
						}
					});
					plateau.buttonCards[1][0].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[1][0].setIcon(img);
						}
					});
					plateau.buttonCards[1][1].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[1][1].setIcon(img);
						}
					});
					plateau.buttonCards[1][2].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[1][2].setIcon(img);
						}
					});
					plateau.buttonCards[1][3].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[1][3].setIcon(img);
						}
					});
					plateau.buttonCards[1][4].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[1][4].setIcon(img);
						}
					});
					plateau.buttonCards[2][0].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[2][0].setIcon(img);
						}
					});
					plateau.buttonCards[2][1].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[2][1].setIcon(img);
						}
					});
					plateau.buttonCards[2][2].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[2][2].setIcon(img);
						}
					});
					plateau.buttonCards[2][3].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[2][3].setIcon(img);
						}
					});
					plateau.buttonCards[2][4].addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							ImageIcon img = new ImageIcon(
									(ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));

							plateau.buttonCards[2][4].setIcon(img);
						}
					});

				}

				else if (param.getComboBox_1().getSelectedItem() == "Avance") {
					System.out.println("Lancement d'une partie avancée !");

					Pioche nouvellePioche = new Pioche();
					nouvellePioche.melangerJeu();
					ShapeUp.setPioche(nouvellePioche);
					ShapeUp.setNbreJPhysiques(param.getSliderJp().getValue());
					ShapeUp.setNbreJVirtuels(param.getSliderJv().getValue());

					if (param.getComboBox().getSelectedItem() == "Rectangle") {
						System.out.println("Tapis rectangulaire");
						Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
						ShapeUp.setTapis(tapis);
						ShapeUp.getTapis().setEstPlein(false);
					}

					else if (param.getComboBox().getSelectedItem() == "Triangle") {
						System.out.println("Tapis triangulaire");
						Tapis tapis = new Tapis(formePlateau.TRIANGLE);
						ShapeUp.setTapis(tapis);
						ShapeUp.getTapis().setEstPlein(false);
					}

					Plateau plateau = new Plateau();
					System.out.println("Comptons les scores !");
					ShapeUp.compterPoints(ShapeUp);
					System.out.println("Fin du round !");

				}

			}

		});

	}

	/**
	 * Méthode qui fait piocher un joueur
	 * 
	 * @param joueur, un joueur de la partie
	 */

	public void jouerTour(Joueur joueur) {
		joueur.piocherCarte(this.partie.getPioche());
	}

}
