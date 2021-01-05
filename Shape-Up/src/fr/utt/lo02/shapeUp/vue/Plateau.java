package fr.utt.lo02.shapeUp.vue;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Plateau {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Plateau window = new Plateau();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Plateau() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 304);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Nom du joueur");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Carte victoire");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		Image CV = new ImageIcon(this.getClass().getResource("/cartes/carre_bleu_plein.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(CV));
		
		JLabel lblNewLabel_2 = new JLabel("Carte piochée");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		Image CP = new ImageIcon(this.getClass().getResource("/cartes/triangle_vert_vide.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(CP));
		
		/*
		// ajouter un BorderLayout sur l'ensemble de la fenetre
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		// ajouter un JLabel en haut de la page
		
		JLabel labelHaut = new JLabel("Nom du joueur"); //ajouter un moyen d'adapter le nom du joueur qui joue
		frame.getContentPane().add(labelHaut, BorderLayout.NORTH);
		
		
		// ajouter un Panel dans la partie gauche du Layout de la fenêtre
		
		JPanel panel = new JPanel();
		
		// Ajouter d'un panel dans la partie droite
		
		JPanel panel_1 = new JPanel();
		
		JLabel labelGauche = new JLabel("Carte piochée");
		frame.getContentPane().add(labelGauche, BorderLayout.WEST);
		Image CP = new ImageIcon(this.getClass().getResource("/cartes/triangle_vert_vide.png")).getImage();
		labelGauche.setIcon(new ImageIcon(CP));
		
		JLabel labelDroit = new JLabel("Carte victoire");
		frame.getContentPane().add(labelDroit, BorderLayout.EAST);
		Image CV = new ImageIcon(this.getClass().getResource("/cartes/carre_bleu_plein.png")).getImage();
		labelDroit.setIcon(new ImageIcon(CV));
		*/
		
		
		
		
		/*
		Image CV = new ImageIcon(this.getClass().getResource("/cartes/carre_bleu_plein.png")).getImage();
		LabelCV.setIcon(new ImageIcon(CV));
		LabelCV.setBounds(747, 171, 517, 510);
		*/
		
		
		
		
	}
	

}
