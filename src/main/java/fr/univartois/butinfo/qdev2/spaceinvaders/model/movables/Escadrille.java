package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;

import java.util.ArrayList;
import java.util.List;

public class Escadrille implements IMovable {

    private final List<IMovable> aliens = new ArrayList<>();

    private final IStratMove stratMove;

    public Escadrille() {
        this.stratMove = new EscadrilleMove();
    }

    public void addAlien(IMovable alien) {
        aliens.add(alien);
    }

    public void removeAlien(IMovable alien) {
        aliens.remove(alien);
    }


    @Override
    public void collidedWith(IMovable other) {
        other.hitAlien();
    }

    @Override
    public boolean isCollidingWith(IMovable other) {
        boolean collide = false;
        for (IMovable alien: aliens) {
            if(alien.isCollidingWith(other)) {
                collide = true;
                alien.receiveShot();
                break;
            }
        }
        return collide;
    }

    @Override
    public void hitAlien() {
        // Méthode vide
    }

    @Override
    public void receiveShot() {
        // Méthode vide
    }

    @Override
    public IMovable self() {
        return this;
    }

    @Override
    public int getWidth() {
        return aliens.get(0).getWidth();
    }

    @Override
    public int getHeight() {
        return aliens.get(0).getHeight();
    }

    @Override
    public void setX(int xPosition) {
        // Méthode vide
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public DoubleProperty getXProperty() {
        return null;
    }

    @Override
    public void setY(int yPosition) {
        // Méthode vide
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public DoubleProperty getYProperty() {
        return null;
    }

    @Override
    public void consume() {
        for (IMovable alien: aliens) {
            alien.consume();
        }
    }

    @Override
    public boolean isConsumed() {
        return false;
    }

    @Override
    public void setHorizontalSpeed(double speed) {
        for (IMovable alien: aliens) {
            alien.setHorizontalSpeed(speed);
        }
    }

    @Override
    public double getHorizontalSpeed() {
        return aliens.get(0).getHorizontalSpeed();
    }

    @Override
    public void setVerticalSpeed(double speed) {
        for (IMovable alien: aliens) {
            alien.setVerticalSpeed(speed);
        }
    }

    @Override
    public double getVerticalSpeed() {
        return aliens.get(0).getVerticalSpeed();
    }

    @Override
    public ObjectProperty<Sprite> getSpriteProperty() {
        return null;
    }

    @Override
    public BooleanProperty isConsumedProperty() {
        return null;
    }

    @Override
    public boolean move(long delta) {
        boolean bloque = false;
        for (IMovable alien: aliens) {
            if (!alien.move(delta)) {
                bloque = true;
                break;
            }
        }
        if (bloque) {
            for (IMovable alien: aliens) {
                alien.setHorizontalSpeed(-alien.getHorizontalSpeed());
            }
        }
        return bloque;
    }

    @Override
    public Sprite getSprite() {
        return null;
    }
}
