package io.github.fourohfour.divertion.gui;

public class DrawMapLoad {
	public static String message = "Creating Map...";
	public static int progress = 0;
	
	public static void drawMapLoad(){
		TextProfiles.writeHeader(10, 10, message + " " + progress);
	}
}
