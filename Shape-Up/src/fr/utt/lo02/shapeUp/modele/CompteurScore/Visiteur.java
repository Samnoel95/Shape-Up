package fr.utt.lo02.shapeUp.modele.CompteurScore;

public interface Visiteur {
	
	
	int compterLigneForme(fr.utt.lo02.shapeUp.modele.Tapis.Tapis tapis, fr.utt.lo02.shapeUp.modele.Carte.Forme forme, int ligne);
	int compterColonneForme(fr.utt.lo02.shapeUp.modele.Tapis.Tapis tapis, fr.utt.lo02.shapeUp.modele.Carte.Forme forme, int colonne);
	int compterLigneCouleur(fr.utt.lo02.shapeUp.modele.Tapis.Tapis tapis, fr.utt.lo02.shapeUp.modele.Carte.Couleur couleur,
			int ligne);
	int compterColonneCouleur(fr.utt.lo02.shapeUp.modele.Tapis.Tapis tapis, fr.utt.lo02.shapeUp.modele.Carte.Couleur couleur,
			int colonne);
	int compterLigneEstPlein(fr.utt.lo02.shapeUp.modele.Tapis.Tapis tapis, boolean estPlein, int ligne);
	int compterColonneEstPlein(fr.utt.lo02.shapeUp.modele.Tapis.Tapis tapis, boolean estPlein, int colonne);
	int compterScore(fr.utt.lo02.shapeUp.modele.Tapis.Tapis tapis, fr.utt.lo02.shapeUp.modele.Carte.Carte carteV);

}
