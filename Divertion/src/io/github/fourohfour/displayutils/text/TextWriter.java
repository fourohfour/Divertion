package io.github.fourohfour.displayutils.text;

import io.github.fourohfour.displayutils.text.Font;
import io.github.fourohfour.displayutils.text.GraphicChar;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class TextWriter {
	public Font font = new Font();
	public int scale = 1;
	public int displayX = Display.getWidth();
	public int displayY = Display.getHeight();
	public int[] colour = new int[]{0,0,0};
	
	public int[] write(int x, int y, String s){
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, displayX, 0, displayY, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		int oldy = y;
		int oldx = x;
		
		GL11.glColor3d(divide225(colour[0]),divide225(colour[1]),divide225(colour[2]));
		int ccount = 0;
	    for(Character c : s.toCharArray()){
	    	GraphicChar gc = font.getChar(c);
	    	if(gc == null){
	    		gc = font.DefaultGC;
	    		if(gc == null){
	    			return null;
	    		}
	    	}
	    	for(int cy = 0; cy < font.res; cy++){
	    		for(int cx = 0; cx < font.res/2; cx++){
	    			if(gc.getBit(cx, cy)){
	    				
	    			    GL11.glBegin(GL11.GL_QUADS);
	    			    GL11.glVertex2f(x + scale, y + scale);

	    			    GL11.glVertex2f(x, y + scale);

	    			    GL11.glVertex2f(x, y);

	    			    GL11.glVertex2f(x + scale, y);
	    			    
	    			    GL11.glEnd();
	    			}
	    			x = x + scale;
	    		}
	    		y = y + scale;
	    		x = x - (scale*font.res/2);
	    	}
	    	ccount++;
	    	
	    	y = oldy;
	    	x = oldx + ((ccount*(font.res/2))*scale+(ccount*font.space)*scale);
	    }
	    return new int[]{x, y};
	}
	
	public static Double divide225(double d){
		return d/255;
	}
	
	public int getLen(String s){
		return scale*((s.length() * (font.res/2)) + (s.length() - 1));
	}
}
