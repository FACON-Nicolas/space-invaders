/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

/**
 * Le type ContreAttaqueIntelligent
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class ContreAttaqueIntelligent extends ContreAttaqueStrategie {
    
    private boolean isNear = false;
    private IMovable target;
    
    public ContreAttaqueIntelligent(SpaceInvadersGame game, IMovable target) {
        this.target = target;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IContreAttaque#fireShot()
     */
    public void fireShot() {
        if (Math.abs(movable.getX() - target.getX()) < 100) {
            if (!isNear) {
                game.addMovable(new Shoot(game, movable.getX(), movable.getY() + movable.getSprite().getHeight()+10, SpriteStore.getInstance().getSprite("shot")));
                isNear = true;
            }
        } else isNear = false;
    }

}

