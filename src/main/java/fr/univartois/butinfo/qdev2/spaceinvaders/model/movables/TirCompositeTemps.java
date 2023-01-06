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
import javafx.util.Duration;

/**
 * Le type TirCompositeTemps
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class TirCompositeTemps extends ContreAttaqueStrategie {
    
    private Timeline timeline;
    private final List<IContreAttaque> list;
    private SpaceInvadersGame game;
    private AlienShip alien;
    private int index = 0;
    
    public TirCompositeTemps(AlienShip alien, SpaceInvadersGame game, int proba) {
        this.game = game;
        this.alien = alien;
        
        list = List.of(
            new ContreAttaqueDefaut(),
            new ContreAttaqueRandom(proba)
        );
        
        timeline = timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(20), e -> changeIndex()
                    )
            );
        
    }
    
    public void changeIndex() {
        index = (index+1) % list.size(); 
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IContreAttaque#fireShot()
     */
    @Override
    public void fireShot() {
        // TODO Auto-generated method stub.
        
    }

}

