package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;

import static fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovable.updatePosition;

public class BounceMove implements IStratMove {

    private static final int H_SPEED = 175;

    private static final int V_SPEED = 100;

    private static final int NB_FRAME_MAX_REBOND = 120;
    private int nbFrameRebond = 0;

    @Override
    public void initialSpeed(IMovable alien) {
        alien.setHorizontalSpeed(H_SPEED);
        alien.setVerticalSpeed(V_SPEED);
        alien.setY(15);
    }

    @Override
    public boolean move(IMovable alien, SpaceInvadersGame game, long delta) {
        // Si le compteur arrive à la limite ou si l'alien arrive proche du bord supérieur
        if(nbFrameRebond > NB_FRAME_MAX_REBOND || alien.getY() - 5 < game.getTopLimit()){
            alien.setVerticalSpeed(-alien.getVerticalSpeed());
            nbFrameRebond = 0;
        }
        nbFrameRebond++;



        // On met à jour la position de l'objet sur l'axe x.
        int limitMaxX = game.getRightLimit() - alien.getWidth();
        double newX = updatePosition(alien.getXProperty().get(), alien.getHorizontalSpeed(), delta, game.getLeftLimit(), limitMaxX);
        alien.getXProperty().set(newX);

        // On met à jour la position de l'objet sur l'axe y.
        int limitMaxY = game.getBottomLimit() - alien.getHeight();
        double newY = updatePosition(alien.getYProperty().get(), alien.getVerticalSpeed(), delta, game.getTopLimit(), limitMaxY);
        alien.getYProperty().set(newY);

        if ((newX == game.getLeftLimit()) || (newX == limitMaxX)) {
            // Rebond + augmentation de la vitesse
            alien.setHorizontalSpeed( - (alien.getHorizontalSpeed() * 1.02));
            alien.setVerticalSpeed(alien.getVerticalSpeed() * 1.02);
            return false;
        }
        return true;
    }

}
