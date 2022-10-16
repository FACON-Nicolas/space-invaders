/**
 * Ce fichier fait partie du projet Space Invaders.
 *
 * (c) 2022 gasto
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;

/**
 * Le type VieIMovableDecorator
 *
 * @author gasto
 *
 * @version 0.1.0
 */
public class VieIMovableDecorator extends IMovableDecorator{
    
    private int vieAlien;
    /**
     * Crée une nouvelle instance de VieIMovableDecorator.
     * @param decore
     */
    public VieIMovableDecorator(IMovable decore,int vieAlien) {
        // TODO Auto-generated constructor stub.
        super(decore);
        this.vieAlien=vieAlien;
    }
    
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable)
     */
    @Override
    public void collidedWith(IMovable other) {
        other.hitAlien();
        
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#hitAlien()
     */
    @Override
    public void hitAlien() {
        game.playerIsDead();
        
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#receiveShot()
     */
    @Override
    public void receiveShot() {
        vieAlien=vieAlien-20;
        
    }

}

