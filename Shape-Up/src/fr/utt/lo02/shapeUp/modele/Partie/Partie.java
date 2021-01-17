package fr.utt.lo02.shapeUp.modele.Partie;

import java.util.*;

import fr.utt.lo02.shapeUp.modele.Carte.Carte;
import fr.utt.lo02.shapeUp.modele.Carte.Couleur;
import fr.utt.lo02.shapeUp.modele.Carte.Forme;
import fr.utt.lo02.shapeUp.modele.Carte.Pioche;
import fr.utt.lo02.shapeUp.modele.CompteurScore.CompteurInverse;
import fr.utt.lo02.shapeUp.modele.CompteurScore.CompteurNormal;
import fr.utt.lo02.shapeUp.modele.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.modele.Joueur.Joueur;
import fr.utt.lo02.shapeUp.modele.Joueur.JoueurPhysique;
import fr.utt.lo02.shapeUp.modele.Joueur.JoueurVirtuel;
import fr.utt.lo02.shapeUp.modele.Tapis.Tapis;
import fr.utt.lo02.shapeUp.modele.Tapis.formePlateau;

/**
 * Classe qui decrit une partie
 * 
 * @author Lorène Bergougnoux
 *
 */

public class Partie {
	private int nombreDeJoueur;
	private int nbreJVirtuels;
	private int nbreJPhysiques;
	private static ArrayList<Joueur> listeJ; // listeJ est l'ensemble des joueurs de la partie
	private int round;
	private int tour;
	private String regle;
	private Pioche pioche;
	private Tapis tapis;
	private Visiteur compteur;
	private Carte carteCachee;

	/**
	 * Constructeur de la classe Partie
	 * 
	 */

	public Partie() {
		setListeJ(new ArrayList<Joueur>());
		Pioche pioche = new Pioche();
		pioche.melangerJeu();
		this.setPioche(pioche);
	}

	/**
	 * Méthode qui retourne le compteur associé à la partie
	 * 
	 */

	public Visiteur getCompteur() {
		return this.compteur;
	}

	/**
	 * Méthode qui définit un compteur pour la partie
	 * 
	 * @param compteur : un compteur
	 * 
	 */

	public void setCompteur(Visiteur compteur) {
		this.compteur = compteur;
	}

	/**
	 * Méthode qui retourne le tapis associé à la partie
	 * 
	 */
	public Tapis getTapis() {
		return this.tapis;
	}

	/**
	 * Méthode qui définit un tapis pour la partie
	 * 
	 * @param tapis : un tapis
	 * 
	 */
	public void setTapis(Tapis tapis) {
		this.tapis = tapis;
	}

	/**
	 * Méthode qui retourne la pioche associée à la partie
	 * 
	 */
	public Pioche getPioche() {
		return this.pioche;
	}

	/**
	 * Méthode qui définit une pioche pour la partie
	 * 
	 * @param pioche : une pioche
	 * 
	 */
	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	/**
	 * Méthode qui retourne le nombre de joueurs de la partie
	 * 
	 */
	public int getNombreDeJoueur() {
		return this.nombreDeJoueur;
	}

	/**
	 * Méthode qui définit le nombre de joueurs de la partie
	 * 
	 * @param nombreDeJoueur : le nombre de joueurs dans la partie
	 * 
	 */

	public void setNombreDeJoueur(int nombreDeJoueur) {
		this.nombreDeJoueur = nombreDeJoueur;
	}

	/**
	 * Méthode qui retourne le nombre de joueurs virtuels de la partie
	 * 
	 */
	public int getNbreJVirtuels() {
		return this.nbreJVirtuels;
	}

	/**
	 * Méthode qui définit le nombre de joueurs virtuels de la partie
	 * 
	 * @param nbreJVirtuels : le nombre de joueurs virtuels dans la partie
	 * 
	 */
	public void setNbreJVirtuels(int nbreJVirtuels) {
		this.nbreJVirtuels = nbreJVirtuels;
	}

	/**
	 * Méthode qui retourne le nombre de joueurs physiques de la partie
	 * 
	 */
	public int getNbreJPhysiques() {
		return this.nbreJPhysiques;
	}

	/**
	 * Méthode qui définit le nombre de joueurs physiques de la partie
	 * 
	 * @param nbreJPhysique : le nombre de joueurs physiques dans la partie
	 * 
	 */
	public void setNbreJPhysiques(int nbreJPhysiques) {
		this.nbreJPhysiques = nbreJPhysiques;
	}

	/**
	 * Méthode qui ajoute un joueurs à la partie
	 * 
	 * @param joueur : un joueur
	 * 
	 */
	public void ajouterUnJoueur(Joueur joueur) {
		getListeJ().add(joueur);
	}

	/**
	 * Méthode qui retourne la liste de joueur de la partie
	 * 
	 */
	public ArrayList<Joueur> getListeJ() {
		return listeJ;
	}

	/**
	 * Méthode qui définit la liste de joueur de la partie
	 * 
	 * @param listeJ : une ArrayList de joueurs
	 * 
	 */
	public void setListeJ(ArrayList<Joueur> listeJ) {
		Partie.listeJ = listeJ;
	}

	/**
	 * Méthode qui affiche les joueurs de la partie
	 * 
	 * @param ShapeUp : une partie
	 * 
	 */
	public void affichageJoueur(Partie ShapeUp) {
		System.out.println("");
		System.out.println("**************************");
		System.out.println("");
		System.out.println("Voici les joueurs qui participent à la partie :");
		System.out.println("");
		Iterator<Joueur> it = ShapeUp.getListeJ().listIterator();
		while (it.hasNext()) {
			System.out.println(it.next().getNomJoueur());
		}
		System.out.println("");
		System.out.println("**************************");
		System.out.println("");
	}

	/**
	 * Méthode qui demande combien de joueurs participent à la partie
	 * 
	 */
	public void askNbreJoueur() {
		do {
			Scanner in2 = new Scanner(System.in);
			System.out.println("A combien de joueurs voulez vous jouer (possibilités : 2 ou 3)?");
			this.setNombreDeJoueur(in2.nextInt());
		} while (this.getNombreDeJoueur() < 2 || this.getNombreDeJoueur() > 3);
	}

	/**
	 * Méthode qui demande combien de joueurs physiques participent à la partie
	 * 
	 */
	public void askNbreJoueurPhys() {
		do {
			Scanner in = new Scanner(System.in);
			System.out.println("Combien de joueurs physiques participent à la partie?");
			this.setNbreJPhysiques(in.nextInt());
		} while (this.getNbreJPhysiques() > this.getNombreDeJoueur() || this.getNbreJPhysiques() < 0);

	}

	/**
	 * Méthode qui calcule le nombre de joueurs virtuels qui participent à la partie
	 * 
	 */
	public void calculNbreJoueursVirt() {
		this.setNbreJVirtuels(this.getNombreDeJoueur() - this.getNbreJPhysiques());
	}

	/**
	 * Méthode qui crée des joueurs et les ajoute à la partie
	 * 
	 */
	public void creerJoueurs() {
		boolean premierJ = false;

		for (int i = 0; i < this.getNbreJPhysiques(); i++) {
			Scanner in3 = new Scanner(System.in);
			System.out.println("Quel est le nom du joueur physique " + (i + 1) + "?");
			String nom = in3.nextLine();
			Scanner in4 = new Scanner(System.in);
			if (premierJ == false) {
				JoueurPhysique j = new JoueurPhysique(nom, true);
				this.ajouterUnJoueur(j);
				premierJ = true;
			} else {
				JoueurPhysique j = new JoueurPhysique(nom, false);
				this.ajouterUnJoueur(j);
			}
		}

		for (int i = 0; i < this.getNbreJVirtuels(); i++) {
			int difficulte;
			do {
				Scanner in = new Scanner(System.in);
				System.out.println("Quelle difficulté souhaitez vous attribuer au joueur virtuel " + (i + 1)
						+ " (possibilité : 1 (facile) ou 2 (difficile))");
				difficulte = in.nextInt();
			} while (difficulte < 1 || difficulte > 2);
			StringBuffer sb = new StringBuffer();
			sb.append("Joueur virtuel numéro ");
			sb.append(i + 1);
			String nom = sb.toString();
			if (premierJ == false) {
				Joueur j = new JoueurVirtuel(nom, true, difficulte);
				this.ajouterUnJoueur(j);
			} else {
				Joueur j = new JoueurVirtuel(nom, false, difficulte);
				this.ajouterUnJoueur(j);
			}

		}
	}

	/**
	 * Méthode qui demande avec quel plateau sera jouée la partie
	 * 
	 */

	public void choixPlateau() {
		int plateau;
		do {
			Scanner in2 = new Scanner(System.in);
			System.out.println("Avec quel tapis souhaitez vous jouer?");
			System.out.println("1. Tapis 3x5");
			System.out.println("2. Tapis triangulaire");
			plateau = in2.nextInt();
		} while (plateau < 1 || plateau > 2);

		switch (plateau) {
		case 1:
			Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
			this.setTapis(tapis);
			break;
		case 2:
			Tapis tapis2 = new Tapis(formePlateau.TRIANGLE);
			this.setTapis(tapis2);
			break;
		}
	}

	/**
	 * Méthode qui demande avec quel compteur sera jouée la partie
	 * 
	 */
	public void choixCompteur() {
		int compteur;
		do {
			Scanner in2 = new Scanner(System.in);
			System.out.println("Avec quel compteur souhaitez vous compter les points?");
			System.out.println("1. Compteur normal");
			System.out.println("2. Compteur inversé");
			compteur = in2.nextInt();
		} while (compteur < 1 || compteur > 2);

		switch (compteur) {
		case 1:
			CompteurNormal compte = new CompteurNormal();
			this.setCompteur(compte);
			;
			break;
		case 2:
			CompteurInverse compte2 = new CompteurInverse();
			this.setCompteur(compte2);
			break;
		}
	}

	/**
	 * Méthode qui déroule un tour de partie classique
	 * 
	 * @param ShapeUp : une partie
	 */

	public void partieClassique(Partie ShapeUp) {
		Iterator<Joueur> it11 = ShapeUp.getListeJ().listIterator();
		Iterator<Joueur> it5 = ShapeUp.getListeJ().listIterator();
		Iterator<Joueur> it4 = ShapeUp.getListeJ().listIterator();
		Iterator<Joueur> it3 = ShapeUp.getListeJ().listIterator();
		while (it3.hasNext()) {
			System.out.println(it3.next().getNomJoueur() + " pioche sa carte victoire.");
			it11.next().setCarteVictoire(it4.next().piocherCarte(ShapeUp.getPioche()));
		}

		while (ShapeUp.getTapis().getEstPlein() == false) {
			Iterator<Joueur> it8 = ShapeUp.getListeJ().listIterator();
			Iterator<Joueur> it7 = ShapeUp.getListeJ().listIterator();
			Iterator<Joueur> it2 = ShapeUp.getListeJ().listIterator();
			Iterator<Joueur> it = ShapeUp.getListeJ().listIterator();
			while (it.hasNext() && ShapeUp.getTapis().getEstPlein() == false) {
				System.out.println("");
				System.out.println("**************************");
				System.out.println("");
				System.out.println("C'est au tour de : ");
				System.out.println(it.next().getNomJoueur() + " // carte victoire : " + it2.next().getCarteVictoire());
				it7.next().jouer(it8.next(), ShapeUp.getTapis(), ShapeUp.getPioche(), ShapeUp.getCompteur());

				if (ShapeUp.getTapis().getPlateau().size() == 15 && ShapeUp.getNombreDeJoueur() == 2) {
					ShapeUp.getTapis().setEstPlein(true);
					System.out.println("Le tapis est rempli !");
				} else if (ShapeUp.getTapis().getPlateau().size() == 14 && ShapeUp.getNombreDeJoueur() == 3) {
					ShapeUp.getTapis().setEstPlein(true);
					System.out.println("Le tapis est rempli !");
				}

			}

		}
	}

	/**
	 * Méthode qui déroule un tour de partie avancée
	 * 
	 * @param ShapeUp : une partie
	 */
	public void partieAdvanced(Partie ShapeUp) {
		for (int i = 0; i < ShapeUp.getNombreDeJoueur(); i++) {
			System.out.println(ShapeUp.getListeJ().get(i).getNomJoueur());
		}
		for (int i = 0; i < ShapeUp.getNombreDeJoueur(); i++) {
			System.out.println(ShapeUp.getListeJ().get(i).getNomJoueur() + " pioche ses 3 cartes victoires.");
			for (int j = 0; j < 3; j++) {
				ShapeUp.getListeJ().get(i).getCarteEnMain()
						.add(ShapeUp.getListeJ().get(i).piocherCarte(ShapeUp.getPioche()));
			}
		}

		Iterator<Joueur> it23 = ShapeUp.getListeJ().listIterator();
		Iterator<Joueur> it24 = ShapeUp.getListeJ().listIterator();
		Iterator<Joueur> it25 = ShapeUp.getListeJ().listIterator();
		while (ShapeUp.getTapis().getEstPlein() == false) {
			System.out.println(ShapeUp.getTapis().getPlateau().size());
			Iterator<Joueur> it8 = ShapeUp.getListeJ().listIterator();
			Iterator<Joueur> it9 = ShapeUp.getListeJ().listIterator();
			Iterator<Joueur> it7 = ShapeUp.getListeJ().listIterator();
			Iterator<Joueur> it2 = ShapeUp.getListeJ().listIterator();
			Iterator<Joueur> it = ShapeUp.getListeJ().listIterator();
			while (it.hasNext() && ShapeUp.getTapis().getEstPlein() == false) {
				System.out.println("");
				System.out.println("**************************");
				System.out.println("");
				System.out.println("C'est au tour de : ");
				System.out.println(it.next().getNomJoueur() + " // carte victoire : " + it2.next().getCarteEnMain());
				it7.next().jouerAdvanced(it8.next(), ShapeUp.getTapis(), ShapeUp.getPioche(), ShapeUp.getCompteur());
				if (ShapeUp.getTapis().getPlateau().size() == 15 && ShapeUp.getNombreDeJoueur() == 2) {
					ShapeUp.getTapis().setEstPlein(true);
					System.out.println("Le tapis est rempli !");
				} else if (ShapeUp.getTapis().getPlateau().size() == 14 && ShapeUp.getNombreDeJoueur() == 3) {
					ShapeUp.getTapis().setEstPlein(true);
					System.out.println("Le tapis est rempli !");
				}

			}

		}
		for (int i = 0; i < ShapeUp.getNombreDeJoueur(); i++) {
			ShapeUp.getListeJ().get(i).setCarteVictoire(it25.next().getCarteEnMain().get(0));
		}

	}

	/**
	 * Méthode qui demande avec quelle variante sera jouée la partie
	 * 
	 * @param ShapeUp : une partie
	 */
	public int choixVariante(Partie ShapeUp) {
		int version;
		do {
			Scanner in = new Scanner(System.in);
			System.out.println("A quelle variante souhaitez vous jouer?");
			System.out.println("1. Version classique");
			System.out.println("2. Version avancée");
			version = in.nextInt();
		} while (version < 1 || version > 2);

		return version;

	}

	/**
	 * Méthode qui compte les points d'une partie
	 * 
	 * @param ShapeUp : une partie
	 */
	public void compterPoints(Partie ShapeUp) {

		for (int i = 0; i < ShapeUp.getNombreDeJoueur(); i++) {
			int scoreTotal = ShapeUp.getListeJ().get(i).getScore() + ShapeUp.getCompteur()
					.compterScore(ShapeUp.getTapis(), ShapeUp.getListeJ().get(i).getCarteVictoire());
			ShapeUp.getListeJ().get(i).setScore(scoreTotal);
			System.out.println("Le joueur " + ShapeUp.getListeJ().get(i).getNomJoueur() + " a obtenu "
					+ ShapeUp.getListeJ().get(i).getScore() + " points au total.");
		}
	}

	/**
	 * Méthode qui pioche la carte cachée
	 * 
	 * @param ShapeUp : une partie
	 */
	public void carteCachee(Partie ShapeUp) {
		System.out.println("");
		System.out.println("**************************");
		System.out.println("");
		System.out.println("Nous piochons une carte qui sera la carte cachée : nous la mettons de côté.");
		System.out.println("");
		System.out.println("**************************");
		System.out.println("");
		Carte carteCachee = ShapeUp.getPioche().distribuerUneCarte();
	}

	/**
	 * Méthode qui déroule une partie
	 */

	public static void main(String[] args) {

		Partie ShapeUp = new Partie();
		ShapeUp.askNbreJoueur();
		ShapeUp.askNbreJoueurPhys();
		ShapeUp.calculNbreJoueursVirt();
		ShapeUp.creerJoueurs();
		ShapeUp.affichageJoueur(ShapeUp);
		ShapeUp.choixPlateau();
		ShapeUp.choixCompteur();
		ShapeUp.carteCachee(ShapeUp);
		int version = ShapeUp.choixVariante(ShapeUp);
		if (version == 1) {
			for (int i = 0; i < 4; i++) {
				Pioche nouvellePioche = new Pioche();
				nouvellePioche.melangerJeu();
				ShapeUp.setPioche(nouvellePioche);
				Tapis nouveautapis = new Tapis(ShapeUp.getTapis().getForme());
				ShapeUp.setTapis(nouveautapis);
				ShapeUp.partieClassique(ShapeUp);
				System.out.println("Comptons les scores !");
				ShapeUp.compterPoints(ShapeUp);
				System.out.println("Fin du round !");
			}
		} else if (version == 2) {
			for (int i = 0; i < 4; i++) {
				Pioche nouvellePioche = new Pioche();
				nouvellePioche.melangerJeu();
				ShapeUp.setPioche(nouvellePioche);
				Tapis nouveautapis = new Tapis(ShapeUp.getTapis().getForme());
				ShapeUp.setTapis(nouveautapis);
				ShapeUp.partieAdvanced(ShapeUp);
				System.out.println("Comptons les scores !");
				ShapeUp.compterPoints(ShapeUp);
				System.out.println("Fin du round !");
			}
		}

		System.out.println("Fin de la partie !");

	}
}
