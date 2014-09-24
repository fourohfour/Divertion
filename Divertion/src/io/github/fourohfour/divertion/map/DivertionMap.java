package io.github.fourohfour.divertion.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.lwjgl.input.Keyboard;

import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.game.Gamestage;
import io.github.fourohfour.divertion.game.MoveCrosshairInteraction;
import io.github.fourohfour.divertion.game.NPC;
import io.github.fourohfour.divertion.game.ZoomInteraction;
import io.github.fourohfour.divertion.interact.Control;
import io.github.fourohfour.divertion.item.Item;


public class DivertionMap {
	private int[] crosshair = new int[] {512, 512};
	private int zoom = 2;
	
	private MapSquare[][] map;
	private Set<NPC> npcs = new HashSet<>();
	private Map<String, Item> items;
	
	private long seed;

	public DivertionMap(MapSquare[][] map, long s){
		this.map = map;
		this.seed = s;
		this.items = new HashMap<>();
		
		Control c = new Control(Gamestage.GAME, new MoveCrosshairInteraction());
		Divertion.getControlManager().addControl(Divertion.controls.get("mapup"), c);
		Divertion.getControlManager().addControl(Divertion.controls.get("mapdown"), c);
		Divertion.getControlManager().addControl(Divertion.controls.get("mapleft"), c);
		Divertion.getControlManager().addControl(Divertion.controls.get("mapright"), c);
		
		Control zc = new Control(Gamestage.GAME, new ZoomInteraction());
		Divertion.getControlManager().addControl(Divertion.controls.get("zoomin"), zc);
		Divertion.getControlManager().addControl(Divertion.controls.get("zoomout"), zc);
		
	}
	
	public MapSquare getSquare(int x, int y){
		return map[x][y];
	}
	
	public void setSquare(int x, int y, MapSquare s){
		map[x][y] = s;
	}

	public int[] getCrosshair() {
		return crosshair;
	}

	public void setCrosshair(int[] crosshair) {
		this.crosshair = crosshair;
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public long getSeed() {
		return seed;
	}
	
	public void setItemAt(int x, int y, Item i){
		items.put(x + " " + y  , i);
	}
	
	public Item getItemAt(int x, int y){
		return items.get(x + " " + y);
	}
}
