package io.github.fourohfour.divertion.gui;

import io.github.fourohfour.displayutils.text.BasicFont;
import io.github.fourohfour.displayutils.text.TextWriter;

public class TextProfiles {
	public static void writeHeader(int x, int y, String str){
		TextWriter w = new TextWriter();
		w.font = new BasicFont();
		w.scale = 4;
		w.colour = new int[]{0, 123, 139};
		w.write(x - 2, y - 2, str);
		w.colour = new int[]{0, 0, 0};
		w.write(x, y, str);
	}
	
	public static void writeTitle(int x, int y, String str){
		TextWriter w = new TextWriter();
		w.font = new BasicFont();
		w.scale = 10;
		w.colour = new int[]{195, 42, 42};
		w.write(x - 3, y - 3, str);
		w.colour = new int[]{0, 0, 0};
		w.write(x, y, str);
	}
	
	public static void writeMain(int x, int y, String str){
		TextWriter w = new TextWriter();
		w.font = new BasicFont();
		w.scale = 3;
		w.colour = new int[]{20, 20, 20};
		w.write(x, y, str);
	}
	public static int mainLength(String s){
		TextWriter w = new TextWriter();
		w.font = new BasicFont();
		w.scale = 3;
		return w.getLen(s);
	}
}
