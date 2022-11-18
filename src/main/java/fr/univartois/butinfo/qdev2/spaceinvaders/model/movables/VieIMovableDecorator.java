/**
 * Ce fichier fait partie du projet Space Invaders.
 *
 * (c) 2022 gasto
 * Tous droits r�serv�s.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

/**
 * Le type VieIMovableDecorator
 *
 * @author gasto
 *
 * @version 0.1.0
 */
public class VieIMovableDecorator extends IMovableDecorator{
    
    private int vie;
    
    /**
     * Donne l'attribut vie de cette instance de VieIMovableDecorator.
     *
     * @return L'attribut vie de cette instance de VieIMovableDecorator.
     */
    public int getVie() {
        return vie;
    }


    
    /**
     * Modifie l'attribut vie de cette instance de VieIMovableDecorator.
     *
     * @param vie La nouvelle valeur de l'attribut vie pour cette instance de VieIMovableDecorator.
     */
    public void setVie(int vie) {
        this.vie = vie;
    }


    /**
     * Cr�e une nouvelle instance de VieIMovableDecorator.
     * @param decore
     */
    public VieIMovableDecorator(IMovable decore,int vie) {
        // TODO Auto-generated constructor stub.
        super(decore);
        this.vie=vie;
    }
    
    
    

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#receiveShot()
     */
    @Override
    public void receiveShot() {
        vie--;
        if (vie <= 0)
            getDecore().receiveShot();
        
    }



    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#self()
     */
    @Override
    public IMovable self() {
        // TODO Auto-generated method stub.
        return this;
    }

}

