package fr.univartois.butinfo.qdev2.spaceinvaders.mur;

import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

public class MurDetruit implements IMursState {
	@Override
	public IMursState nextState() {
		return this;
		
}

	@Override
	public void handle(Mur m) {
		m.consume();
		
	}
	
}
