package fr.utt.lo02.shapeUp.vue;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * Classe qui decrit une vue règles
 * 
 * @author Sam Noel
 *
 */
public class Regle {

	public JFrame frame;

	/**
	 * Constructeur de la classe
	 */
	public Regle() {
		initialize();
	}

	/**
	 * Méthode qui initialise les composants de la vue
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		// r�cuperer la dimension de l'�cran
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = tailleMoniteur.width * 2 / 3;
		int hauteur = tailleMoniteur.height * 2 / 3;
		// r�gler la taille de JFrame � 2/3 la taille de l'�cran
		frame.setSize(longueur, hauteur);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/regles.png")).getImage();

		JButton btnNewButton = new JButton("Retour");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			/**
			 * Méthode qui précise l'action au clic pour le bouton btnNewButton
			 */
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(993, 514, 214, 48);
		frame.getContentPane().add(btnNewButton);

		JLabel Label = new JLabel("");
		Label.setIcon(new ImageIcon(img));
		Label.setBounds(0, 0, 1264, 681);
		frame.getContentPane().add(Label);
	}

}
