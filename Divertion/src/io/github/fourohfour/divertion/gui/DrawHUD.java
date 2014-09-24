package io.github.fourohfour.divertion.gui;

import org.lwjgl.opengl.Display;

import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.game.Button;
import io.github.fourohfour.divertion.game.Game;
import io.github.fourohfour.divertion.game.Gamestage;
import io.github.fourohfour.divertion.game.Player;
import io.github.fourohfour.divertion.game.ReturnHomeInteraction;

public class DrawHUD {
	public static boolean showinv = false;
	private static Button back = new Button(Display.getWidth() - 110, Display.getHeight() - 60, 100, 50, new ReturnHomeInteraction(), Gamestage.GAME);
	static {
		back.setFrameColour(new int[]{230, 220, 140});
		back.setText("Back");
		back.setScale(4);
	}
	
	public static void drawHUD(Game g){
		ButtonDrawer.drawButton(back);
		
		
		if(Divertion.debug){
			String z = "Zoom: " + Divertion.map.getZoom();
			String c = "Coords: " + Divertion.map.getCrosshair()[0] + " " + Divertion.map.getCrosshair()[1];
			String s = "Seed: " + Divertion.map.getSeed();
			String b = "Biome: None";
			try{
			    b = "Biome: " + Divertion.map.getSquare(Divertion.map.getCrosshair()[0], Divertion.map.getCrosshair()[1]).t.toString();
			}
			catch(IndexOutOfBoundsException e){ 
			}
		    TextProfiles.writeMain(Display.getWidth() - TextProfiles.mainLength(z) - 10, 10, z);
		    TextProfiles.writeMain(Display.getWidth() - TextProfiles.mainLength(c) - 10, 40, c);
		    TextProfiles.writeMain(Display.getWidth() - TextProfiles.mainLength(s) - 10, 70, s);
		    TextProfiles.writeMain(Display.getWidth() - TextProfiles.mainLength(b) - 10, 100, b);
		}
	}
}
