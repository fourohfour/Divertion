package io.github.fourohfour.divertion.game;

import java.util.Random;

import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.interact.Interaction;
import io.github.fourohfour.divertion.map.MapGenerator;

public class PlayButtonInteraction implements Interaction{

	@Override
	public void onInteract() {
		Divertion.setGamestage(Gamestage.MAPLOAD);
		final Random rand = new Random();
		Runnable r = new Runnable(){

			@Override
			public void run() {
				Divertion.map = MapGenerator.generateMap(rand.nextLong()); 
				Divertion.setGamestage(Gamestage.GAME);
			}
		};
		new Thread(r).start();
	}

}
