/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.MovableFactory;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

/**
 * Le type ContreAttaqueDefaut
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class ContreAttaqueDefaut extends ContreAttaqueStrategie {
    
    private static final int SHOT_TEMP = 500;
    
    private double lastShot = 0;
    
    public ContreAttaqueDefaut() {
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IContreAttaque#fireShot()
     */
    public void fireShot() {
        if (!movable.isConsumed()) {
            if (lastShot == 0 || System.currentTimeMillis() - lastShot >= SHOT_TEMP) {
                lastShot = System.currentTimeMillis();
                Shoot shoot = new Shoot(game, movable.getX(), movable.getY() + movable.getSprite().getHeight()+10, SpriteStore.getInstance().getSprite("shot"));
                shoot.verticalSpeed *= -1;
                game.addMovable(shoot);
           }
        }
    }
}

