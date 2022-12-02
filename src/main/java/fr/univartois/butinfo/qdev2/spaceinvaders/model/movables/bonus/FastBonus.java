/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.PlayerShip;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Le type FastBonus
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class FastBonus extends AbstractBonus {
    
    public FastBonus(SpaceInvadersGame game, double x, double y) {
        super(game, x, y, SpriteStore.getInstance().getSprite("speed"));
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.AbstractBonus#giveBonus(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.PlayerShip)
     */
    @Override
    public void giveBonus(PlayerShip player) {
        if (!isConsumed()) {
            player.setHorizontalSpeedPlayer(player.getHorizontalSpeed() + 150);
            Timeline timeline = new Timeline(
                    new KeyFrame(
                            Duration.seconds(5), 
                            e -> player.setHorizontalSpeedPlayer(player.getHorizontalSpeed() - 150))
                    );
            timeline.play();
            consume();
        }
    }

}

