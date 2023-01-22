/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2023 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import java.util.Random;


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

    private final int nbAliensParLignes = 12;
    private final int distanceEntreLigne = 30;
    
    
    /**
     * Crée une nouvelle instance de LevelFactory.
     */
    public LevelFactory(SpaceInvadersGame game, IMovableFactory factory) {
        this.game = game;
        this.factory = factory;
    }

    /**
     * Cette méthode permet d'aligner correctement les aliens à la manière d'un 'space-evenly' en CSS
     */
    private int[] coordonnesXYCreationAlien(int numAlien, int nbAliens) {
        double n = numAlien % nbAliensParLignes + 1.0;
        int ligneCourante = numAlien / nbAliensParLignes;
        double N;
        if(ligneCourante == (nbAliens / nbAliensParLignes)){
            N = nbAliens % nbAliensParLignes;
        } else {
            N = nbAliensParLignes;
        }

        int x = (int) (game.getTopLimit() + game.getWidth() * (n / (N + 1)));
        int y = game.getLeftLimit() + (numAlien / nbAliensParLignes) * distanceEntreLigne;
        return new int[]{x, y};
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.ILevelFactory#createLevel1()
     */
    @Override
    public void createLevel1() {
        int nbAliens = 5;
        for (int i=0 ; i<nbAliens;i++){
            int[] xy = coordonnesXYCreationAlien(i, nbAliens);
            game.addMovable(factory.createAlienSansTir(xy[0], xy[1]));
        }

        game.setNbRemainingAliens(nbAliens);
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.ILevelFactory#createLevel2()
     */
    @Override
    public void createLevel2() {
        int nbAliens = 7;
        for (int i = 0; i < nbAliens; i++) {
            int[] xy = coordonnesXYCreationAlien(i, nbAliens);
            game.addMovable(factory.createAlien(xy[0], xy[1]));
        }
        game.setNbRemainingAliens(nbAliens);
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.ILevelFactory#createLevel3()
     */
    @Override
    public void createLevel3() {
        int nbAliens = 10;
        for (int i = 0; i < nbAliens; i++) {
            int[] xy = coordonnesXYCreationAlien(i, nbAliens);
            game.addMovable(factory.createAlienVie(xy[0], xy[1]));
        }
        game.setNbRemainingAliens(nbAliens);
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.ILevelFactory#createLevel4()
     */
    @Override
    public void createLevel4() {
        int nbAliens = 15;
        int nbMurs = random.nextInt(10);
        for(int i=0; i<=nbMurs ; i++) {
            game.addMovable(factory.createMur(i*game.getRightLimit()/nbMurs,3*game.getBottomLimit()/5));
        }

        for (int i = 0; i < nbAliens; i++) {
            int[] xy = coordonnesXYCreationAlien(i, nbAliens);
            game.addMovable(factory.createAlienVie(xy[0], xy[1]));
        }
        game.setNbRemainingAliens(nbAliens);
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

