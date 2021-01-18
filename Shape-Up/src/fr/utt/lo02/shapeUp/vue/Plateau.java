package fr.utt.lo02.shapeUp.vue;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.utt.lo02.shapeUp.controleur.Controleur;

import fr.utt.lo02.shapeUp.modele.Joueur.Joueur;
import fr.utt.lo02.shapeUp.modele.Joueur.JoueurPhysique;
import fr.utt.lo02.shapeUp.modele.Partie.Partie;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe qui decrit une vue plateau
 * 
 * @author Sam Noel
 *
 */
public class Plateau extends JFrame implements Observer {

	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	public JButton btnCartePiochee;
	private JButton btnCarteVictoire;
	public JButton btnOK;
	Controleur contr;

	/**
	 * Méthode qui définit le controleur
	 * @param contr, un controleur
	 */

	public void setContr(Controleur contr) {
		this.contr = contr;
	}

	/**
	 * Méthode qui retourne le controleur
	 */
	public Controleur getContr() {
		return this.contr;
	}

	/**
	 * Méthode qui retourne le JLabel lblNewLabel_1
	 */
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	/**
	 * Méthode qui retourne le JLabel lblNewLabel_2
	 */
	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	/**
	 * Méthode qui retourne le JLabel lblNewLabel_2_1
	 */
	public JLabel getLblNewLabel_2_1() {
		return lblNewLabel_2_1;
	}

	/**
	 * Méthode qui retourne l'attribut ButtonCard
	 */
	public ButtonCard[][] getButtonCards() {
		return buttonCards;
	}

	public JFrame frame;
	public ButtonCard buttonCards[][] = new ButtonCard[3][5];

	/**
	 * Méthode qui crée la vue
	 */
	public Plateau() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Méthode qui initialise les composants de la vue
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		// r�cuperer la dimension de l'�cran
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = tailleMoniteur.width;
		int hauteur = tailleMoniteur.height;
		// r�gler la taille de JFrame � 2/3 la taille de l'�cran
		frame.setSize(longueur, hauteur);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(214, 181, 649, 470);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 5, 5, 5));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				buttonCards[i][j] = new ButtonCard(j, i);
				panel.add(buttonCards[i][j]);

			}
		}

		JLabel lblNewLabel = new JLabel("SHAPE UP!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 70));
		lblNewLabel.setBounds(423, 43, 417, 74);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(929, 100, 370, 738);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_1 = new JLabel("Nom du joueur ");
		lblNewLabel_1.setForeground(new Color(255, 140, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(147, 10, 109, 14);
		panel_1.add(lblNewLabel_1);

		btnCartePiochee = new JButton("New button");

		btnCartePiochee.setBounds(85, 56, 229, 327);
		panel_1.add(btnCartePiochee);

		lblNewLabel_2_1 = new JLabel("Carte piochee");
		lblNewLabel_2_1.setBounds(85, 36, 229, 20);
		panel_1.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);

		btnCarteVictoire = new JButton("New button");
		btnCarteVictoire.setBounds(85, 405, 229, 327);
		panel_1.add(btnCarteVictoire);

		JLabel lblNewLabel_2_1_1 = new JLabel("Carte victoire");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setBounds(85, 385, 229, 20);
		panel_1.add(lblNewLabel_2_1_1);

		btnOK = new JButton("Ok !");
		btnOK.setBounds(423, 759, 117, 29);
		frame.getContentPane().add(btnOK);

	}

	/**
	 * Méthode qui permet de poser une carte
	 * 
	 * @param x, la ligne sur laquelle on pose la carte
	 * @param y, la colonne sur laquelle on pose la carte
	 */

	public ButtonCard poserCarte(int x, int y) {
		return this.buttonCards[x][y];

	}

	/**
	 * Méthode d'Observer qui agit lorsque l'état du tapis ou du joueur change
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Tapis) {

		}

		if (o instanceof Joueur) {

			ImageIcon img = new ImageIcon(((Joueur) o).getCartePiochee().getImageCarte());
			this.btnCartePiochee.setIcon(img);

			ImageIcon img2 = new ImageIcon(((Joueur) o).getCarteVictoire().getImageCarte());
			this.btnCarteVictoire.setIcon(img2);
		}

	}
}
