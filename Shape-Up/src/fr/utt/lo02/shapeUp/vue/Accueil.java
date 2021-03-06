package fr.utt.lo02.shapeUp.vue;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

import fr.utt.lo02.shapeUp.controleur.ListenerParam;
import fr.utt.lo02.shapeUp.controleur.ListenerRegles;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Classe qui decrit une vue d'accueil
 * @author Sam Noel 
 *
 */

public class Accueil {

	public JFrame frame;


	/**
	 * Constructeur de la classe
	 */
	public Accueil() {
		initialize();
	}

	/**
	 * Méthode qui initialise les composants de la vue
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = tailleMoniteur.width * 2/3;
		int hauteur = tailleMoniteur.height * 2/3;
		frame.setSize(longueur, hauteur);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JButton btnRgles = new JButton("Regles\r\n");
		btnRgles.addMouseListener(new ListenerRegles());


		JButton btnQuitter = new JButton("Quitter\r\n");
		btnQuitter.addActionListener(new ActionListener() {
			/**
			 * Méthode qui précise l'action au clic pour le bouton btnQuitter
			 */
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnQuitter.setBounds(152, 442, 321, 47);
		frame.getContentPane().add(btnQuitter);
		btnRgles.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnRgles.setBounds(308, 365, 321, 47);
		frame.getContentPane().add(btnRgles);

		JButton btnNewButton = new JButton("Nouvelle partie");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton.setBounds(471, 289, 321, 47);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new ListenerParam());
		
		JLabel Label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Shape_up.png")).getImage();
		Label.setIcon(new ImageIcon(img));
		Label.setBounds(747, 171, 517, 510);
		frame.getContentPane().add(Label);

		
		Image img2 = new ImageIcon(this.getClass().getResource("/Shape_up2.png")).getImage();
		JLabel Label2 = new JLabel("");
		Label2.setIcon(new ImageIcon(img2));
		Label2.setBounds(0, 0, 510, 336);
		frame.getContentPane().add(Label2);

		JLabel lblNewLabel = new JLabel("SHAPE UP!");
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 70));
		lblNewLabel.setBounds(658, 28, 417, 74);
		frame.getContentPane().add(lblNewLabel);




	}
}
