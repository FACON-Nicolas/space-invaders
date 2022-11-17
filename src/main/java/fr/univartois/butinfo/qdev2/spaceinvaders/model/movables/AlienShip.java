package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class AlienShip extends AbstractMovable {

    public static final int H_SPEED = 75;
    public static final int V_SPEED = 1;
    private IContreAttaque contreAttaque;
    private final Timeline timeline;

    public AlienShip(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite, IContreAttaque element) {
        super(game, xPosition, yPosition, sprite);
        super.setHorizontalSpeed(H_SPEED);
        super.setVerticalSpeed(V_SPEED);
        this.contreAttaque = element;
        if (element != null) {
            timeline = new Timeline(
                    new KeyFrame(Duration.millis(16), e -> element.fireShot()));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        } else timeline = null;
    }

    @Override
    public boolean move(long delta) {
        // On met à jour la position de l'objet sur l'axe x.
        int limitMaxX = game.getRightLimit() - getWidth();
        double newX = updatePosition(xPosition.get(), horizontalSpeed, delta, game.getLeftLimit(), limitMaxX);
        xPosition.set(newX);

        // On met à jour la position de l'objet sur l'axe y.
        int limitMaxY = game.getBottomLimit() - getHeight();
        double newY = updatePosition(yPosition.get(), verticalSpeed, delta, game.getTopLimit(), limitMaxY);
        yPosition.set(newY);

        if ((newX == game.getLeftLimit()) || (newX == limitMaxX)) {
            // Rebond + augmentation de la vitesse
            this.setHorizontalSpeed( - (this.getHorizontalSpeed() * 1.02));
            return false;
        }

        if ((newY == game.getTopLimit()) || (newY == limitMaxY)) {
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
