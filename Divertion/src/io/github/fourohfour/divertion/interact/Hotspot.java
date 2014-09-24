package io.github.fourohfour.divertion.interact;

import io.github.fourohfour.divertion.game.Gamestage;

public class Hotspot {
	private int x, y, w, h;
	private Gamestage n;
	
	public Hotspot(int x, int y, int w, int h, Gamestage g){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.n = g;
	}
	
	public boolean isContained(int x, int y){
		if(x >= this.x && x <= this.x + w){
			if(y >= this.y && y <= this.y + h){
				return true;
			}
		}
		return false;
	}
	
	public Gamestage getGroup(){
		return this.n;
	}
}
