package Classes;

import java.util.HashMap;
import java.util.Map;

public class Tapis {
	
	
	private  Map<PositionCarteJoué, Carte> plateau = new HashMap<>();

	public  Map<PositionCarteJoué, Carte> getPlateau() {
		return plateau;
	}

	public  void setPlateau(Map<PositionCarteJoué, Carte> plateau) {
		this.plateau = plateau;
	}
	 
}
