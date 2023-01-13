/**
 * Ce fichier fait partie du projet projet-2022-2023.
 *
 * (c) 2022 nicolas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AlienShip;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.BounceMove;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.ContreAttaqueDefaut;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.ContreAttaqueIntelligent;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.ContreAttaqueRandom;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.DefaultMove;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IContreAttaque;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IEtatVaisseau;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IStratMove;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.PlayerShip;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.RandomMove;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Shoot;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauVulnerable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VieIMovableDecorator;
import fr.univartois.butinfo.qdev2.spaceinvaders.mur.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

/**
 * Le type MovableFactory
 *
 * @author nicolas
 *
 * @version 0.1.0
 */
public class MovableFactory implements IMovableFactory {
    
    private ISpriteStore spriteStore;
    private SpaceInvadersGame game;
    private IEtatVaisseau etat;
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setSpriteStore(fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore)
     */
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
       
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setGame(fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame)
     */
    @Override
    public void setGame(SpaceInvadersGame game) {
        this.game = game;
        
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createAlien(int, int)
     */
    @Override
    public IMovable createAlien(int x, int y) {
        IContreAttaque defaut=new ContreAttaqueDefaut();
        //IContreAttaque intelligent=new ContreAttaqueIntelligent(game);
        IContreAttaque random=new ContreAttaqueRandom(160);
        
        List<IContreAttaque> liste =Arrays.asList(random,defaut);
        Random rand = new Random();
        IContreAttaque element= liste.get(rand.nextInt(liste.size()));
        
        IStratMove bounce=new BounceMove();
        IStratMove defautMove=new DefaultMove();
        IStratMove randomMove=new RandomMove();
        
        List<IStratMove> listeMove= Arrays.asList(bounce,defautMove,randomMove);
        Random rande = new Random();
        IStratMove elementMove=listeMove.get(rand.nextInt(listeMove.size()));
        
        IMovable alien = new AlienShip(game, x, y, spriteStore.getSprite("alien"), element,elementMove);
        return alien;
    }
    
    public VieIMovableDecorator createAlienVie(int x, int y) {  
        IContreAttaque defaut=new ContreAttaqueDefaut();
        //IContreAttaque intelligent=new ContreAttaqueIntelligent(game, null);
        IContreAttaque random=new ContreAttaqueRandom(160);
        
        List<IContreAttaque> liste =Arrays.asList(random);
        Random rand = new Random();
        IContreAttaque element= liste.get(rand.nextInt(liste.size()));
        
        IStratMove bounce=new BounceMove();
        IStratMove defautMove=new DefaultMove();
        IStratMove randomMove=new RandomMove();
        
        List<IStratMove> listeMove= Arrays.asList(bounce,defautMove,randomMove);
        Random rande = new Random();
        IStratMove elementMove=listeMove.get(rand.nextInt(listeMove.size()));
        
        VieIMovableDecorator alien = new VieIMovableDecorator(new AlienShip(game, x, y, spriteStore.getSprite("alien"), element,elementMove),2);

        
        //faire un random dans la liste pour return un des truc
        
        return alien;
    }
    
    @Override
    public IMovable createMur(double x,double y) {
    	return new Mur(game , x, y, spriteStore.getSprite("bricks") );
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createShip(int, int)
     */
    @Override
    public IMovable createShip(int x, int y) {
        IEtatVaisseau state= new VaisseauVulnerable(game,etat);
        return new PlayerShip(game, x, y, spriteStore.getSprite("ship"),state);
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createShot(int, int)
     */
    @Override
    public IMovable createShot(int x, int y) {
        IMovable shot = new Shoot(game, x, y, spriteStore.getSprite("shot"));
        return shot;
    }

}

