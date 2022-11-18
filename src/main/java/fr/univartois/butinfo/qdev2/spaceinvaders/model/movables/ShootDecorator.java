package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;

public class ShootDecorator extends IMovableDecorator {

	private int force;

	public ShootDecorator(IMovable decore, int force) {
		super(decore);
		this.setForce(force);
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}
	
	public void collidedWith(IMovable other) {
		if (force == 1) {
			super.collidedWith(other);
		} else {
			force--;
			other.receiveShot();
		}
	}

}
