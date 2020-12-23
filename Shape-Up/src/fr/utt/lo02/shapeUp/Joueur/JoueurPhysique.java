package fr.utt.lo02.shapeUp.Joueur;

import java.util.Scanner;

import fr.utt.lo02.shapeUp.Carte.Carte;
import fr.utt.lo02.shapeUp.Carte.Pioche;
import fr.utt.lo02.shapeUp.Carte.PositionCarte;
import fr.utt.lo02.shapeUp.Tapis.Tapis;

public class JoueurPhysique extends Joueur {

	public JoueurPhysique(String nomJoueur, int numJoueur, boolean commence, Carte carteVictoire) {
		super(nomJoueur,commence, carteVictoire);
		
	}
	
	public JoueurPhysique(String nomJoueur, boolean commence) {
		super(nomJoueur,commence);
		
	}
	
	public boolean chooseMove() {
		boolean veutDeplacer;
		Scanner in = new Scanner(System.in);
		System.out.println(getNomJoueur()+" veux tu deplacer une carte ? (true=OUI, false=NON)");
        veutDeplacer = in.nextBoolean();
		return veutDeplacer;
	}
	
	public int askX() {
		Scanner in = new Scanner(System.in);
     	System.out.println("Entrez x.");
         int x = in.nextInt();
         
         return x;
	}
	
	public  int askY() {
		Scanner in = new Scanner(System.in);
     	System.out.println("Entrez y.");
         int y = in.nextInt();
         
         return y;
	}
	
	public void jouerAdvanced(Joueur joueur, Tapis tapis, Pioche pioche) {
		int longueur;
        int hauteur;
        int x;
        int y;
        boolean veutDeplacer = false;
        boolean aDeplace = false;
        //System.out.println(this.getNomJoueur()+" c'est ton tour !");
        
        /*
        longueur = tapis.longueurPlateau();
        hauteur = tapis.hauteurPlateau();
        System.out.println("La longueur du plateau est  "+longueur);
        System.out.println("La hauteur du plateau est "+hauteur);
        */
        System.out.println("Voici le plateau actuel :");
        System.out.println(tapis.toString());
    	if (!tapis.getPlateau().isEmpty() && tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {
    		
            veutDeplacer = chooseMove();
            
    	}
        
        if(veutDeplacer && aDeplace == false) {
        	System.out.println("Coordonnees de la carte a deplacer : ");
        	
        	 x = askX();
        	 y = askY();
            
            PositionCarte position1 = new PositionCarte(x,y);
            
            System.out.println( "Ou voulez vous deplacer la carte ?");

            x = askX();
            y = askY();
            
            PositionCarte position2 = new PositionCarte(x,y);
            
            aDeplace = deplacerCarte(position1, position2, tapis);
            while(!aDeplace) {
            	System.out.println("Deplacement invalide ! recommence : ");
            	System.out.println("Coordonnees de la carte a deplacer : ");
            	
            	x = askX();
                y = askY();
                
                position1.setX(x);
                position1.setY(y);
             
                System.out.println( "Ou voulez vous deplacer la carte ?");

                x = askX();
                y = askY();
                
                position2.setX(x);
                position2.setY(y);
               
                
                aDeplace = deplacerCarte(position1, position2, tapis);	
            }
        } 
        
        System.out.println("Quelle carte veux-tu jouer ? (0,1 ou 2)");
        Scanner in = new Scanner(System.in);
         int i = in.nextInt();
        
         System.out.println("Voici le plateau actuel :");
         System.out.println(tapis.toString());
           
        System.out.println("Ou voulez vous poser la carte ?");
        x = askX();
        y = askY();
            
        PositionCarte position = new PositionCarte(x,y);
            
        boolean cartePose = poserCarte(position, carteEnMain.get(i), tapis);
        
        while (!cartePose) {
            	System.out.println("La carte est mal placee ! Recommence : ");
            	
            	x = askX();
                y = askY();
                
               position.setX(x);
               position.setY(y);
               cartePose = poserCarte(position, carteEnMain.get(i), tapis);
         }
        
        carteEnMain.remove(i);
        if(!pioche.getPioche().isEmpty()) {
        Carte cartePiocher = new Carte();
        cartePiocher = piocherCarte(pioche);
        carteEnMain.add(cartePiocher);
        }
        
        /*
          longueur = tapis.longueurPlateau();
          hauteur = tapis.hauteurPlateau();
          System.out.println("La longueur du plateau est  "+longueur);
          System.out.println("La hauteur du plateau est "+hauteur);
          */
        System.out.println("Voici le plateau actuel :");
        System.out.println(tapis.toString());
         if( aDeplace == false && tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {

             veutDeplacer = chooseMove();
             
             
             if(veutDeplacer) {
            	// on deplace
            	 System.out.println("Coordonnees de la carte a deplacer : ");
             	
            	 x = askX();
            	 y = askY();
                
                PositionCarte position1 = new PositionCarte(x,y);
                
                System.out.println( "Ou voulez vous deplacer la carte ?");

                x = askX();
                y = askY();
                
                PositionCarte position2 = new PositionCarte(x,y);
                
                aDeplace = deplacerCarte(position1, position2, tapis);
                while(!aDeplace) {
                	System.out.println("Deplacement invalide ! recommence : ");
                	System.out.println("Coordonnees de la carte a deplacer : ");
                	
                	x = askX();
                    y = askY();
                    
                    position1.setX(x);
                    position1.setY(y);
                 
                    System.out.println( "Ou voulez vous deplacer la carte ?");

                    x = askX();
                    y = askY();
                    
                    position2.setX(x);
                    position2.setY(y);
                   
                    
                    aDeplace = deplacerCarte(position1, position2, tapis);	
                }
             }
         }
	}
	
	@Override
	public void jouer( Joueur joueur,Tapis tapis, Pioche pioche) { // a Refinir dans dans joueurPhysique et joueur virtuel. 
    	Carte carteAJouer = new Carte();
        carteAJouer = piocherCarte(pioche);
        int longueur;
        int hauteur;
        int x;
        int y;
        boolean veutDeplacer = false;
        boolean aDeplace = false;
        //System.out.println(this.getNomJoueur()+" c'est ton tour !");
        
        /*
        longueur = tapis.longueurPlateau();
        hauteur = tapis.hauteurPlateau();
        System.out.println("La longueur du plateau est  "+longueur);
        System.out.println("La hauteur du plateau est "+hauteur);
        */
        System.out.println("Voici le plateau actuel :");
        System.out.println(tapis.toString());
    	if (!tapis.getPlateau().isEmpty() && tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {
            veutDeplacer = chooseMove();    
    	}
        
        if(veutDeplacer && aDeplace == false) {
        	
        	System.out.println("Coordonnees de la carte a deplacer : ");
        	
        	 x = askX();
        	 y = askY();
            
            PositionCarte position1 = new PositionCarte(x,y);
            
            System.out.println( "Ou voulez vous deplacer la carte ?");

            x = askX();
            y = askY();
            
            PositionCarte position2 = new PositionCarte(x,y);
            
            aDeplace = deplacerCarte(position1, position2, tapis);
            while(!aDeplace) {
            	System.out.println("Deplacement invalide ! recommence : ");
            	System.out.println("Coordonnees de la carte a deplacer : ");
            	
            	x = askX();
                y = askY();
                
                position1.setX(x);
                position1.setY(y);
             
                System.out.println( "Ou voulez vous deplacer la carte ?");

                x = askX();
                y = askY();
                
                position2.setX(x);
                position2.setY(y);
               
                
                aDeplace = deplacerCarte(position1, position2, tapis);	
            }
        } 
        
        System.out.println("Ou voulez vous poser la carte "+carteAJouer+"?");
        x = askX();
        y = askY();
            
        PositionCarte position = new PositionCarte(x,y);
            
        boolean cartePose = poserCarte(position, carteAJouer, tapis);
        
        while (!cartePose) {
            	System.out.println("La carte est mal placee ! Recommence : ");
            	
            	x = askX();
                y = askY();
                
               position.setX(x);
               position.setY(y);
               cartePose = poserCarte(position, carteAJouer, tapis);
         }
        /*
          longueur = tapis.longueurPlateau();
          hauteur = tapis.hauteurPlateau();
          System.out.println("La longueur du plateau est  "+longueur);
          System.out.println("La hauteur du plateau est "+hauteur);
          */
        
         if( aDeplace == false &&  tapis.getPlateau().size() != 1 && tapis.getPlateau().size() != 15) {

             veutDeplacer = chooseMove();
             
          
          if(veutDeplacer) {
            	// on deplace
        	  
            	 System.out.println("Coordonnees de la carte a deplacer : ");
             	
            	 x = askX();
            	 y = askY();
                
                PositionCarte position1 = new PositionCarte(x,y);
                
                System.out.println( "Ou voulez vous deplacer la carte ?");

                x = askX();
                y = askY();
                
                PositionCarte position2 = new PositionCarte(x,y);
                
                aDeplace = deplacerCarte(position1, position2, tapis);
            while(!aDeplace) {
                	System.out.println("Deplacement invalide ! recommence : ");
                	System.out.println("Coordonnees de la carte a deplacer : ");
                	
                	x = askX();
                    y = askY();
                    
                    position1.setX(x);
                    position1.setY(y);
                 
                    System.out.println( "Ou voulez vous deplacer la carte ?");

                    x = askX();
                    y = askY();
                    
                    position2.setX(x);
                    position2.setY(y);
                   
                    
                    aDeplace = deplacerCarte(position1, position2, tapis);	
                }
             }
         }
	}
}




