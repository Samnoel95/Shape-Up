package fr.utt.lo02.shapeUp.vue;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Scores {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scores window = new Scores();
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
	public Scores() {
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


		/*
		 * Ajout de l'image
		 */
		JLabel Label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Shape_up.png")).getImage();
		Label.setIcon(new ImageIcon(img));
		Label.setBounds(747, 171, 517, 510);
		frame.getContentPane().add(Label);

		/*
		 * Ajout de la 2eme image
		 */
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

		JLabel lblNewLabel_1 = new JLabel("Scores");
		lblNewLabel_1.setBounds(91, 329, 353, 58);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblNewLabel_1.setForeground(new Color(255, 165, 0));
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Score de +nom du joueur : ");
		lblNewLabel_2.setBounds(91, 392, 590, 82);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblNewLabel_2.setForeground(new Color(255, 165, 0));
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Score de +nom du joueur : ");
		lblNewLabel_2_1.setBounds(91, 455, 590, 58);
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblNewLabel_2_1.setForeground(new Color(255, 165, 0));
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Score de +nom du joueur : ");
		lblNewLabel_2_2.setBounds(91, 512, 614, 60);
		lblNewLabel_2_2.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblNewLabel_2_2.setForeground(new Color(255, 165, 0));
		frame.getContentPane().add(lblNewLabel_2_2);




	}
}
