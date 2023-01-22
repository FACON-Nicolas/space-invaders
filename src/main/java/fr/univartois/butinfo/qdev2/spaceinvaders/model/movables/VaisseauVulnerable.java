/**
 * Ce fichier fait partie du projet Space Invaders.
 *
 * (c) 2022 gasto
 * Tous droits r�serv�s.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Le type vaisseauVulnerable
 *
 * @author gasto
 *
 * @version 0.1.0
 */
public class VaisseauVulnerable  implements IEtatVaisseau {

    private SpaceInvadersGame game;
        
    private Sprite sprite;
    
    private IEtatVaisseau etat;
    
    public static final int H_SPEED = 150;
    
    public VaisseauVulnerable(SpaceInvadersGame game,IEtatVaisseau etat)  {
        this.game=game;
        sprite = game.getSpriteStore().getSprite("ship");
        this.etat=etat;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IEtatVaisseau#nextState()
     */
    public IEtatVaisseau nextState() {
        // TODO Auto-generated method stub.
        return new VaisseauInvulnerable(game, etat);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IEtatVaisseau#receiveShot()
     */
    @Override
    public void receiveShot() {
        game.reducePlayerLife();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IEtatVaisseau#getState()
     */
    @Override
    public EtatVaisseau getState() {
        // TODO Auto-generated method stub.
        return EtatVaisseau.VULNERABLE;
    }

    
}

