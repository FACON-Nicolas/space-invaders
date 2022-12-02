/**
 * Ce fichier fait partie du projet space-invaders.
 *
 * (c) 2022 Elsa
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.AbstractBonus;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * Le type PlayerShip
 *
 * @author Elsa
 *
 * @version 0.1.0
 */
public class PlayerShip extends AbstractMovable {
    
    public static final DoubleProperty h_speed = new SimpleDoubleProperty();

    
    /**
     * Crée une nouvelle instance de PlayerShip.
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     */
    public PlayerShip(SpaceInvadersGame game, double xPosition, double yPosition,
            Sprite sprite) {
        // TODO Auto-generated constructor stub.
        super(game, xPosition, yPosition, sprite);
        super.setHorizontalSpeed(h_speed.get());
        h_speed.bindBidirectional(game.SHIP_SPEED);
        h_speed.set(150);
        
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovable#getHorizontalSpeed()
     */
    @Override
    public double getHorizontalSpeed() {
        // TODO Auto-generated method stub.
        return h_speed.get();
    }
    

    public void setHorizontalSpeedPlayer(double speed) {
        h_speed.set(speed);;
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
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#hitBonus()
     */
    @Override
    public void hitBonus(AbstractBonus bonus) {
        bonus.giveBonus(this);
    }


}

