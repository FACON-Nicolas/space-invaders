package fr.univartois.butinfo.qdev2.spaceinvaders.mur;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public class Mur extends AbstractMovable{
	
	private IMursState etat;

	public Mur(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
		super(game, xPosition, yPosition, sprite);
		this.etat = new MurNeuf();
	}



	@Override
	public void hitAlien() {
		etat = etat.nextState();
		etat.handle(this);
	}

	@Override
	public void receiveShot() {
		etat = etat.nextState();
		etat.handle(this);
		
	}

	@Override
	public void collidedWith(IMovable other) {
	}
}
