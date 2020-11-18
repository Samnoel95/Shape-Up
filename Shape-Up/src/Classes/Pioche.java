package Classes;

public class Pioche {
	
	public static void main(String[] args) {
		Carte[] pioche;
		int i = 0;
		pioche = new Carte[18];
		for(Couleur couleur : Couleur.values())
		{
			for(Forme forme : Forme.values())
			{
				pioche[i] = new Carte(couleur, forme, true);
				i++;
				pioche[i] = new Carte(couleur, forme, false);
				i++;
			}
		}
		
		for(i=0; i<18; i++)
		{
			System.out.println("Carte de couleur "+pioche[i].couleur+" de forme "+pioche[i].forme+" et pleine : "+pioche[i].estPlein);
		}

	}

}
