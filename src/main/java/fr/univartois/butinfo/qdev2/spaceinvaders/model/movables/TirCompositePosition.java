/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2023 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import java.util.List;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

/**
 * Le type TirCompositePosition
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class TirCompositePosition extends ContreAttaqueStrategie {
    
    private final List<IContreAttaque> list;
    private final IntegerProperty screenPart;
    private final Timeline shot;
    
    public TirCompositePosition(SpaceInvadersGame game, int proba) {
        this.game = game;
        
        initGame(game);
                
        list = List.of(
                new ContreAttaqueDefaut(),
                new ContreAttaqueRandom(proba)
        );
        
        screenPart = new SimpleIntegerProperty();

        
        shot = new Timeline(
                    new KeyFrame(Duration.millis(16), e -> screenPart.set(movable.getX() / (game.getWidth() / list.size())))
                );
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.ContreAttaqueStrategie#initAlien(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AlienShip)
     */
    @Override
    public void initAlien(AlienShip alien) {
        // TODO Auto-generated method stub.
        super.initAlien(alien);
        for (IContreAttaque tir : list) {
            tir.initAlien((AlienShip) movable);
            tir.initGame(game);
        }
        shot.setCycleCount(Animation.INDEFINITE);
        shot.play();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IContreAttaque#fireShot()
     */
    @Override
    public void fireShot() {
        list.get(screenPart.get()).fireShot();        
    }
}