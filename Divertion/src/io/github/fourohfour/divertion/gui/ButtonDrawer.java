package io.github.fourohfour.divertion.gui;

import io.github.fourohfour.displayutils.frame.FrameDrawer;
import io.github.fourohfour.displayutils.text.TextWriter;
import io.github.fourohfour.divertion.game.Button;

public class ButtonDrawer {
	public static void drawButton(Button b){
		FrameDrawer.colour = b.getFrameColour();
		FrameDrawer.drawFrame(b.getWidth(), b.getHeight(), b.getX(), b.getY());
		
		TextWriter writer = new TextWriter();
		writer.colour = b.getTextColour();
		writer.font = b.getFont();
		writer.scale = b.getScale();
		int w = writer.getLen(b.getText());
		int h = b.getFont().res * b.getScale();

		writer.write(b.getX() + ((b.getWidth() - w) / 2), b.getY() + ((b.getHeight() - h) / 2), b.getText());
	}
}
