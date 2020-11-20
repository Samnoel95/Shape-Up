package Classes;


public class CompteurNormal {

	//à refaire par rapport au plateau
	
	// ajouter le fait qu'il faille comparer à une forme particulière
	public static int compterForme(Carte[] ligne, Forme forme)
	{
		int x=0;
		int y=0;
		
		for(int i=0; i<4; i++)
		{
			if (ligne[i].forme == ligne[i+1].forme && ligne[i].forme == forme)
			{
				x+=1;
			}
			else if(ligne[i].forme != ligne[i+1].forme && y==0)
			{
				y=x;
				x=0;
			}
		}
		if(x>y) {
			return x;
		}
		return y;
		
	}
	
	public static int comptePlein(Carte[] ligne, boolean estPlein)
	{
		int x=1;
		int y=0;
		
		for(int i=0; i<4; i++)
		{
			if (ligne[i].estPlein == ligne[i+1].estPlein && ligne[i].estPlein == estPlein)
			{
				x+=1;
				
			}
			else if(ligne[i].estPlein != ligne[i+1].estPlein && y==0)
			{
				y=x;
				x=1;
			}
		}
		
		if(y>x)
		{
			x=y;
		}
		if(x<2)
		{
			return 0;
		}
		return x;
		
	}
	
	public static int compteCouleur(Carte[] ligne, Couleur couleur)
	{
		int x=1;
		int y=0;
		
		for(int i=0; i<4; i++)
		{
			if (ligne[i].couleur == ligne[i+1].couleur && ligne[i].couleur == couleur)
			{
				x+=1;

			}
			else if(ligne[i].couleur != ligne[i+1].couleur && y==0)
			{
				y=x;
				x=1;
			}
		}
	
		if(y>x)
		{
			x=y;
		}
		
		if(x<3)
		{
			return 0;
		}
		return x+1;
		
	}

	public static void main(String[] args) {
		
		Carte[] ligne = new Carte[5];
		ligne[0] = new Carte(Couleur.BLEU, Forme.TRIANGLE, false);
		ligne[1] = new Carte(Couleur.ROUGE, Forme.CARRE, false);
		ligne[2] = new Carte(Couleur.BLEU, Forme.CERCLE, false);
		ligne[3] = new Carte(Couleur.BLEU, Forme.TRIANGLE, true);
		ligne[4] = new Carte(Couleur.VERT, Forme.TRIANGLE, true);
		
		int x = compteCouleur(ligne, Couleur.BLEU);
		System.out.println(x);
		int y = compterForme(ligne, Forme.TRIANGLE);
		System.out.println(y);
		int z = comptePlein(ligne, false);
		System.out.println(z);
		

	}

}
