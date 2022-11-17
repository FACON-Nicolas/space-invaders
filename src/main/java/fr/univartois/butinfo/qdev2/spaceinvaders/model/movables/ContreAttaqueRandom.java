/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import java.util.Random;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

/**
 * Le type ContreAttaqueRandom
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class ContreAttaqueRandom extends ContreAttaqueStrategie {
    
    public static final Random RANDOM = new Random(); 
    
    private int proba;
    
    public ContreAttaqueRandom(int proba) {
        this.proba = proba;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IContreAttaque#fireShot()
     */
    public void fireShot() {
        int n = RANDOM.nextInt(0, proba);
        if (n == 0) {
            game.addMovable(new Shoot(game, movable.getX(), movable.getY() + movable.getSprite().getHeight()+10, SpriteStore.getInstance().getSprite("shot")));
        }
    }

}

