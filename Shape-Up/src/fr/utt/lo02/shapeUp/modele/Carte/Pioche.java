package fr.utt.lo02.shapeUp.modele.Carte;

import java.util.*;


public class Pioche {
private LinkedList<Carte> pioche; // représente une liste de carte pour modéliser la pioche
public static final int nbrCartes = Forme.values().length * Couleur.values().length * 2;
	
	public Pioche(){
		pioche = new LinkedList<Carte>();
		Couleur[] c = Couleur.values();
		Forme[] f = Forme.values();
		
		for(int i=0; i<f.length; i++)
		{
			for(int j=0; j<c.length; j++)
			{
				Carte carte = new Carte(c[j],f[i], true);
				pioche.add(carte);
				Carte carte2 = new Carte(c[j],f[i], false);
				pioche.add(carte2);
			}
		}
	}
	
	public LinkedList<Carte> getPioche(){
		return pioche;
	}

	public Carte distribuerUneCarte() {
		return pioche.poll();
	}

	public void melangerJeu(){
	// Mélange le tas de cartes…voir la classe Collections….méthode shuffle() ;)
		Collections.shuffle(pioche);
	}

	public String toString(){
	//Décrit le tas de cartes
		return pioche.toString();
	}	
	
	
	// main de tests
	public static void main(String[]args){
		Pioche pioche = new Pioche();
		System.out.println(pioche.toString()); //????
		System.out.println(pioche.nbrCartes);
		pioche.melangerJeu();
		System.out.println(pioche.toString());
	}


}
