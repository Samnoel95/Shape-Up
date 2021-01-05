package fr.utt.lo02.shapeUp.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Parametres {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parametres window = new Parametres();
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
	public Parametres() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		//r�cuperer la dimension de l'�cran
		Dimension tailleMoniteur = Toolkit.getDefaultToolkit().getScreenSize();
		int longueur = tailleMoniteur.width * 2/3;
		int hauteur = tailleMoniteur.height * 2/3;
		//r�gler la taille de JFrame � 2/3 la taille de l'�cran
		frame.setSize(longueur, hauteur);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SHAPE UP!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 70));
		lblNewLabel.setBounds(658, 28, 417, 74);
		frame.getContentPane().add(lblNewLabel);
		
		JSlider sliderJp = new JSlider();

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
		
		JLabel LabelJp = new JLabel("Nombre de joueur physique : ");
		LabelJp.setForeground(new Color(255, 165, 0));
		LabelJp.setFont(new Font("Segoe UI", Font.BOLD, 24));
		LabelJp.setBounds(10, 342, 351, 42);
		frame.getContentPane().add(LabelJp);
		
		JLabel LabelNJp = new JLabel("0");
		LabelNJp.setForeground(new Color(255, 0, 0));
		LabelNJp.setFont(new Font("Tahoma", Font.BOLD, 24));
		LabelNJp.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNJp.setBounds(346, 342, 44, 42);
		frame.getContentPane().add(LabelNJp);
		
		JLabel LabelJv = new JLabel("Nombre de joueur virtuel : ");
		LabelJv.setForeground(new Color(255, 165, 0));
		LabelJv.setFont(new Font("Segoe UI", Font.BOLD, 24));
		LabelJv.setBounds(10, 449, 313, 42);
		frame.getContentPane().add(LabelJv);
		
		JLabel LabelNJv = new JLabel("0");
		LabelNJv.setForeground(new Color(255, 0, 0));
		LabelNJv.setFont(new Font("Tahoma", Font.BOLD, 24));
		LabelNJv.setHorizontalAlignment(SwingConstants.CENTER);
		LabelNJv.setBounds(329, 449, 44, 42);
		frame.getContentPane().add(LabelNJv);
		
		JSlider sliderJv = new JSlider();
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
		
		JLabel lblNewLabel_1 = new JLabel("Forme tapis : ");
		lblNewLabel_1.setForeground(new Color(255, 165, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setBounds(753, 347, 214, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Choisir le compteur : ");
		lblNewLabel_2.setForeground(new Color(255, 165, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_2.setBounds(753, 485, 258, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Choisir la variante : ");
		lblNewLabel_3.setForeground(new Color(255, 165, 0));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_3.setBounds(753, 412, 233, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rectangle", "Triangle"}));
		comboBox.setBounds(949, 343, 141, 42);
		frame.getContentPane().add(comboBox);
		
		sliderJp.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				LabelNJp.setText(Integer.toString(sliderJp.getValue()));
			}
		});
		
		sliderJv.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				LabelNJv.setText(Integer.toString(sliderJv.getValue()));
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/Shape_up.png")).getImage();
		
		Image img2 = new ImageIcon(this.getClass().getResource("/Shape_up2.png")).getImage();
		JLabel Label2 = new JLabel("");
		Label2.setIcon(new ImageIcon(img2));
		Label2.setBounds(0, 0, 510, 336);
		frame.getContentPane().add(Label2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Classique", "Avanc\u00E9e"}));
		comboBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_1.setBounds(1012, 408, 141, 42);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Inverse"}));
		comboBox_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		comboBox_1_1.setBounds(1021, 482, 141, 42);
		frame.getContentPane().add(comboBox_1_1);
		
	}
}
