/**
 * Ce fichier fait partie du projet Space Invaders.
 *
 * (c) 2022 gasto
 * Tous droits r�serv�s.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;

/**
 * Le type AlienResistant
 *
 * @author gasto
 *
 * @version 0.1.0
 */
public abstract class IMovableDecorator implements IMovable{
    
    private IMovable decore;
    
    
    public IMovableDecorator(IMovable decore) {
        this.decore=decore;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#isConsumedProperty()
     */
    @Override
    public BooleanProperty isConsumedProperty() {
        // TODO Auto-generated method stub.
        return decore.isConsumedProperty();
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getSpriteProperty()
     */
    @Override
    public ObjectProperty<Sprite> getSpriteProperty() {
        // TODO Auto-generated method stub.
        return getDecore().getSpriteProperty();
    }
    
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getWidth()
     */
    @Override
    public int getWidth() {
        // TODO Auto-generated method stub.
        return decore.getWidth();
    }

    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getHeight()
     */
    @Override
    public int getHeight() {
        // TODO Auto-generated method stub.
        return decore.getHeight();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setX(int)
     */
    @Override
    public void setX(int xPosition) {
        // TODO Auto-generated method stub.
        decore.setX(xPosition);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getX()
     */
    @Override
    public int getX() {
        // TODO Auto-generated method stub.
        return decore.getX();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getXProperty()
     */
    @Override
    public DoubleProperty getXProperty() {
        // TODO Auto-generated method stub.
        return decore.getXProperty();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setY(int)
     */
    @Override
    public void setY(int yPosition) {
        // TODO Auto-generated method stub.
        decore.setY(yPosition);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getY()
     */
    @Override
    public int getY() {
        // TODO Auto-generated method stub.
        return decore.getY();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getYProperty()
     */
    @Override
    public DoubleProperty getYProperty() {
        // TODO Auto-generated method stub.
        return decore.getYProperty();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#consume()
     */
    @Override
    public void consume() {
        // TODO Auto-generated method stub.
        decore.consume();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#isConsumed()
     */
    @Override
    public boolean isConsumed() {
        // TODO Auto-generated method stub.
        return decore.isConsumed();
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setHorizontalSpeed(double)
     */
    @Override
    public void setHorizontalSpeed(double speed) {
        // TODO Auto-generated method stub.
        decore.setHorizontalSpeed(speed);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getHorizontalSpeed()
     */
    @Override
    public double getHorizontalSpeed() {
        // TODO Auto-generated method stub.
        return decore.getHorizontalSpeed();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setVerticalSpeed(double)
     */
    @Override
    public void setVerticalSpeed(double speed) {
        // TODO Auto-generated method stub.
        decore.setVerticalSpeed(speed);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getVerticalSpeed()
     */
    @Override
    public double getVerticalSpeed() {
        // TODO Auto-generated method stub.
        return decore.getVerticalSpeed();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#move(long)
     */
    @Override
    public boolean move(long timeDelta) {
        // TODO Auto-generated method stub.
        return decore.move(timeDelta);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getSprite()
     */
    @Override
    public Sprite getSprite() {
        // TODO Auto-generated method stub.
        return decore.getSprite();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#isCollidingWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable)
     */
    @Override
    public boolean isCollidingWith(IMovable other) {
        // TODO Auto-generated method stub.
        return decore.isCollidingWith(other);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable)
     */
    @Override
    public void collidedWith(IMovable other) {
        // TODO Auto-generated method stub.
        decore.collidedWith(other);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#hitAlien()
     */
    @Override
    public void hitAlien() {
        // TODO Auto-generated method stub.
        decore.hitAlien();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#receiveShot()
     */
    @Override
    public void receiveShot() {
        // TODO Auto-generated method stub.
        decore.receiveShot();
    }
    
    
    /**
     * Donne l'attribut decore de cette instance de IMovableDecorator.
     *
     * @return L'attribut decore de cette instance de IMovableDecorator.
     */
    public IMovable getDecore() {
        return decore;
    }

}

