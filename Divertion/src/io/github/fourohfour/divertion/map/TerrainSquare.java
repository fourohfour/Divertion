package io.github.fourohfour.divertion.map;

public class TerrainSquare {
	public final double r;
	public final double g;
	public final double b;
	public final Terrain t;
	
	public TerrainSquare(double r, double g, double b, Terrain t){
		this.r = r;
		this.g = g;
		this.b = b;
		this.t = t;
	}
	
	public String toString(){
		return t.name() + ": " + String.valueOf(r) +  " " + String.valueOf(g) + " " + String.valueOf(b);
	}
}
