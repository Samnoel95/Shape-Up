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

public class Controleur {
	
	public Partie partie;
	public Parametres param;
	public Plateau plateau;

	public int indexJoueur;
	public int nbreCoup;
	
	public Controleur(Parametres param) {
		
		Partie ShapeUp = new Partie();
		partie = ShapeUp;
		/*
		 Le bouton qui choisit la version, test pour affichage console
		 */
		
		param.getComboBox_1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(param.getComboBox_1().getSelectedItem() == "Classique")
					System.out.println("Variante classique"); //ensuite relier à Partie
				else if(param.getComboBox_1().getSelectedItem() == "Avance")
					System.out.println("Variante avance"); //ensuite relier à Partie
			}
		});
		
		/*
		 Le bouton qui choisit le nombre de joueurs virtuels, affichage IG
		 */
		
		
		param.getSliderJv().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				param.getLabelNJv().setText(Integer.toString(param.getSliderJv().getValue()));
			}
		});
		
		/*
		 Le bouton qui choisit le nombre de joueurs physiques, affichage IG
		 */
		
		param.getSliderJp().addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				param.getLabelNJp().setText(Integer.toString(param.getSliderJp().getValue()));
			}
		});
		
		/*
		 Le bouton qui choisit la forme du plateau, test pour affichage console
		 */
	    
	    if(param.getComboBox().getSelectedItem() == "Rectangle") {
			System.out.println("Tapis rectangulaire"); //ensuite relier à Partie
			
		}
			
		else if(param.getComboBox().getSelectedItem() == "Triangle") {
			System.out.println("Tapis triangulaire"); //ensuite relier à Partie
		
		}
	    
	    /*
		 Le bouton qui choisit la forme du plateau, test pour affichage console
		 */
	    
		if(param.getComboBox_1_1().getSelectedItem() == "Normal")
		{
			System.out.println("Compteur normal"); //ensuite relier à Partie
		}
			
		else if(param.getComboBox_1_1().getSelectedItem() == "Inverse") {
			System.out.println("Compteur inverse"); //ensuite relier à Partie
		}
		
		
		/*
		 Appui sur le bouton "commencer" de paramètres
		 */
		
		param.getCommencer().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Commencer !");
					// ajout JP
					for(int i=0; i<param.getSliderJp().getValue(); i++) {
						String nom = JOptionPane.showInputDialog( "Entrez le nom du joueur : " );
						JoueurPhysique joueur = new JoueurPhysique(nom, true);
						ShapeUp.ajouterUnJoueur(joueur);
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
					    ShapeUp.ajouterUnJoueur(joueur);
					// choix compteur
						if(param.getComboBox_1_1().getSelectedItem() == "Normal")
						{
							CompteurNormal compt = new CompteurNormal();
							ShapeUp.setCompteur(compt);
						}
							
						else if(param.getComboBox_1_1().getSelectedItem() == "Inverse") {
							CompteurInverse compt = new CompteurInverse();
							ShapeUp.setCompteur(compt);
						}
					}
					
					/*
					 Si c'est une partie classique
					 */
					
						if(param.getComboBox_1().getSelectedItem() == "Classique") {
						System.out.println("Lancement d'une partie classique !");
						//for(int i=0; i<4;i++) {
						Pioche nouvellePioche = new Pioche();
						nouvellePioche.melangerJeu();
						ShapeUp.setPioche(nouvellePioche);
						ShapeUp.setNbreJPhysiques(param.getSliderJp().getValue());
						ShapeUp.setNbreJVirtuels(param.getSliderJv().getValue());
						
						/*
						 Si c'est un tapis rectangulaire
						 */
						
						 if(param.getComboBox().getSelectedItem() == "Rectangle") {
								System.out.println("Tapis rectangulaire"); //ensuite relier à Partie
								Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
								ShapeUp.setTapis(tapis);
								ShapeUp.getTapis().setEstPlein(false);
							}
						 
						 /*
						 Si c'est un plateau rectangulaire
						 */
								
							else if(param.getComboBox().getSelectedItem() == "Triangle") {
								System.out.println("Tapis triangulaire"); //ensuite relier à Partie
							Tapis tapis = new Tapis(formePlateau.TRIANGLE);
							ShapeUp.setTapis(tapis);
							ShapeUp.getTapis().setEstPlein(false);
							}

						 /*
						 Ouverture d'un fenetre plateau
						 */
						 ShapeUp.setNombreDeJoueur(ShapeUp.getNbreJPhysiques()+ShapeUp.getNbreJVirtuels());
						 Plateau plateau = new Plateau();
						 
						 nbreCoup=0;
						 
							 System.out.println("A toi joueur numero : "+indexJoueur);
							 partie.getListeJ().get(indexJoueur).addObserver(plateau);
							 System.out.println(partie.getListeJ().get(indexJoueur).getNomJoueur()+" a pioche sa carte victoire : ");
							 partie.getListeJ().get(indexJoueur).setCarteVictoire((partie.getListeJ().get(indexJoueur).piocherCarte(partie.getPioche())));
							 partie.getListeJ().get(indexJoueur).getCarteVictoire().toString();
							 System.out.println(partie.getListeJ().get(indexJoueur).getNomJoueur()+" a pioche une carte : ");
							 partie.getListeJ().get(indexJoueur).setCartePiochee(partie.getListeJ().get(indexJoueur).piocherCarte(partie.getPioche()));
							 partie.getListeJ().get(indexJoueur).getCartePiochee().toString();
							 plateau.getLblNewLabel_1().setText(partie.getListeJ().get(indexJoueur).getNomJoueur());
							 // PASSER AU JOUEUR SUIVANT AU CLIC SUR LE BOUTON OK
							 //utiliser une boucle pour pour effectuer ces actions une fois par joueur
							 //utiliser ensuite une autre boucle où il pioche juste une carte 
						
						
							 
						 

						 plateau.btnOK.addMouseListener(new MouseAdapter() {
						 	@Override
						 	public void mousePressed(MouseEvent e) {
						 		nbreCoup++;
						 		if(indexJoueur < ShapeUp.getNombreDeJoueur())
						 			indexJoueur++;
						 		else {
						 			indexJoueur=0;	
						 		}
						 		System.out.println("indexJoueur = "+indexJoueur);
						 		
						 	}
						 });
						
								plateau.buttonCards[0][0].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[0][0].setIcon(img);
									}
								});
								plateau.buttonCards[0][1].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[0][1].setIcon(img);
									}
								});
								plateau.buttonCards[0][2].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[0][2].setIcon(img);
									}
								});
								plateau.buttonCards[0][3].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[0][3].setIcon(img);
									}
								});
								plateau.buttonCards[0][4].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[0][4].setIcon(img);
									}
								});
								plateau.buttonCards[1][0].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[1][0].setIcon(img);
									}
								});
								plateau.buttonCards[1][1].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[1][1].setIcon(img);
									}
								});
								plateau.buttonCards[1][2].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[1][2].setIcon(img);
									}
								});
								plateau.buttonCards[1][3].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[1][3].setIcon(img);
									}
								});
								plateau.buttonCards[1][4].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[1][4].setIcon(img);
									}
								});
								plateau.buttonCards[2][0].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[2][0].setIcon(img);
									}
								});
								plateau.buttonCards[2][1].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[2][1].setIcon(img);
									}
								});
								plateau.buttonCards[2][2].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[2][2].setIcon(img);
									}
								});
								plateau.buttonCards[2][3].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[2][3].setIcon(img);
									}
								});
								plateau.buttonCards[2][4].addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent e) {
										//ShapeUp.getTapis().addObserver(plateau);
										ImageIcon img = new ImageIcon((ShapeUp.getListeJ().get(0).getCartePiochee().getImageCarte()));
										/*System.out.println(img.getIconHeight() + " " + img.getIconWidth());
										Image image = img.getImage();
										BufferedImage bi = new BufferedImage(img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
										Graphics g = bi.createGraphics();
										g.drawImage(image, 0, 0, 71, 100, null);
										ImageIcon newImg = new ImageIcon(bi);
										*/
										plateau.buttonCards[2][4].setIcon(img);
									}
								});
						 
						
					//}
				}
				
						
						/*
						 Si c'est une partie avancée
						 */
						
					else if(param.getComboBox_1().getSelectedItem() == "Avance") {
						System.out.println("Lancement d'une partie avancée !");
						//for(int i=0; i<4;i++) {
							Pioche nouvellePioche = new Pioche();
							nouvellePioche.melangerJeu();
							ShapeUp.setPioche(nouvellePioche);
							ShapeUp.setNbreJPhysiques(param.getSliderJp().getValue());
							ShapeUp.setNbreJVirtuels(param.getSliderJv().getValue());
							
							/*
							 Si c'est un plateau rectangulaire
							 */
							
							 if(param.getComboBox().getSelectedItem() == "Rectangle") {
									System.out.println("Tapis rectangulaire"); //ensuite relier à Partie
									Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
									ShapeUp.setTapis(tapis);
									ShapeUp.getTapis().setEstPlein(false);
								}
							 
							 /*
							 Si c'est un plateau triangulaire
							 */
									
								else if(param.getComboBox().getSelectedItem() == "Triangle") {
									System.out.println("Tapis triangulaire"); //ensuite relier à Partie
								Tapis tapis = new Tapis(formePlateau.TRIANGLE);
								ShapeUp.setTapis(tapis);
								ShapeUp.getTapis().setEstPlein(false);
								}
							 
							 /*
							 Ouverture d'une fenêtre Plateau
							 */

							Plateau plateau = new Plateau();
							//partie.partieAdvanced(ShapeUp); //instancier les mouvements sur le plateau
							System.out.println("Comptons les scores !");
							ShapeUp.compterPoints(ShapeUp);
							System.out.println("Fin du round !");
					
				}

			
		}
		
		});
		
		/*
		ShapeUp.setNombreDeJoueur(ShapeUp.getNbreJPhysiques()+ShapeUp.getNbreJVirtuels());
		for(int i=0; i<ShapeUp.getNombreDeJoueur(); i++) {
			System.out.println(ShapeUp.getListeJ().get(i).getNomJoueur()+" pioche sa carte victoire.");
			ShapeUp.getListeJ().get(i).setCarteVictoire(ShapeUp.getListeJ().get(i).piocherCarte(partie.getPioche()));
		}
		//jouer pour la version classique	
		// while(ShapeUp.getTapis().getEstPlein()==false) {
		for(int i=0; i<15; i++) {
		//System.out.println(ShapeUp.getTapis().getPlateau().size());
		for(int j=0; j<ShapeUp.getNombreDeJoueur(); j++) {
			
			System.out.println("Affichage nouveau plateau !");
		Plateau nvPlateau = new Plateau();
		nvPlateau.getLblNewLabel_1().setText(partie.getListeJ().get(j).getNomJoueur());
		nvPlateau.setVisible(true);
		
		while(ShapeUp.getTapis().getEstPlein()==false) {
			System.out.println("");
			System.out.println("**************************");
			System.out.println("");
			System.out.println("C'est au tour de : ");
			System.out.println(ShapeUp.getListeJ().get(j).getNomJoueur()+" // carte victoire : "+ShapeUp.getListeJ().get(j).getCarteVictoire());
			
			ShapeUp.getListeJ().get(j).jouer(ShapeUp.getListeJ().get(j), ShapeUp.getTapis(), ShapeUp.getPioche(), partie.getCompteur());
			System.out.println("5");
			if(ShapeUp.getTapis().getPlateau().size()==15 && ShapeUp.getNombreDeJoueur()==2) {
				ShapeUp.getTapis().setEstPlein(true);
				System.out.println("Le tapis est rempli !");
			}
			else if(ShapeUp.getTapis().getPlateau().size()==14 && ShapeUp.getNombreDeJoueur()==3) {
				ShapeUp.getTapis().setEstPlein(true);
				System.out.println("Le tapis est rempli !");
			}
			
		}
		
		}
	

	}
	*/
}

	public void jouerTour(Joueur joueur) {
		joueur.piocherCarte(this.partie.getPioche());
	}
	
/*
public void premierTour(Partie ShapeUp, int i) {
	 ShapeUp.getListeJ().get(i).addObserver(plateau);
	 System.out.println(ShapeUp.getListeJ().get(i).getNomJoueur()+" a pioche sa carte victoire : ");
	 ShapeUp.getListeJ().get(i).setCarteVictoire((ShapeUp.getListeJ().get(i).piocherCarte(ShapeUp.getPioche())));
	 ShapeUp.getListeJ().get(i).getCarteVictoire().toString();
	 System.out.println(ShapeUp.getListeJ().get(i).getNomJoueur()+" a pioche une carte : ");
	 ShapeUp.getListeJ().get(i).setCartePiochee(ShapeUp.getListeJ().get(i).piocherCarte(ShapeUp.getPioche()));
	 ShapeUp.getListeJ().get(i).getCartePiochee().toString();
	 plateau.getLblNewLabel_1().setText(ShapeUp.getListeJ().get(i).getNomJoueur());
}
*/
}
/*
 for(int i = 0; i<ShapeUp.getNombreDeJoueur(); i++)
						{
							System.out.println("");
							System.out.println("**************************");
							System.out.println("");
							plateau.getLblNewLabel_1().setText(partie.getListeJ().get(j).getNomJoueur());
							System.out.println(ShapeUp.getListeJ().get(i).getNomJoueur()+" pioche sa carte victoire : ");
						ShapeUp.getListeJ().get(0).setCarteVictoire(ShapeUp.getListeJ().get(i).piocherCarte(ShapeUp.getPioche()));
						System.out.println(ShapeUp.getListeJ().get(0).getCartePiochee().toString());
						System.out.println("Comptons les scores !");
						ShapeUp.compterPoints(ShapeUp);
						System.out.println("Fin du round !");
					//}
				}
						}
 */

	
