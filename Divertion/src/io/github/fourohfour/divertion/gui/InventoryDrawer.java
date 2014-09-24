package io.github.fourohfour.divertion.gui;

import io.github.fourohfour.displayutils.frame.FrameDrawer;
import io.github.fourohfour.divertion.game.Button;
import io.github.fourohfour.divertion.game.Gamestage;
import io.github.fourohfour.divertion.game.Inventory;
import io.github.fourohfour.divertion.game.InventoryVisibilityInteraction;

import org.lwjgl.opengl.Display;

public class InventoryDrawer {
	private static Button b = new Button(6, Display.getHeight() - 56, 300, 50, new InventoryVisibilityInteraction(), Gamestage.GAME);
	static {
		b.setFrameColour(new int[]{230, 220, 140});
		b.setText("Inventory");
		b.setScale(4);
	}
	public static void drawInventory(Inventory inv){
		int h = Display.getHeight();
		ButtonDrawer.drawButton(b);
		
		if(DrawHUD.showinv){
			FrameDrawer.colour = new int[]{230, 220, 140};
			FrameDrawer.drawFrame(300, h - 62, 6, 3);
		}
	}
}
