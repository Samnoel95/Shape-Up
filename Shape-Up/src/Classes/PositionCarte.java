package Classes;

public class PositionCarte{

		
		boolean estBienPlace;
		int posX;
		int posY;
		
		public PositionCarte(int x, int y) {
			this.posX=x;
			this.posY=y;
		}
		
		public void setX(int x) {
			this.posX=x;
		}
		
		public void setY(int y) {
			this.posY=y;
		}
		
		public void setPosition(int x, int y) {
			this.setX(x);
			this.setY(y);
		}
		
		public int getX() {
			return this.posX;
		}
		
		public int getY() {
			return this.posY;
		}

		@Override 
		public int hashCode() {
			return posX*posY;
		}
		@Override 
		public boolean equals(Object o) {
		if(((PositionCarte) o).posX == this.posX && ((PositionCarte) o).posY == this.posY)
			return true;
		return false;
			
		}
		
		
		public static boolean verifierPlacement(int x, int y)
		{
			boolean evaluationPlacement = false;
			
			// ajouter les conditions de placements : cases à enlever selon forme plateau, case déjà remplie
			
			if(x>0 && x<5)
			{
				if(y>0 && y<5)
				{
					evaluationPlacement = true;
				}
			}
			
			return evaluationPlacement;
		}
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("x=");
		    sb.append(this.posX);
		    sb.append(" et y=");
		    sb.append(this.posY);
		    return sb.toString();
		}

		public static void main(String[] args) {
			System.out.println(verifierPlacement(4,-1));
			PositionCarte position = new PositionCarte(1,2);
			System.out.println(position.toString());
			

		}

	}
	
