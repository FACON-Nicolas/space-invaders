/**
 * Ce fichier fait partie du projet Space Invaders.
 *
 * (c) 2023 gasto
 * Tous droits r�serv�s.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import java.util.Arrays;
import java.util.List;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;

/**
 * Le type StratMoveComposite
 *
 * @author gasto
 *
 * @version 0.1.0
 */
public class StratMoveComposite implements IStratMove{
    
    private IStratMove bounce=new BounceMove();
    private IStratMove defautMove=new DefaultMove();
    private IStratMove randomMove=new RandomMove();
    
    private List<IStratMove> listeMove= Arrays.asList(bounce,defautMove,randomMove);
    private SpaceInvadersGame game;
    
    public StratMoveComposite(SpaceInvadersGame game) {
            this.game=game;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IStratMove#initialSpeed(fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable)
     */
    @Override
    public void initialSpeed(IMovable alien) {
        int position=alien.getX();
        if(position<(game.getWidth()/listeMove.size())) {
            alien.setVerticalSpeed(1);
            defautMove.initialSpeed(alien);
        }
        else if (position>=game.getWidth()/listeMove.size() && position<(game.getWidth()/listeMove.size())*2) {
            alien.setVerticalSpeed(100);
            bounce.initialSpeed(alien);
        }
        else {
            alien.setVerticalSpeed(1);
            randomMove.initialSpeed(alien);
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IStratMove#move(fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable, fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame, long)
     */
    @Override
    public boolean move(IMovable alien, SpaceInvadersGame game, long delta) {
       
        int position=alien.getX();
        if(position<(game.getWidth()/listeMove.size())) {
            alien.setVerticalSpeed(1);
            return defautMove.move(alien, game, delta);
        }
        else if (position>=game.getWidth()/listeMove.size() && position<(game.getWidth()/listeMove.size())*2) {
            alien.setVerticalSpeed(100);
            return bounce.move(alien, game, delta);
        }
        else {
            alien.setVerticalSpeed(1);

            return randomMove.move(alien, game, delta);
        }
    
    }

}

