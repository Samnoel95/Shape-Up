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



public class Accueil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
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
	public Accueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		//récuperer la dimension de l'écran
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = tailleMoniteur.width * 2/3;
		int hauteur = tailleMoniteur.height * 2/3;
		//régler la taille de JFrame à 2/3 la taille de l'écran
		frame.setSize(longueur, hauteur);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton btnRgles = new JButton("R\u00E8gles\r\n");
		btnRgles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnQuitter = new JButton("Quitter\r\n");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		
		

	}
}
