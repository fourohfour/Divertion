package io.github.fourohfour.divertion.game;

import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.interact.Interaction;

public class CreditsButtonInteraction implements Interaction{

	@Override
	public void onInteract() {
		Divertion.setGamestage(Gamestage.CREDITS);
	}

}
