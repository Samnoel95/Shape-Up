package Classes;

public class Partie {

	private int nombreDeJoueur;
	private int round;
	private int tour;
	private String r�gle;
	// est ce que Round et tour sont obligatoire ? tour peut etre cr�� a l'int�rieur du main ? a quoi correspond r�ellement un round ? 
	
	public Partie(int nombreDeJoueur, int round, int tour, String r�gle) {
		this.setNombreDeJoueur(nombreDeJoueur);
		this.setRound(round);
		this.setTour(tour);
		this.setR�gle(r�gle);
		
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

	public String getR�gle() {
		return r�gle;
	}

	public void setR�gle(String r�gle) {
		this.r�gle = r�gle;
	}
	
	
	
}
