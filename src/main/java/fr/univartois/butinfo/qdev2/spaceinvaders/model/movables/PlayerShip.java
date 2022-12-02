/**
 * Ce fichier fait partie du projet space-invaders.
 *
 * (c) 2022 Elsa
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
    
    private IEtatVaisseau etat;
    
    public static final int H_SPEED = 150;

    
    /**
     * Crée une nouvelle instance de PlayerShip.
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     */
    public PlayerShip(SpaceInvadersGame game, double xPosition, double yPosition,
            Sprite sprite,IEtatVaisseau etat) {
        // TODO Auto-generated constructor stub.
        super(game, xPosition, yPosition, sprite);
        super.setHorizontalSpeed(H_SPEED);
        this.etat=etat;
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
    public void changerEtat(IEtatVaisseau etat) {
        etat=etat.nextState();
        this.setSprite(etat.getSprite());
    }
    */
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#receiveShot()
     */
    @Override
    public void receiveShot() {
        etat=etat.receiveShot();
        this.setSprite(etat.getSprite());
        this.setSprite(etat.getSprite());
        if((game.getLife()!=0)){
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.schedule(() -> etat=etat.nextState(), 3, TimeUnit.SECONDS);
            ScheduledExecutorService executorService2 = Executors.newSingleThreadScheduledExecutor();
            executorService2.schedule(() ->  this.setSprite(game.getSpriteStore().getSprite("ship")), 3, TimeUnit.SECONDS);
            }
    }
}

