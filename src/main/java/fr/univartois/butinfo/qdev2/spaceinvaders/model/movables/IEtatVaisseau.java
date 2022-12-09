/**
 * Ce fichier fait partie du projet Space Invaders.
 *
 * (c) 2022 gasto
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

/**
 * Le type IEtatVaisseau
 *
 * @author gasto
 *
 * @version 0.1.0
 */
public interface IEtatVaisseau {
    

    IEtatVaisseau nextState();

   void receiveShot();

    
}

