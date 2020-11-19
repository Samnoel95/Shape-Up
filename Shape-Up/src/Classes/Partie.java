package Classes;

public class Partie {

	private int nombreDeJoueur;
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
	

	
}
