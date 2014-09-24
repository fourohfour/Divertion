package io.github.fourohfour.divertion.map;

public class LEGACYGenPointForCircle {
	public int[] coords;
	public int reach;
	public Terrain type;
	
	public LEGACYGenPointForCircle(int[] c, int r, Terrain t){
		this.coords = c;
		this.reach = r;
		this.type = t;
	}
	
	public boolean isIn(int checkx, int checky){
		double hyp = Math.sqrt((Math.pow(coords[0] - checkx, 2) + (Math.pow(coords[1] - checky, 2))));
		if(hyp < reach){
			return true;
		}
		return false;
	}
}
