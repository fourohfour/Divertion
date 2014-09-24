package io.github.fourohfour.divertion.gui;

import org.lwjgl.opengl.GL11;

import io.github.fourohfour.divertion.item.Item;
import io.github.fourohfour.divertion.utils.RGB;

public class DrawItem {
	public static void drawItem(Item i, int x, int y, int scale){
		for(int bitx = 0; bitx < i.getWidth(); bitx++){
			for(int bity = 0; bity < i.getHeight(); bity++){
				int curx = x + (bitx * scale);
				int cury = y + (bity * scale);
				RGB c = i.getAt(bitx, bity);
				
				double red = c.getR() / 255.0;
				double green = c.getG() / 255.0;
				double blue = c.getB() / 255.0;
	
				
				if(!(red > 1)){
					GL11.glColor3d(red, green, blue);
					
				    GL11.glBegin(GL11.GL_QUADS);
				    GL11.glVertex2f(curx + scale, cury + scale);
	
				    GL11.glVertex2f(curx, cury + scale);
	
				    GL11.glVertex2f(curx, cury);
	
				    GL11.glVertex2f(curx + scale, cury);
				    
				    GL11.glEnd();
				}
			}
		}
	}
}
