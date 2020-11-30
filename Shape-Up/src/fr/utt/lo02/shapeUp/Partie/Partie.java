package fr.utt.lo02.shapeUp.Partie;

import java.util.*;

import fr.utt.lo02.shapeUp.Carte.Carte;
import fr.utt.lo02.shapeUp.Carte.Pioche;
import fr.utt.lo02.shapeUp.CompteurScore.CompteurInverse;
import fr.utt.lo02.shapeUp.CompteurScore.CompteurNormal;
import fr.utt.lo02.shapeUp.CompteurScore.Visiteur;
import fr.utt.lo02.shapeUp.Joueur.Joueur;
import fr.utt.lo02.shapeUp.Joueur.JoueurPhysique;
import fr.utt.lo02.shapeUp.Joueur.JoueurVirtuel;
import fr.utt.lo02.shapeUp.Tapis.Tapis;
import fr.utt.lo02.shapeUp.Tapis.formePlateau;

public class Partie {
	private int nombreDeJoueur;
	private int nbreJVirtuels;
	private int nbreJPhysiques;
	private static ArrayList<Joueur> listeJ; //listeJ est l'ensemble des joueurs de la partie
	private int round;
	private int tour;
	private String regle;
	private Pioche pioche;
	private Tapis tapis;
	private Visiteur compteur;
	// est ce que Round et tour sont obligatoire ? tour peut etre cr�� a l'int�rieur du main ? a quoi correspond r�ellement un round ? 
	
	public Partie(int nombreDeJoueur, int round, int tour, String regle) {
		this.setNombreDeJoueur(nombreDeJoueur);
		this.setRound(round);
		this.setTour(tour);
		this.setRegle(regle);
		
	}
	
	public Partie() {
		setListeJ(new ArrayList<Joueur>());
		Pioche pioche = new Pioche();
		pioche.melangerJeu();
		this.setPioche(pioche);
	}
	
	// setters et getters
	
	public Visiteur getCompteur() {
		return this.compteur;
	}
	
	public void setCompteur(Visiteur compteur) {
		this.compteur=compteur;
	}

	public Tapis getTapis(){
		return this.tapis;
	}
	
	public void setTapis(Tapis tapis) {
		this.tapis=tapis;
	}
	
	public Pioche getPioche() {
		return this.pioche;
	}
	
	public void setPioche(Pioche pioche) {
		this.pioche=pioche;
	}
	
	public int getNombreDeJoueur() {
		return this.nombreDeJoueur;
	}


	public void setNombreDeJoueur(int nombreDeJoueur) {
		this.nombreDeJoueur = nombreDeJoueur;
	}
	
	public int getNbreJVirtuels() {
		return this.nbreJVirtuels;
	}
	
	public void setNbreJVirtuels(int nbreJVirtuels) {
		this.nbreJVirtuels=nbreJVirtuels;
	}
	
	public int getNbreJPhysiques() {
		return this.nbreJPhysiques;
	}
	
	public void setNbreJPhysiques(int nbreJPhysiques){
		this.nbreJPhysiques=nbreJPhysiques;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public String getRegle() {
		return regle;
	}

	public void setRegle(String regle) {
		this.regle = regle;
	}
	
	public void ajouterUnJoueur(Joueur joueur) {
		getListeJ().add(joueur);
	}
	
	public ArrayList<Joueur> getListeJ() {
		return listeJ;
	}

	public void setListeJ(ArrayList<Joueur> listeJ) {
		Partie.listeJ = listeJ;
	}
	
	public void affichageJoueur(Partie ShapeUp) 
	{
		System.out.println("**************************");
        System.out.println("Voici les joueurs qui participent à la partie :");
        System.out.println("");
        Iterator<Joueur> it = ShapeUp.getListeJ().listIterator();
        while(it.hasNext()) {
        	System.out.println(it.next().getNomJoueur());
        }
        System.out.println("**************************");
	}
	
	public void askNbreJoueur(){
		do {
			Scanner in2 = new Scanner(System.in);
			System.out.println("A combien de joueurs voulez vous jouer (possibilités : 2 ou 3)?");
			this.setNombreDeJoueur(in2.nextInt());
			}
			while(this.getNombreDeJoueur()<2 || this.getNombreDeJoueur()>3);
	}
	
	public void askNbreJoueurPhys() {
		do {
			Scanner in = new Scanner(System.in);
			System.out.println("Combien de joueurs physiques participent à la partie?");
			this.setNbreJPhysiques(in.nextInt());
			}
			while(this.getNbreJPhysiques()>this.getNombreDeJoueur() || this.getNbreJPhysiques()<0);
			
	}
	
	public void calculNbreJoueursVirt() {
		this.setNbreJVirtuels(this.getNombreDeJoueur()-this.getNbreJPhysiques());
	}
	
	public void créerJoueurs() {
		boolean premierJ=false;
		
		for(int i=0; i<this.getNbreJPhysiques();i++) {
			Scanner in3 = new Scanner(System.in);
			System.out.println("Quel est le nom du joueur physique "+(i+1)+"?");
			String nom = in3.nextLine();
			Scanner in4 = new Scanner(System.in);
			if(premierJ==false) {
			JoueurPhysique j = new JoueurPhysique(nom, true);
			this.ajouterUnJoueur(j);
			premierJ=true;
			}
			else {
				JoueurPhysique j = new JoueurPhysique(nom, false);
				this.ajouterUnJoueur(j);
			}
		}
		
		for(int i=0; i<this.getNbreJVirtuels();i++) {
			int difficulte;
			do {
			Scanner in = new Scanner(System.in);
			System.out.println("Quelle difficulté souhaitez vous attribuer au joueur virtuel "+(i+1)+" (possibilité : 1 (facile) ou 2 (difficile))");
			difficulte = in.nextInt();
			}
			while(difficulte<1 || difficulte>2);
			StringBuffer sb = new StringBuffer();
			sb.append("Joueur virtuel numéro ");
		    sb.append(i+1);
		    String nom = sb.toString();
		    if(premierJ==false) {
		    Joueur j = new JoueurVirtuel(nom, true, difficulte);
			this.ajouterUnJoueur(j);
		    }
		    else {
		    	Joueur j = new JoueurVirtuel(nom, false, difficulte);
				this.ajouterUnJoueur(j);
		    }
		   
		}
	}
	
	public void choixPlateau() {
		int plateau; 
		do {
		Scanner in2 = new Scanner(System.in);
		System.out.println("Avec quel tapis souhaitez vous jouer?");
		System.out.println("1. Tapis 3x5");
		System.out.println("2. Tapis triangulaire");
		plateau = in2.nextInt();
		}
		while(plateau<1 || plateau>2);
				
		switch(plateau) {
			case 1 :
				Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
				this.setTapis(tapis);
				break;
			case 2 : 
				Tapis tapis2 = new Tapis(formePlateau.TRIANGLE);
				this.setTapis(tapis2);
				break;			
		}		
		}
	
	public void choixCompteur() {
		int compteur; 
		do {
		Scanner in2 = new Scanner(System.in);
		System.out.println("Avec quel compteur souhaitez vous compter les points?");
		System.out.println("1. Compteur normal");
		System.out.println("2. Compteur inversé");
		compteur = in2.nextInt();
		}
		while(compteur<1 || compteur>2);
				
		switch(compteur) {
			case 1 :
				CompteurNormal compte = new CompteurNormal();
				this.setCompteur(compte);;
				break;
			case 2 : 
				CompteurInverse compte2 = new CompteurInverse();
				this.setCompteur(compte2);
				break;			
		}		
		}
	
		public void partieClassique(Partie ShapeUp) {
			//instancier à la partie pour chaque cas, faire piocher une carte victoire par joueur
			//méthode attribuer carte victoire si version classique
				Iterator<Joueur> it11 = ShapeUp.getListeJ().listIterator();
				Iterator<Joueur> it5 = ShapeUp.getListeJ().listIterator();
				Iterator<Joueur> it4 = ShapeUp.getListeJ().listIterator();
				Iterator<Joueur> it3 = ShapeUp.getListeJ().listIterator();
				while(it3.hasNext()) {
					System.out.println(it3.next().getNomJoueur()+" pioche sa carte victoire.");
					it11.next().setCarteVictoire(it4.next().piocherCarte(ShapeUp.getPioche()));
				}
			
			//jouer pour la version classique
			while(ShapeUp.getTapis().getPlateau().size()<15) {
				Iterator<Joueur> it8 = ShapeUp.getListeJ().listIterator();
				Iterator<Joueur> it7 = ShapeUp.getListeJ().listIterator();
				Iterator<Joueur> it6 = ShapeUp.getListeJ().listIterator();
				Iterator<Joueur> it2 = ShapeUp.getListeJ().listIterator();
				Iterator<Joueur> it = ShapeUp.getListeJ().listIterator();
				while(it.hasNext()) {
					System.out.println("C'est au tour de : ");
					System.out.println(it.next().getNomJoueur()+" // carte victoire : "+it2.next().getCarteVictoire());
					it7.next().jouer(it8.next(), ShapeUp.getTapis(), ShapeUp.getPioche());
				}
				
			}
		}
		
		public void partieAdvanced(Partie ShapeUp) {
			//instancier à la partie pour chaque cas, faire piocher 3 cartes victoires par joueur
			//méthode attribuer carte victoire si version classique
				Iterator<Joueur> it3 = ShapeUp.getListeJ().listIterator();
				while(it3.hasNext()) {
					// piocher 3 cartes et les mettre dans la main du joueur
				}
			
			while(ShapeUp.getTapis().getPlateau().size()<15) {
				Iterator<Joueur> it2 = ShapeUp.getListeJ().listIterator();
				Iterator<Joueur> it9 = ShapeUp.getListeJ().listIterator();
				while(it9.hasNext()) {
					System.out.println("C'est au tour de : ");
					System.out.println(it9.next().getNomJoueur()+" // carte victoire : "+it9.next().getCarteVictoire());
					it2.next().jouerAdvanced(it2.next(), ShapeUp.getTapis(), ShapeUp.getPioche());
				}
				
			}
			Iterator<Joueur> it10 = ShapeUp.getListeJ().listIterator();
			while(it10.hasNext()) {
				// ajouter en carte victoire la carte qu'il lui reste en main
			}
		}
		
		public void choixVarianteEtJeu(Partie ShapeUp) {
			int version;
			do {
			Scanner in = new Scanner(System.in);
			System.out.println("A quelle variante souhaitez vous jouer?");
			System.out.println("1. Version classique");
			System.out.println("2. Version avancée");
			version = in.nextInt();
			}
			while(version<1 || version>2);
			
			switch(version) {
				case 1 :
					ShapeUp.partieClassique(ShapeUp);
					break;
				case 2 :
					ShapeUp.partieAdvanced(ShapeUp);
					break;
					
			}
		}
		
		public void compterPoints(Partie ShapeUp) {
			Iterator<Joueur> it = ShapeUp.getListeJ().listIterator();
			while(it.hasNext())
				it.next().setScore(ShapeUp.getCompteur().compterScore(ShapeUp.getTapis(), it.next().getCarteVictoire()));
				System.out.println("Le joueur "+it.next().getNomJoueur()+" a obtenu "+it.next().getScore()+" points.");
		}
	
	public static void main(String[] args) {
		
		Partie ShapeUp = new Partie();
		ShapeUp.askNbreJoueur();
		ShapeUp.askNbreJoueurPhys();
		ShapeUp.calculNbreJoueursVirt();
		ShapeUp.créerJoueurs();
		ShapeUp.affichageJoueur(ShapeUp);
		ShapeUp.choixPlateau();
		ShapeUp.choixCompteur();
		ShapeUp.choixVarianteEtJeu(ShapeUp);
		ShapeUp.compterPoints(ShapeUp);
		
		System.out.println("Fin de la partie !");
		
	}		
}


        
        
        
			
		
	


