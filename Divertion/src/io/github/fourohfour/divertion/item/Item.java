package io.github.fourohfour.divertion.item;

import io.github.fourohfour.divertion.utils.RGB;

public class Item{

	private String name;
	private BuiltItem item;
	
	public Item(BuiltItem i) {
		name = i.getName();
		item = i;
	}

	public String getName() {
		return name;
	}
	
	public RGB getAt(int x, int y){
		return item.getAt(x, y);
	}
	
	public int getHeight(){
		return item.getHeight();
	}
	
	public int getWidth(){
		return item.getWidth();
	}
	
}
