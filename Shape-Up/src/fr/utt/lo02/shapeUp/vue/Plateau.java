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
import fr.utt.lo02.shapeUp.controleur.ControleurPlateau;
import fr.utt.lo02.shapeUp.modele.Partie.Partie;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

public class Plateau extends JFrame {
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	ControleurPlateau contr;
	
	public void setContr(ControleurPlateau contr) {
		this.contr = contr;
	}

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public JLabel getLblNewLabel_2_1() {
		return lblNewLabel_2_1;
	}

	public ButtonCard[][] getButtonCards() {
		return buttonCards;
	}

	public JFrame frame;
	ButtonCard buttonCards[][] = new ButtonCard[3][5];

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
		frame.getContentPane().setBackground(Color.WHITE);
		//r�cuperer la dimension de l'�cran
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = tailleMoniteur.width * 2/3;
		int hauteur = tailleMoniteur.height * 2/3;
		//r�gler la taille de JFrame � 2/3 la taille de l'�cran
		frame.setSize(longueur, hauteur);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(214, 181, 649, 470);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 5, 5, 5));
		
		  for(int i = 0; i <3 ; i++) {
		    	for(int j = 0 ; j<5;j++) {
		    		buttonCards[i][j] = new ButtonCard(j,i);
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
		panel_1.setBounds(929, 181, 278, 389);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Nom du joueur ");
		lblNewLabel_1.setForeground(new Color(255, 140, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(84, 26, 109, 14);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Afficher carte victoire");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(71, 74, 146, 87);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_2_1 = new JLabel("Afficher carte piocher");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(71, 239, 146, 87);
		panel_1.add(lblNewLabel_2_1);
		
		
	}
	
}
