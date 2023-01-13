/**
 * Ce logiciel est distribu� � des fins �ducatives.
 *
 * Il est fourni "tel quel", sans garantie d�aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualit� marchande, d�ad�quation
 * � un usage particulier et d�absence de contrefa�on.
 * En aucun cas, les auteurs ou titulaires du droit d�auteur ne seront
 * responsables de tout dommage, r�clamation ou autre responsabilit�, que ce
 * soit dans le cadre d�un contrat, d�un d�lit ou autre, en provenance de,
 * cons�cutif � ou en relation avec le logiciel ou son utilisation, ou avec
 * d�autres �l�ments du logiciel.
 *
 * (c) 2022 Romain Wallon - Universit� d'Artois.
 * Tous droits r�serv�s.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.shape.Rectangle;

/**
 * La classe {@link AbstractMovable} fournit une implantation de base pour tous les objets
 * �l�mentaires pouvant se d�placer dans le jeu.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public abstract class AbstractMovable implements IMovable {

    /**
     * Le jeu dans lequel cet objet �volue.
     */
    protected final SpaceInvadersGame game;

    /**
     * La position en x de cet objet.
     */
    protected final DoubleProperty xPosition;

    /**
     * La position en y de cet objet.
     */
    protected final DoubleProperty yPosition;

    /**
     * Si cet objet a �t� consomm�.
     */
    protected final BooleanProperty consumed;

    /**
     * La vitesse horizontale actuelle de cet objet (en pixels/s).
     */
    protected double horizontalSpeed;

    /**
     * La vitesse verticale actuelle de cet objet (en pixels/s).
     */
    protected double verticalSpeed;

    /**
     * L'instance de {@link Sprite} repr�sentant cet objet.
     */
    protected final ObjectProperty<Sprite> sprite;

    /**
     * Cr�e une nouvelle instance de AbstractMovable.
     *
     * @param game Le jeu dans lequel l'objet �volue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite L'instance de {@link Sprite} repr�sentant l'objet.
     */
    protected AbstractMovable(SpaceInvadersGame game, double xPosition,
            double yPosition, Sprite sprite) {
        this.game = game;
        this.xPosition = new SimpleDoubleProperty(xPosition);
        this.yPosition = new SimpleDoubleProperty(yPosition);
        this.consumed = new SimpleBooleanProperty(false);
        this.sprite = new SimpleObjectProperty<>(sprite);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getWidth()
     */
    @Override
    public int getWidth() {
        return sprite.get().getWidth();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getHeight()
     */
    @Override
    public int getHeight() {
        return sprite.get().getHeight();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setX(int)
     */
    @Override
    public void setX(int xPosition) {
        this.xPosition.set(xPosition);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getX()
     */
    @Override
    public int getX() {
        return xPosition.intValue();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getXProperty()
     */
    @Override
    public DoubleProperty getXProperty() {
        return xPosition;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setY(int)
     */
    @Override
    public void setY(int yPosition) {
        this.yPosition.set(yPosition);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getY()
     */
    @Override
    public int getY() {
        return yPosition.intValue();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getYProperty()
     */
    @Override
    public DoubleProperty getYProperty() {
        return yPosition;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#consume()
     */
    @Override
    public void consume() {
        consumed.set(true);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#isConsumed()
     */
    @Override
    public boolean isConsumed() {
        return consumed.get();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#isConsumedProperty()
     */
    @Override
    public BooleanProperty isConsumedProperty() {
        return consumed;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setHorizontalSpeed(double)
     */
    @Override
    public void setHorizontalSpeed(double speed) {
        this.horizontalSpeed = speed;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getHorizontalSpeed()
     */
    @Override
    public double getHorizontalSpeed() {
        return horizontalSpeed;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setVerticalSpeed(double)
     */
    @Override
    public void setVerticalSpeed(double speed) {
        this.verticalSpeed = speed;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getVerticalSpeed()
     */
    @Override
    public double getVerticalSpeed() {
        return verticalSpeed;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#move(long)
     */
    @Override
    public boolean move(long delta) {
        // On met � jour la position de l'objet sur l'axe x.
        int limitMaxX = game.getRightLimit() - getWidth();
        double newX = updatePosition(xPosition.get(), horizontalSpeed, delta, game.getLeftLimit(),
                limitMaxX);
        xPosition.set(newX);

        // On met � jour la position de l'objet sur l'axe y.
        int limitMaxY = game.getBottomLimit() - getHeight();
        double newY = updatePosition(yPosition.get(), verticalSpeed, delta, game.getTopLimit(),
                limitMaxY);
        yPosition.set(newY);

        if ((newX == game.getLeftLimit()) || (newX == limitMaxX)) {
            // L'objet a atteint la limite sur l'axe x.
            return false;
        }

        if ((newY == game.getTopLimit()) || (newY == limitMaxY)) {
            // L'objet a atteint la limite sur l'axe y.
            return false;
        }

        // L'objet n'a atteint aucune limite
        return true;
    }

    /**
     * Calcule la nouvelle position d'un objet sur un axe particulier, en fonction de sa
     * position actuelle sur cet axe.
     *
     * @param current La position courante de l'objet.
     * @param speed La vitesse actuelle de l'objet.
     * @param delta Le temps qui s'est �coul� depuis la derni�re mise � jour de la
     *        position de cet objet.
     * @param limitMin La limite inf�rieure pour la position de l'objet.
     * @param limitMax La limite sup�rieure pour la position de l'objet.
     *
     * @return La nouvelle position de l'objet apr�s la mise � jour.
     */
    protected static double updatePosition(double current, double speed, long delta,
            int limitMin, int limitMax) {
        double newPosition = current + (delta * speed) / 1000;

        if (newPosition < limitMin) {
            // Lorsque la limite inf�rieure est atteinte, on s'arr�te � cette limite.
            newPosition = limitMin;

        } else if (newPosition > limitMax) {
            // Lorsque la limite sup�rieure est atteinte, on s'arr�te � cette limite.
            newPosition = limitMax;
        }

        return newPosition;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getSprite()
     */
    @Override
    public Sprite getSprite() {
        return sprite.get();
    }
    
    public void setSprite(Sprite sprite) {
         this.sprite.set(sprite);
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getSpriteProperty()
     */
    @Override
    public ObjectProperty<Sprite> getSpriteProperty() {
        return sprite;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#isCollidingWith(fr.
     * univartois.butinfo.qdev2.spaceinvaders.model.IMovable)
     */
    @Override
    public boolean isCollidingWith(IMovable other) {
        if (isConsumed() || other.isConsumed()) {
            // L'un des deux objets au moins est d�j� consomm�.
            // Il ne peut donc pas y avoir de collision.
            return false;
        }

        Rectangle rectangle = new Rectangle(getX(), getY(), getWidth(), getHeight());
        return rectangle.intersects(other.getX(), other.getY(), other.getWidth(),
                other.getHeight());
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#self()
     */
    @Override
    public IMovable self() {
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            // Les deux objets sont forcément différents.
            return false;
        }

        if (obj == this) {
            // Les deux objets sont strictement identiques.
            return true;
        }

        if (obj instanceof IMovable other) {
            // On compare les "vrais objets".
            return other.self() == self();
        }

        // L'objet donné n'est pas d'une classe compatible.
        return false;
    }

}
