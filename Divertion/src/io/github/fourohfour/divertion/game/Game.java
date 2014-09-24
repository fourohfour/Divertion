package io.github.fourohfour.divertion.game;

import io.github.fourohfour.divertion.map.DivertionMap;

public class Game {
	public Player p;
	private World w;
	
	public Game(Player p, World w){
		this.p = p;
		this.w = w;
	}

	public Player getPlayer() {
		return p;
	}
	
	public World getWorld(){
		return w;
	}
}
