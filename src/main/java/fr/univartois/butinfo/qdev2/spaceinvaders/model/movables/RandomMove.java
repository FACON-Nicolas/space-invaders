package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;

import java.util.Random;

import static fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovable.updatePosition;

public class RandomMove implements IStratMove {

    private static final int V_SPEED = 1;

    private static final int H_SPEED_MAX = 200;

    private int nbFrameChangementVitesse = 0;
    private static final int NB_FRAME_MAX_CHANGEMENT_VITESSE = 120;

    private static final Random RANDOM = new Random();
    
    @Override
    public void initialSpeed(IMovable alien) {
        alien.setHorizontalSpeed(RANDOM.nextInt(1, H_SPEED_MAX));
        alien.setVerticalSpeed(V_SPEED);
    }

    @Override
    public boolean move(IMovable alien, SpaceInvadersGame game, long delta) {
        // Attribution de la vitesse horizontal
        nbFrameChangementVitesse++;
        if (nbFrameChangementVitesse >= NB_FRAME_MAX_CHANGEMENT_VITESSE) {
            nbFrameChangementVitesse = 0;
            int hSpeed = RANDOM.nextInt(-H_SPEED_MAX, H_SPEED_MAX);
            alien.setHorizontalSpeed(hSpeed);
        }


        // On met à jour la position de l'objet sur l'axe x.
        int limitMaxX = game.getRightLimit() - alien.getWidth();
        double newX = updatePosition(alien.getXProperty().get(), alien.getHorizontalSpeed(), delta, game.getLeftLimit(), limitMaxX);
        alien.getXProperty().set(newX);

        // On met à jour la position de l'objet sur l'axe y.
        int limitMaxY = game.getBottomLimit() - alien.getHeight();
        double newY = updatePosition(alien.getYProperty().get(), alien.getVerticalSpeed(), delta, game.getTopLimit(), limitMaxY);
        alien.getYProperty().set(newY);

        if ((newX == game.getLeftLimit()) || (newX == limitMaxX)) {
            // Rebond
            alien.setHorizontalSpeed( - (alien.getHorizontalSpeed()));
            return false;
        }
        return true;
    }
}
