package Classes;

import java.util.HashMap;
import java.util.Map;

public class Tapis {
	
	
	private  Map<PositionCarteJou�, Carte> plateau = new HashMap<>();

	public  Map<PositionCarteJou�, Carte> getPlateau() {
		return plateau;
	}

	public  void setPlateau(Map<PositionCarteJou�, Carte> plateau) {
		this.plateau = plateau;
	}
	 
}
