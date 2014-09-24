package io.github.fourohfour.displayutils.text;

public class GraphicChar {
	private Boolean[][] bitrepr;
	
	public GraphicChar(Boolean[][] b){
		this.bitrepr = b;
	}
	
	public Boolean getBit(int x, int y){
		boolean ret = bitrepr[bitrepr.length - y - 1][x];
		return ret;
	}
}
