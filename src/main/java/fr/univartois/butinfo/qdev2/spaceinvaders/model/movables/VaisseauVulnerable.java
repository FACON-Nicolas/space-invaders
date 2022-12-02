/**
 * Ce fichier fait partie du projet Space Invaders.
 *
 * (c) 2022 gasto
 * Tous droits réservés.
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
        return etat=new VaisseauInvulnerable(game, etat);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IEtatVaisseau#getSprite()
     */
    public Sprite getSprite() {
        // TODO Auto-generated method stub.
        return sprite;
    }
    
    
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IEtatVaisseau#receiveShot()
     */
    @Override
    public IEtatVaisseau receiveShot() {
        game.reducePlayerLife();
        etat=this.nextState();
        return etat;

    }

    /**
     * @param sprite2
     */
    private void setSprite(Sprite sprite2) {
        // TODO Auto-generated method stub.
        this.sprite=sprite2;
    }

}

