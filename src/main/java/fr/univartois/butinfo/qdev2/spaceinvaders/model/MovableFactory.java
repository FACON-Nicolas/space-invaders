/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import java.util.Arrays;
import java.util.List;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AlienShip;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.PlayerShip;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Shoot;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VieIMovableDecorator;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore;

/**
 * Le type MovableFactory
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class MovableFactory implements IMovableFactory {
    
    private ISpriteStore spriteStore;
    private SpaceInvadersGame game;

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setSpriteStore(fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore)
     */
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
       
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setGame(fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame)
     */
    @Override
    public void setGame(SpaceInvadersGame game) {
        this.game = game;
        
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createAlien(int, int)
     */
    @Override
    public IMovable createAlien(int x, int y) {
        IMovable alien = new AlienShip(game, x, y, spriteStore.getSprite("alien"));
        return alien;
    }
    
    public VieIMovableDecorator createAlienVie(int x, int y) {      
        IContreAttaque defaut=new ContreAttaqueDefaut();
        IContreAttaque intelligent=new ContreAttaqueIntelligent();
        IContreAttaque random=new ContreAttaqueRandom();
        List<IContreAttaque> liste =Arrays.asList(defaut,intelligent,random);
        VieIMovableDecorator alien = new VieIMovableDecorator(createAlien(x, y), 2);
        return alien;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createShip(int, int)
     */
    @Override
    public IMovable createShip(int x, int y) {
        return new PlayerShip(game, x, y, spriteStore.getSprite("ship"));
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createShot(int, int)
     */
    @Override
    public IMovable createShot(int x, int y) {
        IMovable shot = new Shoot(game, x, y, spriteStore.getSprite("shot"));
        return shot;
    }

}

