package io.github.fourohfour.divertion.interact;

import io.github.fourohfour.divertion.Divertion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ControlManager {
	private Map<Integer, Set<Control>> cmap;
	
	public ControlManager(){
		this.cmap = new HashMap<>();
	}
	
	public void addControl(int key, Control c){
		Set<Control> cset = cmap.get(key);
		if(cset == null){
			cset = new HashSet<>();
		}
		cset.add(c);
		cmap.put(key, cset);
	}
	
	public void trigger(int key){
		Set<Control> cset = cmap.get(key);
		if(!(cset == null)){
		for(Control c : cset){
		    if(c.getGamestage() == Divertion.getGamestage()){
	  	    	c.getInteraction().onInteract(key);
		    }
		}
		}
	}
	
	public void untrigger(int key){
		Set<Control> cset = cmap.get(key);
		if(!(cset == null)){
		for(Control c : cset){
		    if(c.getGamestage() == Divertion.getGamestage()){
	  	    	c.getInteraction().onRelease(key);
		    }
		}
		}
	}
}
