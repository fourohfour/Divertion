package io.github.fourohfour.divertion.game;

import io.github.fourohfour.divertion.gui.DrawHUD;
import io.github.fourohfour.divertion.interact.Interaction;

public class InventoryVisibilityInteraction implements Interaction{

	@Override
	public void onInteract() {
		if(DrawHUD.showinv){
			DrawHUD.showinv = false;
		}
		else{
			DrawHUD.showinv = true;
		}
	}

}
