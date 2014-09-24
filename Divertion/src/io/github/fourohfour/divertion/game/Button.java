package io.github.fourohfour.divertion.game;

import io.github.fourohfour.displayutils.text.BasicFont;
import io.github.fourohfour.displayutils.text.Font;
import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.interact.Hotspot;
import io.github.fourohfour.divertion.interact.Interaction;

public class Button {
	private int[] txtcolour = {0, 0, 0};
	private int[] framecolour = {0, 0, 0};
	private Font font = new BasicFont();
	private int scale = 1;
    private String text = "";
	private int x;
	private int y;
	private int width;
	private int height;
	private Hotspot h;
	private Interaction i;
	
	public Button(int x, int y, int width, int height, Interaction i, Gamestage g){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.h = new Hotspot(x, y, width, height, g);
		this.i = i;
		
		Divertion.getInteractionManager().addInteraction(this.h, this.i);
	}

	public int[] getTextColour() {
		return txtcolour;
	}

	public void setTextColour(int[] txtcolour) {
		this.txtcolour = txtcolour;
	}

	public int[] getFrameColour() {
		return framecolour;
	}

	public void setFrameColour(int[] framecolour) {
		this.framecolour = framecolour;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
}
