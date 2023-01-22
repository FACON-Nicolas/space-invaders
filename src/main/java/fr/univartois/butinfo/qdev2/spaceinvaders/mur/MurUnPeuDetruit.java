package fr.univartois.butinfo.qdev2.spaceinvaders.mur;

import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

public class MurUnPeuDetruit implements IMursState{

	@Override
	public IMursState nextState() {
		return new PresquePlusMur();
}

	@Override
	public void handle(Mur m) {
		m.getSpriteProperty().set(SpriteStore.getInstance().getSprite("cracked-bricks"));
	}

}
