package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

public class AlienShip extends AbstractMovable{

    private final IStratMove stratM;


    public AlienShip(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        // TODO Changer le mouvement appliqué dans la factory qui créer les aliens
        stratM = new RandomMove();
        stratM.initialSpeed(this);
    }

    @Override
    public boolean move(long delta) {
        boolean isMoving = stratM.move(this, game, delta);
        if (!isMoving) return false;

        // Si l'alien touche atteint le joueur
        int limitMaxY = game.getBottomLimit() - getHeight();
        if ((yPosition.get() == game.getTopLimit()) || (yPosition.get() == limitMaxY)) {
            // L'objet a atteint la limite sur l'axe y.
            // Fin de la partie
            game.alienReachedPlanet();
            return false;
        }

        // L'objet n'a atteint aucune limite
        return true;
    }

    @Override
    public void collidedWith(IMovable other) {
        other.hitAlien();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#hitAlien()
     */
    @Override
    public void hitAlien() {
        // TODO Auto-generated method stub.
        
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#receiveShot()
     */
    @Override
    public void receiveShot() {
        game.alienIsDead(this);
        this.consume();
        
    }

}
