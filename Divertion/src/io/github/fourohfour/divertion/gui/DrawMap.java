package io.github.fourohfour.divertion.gui;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import io.github.fourohfour.displayutils.text.BasicFont;
import io.github.fourohfour.displayutils.text.TextWriter;
import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.game.Game;
import io.github.fourohfour.divertion.map.DivertionMap;
import io.github.fourohfour.divertion.map.MapSquare;
import io.github.fourohfour.divertion.map.Terrain;

public class DrawMap {
	public static void drawMap(Game g){
		DivertionMap m = Divertion.map;
		int h = Display.getHeight();
		int w = Display.getWidth();
		int[] c = m.getCrosshair();
		int z = m.getZoom();
		
		int[] bl = new int[]{((c[0] * z) - (w / 2)) / z, ((c[1] * z) - (h / 2)) / z};
		
		for(int i1 = bl[0]; i1 < 1024; i1++){
			for(int i2 = bl[1]; i2 < 1024; i2++){
				if(!(i1 < 0) && !(i2 < 0)){
				MapSquare s = m.getSquare(i1, i2);
				int x = (i1 - bl[0]) * z;
				int y = (i2 - bl[1]) * z;
				
				double[] newcols = {s.getTerrainSquare().r, s.getTerrainSquare().g, s.getTerrainSquare().b};
				double[] tercols = {s.getTerrainSquare().t.r, s.getTerrainSquare().t.g, s.getTerrainSquare().t.b};
				if(newcols == tercols){
					System.out.println("True");
				}
				GL11.glColor3d(s.getTerrainSquare().r, s.getTerrainSquare().g, s.getTerrainSquare().b);
				
				
				GL11.glBegin(GL11.GL_QUADS);
				GL11.glVertex2d(x, y);
				GL11.glVertex2d(x, y + z);
				GL11.glVertex2d(x + z, y + z);
				GL11.glVertex2d(x + z, y);
				GL11.glEnd();
				
				}
			}
		}
		
		for(int i1 = bl[0]; i1 < 1024; i1++){
			for(int i2 = bl[1]; i2 < 1024; i2++){
				int x = (i1 - bl[0]) * z;
				int y = (i2 - bl[1]) * z;
				
				int scale = 1;
				
				if(z > 4){
					scale = 2;
				}
				if(!(m.getItemAt(i1, i2) == null )){
					DrawItem.drawItem(m.getItemAt(i1, i2), Double.valueOf((x + Math.floor(scale / 2)) - Math.floor(m.getItemAt(i1, i2).getWidth() / 2)).intValue() , y, scale);
				}
			}
			
		}
		
		
	}
}
