package io.github.fourohfour.divertion.map;

public enum Terrain {
	PLAINS(0.32, 0.795, 0.04),
	DESERT(0.9, 0.8, 0.1),
	OCEAN(0.17, 0.03, 0.7),
	SNOW(0.9, 0.90, 0.9),
    MESA(0.45, 0, 0),
	RAINFOREST(0, 0.39, 0),
	MOUNTAINS(0, 0.39, 0);
	
	public final double r;
	public final double g;
	public final double b;
	
	Terrain(double r, double g, double b){
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	double[] coloursAsArray(){
		return new double[] {r, g, b};
	}
	
	static TerrainSquare mixColourToTerrainSquare(Terrain t, double factor){
		double[] mixed = t.mixColour(t.coloursAsArray(), factor);
		return new TerrainSquare(mixed[0], mixed[1], mixed [2], t);
	}
	
	static double[] mixColour(Terrain t, double factor){
		return t.mixColour(t.coloursAsArray(), factor);
	}
	
	double[] mixColour(double[] newcolours, double factor){
		double[] colours = this.coloursAsArray();
		
		for (int i = 0; i < 3; i++){
			if (newcolours[i] > colours[i]){
			    colours[i] += newcolours[i] * factor;
			    System.out.println("Adding: " + String.valueOf(newcolours[i] * factor));
			}
			else {
				colours[i] -= newcolours[i] * factor;
//			    System.out.println("Taking: " + String.valueOf(newcolours[i] * factor));
			}
		}
		
		return colours;
	}
	
	
}
