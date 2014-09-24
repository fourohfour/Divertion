package io.github.fourohfour.divertion.item;

import io.github.fourohfour.divertion.utils.RGB;

public class BuiltItem {
	private String name;
	private int height;
	private int width;
	
	private RGB[][] item;
	
	public BuiltItem(String n, int h, int w){
		this.name = n;
		this.height = h;
		this.width = w;
		item = new RGB[width][height];
	}
	
	public String getName(){
		return name;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public RGB getAt(int x, int y){
		return item[x][y];
	}
	
	public void setAt(int x, int y, RGB r){
		this.item[x][y] = r;
	}
}
