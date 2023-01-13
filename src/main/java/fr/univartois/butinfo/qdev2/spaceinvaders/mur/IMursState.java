package fr.univartois.butinfo.qdev2.spaceinvaders.mur;

import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public interface IMursState {
	IMursState nextState();
	void handle(Mur m);
	
	
	
}
