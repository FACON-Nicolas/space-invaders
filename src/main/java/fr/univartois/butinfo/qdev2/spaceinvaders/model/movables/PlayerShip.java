/**
 * Ce fichier fait partie du projet space-invaders.
 *
 * (c) 2022 Elsa
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;

/**
 * Le type PlayerShip
 *
 * @author Elsa
 *
 * @version 0.1.0
 */
public class PlayerShip extends AbstractMovable {
    
    public static final int H_SPEED = 150;

    
    /**
     * Crée une nouvelle instance de PlayerShip.
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     */
    protected PlayerShip(SpaceInvadersGame game, double xPosition, double yPosition,
            Sprite sprite) {
        // TODO Auto-generated constructor stub.
        super(game, xPosition, yPosition, sprite);
        super.setHorizontalSpeed(H_SPEED);
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
        game.reducePlayerLife();
        
    }


}

