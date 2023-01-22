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
    private int index = 0;
    
    public TirCompositeTemps(SpaceInvadersGame game, int proba) {
        this.game = game;
                
        list = List.of(
            new ContreAttaqueDefaut(),
            new ContreAttaqueRandom(proba)
        );
        
        timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(20), e -> changeIndex()
                    )
            );   
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    public void changeIndex() {
        index = (index+1) % list.size(); 
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
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IContreAttaque#fireShot()
     */
    @Override
    public void fireShot() {
        list.get(index).fireShot();        
    }

}

