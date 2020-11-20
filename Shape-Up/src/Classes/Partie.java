package Classes;

import java.util.*;

public class Partie {
	private int nombreDeJoueur;
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
	
	public static void main(String[] args) {
		boolean veutCommencer;
		int numPremierJoueur=-1;
		Partie ShapeUp = new Partie();
		Pioche pioche = new Pioche();
		Scanner in = new Scanner(System.in);
		pioche.melangerJeu();
		
        System.out.println("Nous prenons ici une partie à 2 joueurs.");
        	Scanner in2 = new Scanner(System.in);
        	System.out.println("Quel est le nom du joueur numéro 1?");
            String nom = in2.nextLine();

            	do {
            	Scanner in3 = new Scanner(System.in);
                System.out.println("Ce joueur veut il commencer? (true=OUI, false=NON)");
                veutCommencer = in3.nextBoolean();
            	}
            	while(veutCommencer != true && veutCommencer != false);
            
            
            Joueur j1 = new Joueur(nom, 1, veutCommencer);
            
            
            j1.setCarteVictoire(pioche.distribuerUneCarte());
            ShapeUp.ajouterUnJoueur(j1);   
            
            Scanner in4 = new Scanner(System.in);
        	System.out.println("Quel est le nom du joueur numéro 2?");
            String nom2 = in4.nextLine();

			
			Joueur j2 = new Joueur(nom2, 2);	
            if(j1.getCommence()==true)
            	j2.setCommence(false);
            else
            	j2.setCommence(true);
            j2.setCarteVictoire(pioche.distribuerUneCarte());
            ShapeUp.ajouterUnJoueur(j2); 
            
            System.out.println("**************************");
            System.out.println("Voici les joueurs qui participent à la partie :");
            System.out.println("");
            System.out.println(j1.toString());
            System.out.println("");
            System.out.println(j2.toString());
            System.out.println("");
            System.out.println("**************************");
            j1.piocherCarte(pioche);
            System.out.println("**************************");
            j2.piocherCarte(pioche);
            
            
		}
}

        
        
        
			
		
	


