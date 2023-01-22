/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2023 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;


/**
 * Le type ILevelFactory
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public interface ILevelFactory {
    
    void createLevel1();
    
    void createLevel2();
    
    void createLevel3();
    
    void createLevel4();
    
    void createLevel(int level);

}

