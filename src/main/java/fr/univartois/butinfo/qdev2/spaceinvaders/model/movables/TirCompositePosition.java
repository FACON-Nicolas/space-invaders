/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2023 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import java.util.List;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Le type TirCompositePosition
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class TirCompositePosition extends ContreAttaqueStrategie {
    
    private final List<IContreAttaque> list;
    private SpaceInvadersGame game;
    private AlienShip alien;
    private final IntegerProperty screenPart;
    
    public TirCompositePosition(AlienShip alien, SpaceInvadersGame game, int proba) {
        this.game = game;
        this.alien = alien;
        
        list = List.of(
                new ContreAttaqueDefaut(),
                new ContreAttaqueRandom(proba)
        );
        
        screenPart = new SimpleIntegerProperty();
        screenPart.addListener((p, o, n) -> screenPart.set(alien.getX() / (game.getWidth() / list.size())));
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