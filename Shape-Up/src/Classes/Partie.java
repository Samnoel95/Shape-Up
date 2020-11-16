package Classes;

public class Partie {

	private int nombreDeJoueur;
	private int round;
	private int tour;
	private String règle;
	// est ce que Round et tour sont obligatoire ? tour peut etre créé a l'intérieur du main ? a quoi correspond réellement un round ? 
	
	public Partie(int nombreDeJoueur, int round, int tour, String règle) {
		this.setNombreDeJoueur(nombreDeJoueur);
		this.setRound(round);
		this.setTour(tour);
		this.setRègle(règle);
		
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

	public String getRègle() {
		return règle;
	}

	public void setRègle(String règle) {
		this.règle = règle;
	}
	
	
	
}
