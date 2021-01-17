package fr.utt.lo02.shapeUp.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.event.ChangeListener;

import fr.utt.lo02.shapeUp.controleur.Controleur;
import fr.utt.lo02.shapeUp.controleur.ListenerPlateau;
import fr.utt.lo02.shapeUp.controleur.ListenerRegles;
import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.CompteurScore.CompteurInverse;
import fr.utt.lo02.shapeUp.modele.CompteurScore.CompteurNormal;
import fr.utt.lo02.shapeUp.modele.Joueur.JoueurPhysique;
import fr.utt.lo02.shapeUp.modele.Joueur.JoueurVirtuel;
import fr.utt.lo02.shapeUp.modele.Partie.Partie;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;
import fr.utt.lo02.shapeUp.modele.Tapis.formePlateau;

import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;

/**
 * Classe qui decrit une vue parametres
 * 
 * @author Sam Noel
 *
 */
public class Parametres {
	public JFrame frame;
	private JButton commencer;
	private JComboBox comboBox_1_1;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JSlider sliderJv;
	private JLabel LabelNJv;
	private JLabel LabelJv;
	private JLabel LabelNJp;
	private JLabel LabelJp;
	private JSlider sliderJp;
	Controleur controleur;

	/**
	 * Méthode qui retourne une fenêtre
	 */

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Méthode qui retourne un JButton
	 */
	public JButton getCommencer() {
		return commencer;
	}

	/**
	 * Méthode qui retourne un JComboBox
	 */

	public JComboBox getComboBox_1_1() {
		return comboBox_1_1;
	}

	/**
	 * Méthode qui retourne un JComboBox
	 */
	public JComboBox getComboBox_1() {
		return comboBox_1;
	}

	/**
	 * Méthode qui retourne un JComboBox
	 */
	public JComboBox getComboBox() {
		return comboBox;
	}

	/**
	 * Méthode qui retourne un JLabel
	 */
	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	/**
	 * Méthode qui retourne un JLabel
	 */
	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	/**
	 * Méthode qui retourne un JLabel
	 */
	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	/**
	 * Méthode qui retourne un JSlider
	 */
	public JSlider getSliderJv() {
		return sliderJv;
	}

	/**
	 * Méthode qui retourne un JSlider
	 */
	public JLabel getLabelNJv() {
		return LabelNJv;
	}

	/**
	 * Méthode qui retourne un JSlider
	 */
	public JLabel getLabelJv() {
		return LabelJv;
	}

	/**
	 * Méthode qui retourne un JLabel
	 */
	public JLabel getLabelNJp() {
		return LabelNJp;
	}

	/**
	 * Méthode qui retourne un JLabel
	 */
	public JLabel getLabelJp() {
		return LabelJp;
	}

	/**
	 * Méthode qui retourne un JSlider
	 */
	public JSlider getSliderJp() {
		return sliderJp;
	}

	/**
	 * Constructeur de la classe
	 */
	public Parametres() {
		initialize();
		Controleur controleur = new Controleur(this);
	}

	/**
	 * Méthode qui initialise les composants de la vue
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = tailleMoniteur.width * 2 / 3;
		int hauteur = tailleMoniteur.height * 2 / 3;
		frame.setSize(longueur, hauteur);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("SHAPE UP!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 70));
		lblNewLabel.setBounds(658, 28, 417, 74);
		frame.getContentPane().add(lblNewLabel);

		sliderJp = new JSlider();

		sliderJp.setPaintLabels(true);
		sliderJp.setPaintTicks(true);
		sliderJp.setBackground(Color.WHITE);
		sliderJp.setName("");
		sliderJp.setToolTipText("");
		sliderJp.setMaximum(3);
		sliderJp.setMinorTickSpacing(1);
		sliderJp.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		sliderJp.setValue(0);
		sliderJp.setBounds(106, 395, 200, 26);
		frame.getContentPane().add(sliderJp);

		LabelJp = new JLabel("Nombre de joueur physique : ");
		LabelJp.setForeground(new Color(255, 165, 0));
		LabelJp.setFont(new Font("Segoe UI", Font.BOLD, 24));
		LabelJp.setBounds(10, 342, 351, 42);
		frame.getContentPane().add(LabelJp);

		LabelNJp = new JLabel("0");
		LabelNJp.setForeground(new Color(255, 0, 0));
		LabelNJp.setFont(new Font("Tahoma", Font.BOLD, 24));
		LabelNJp.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNJp.setBounds(346, 342, 44, 42);
		frame.getContentPane().add(LabelNJp);

		LabelJv = new JLabel("Nombre de joueur virtuel : ");
		LabelJv.setForeground(new Color(255, 165, 0));
		LabelJv.setFont(new Font("Segoe UI", Font.BOLD, 24));
		LabelJv.setBounds(10, 449, 313, 42);
		frame.getContentPane().add(LabelJv);

		LabelNJv = new JLabel("0");
		LabelNJv.setForeground(new Color(255, 0, 0));
		LabelNJv.setFont(new Font("Tahoma", Font.BOLD, 24));
		LabelNJv.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNJv.setBounds(329, 449, 44, 42);
		frame.getContentPane().add(LabelNJv);

		sliderJv = new JSlider();
		sliderJv.setValue(0);
		sliderJv.setToolTipText("");
		sliderJv.setPaintTicks(true);
		sliderJv.setPaintLabels(true);
		sliderJv.setName("");
		sliderJv.setMinorTickSpacing(1);
		sliderJv.setMaximum(3);
		sliderJv.setBackground(Color.WHITE);
		sliderJv.setBounds(69, 498, 200, 26);
		frame.getContentPane().add(sliderJv);

		lblNewLabel_1 = new JLabel("Forme tapis : ");
		lblNewLabel_1.setForeground(new Color(255, 165, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setBounds(753, 347, 214, 22);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel(" Choisir le compteur : ");
		lblNewLabel_2.setForeground(new Color(255, 165, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_2.setBounds(753, 485, 258, 26);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Choisir la variante : ");
		lblNewLabel_3.setForeground(new Color(255, 165, 0));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_3.setBounds(753, 412, 233, 26);
		frame.getContentPane().add(lblNewLabel_3);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Rectangle", "Triangle" }));
		comboBox.setBounds(949, 343, 141, 42);
		frame.getContentPane().add(comboBox);

		Image img = new ImageIcon(this.getClass().getResource("/Shape_up.png")).getImage();

		Image img2 = new ImageIcon(this.getClass().getResource("/Shape_up2.png")).getImage();
		JLabel Label2 = new JLabel("");
		Label2.setIcon(new ImageIcon(img2));
		Label2.setBounds(0, 0, 510, 336);
		frame.getContentPane().add(Label2);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Classique", "Avance" }));
		comboBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_1.setBounds(1012, 408, 141, 42);
		frame.getContentPane().add(comboBox_1);

		comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] { "Normal", "Inverse" }));
		comboBox_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_1_1.setBounds(1021, 482, 141, 42);
		frame.getContentPane().add(comboBox_1_1);

		commencer = new JButton("Commencer");
		commencer.setBounds(497, 543, 117, 29);
		frame.getContentPane().add(commencer);

	}

}
