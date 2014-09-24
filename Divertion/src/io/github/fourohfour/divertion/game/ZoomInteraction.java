package io.github.fourohfour.divertion.game;

import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.interact.ControlInteraction;

public class ZoomInteraction implements ControlInteraction {
	int holdtick = 10;
	@Override
	public void onInteract(int i) {
		int zoom = Divertion.map.getZoom();
		if(holdtick ==10){
		if(i == Divertion.controls.get("zoomin")){
			zoom++;
			if(zoom > 10){
				zoom = 10;
			}
		}
		else if (i == Divertion.controls.get("zoomout")){
			zoom--;
			if(zoom == 0){
				zoom = 1;
			}
		}
		Divertion.map.setZoom(zoom);
		holdtick = 0;
		}
		else{
			holdtick++;
		}
	}

	@Override
	public void onRelease(int i) {
		holdtick = 10;
		
	}

}
