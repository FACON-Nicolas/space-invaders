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
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.AbstractBonus;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.util.Duration;

/**
 * Le type PlayerShip
 *
 * @author Elsa
 *
 * @version 0.1.0
 */
public class PlayerShip extends AbstractMovable {
    
    public static final DoubleProperty h_speed = new SimpleDoubleProperty();

    private IEtatVaisseau etat;
    
    public static final int H_SPEED = 150;

    private boolean bool=true;
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
        super.setHorizontalSpeed(h_speed.get());
        h_speed.bindBidirectional(game.SHIP_SPEED);
        h_speed.set(150);
        
        super.setHorizontalSpeed(H_SPEED);
        this.etat=etat;
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
        etat.receiveShot();
        if(bool==true) {
            if(game.getLife()!=0){
                bool=false;
                etat=etat.nextState();
                sprite.set(game.getSpriteStore().getSprite("ufo"));
                long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                
                ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                executorService.schedule(() -> {
                    etat=etat.nextState();
                    sprite.set(game.getSpriteStore().getSprite("ship"));
                    bool=true;
                }, 3, TimeUnit.SECONDS);
            }
        }
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

    
    /**
     * Donne l'attribut etat de cette instance de PlayerShip.
     *
     * @return L'attribut etat de cette instance de PlayerShip.
     */
    public IEtatVaisseau getEtat() {
        return etat;
    }

    
    /**
     * Modifie l'attribut etat de cette instance de PlayerShip.
     *
     * @param etat La nouvelle valeur de l'attribut etat pour cette instance de PlayerShip.
     */
    public void setEtat(IEtatVaisseau etat) {
        this.etat = etat;
    }
    
    
    
}

