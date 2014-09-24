package io.github.fourohfour.divertion.interact;

import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.game.Gamestage;

import java.util.HashMap;
import java.util.Map;

public class InteractionManager {
	private Map<Hotspot, Interaction> intermap;
	
	public InteractionManager(){
		this.intermap = new HashMap<>();
	}
	
	public void addInteraction(Hotspot h, Interaction i){
		intermap.put(h, i);
	}
	
	public void tick(int x, int y){
		for(Hotspot h : intermap.keySet()){
			if(h.getGroup() == Divertion.getGamestage()){
		    	if(h.isContained(x, y)){
			    	intermap.get(h).onInteract();
			    }
			}
		}
	}
}
