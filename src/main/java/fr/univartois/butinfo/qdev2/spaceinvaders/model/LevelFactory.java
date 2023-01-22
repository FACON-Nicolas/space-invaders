/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2023 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import java.util.Random;

import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

/**
 * Le type LevelFactory
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class LevelFactory implements ILevelFactory {
    
    
    
    private SpaceInvadersGame game;
    private IMovableFactory factory;
    private static final Random random = new Random();
    
    
    /**
     * Crée une nouvelle instance de LevelFactory.
     */
    public LevelFactory(SpaceInvadersGame game, IMovableFactory factory) {
        this.game = game;
        this.factory = factory;
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.ILevelFactory#createLevel1()
     */
    @Override
    public void createLevel1() {
        int width = SpriteStore.getInstance().getSprite("alien").getWidth();
        for (int i=0 ; i<5;i++)
            game.addMovable(factory.createAlienSansTir(i * width, game.getLeftLimit()));
        game.setNbRemainingAliens(5);
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.ILevelFactory#createLevel2()
     */
    @Override
    public void createLevel2() {
        int width = SpriteStore.getInstance().getSprite("alien").getWidth();
        for (int i = 0; i < 7; i++) {
            game.addMovable(factory.createAlien(i * width, game.getLeftLimit()));
            game.setNbRemainingAliens(7);
        }
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.ILevelFactory#createLevel3()
     */
    @Override
    public void createLevel3() {
        int width = SpriteStore.getInstance().getSprite("alien").getWidth();
        for (int i = 0; i < 10; i++) {
            game.addMovable(factory.createAlienVie(i * width, game.getLeftLimit()));
            game.setNbRemainingAliens(10);
        }
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.ILevelFactory#createLevel4()
     */
    @Override
    public void createLevel4() {
        int width = SpriteStore.getInstance().getSprite("alien").getWidth();
        int nbMurs = random.nextInt(10);
        for(int i=0; i<=nbMurs ; i++) {
            game.addMovable(factory.createMur(i*game.getRightLimit()/nbMurs,3*game.getBottomLimit()/5));
        }

        for (int i = 0; i < 15; i++) {
            game.addMovable(factory.createAlienVie(i * width, game.getLeftLimit()));
            game.setNbRemainingAliens(15);
        }
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.ILevelFactory#createLevel()
     */
    @Override
    public void createLevel(int level) {
        switch (level) {
            case 1 -> createLevel1();
            case 2 -> createLevel2();
            case 3 -> createLevel3();
            case 4 -> createLevel4();
            default -> {
                game.setLevel(1);
                game.start();
            }
        }
        
    }

}

