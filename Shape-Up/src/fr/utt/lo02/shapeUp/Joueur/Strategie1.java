package fr.utt.lo02.shapeUp.Joueur;

import java.util.Random;

import fr.utt.lo02.shapeUp.Carte.Carte;
import fr.utt.lo02.shapeUp.Carte.Pioche;
import fr.utt.lo02.shapeUp.Carte.PositionCarte;
import fr.utt.lo02.shapeUp.Tapis.Tapis;

public class Strategie1 implements Strategie {
	
	
	
	public int randomX(Tapis tapis) {
		int xMin = tapis.getXMin()-1;
		int xMax = tapis.getXMax()+1;
		int longueur = Math.abs(xMax - xMin) + 1;
		Random generator = new Random();
		int x = xMax - generator.nextInt(longueur);
		return x;
	}
	
	public int randomY(Tapis tapis) {
		int yMin = tapis.getYMin()-1;
		int yMax = tapis.getYMax()+1;
		int hauteur = Math.abs(yMax - yMin) + 1;
		Random generator = new Random();
		int y = yMax - generator.nextInt(hauteur);
		return y;
	}
	
	public boolean randomBoolean() {
		int bool = (int)(Math.random()*2);
		boolean randomBoolean = false;
		if(bool == 0) {
			randomBoolean = false;
		}else if(bool == 1) {
			randomBoolean = true;
		}
		return randomBoolean;
	}
	public void jouer(Joueur joueur,Tapis tapis, Pioche pioche) {
		Carte carteAJouer = new Carte();
        carteAJouer = joueur.piocherCarte(pioche);
        int longueur;
        int hauteur;
        int x;
        int y;
        boolean veutDeplacer = false;
        boolean aDeplace = false;
        System.out.println(joueur.getNomJoueur()+" c'est ton tour !");
        longueur = joueur.longueurPlateau(tapis);
        hauteur = joueur.hauteurPlateau(tapis);
    	if (!tapis.getPlateau().isEmpty() && (hauteur !=1 || longueur != 1) && (hauteur !=3 || longueur !=5) && (hauteur !=5 || longueur !=3)) {
    		
            veutDeplacer = randomBoolean();
            
    	}
        
        if(veutDeplacer && aDeplace == false) {
        	
        	 x = randomX(tapis);
        	 y = randomY(tapis);
            
            PositionCarte position1 = new PositionCarte(x,y);

            x = randomX(tapis);
            y = randomY(tapis);
            System.out.println("x2 = "+x);
            System.out.println("y2 = "+y);
            PositionCarte position2 = new PositionCarte(x,y);
            
            aDeplace = joueur.deplacerCarte(position1, position2, tapis);
            while(!aDeplace) {
            	// position de la carte a deplacer
            	 x = randomX(tapis);
                 y = randomY(tapis);
                
                 PositionCarte position12 = new PositionCarte(x,y);
             
                // position ou d�placer la carte 
                x = randomX(tapis);
                y = randomY(tapis);
                
                position2.setX(x);
                position2.setY(y);
                System.out.println(longueur);
                System.out.println(hauteur);
                System.out.println("x2 = "+x);
                System.out.println("y2 = "+y);
               
                
                aDeplace = joueur.deplacerCarte(position12, position2, tapis);	
            }
        } 
           
        x = randomX(tapis);
        y = randomY(tapis);
        
        System.out.println("x = "+x);
        System.out.println("y = "+y);
            
        PositionCarte position = new PositionCarte(x,y);
            
        boolean cartePose = joueur.poserCarte(position, carteAJouer, tapis);
        
        while (!cartePose) {
            	
            	 x = randomX(tapis);
                 y = randomY(tapis);
                 System.out.println("x = "+x);
                 System.out.println("y = "+y);
                
               position.setX(x);
               position.setY(y);
               cartePose = joueur.poserCarte(position, carteAJouer, tapis);
         }
        
          longueur = joueur.longueurPlateau(tapis);
          hauteur = joueur.hauteurPlateau(tapis);
         if( aDeplace == false && (hauteur !=1 || longueur != 1) && (hauteur !=3 || longueur !=5) && (hauteur !=5 || longueur !=3)) {
        	 
        	 System.out.println("test");
             veutDeplacer = randomBoolean();
             
             
             if(veutDeplacer) {
             	
            	 x = randomX(tapis);
                 y = randomY(tapis);
                
                PositionCarte position1 = new PositionCarte(x,y);
                

                x = randomX(tapis);
                y = randomY(tapis);
                
                PositionCarte position2 = new PositionCarte(x,y);
                
                aDeplace = joueur.deplacerCarte(position1, position2, tapis);
                while(!aDeplace) {
                	System.out.println("test2");
                	 x = randomX(tapis);
                     y = randomY(tapis);
                    
                    PositionCarte position12 = new PositionCarte(x,y);
                 

                    x = randomX(tapis);
                    y = randomY(tapis);
                    
                    position2.setX(x);
                    position2.setY(y);
                   
                    
                    aDeplace = joueur.deplacerCarte(position12, position2, tapis);	
                }
             }
         }
        
      
	}


		

}
	
	
	
	
	


