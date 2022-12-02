/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.PlayerShip;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

/**
 * Le type AddHealthBonus
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class AddHealthBonus extends AbstractBonus {
    
    public AddHealthBonus(SpaceInvadersGame game, double xPosition, double yPosition) {
        super(game, xPosition, yPosition, SpriteStore.getInstance().getSprite("heart"));
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.AbstractBonus#giveBonus(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.PlayerShip)
     */
    @Override
    public void giveBonus(PlayerShip player) {
        if (!isConsumed()) {
            game.setLife(game.getLife()+1);
            consume();
        }
    }

}

