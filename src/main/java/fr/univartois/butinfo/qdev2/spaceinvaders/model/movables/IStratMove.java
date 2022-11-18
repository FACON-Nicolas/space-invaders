package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;

public interface IStratMove {

    void initialSpeed(IMovable alien);

    boolean move(IMovable alien, SpaceInvadersGame game, long delta);

}
