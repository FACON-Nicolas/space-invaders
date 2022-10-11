/**
 * Ce fichier fait partie du projet Space Invaders.
 *
 * (c) 2022 gasto
 * Tous droits r�serv�s.
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
     * Cr�e une nouvelle instance de shoot.
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     */
    public Shoot(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
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
        other.receiveShot();
        
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#move(long)
     */
    @Override
    public boolean move(long delta) {
        super.move(delta);
        
        int limitMaxY = game.getBottomLimit() - getHeight();

        if ((yPosition.get() <= game.getTopLimit()) || (yPosition.get() >= limitMaxY)) {
            // L'objet a atteint la limite sur l'axe y.
           game.removeMovable(this);
           this.consume();
           return false;
        }

        // L'objet n'a atteint aucune limite
        return true;
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#hitAlien()
     */
    @Override
    public void hitAlien() {
       
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#receiveShot()
     */
    @Override
    public void receiveShot() {
        game.removeMovable(this);
        this.consume();
    }
}

