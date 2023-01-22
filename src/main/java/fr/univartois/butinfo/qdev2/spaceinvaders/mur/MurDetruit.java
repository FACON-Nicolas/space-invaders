package fr.univartois.butinfo.qdev2.spaceinvaders.mur;


public class MurDetruit implements IMursState {
	@Override
	public IMursState nextState() {
		return this;
		
}

	@Override
	public void handle(Mur m) {
		m.consume();
		
	}
	
}
