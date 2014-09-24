package io.github.fourohfour.displayutils.frame;

import org.lwjgl.opengl.GL11;

public class FrameDrawer {
	public static int[] colour = {0, 0, 0};
	public static void drawFrame(int width, int height, int cornerx, int cornery){
		GL11.glColor3d(divide225(colour[0]), divide225(colour[1]), divide225(colour[2]));
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2d(cornerx, cornery);
		GL11.glVertex2d(cornerx, cornery + height);
		GL11.glVertex2d(cornerx + width, cornery + height);
		GL11.glVertex2d(cornerx + width, cornery);
		GL11.glEnd();
		
		GL11.glColor3d(divide225(colour[0] + 20), divide225(colour[1] + 20), divide225(colour[2] + 20));
		
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2d(cornerx + 7, cornery + 7);
		GL11.glVertex2d(cornerx + 7, cornery + height - 7);
		GL11.glVertex2d(cornerx + width - 7, cornery + height - 7);
		GL11.glVertex2d(cornerx + width - 7, cornery + 7);
		GL11.glEnd();
	}
	private static double divide225(double i) {
		return i/255;
	}
}
