/**
 * Ce fichier fait partie du projet Space Invaders.
 *
 * (c) 2022 gasto
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

/**
 * Le type vaisseauInvulnerable
 *
 * @author gasto
 *
 * @version 0.1.0
 */
public class VaisseauInvulnerable implements IEtatVaisseau  {
    
    private SpaceInvadersGame game;
        
    private Sprite sprite ;

    private IEtatVaisseau etat;
    public VaisseauInvulnerable(SpaceInvadersGame game,IEtatVaisseau etat)  {
        this.game = game;
        sprite = game.getSpriteStore().getSprite("ufo");
        this.etat=etat;
    }
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IEtatVaisseau#sprite()
     */
    public Sprite getSprite() {
        return sprite;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IEtatVaisseau#nextState()
     */
    public IEtatVaisseau nextState() {
        return new VaisseauVulnerable(game,etat);
    }
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IEtatVaisseau#receiveShot()
     */
    @Override
    public IEtatVaisseau receiveShot() { 
        return this ;
    }

}

