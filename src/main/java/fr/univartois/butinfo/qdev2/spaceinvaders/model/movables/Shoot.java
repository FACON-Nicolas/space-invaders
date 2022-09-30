/**
 * Ce fichier fait partie du projet Space Invaders.
 *
 * (c) 2022 gasto
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

/**
 * Le type shoot
 *
 * @author gasto
 *
 * @version 0.1.0
 */
public class Shoot extends AbstractMovable {
    
    
    /**
     * Crée une nouvelle instance de shoot.
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     */
    protected Shoot(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
        // TODO Auto-generated constructor stub.
        super(game, xPosition, yPosition, sprite);
        this.verticalSpeed=-300;
        
    }

    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable)
     */
    @Override
    public void collidedWith(IMovable other) {
        game.removeMovable(this);
        
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#move(long)
     */
    @Override
    public boolean move(long delta) {
        // On met Ã  jour la position de l'objet sur l'axe x.
        int limitMaxX = game.getRightLimit() - getWidth();
        double newX = xPosition.get();
        xPosition.set(newX);

        // On met Ã  jour la position de l'objet sur l'axe y.
        int limitMaxY = game.getBottomLimit() - getHeight();
        double newY = yPosition.get()+verticalSpeed;
        yPosition.set(newY);

        if ((newY == game.getTopLimit()) || (newY == limitMaxY)) {
            // L'objet a atteint la limite sur l'axe y.
           game.removeMovable(this);
            return false;
        }

        // L'objet n'a atteint aucune limite
        return true;
    }
}

