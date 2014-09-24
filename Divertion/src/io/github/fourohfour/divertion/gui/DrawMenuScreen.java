package io.github.fourohfour.divertion.gui;

import org.lwjgl.opengl.Display;
import io.github.fourohfour.displayutils.text.BasicFont;
import io.github.fourohfour.displayutils.text.TextWriter;
import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.game.Button;
import io.github.fourohfour.divertion.game.CreditsButtonInteraction;
import io.github.fourohfour.divertion.game.Gamestage;
import io.github.fourohfour.divertion.game.PlayButtonInteraction;

public class DrawMenuScreen {
	private static int mw = (Display.getWidth() / 2);
	private static int mh = (Display.getHeight() / 2);
	
	private static Button b = new Button(mw - 150, mh - 55, 300, 100, new PlayButtonInteraction(), Gamestage.MENU);
	static {
		b.setFrameColour(new int[]{230, 220, 140});
		b.setScale(4);
		b.setText("Play Game");
	}
	
	private static Button c = new Button(mw - 150, mh - 185, 300, 100, new CreditsButtonInteraction(), Gamestage.MENU);
	static {
		c.setFrameColour(new int[]{230, 220, 140});
		c.setScale(4);
		c.setText("Credits");
	}
	public static void drawMenu(){	
		TextProfiles.writeTitle(mw - 220, mh + 100, "Divertion");
		TextWriter creditwriter = new TextWriter();
		
		creditwriter.font = new BasicFont();
		creditwriter.scale = 2;
		
		creditwriter.write(mw - 110, mh + 70, "A FourOhFour Production");
		
		ButtonDrawer.drawButton(b);
		ButtonDrawer.drawButton(c);
		
		
		if(Divertion.debug){
		    TextProfiles.writeHeader(10, 10, "v0.1-alpha");
		}
		
	}
}
