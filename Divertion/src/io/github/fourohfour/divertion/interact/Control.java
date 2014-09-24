package io.github.fourohfour.divertion.interact;

import io.github.fourohfour.divertion.game.Gamestage;

public class Control {
	private Gamestage g;
	private ControlInteraction i;
	
	public Control(Gamestage g, ControlInteraction i){
		this.g = g;
		this.i = i;
	}
	public Gamestage getGamestage() {
		return g;
	}
	
	public ControlInteraction getInteraction(){
		return i;
		
	}

}
