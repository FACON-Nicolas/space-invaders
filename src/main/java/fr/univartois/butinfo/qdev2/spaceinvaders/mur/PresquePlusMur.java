package fr.univartois.butinfo.qdev2.spaceinvaders.mur;

import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

public class PresquePlusMur implements IMursState{

	@Override
	public IMursState nextState() {
		return new MurUnPeuDetruit();
}
	@Override
	public void handle(Mur m) {
		m.getSpriteProperty().set(SpriteStore.getInstance().getSprite("empty-bricks"));
		
	}

}
