package io.github.fourohfour.divertion.game;

import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.interact.ControlInteraction;

public class MoveCrosshairInteraction implements ControlInteraction{

	@Override
	public void onInteract(int i) {
		int[] cross = Divertion.map.getCrosshair();
		if(i == Divertion.controls.get("mapup")){
		    Divertion.map.setCrosshair(new int[]{cross[0], cross[1] + 5});
		}
		else if(i == Divertion.controls.get("mapdown")){
		    Divertion.map.setCrosshair(new int[]{cross[0], cross[1] - 5});
		}
		else if(i == Divertion.controls.get("mapleft")){
		    Divertion.map.setCrosshair(new int[]{cross[0] - 5, cross[1]});
		}
		else if(i == Divertion.controls.get("mapright")){
		    Divertion.map.setCrosshair(new int[]{cross[0] + 5, cross[1]});
		}
	}

	@Override
	public void onRelease(int i) {
		
	}

}
