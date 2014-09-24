package io.github.fourohfour.divertion.map;


public class MapSquare {
	public TerrainSquare t;
	
	public MapSquare(TerrainSquare t){
		this.t = t;
	}
	
	public MapSquare(Terrain t){
		this.t = new TerrainSquare(t.r, t.g, t.b, t);
	}
	
	public TerrainSquare getTerrainSquare(){
		return t;
	}
}
