package io.github.fourohfour.divertion.gui;

import org.lwjgl.opengl.Display;

import io.github.fourohfour.divertion.game.Button;
import io.github.fourohfour.divertion.game.Gamestage;
import io.github.fourohfour.divertion.game.ReturnHomeInteraction;

public class DrawCredits {
	private static Button back = new Button(Display.getWidth() - 110, Display.getHeight() - 60, 100, 50, new ReturnHomeInteraction(), Gamestage.CREDITS);
	static {
	back.setFrameColour(new int[]{230, 220, 140});
	back.setText("Back");
	back.setScale(4);
    }
	public static void drawCredits(){
		
		TextProfiles.writeMain(10, Display.getHeight() - 37, "Game Made By FourOhFour");
		TextProfiles.writeMain(10, Display.getHeight() - 77, "Copyright FourOhFour 2014");
		TextProfiles.writeMain(10, Display.getHeight() - 117, "Community: reddit.com/r/Divertion");
		TextProfiles.writeMain(10, Display.getHeight() - 157, "My Homepage: fourohfour.github.io");
		TextProfiles.writeMain(10, Display.getHeight() - 197, "Game made using lwjgl and eclipse");
		TextProfiles.writeMain(10, Display.getHeight() - 237, "Want to support me? Please use the Dogecoin");
		TextProfiles.writeMain(10, Display.getHeight() - 277, "adress situated on my Homepage. Thanks!");
		TextProfiles.writeMain(10, Display.getHeight() - 357, "Have Fun!");
		
		ButtonDrawer.drawButton(back);
	}
}
