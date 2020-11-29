package fr.utt.lo02.shapeUp.Partie;

import java.util.*;

import fr.utt.lo02.shapeUp.Carte.Carte;
import fr.utt.lo02.shapeUp.Carte.Pioche;
import fr.utt.lo02.shapeUp.Joueur.Joueur;
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
	// est ce que Round et tour sont obligatoire ? tour peut etre cr�� a l'int�rieur du main ? a quoi correspond r�ellement un round ? 
	
	public Partie(int nombreDeJoueur, int round, int tour, String regle) {
		this.setNombreDeJoueur(nombreDeJoueur);
		this.setRound(round);
		this.setTour(tour);
		this.setRegle(regle);
		
	}
	
	public Partie() {
		listeJ = new ArrayList<Joueur>();
		Pioche pioche = new Pioche();
	}
	
	// setters et getters
	public int getNombreDeJoueur() {
		return nombreDeJoueur;
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
		listeJ.add(joueur);
	}
	
	public void affichageJoueur(Joueur j1, Joueur j2) 
	{
		System.out.println("**************************");
        System.out.println("Voici les joueurs qui participent à la partie :");
        System.out.println("");
        System.out.println(j1.toString());
        System.out.println("");
        System.out.println(j2.toString());
        System.out.println("");
        System.out.println("**************************");
	}
	
	public static void main(String[] args) {
		/*
		boolean veutCommencer;
		int numPremierJoueur=-1;
		Partie ShapeUp = new Partie();
		Pioche pioche = new Pioche();
		Scanner in = new Scanner(System.in);
		pioche.melangerJeu();
		
        System.out.println("Nous prenons ici une partie à 2 joueurs.");
            String nom = "sam";


                veutCommencer = true;
            	
            
            
            JoueurVirtuel j1 = new JoueurVirtuel(nom, 1, veutCommencer, null, 1);
            
            
            j1.setCarteVictoire(pioche.distribuerUneCarte());
            ShapeUp.ajouterUnJoueur(j1);   
            
           
            String nom2 = "lolo";

			
			JoueurVirtuel j2 = new JoueurVirtuel(nom2, 2, false, null, 1);	
            if(j1.getCommence()==true)
            	j2.setCommence(false);
            else
            	j2.setCommence(true);
            j2.setCarteVictoire(pioche.distribuerUneCarte());
            ShapeUp.ajouterUnJoueur(j2); 
            
            ShapeUp.affichageJoueur(j1, j2);
            
            Tapis tapis = new Tapis(formePlateau.PLATEAUCLASSIQUE);
            
            while(tapis.getEstPlein() == false) {
            	j1.Jouer(j1, tapis, pioche);
            	System.out.println(tapis.toString());
            	j2.Jouer(j2, tapis, pioche);
            	System.out.println(tapis.toString());
            }
          
         */
		Partie ShapeUp = new Partie();
		// méthode askNumberJoueurs
		do {
		Scanner in2 = new Scanner(System.in);
		System.out.println("A combien de joueurs voulez vous jouer (possibilités : 2 ou 3)?");
		ShapeUp.setNombreDeJoueur(in2.nextInt());
		}
		while(ShapeUp.getNombreDeJoueur()<2 || ShapeUp.getNombreDeJoueur()>3);
		
		// méthode askNumberJoueurPhys
		do {
		Scanner in = new Scanner(System.in);
		System.out.println("Combien de joueurs physiques participent à la partie?");
		ShapeUp.setNbreJPhysiques(in.nextInt());
		}
		while(ShapeUp.getNbreJPhysiques()>=ShapeUp.getNombreDeJoueur() || ShapeUp.getNbreJPhysiques()<0);
		
		// méthode caculNbreJoueursVirtuels
		ShapeUp.setNbreJVirtuels(ShapeUp.getNombreDeJoueur()-ShapeUp.getNbreJPhysiques());
		
		
		System.out.println("Nombre de joueurs = "+ShapeUp.nombreDeJoueur+" ("+ShapeUp.nbreJPhysiques+" physiques et "+ShapeUp.nbreJVirtuels+" virtuels).");
		
		//ajouter des joueurs physiques
		for(int i=0; i<ShapeUp.getNbreJPhysiques();i++) {
			Scanner in3 = new Scanner(System.in);
			System.out.println("Quel est le nom du joueur "+i+"?");
			String nom = in3.nextLine();
			Scanner in4 = new Scanner(System.in);
			//ajouter différents constructeurs de joueur
			//ShapeUp.ajouterUnJoueur(Joueur j = new Joueur(nom, i, true, ));
		}
		
		for(int i=0; i<ShapeUp.getNbreJVirtuels();i++) {
			int difficulte;
			do {
			Scanner in = new Scanner(System.in);
			System.out.println("Quelle difficulté souhaitez vous attribuer au joueur virtuel "+i+" (possibilité : 1 (facile) ou 2 (difficile))");
			difficulte = in.nextInt();
			}
			while(difficulte<1 || difficulte>2);
		}
			// il faut un constructeur sans carteV
			//Joueur j = new JoueurVirtuel(joueurVirtuel, i, false, difficulte);
			//ShapeUp.ajouterUnJoueur(j);
		
		}
		
}


        
        
        
			
		
	


