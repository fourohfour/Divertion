package io.github.fourohfour.divertion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import io.github.fourohfour.displayutils.text.BasicFont;
import io.github.fourohfour.displayutils.text.TextWriter;
import io.github.fourohfour.divertion.game.Game;
import io.github.fourohfour.divertion.game.Gamestage;
import io.github.fourohfour.divertion.game.Player;
import io.github.fourohfour.divertion.game.World;
import io.github.fourohfour.divertion.gui.DrawCredits;
import io.github.fourohfour.divertion.gui.DrawHUD;
import io.github.fourohfour.divertion.gui.DrawMap;
import io.github.fourohfour.divertion.gui.DrawMapLoad;
import io.github.fourohfour.divertion.gui.DrawMenuScreen;
import io.github.fourohfour.divertion.gui.InventoryDrawer;
import io.github.fourohfour.divertion.gui.TextProfiles;
import io.github.fourohfour.divertion.interact.ControlManager;
import io.github.fourohfour.divertion.interact.InteractionManager;
import io.github.fourohfour.divertion.item.Item;
import io.github.fourohfour.divertion.map.DivertionMap;
import io.github.fourohfour.divertion.map.MapGenerator;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Divertion {
	Game g;
	
	/*
	 * 0 - Menu
	 * 1 - Game
	 */
	static Gamestage gamestage;
	private static InteractionManager im;
	private static ControlManager cm;
	public static boolean debug = false;
	public static DivertionMap map;
	public static Map<String, Integer> controls = new HashMap<>();
	static {
		controls.put("debug", Keyboard.KEY_F3);
		
		controls.put("mapup", Keyboard.KEY_W);
		controls.put("mapdown", Keyboard.KEY_S);
		controls.put("mapleft", Keyboard.KEY_A);
		controls.put("mapright", Keyboard.KEY_D);
		
		controls.put("zoomin", Keyboard.KEY_LSHIFT);
		controls.put("zoomout", Keyboard.KEY_SPACE);
	}
	
	private static Map<String, Item> items;
	public void gameLoop(){
		try{
		    Display.setDisplayMode(new DisplayMode(1200, 900));
		    Display.setFullscreen(false);
		    Display.create();
		}
		catch(LWJGLException ex){
			ex.printStackTrace();
		}
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Display.getWidth(), 0, Display.getHeight(), 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		g = new Game(new Player("Player"), new World());
		items = GetItems.getItems();
		
		Set<Integer> held = new HashSet<>();
		
		setGamestage(Gamestage.MENU);
		Display.setTitle("Divertion");
		
		while (!Display.isCloseRequested()) {
			GL11.glClearColor(0f, 0f, 0f, 0f);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
			
			Display.sync(120);
			while(Keyboard.next()){
				if(Keyboard.getEventKeyState()){
					if(Keyboard.getEventKey() == Keyboard.KEY_ESCAPE){
						System.exit(0);
					}
					if(Keyboard.getEventKey() == controls.get("debug")){
						if(debug){
							debug = false;
						}
						else{
							debug = true;
						}
					}
					cm.trigger(Keyboard.getEventKey());
					held.add(Keyboard.getEventKey());
				}
				else{
				    cm.untrigger(Keyboard.getEventKey());
				    held.remove(Integer.valueOf(Keyboard.getEventKey()));
				}
			}
			for(int i : held){
				cm.trigger(i);
			}
			
			GL11.glColor3d(divide225(108), divide225(123), divide225(139));
			
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2d(0.0, 0.0);
			GL11.glVertex2d(0.0, Display.getHeight());
			GL11.glVertex2d(Display.getWidth(), Display.getHeight());
			GL11.glVertex2d(Display.getWidth(), 0.0);
			GL11.glEnd();

			if(gamestage == Gamestage.MENU){
				DrawMenuScreen.drawMenu();
			}
			if(gamestage == Gamestage.GAME){
				DrawMap.drawMap(g);
			    DrawHUD.drawHUD(g);
				InventoryDrawer.drawInventory(g.getPlayer().getInventory());
			}
			if(gamestage == Gamestage.CREDITS){
			    DrawCredits.drawCredits();
			}
			if(gamestage == Gamestage.MAPLOAD){
			    DrawMapLoad.drawMapLoad();
			}
//			if (Mouse.isButtonDown(0)){
//			    im.tick(Mouse.getX(), Mouse.getY());
//			}
			while(Mouse.next()){
				if(Mouse.getEventButtonState()){
				im.tick(Mouse.getEventX(), Mouse.getEventY());
				}
			}

			Display.update();
	}
	}
	
	public static void main(String[] args){
		Divertion ec = new Divertion();
		im = new InteractionManager();
		cm = new ControlManager();
		ec.gameLoop();
	}
	
	public static double divide225(double d){
		return d/255;
	}
	
	public static InteractionManager getInteractionManager(){
		return im;
	}
	
	public static ControlManager getControlManager(){
		return cm;
	}
	
	public static void setGamestage(Gamestage i){
		gamestage = i;
	}
	
	public static Gamestage getGamestage(){
		return gamestage;
	}
	
	public static Item getItem(String name){
		return items.get(name);
	}
	

}
