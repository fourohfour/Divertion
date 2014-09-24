package io.github.fourohfour.displayutils.text;

import io.github.fourohfour.displayutils.text.GraphicChar;

import java.util.HashMap;
import java.util.Map;

public class Font {
	protected Map<Character, GraphicChar> font;
	public int space = 1;
	public int res = 2;
	
	public GraphicChar DefaultGC = null;
	
	public Font(){
		this.font = new HashMap<Character, GraphicChar>();
		this.setFont();
	}

	protected void setFont() {
		DefaultGC = new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}});
		this.font.put('A', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
		this.font.put('B', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
		this.font.put('C', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
		this.font.put('D', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
		this.font.put('E', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
		this.font.put('F', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
		this.font.put('G', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
		this.font.put('H', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
		this.font.put('I', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
		this.font.put('J', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
		this.font.put('K', new GraphicChar(new Boolean[][] {new Boolean[] {true},new Boolean[] {true}}));
	}
	
	public GraphicChar getChar(Character c){
		if(!(font.get(c) == null)){
			return font.get(c);
		}
		else if(Character.isLetter(c)){
			if(Character.isUpperCase(c)){
				if(!(font.get(Character.toLowerCase(c)) == null)){
					return font.get(Character.toLowerCase(c));
				}
			}
			else if(Character.isLowerCase(c)){
				if(!(font.get(Character.toUpperCase(c)) == null)){
					return font.get(Character.toUpperCase(c));
				}
			}
		}
		
		return null;
	}
}
