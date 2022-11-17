/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;

/**
 * Le type ContreAttaqueStrategie
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public abstract class ContreAttaqueStrategie implements IContreAttaque {
    
    protected  IMovable movable;
    
    protected  SpaceInvadersGame game;
    
    protected AlienShip alien;
    
    protected ContreAttaqueStrategie() {
    }
    
    public void initAlien(AlienShip alien) {
        this.alien=alien;
    }
}

