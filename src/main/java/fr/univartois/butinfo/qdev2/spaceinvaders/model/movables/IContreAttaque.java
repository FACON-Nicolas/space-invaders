/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;

/**
 * Le type IContreAttaque
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public interface IContreAttaque {
    
    void fireShot();
    
    void initAlien(AlienShip alien);
    
    void initGame(SpaceInvadersGame game);
}

