package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class AlienShip extends AbstractMovable {

    private IContreAttaque contreAttaque;
    private final IStratMove stratM;

    private final Timeline timeline;

    public AlienShip(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite, IContreAttaque element, IStratMove stratM) {
        super(game, xPosition, yPosition, sprite);
//        this.stratM = stratM;
        this.stratM = new DefaultMove();
        this.stratM.initialSpeed(this);
        this.contreAttaque = element;
        if (element != null) {
            timeline = new Timeline(
                    new KeyFrame(Duration.millis(16), e -> element.fireShot()));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
            this.contreAttaque.initAlien(this);
            this.contreAttaque.initGame(game);
        } else timeline = null;
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
