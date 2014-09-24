package io.github.fourohfour.divertion.map;

import java.util.Random;
import java.util.Set;

public class BiomeBand {
	private int reach;
	private int bsearch;
	private Terrain t;
	private Set<int[]> pts;

	public BiomeBand(Set<int[]> pts, int reach, int biomeSearchReach, Terrain t){
		this.pts = pts;
		this.reach = reach;
		this.bsearch = biomeSearchReach;
		
		this.t = t;
	}
	
	public int getReach(){
		return reach;
	}
	
	public boolean isContained(Random r, int x, int y){
		
		double sdist = Double.MAX_VALUE;
		for(int[] ia : pts){
		double dist = Math.sqrt((Math.pow(x - ia[0], 2) + (Math.pow(y - ia[1], 2))));
		if(dist < sdist){
			sdist = dist;
		}
		}
		
		if(reach > sdist){
			return true; 
		}
		return false;
	}
	
	public Terrain getTerrain(){
		return t;
	}
	
	public MapSquare[][] writeBand(MapSquare[][] map){
		for(int[] pt : pts){
			for(int x = pt[0] - reach; x < pt[0] + reach; x++){
				for(int y = pt[1] - reach; y < pt[1] + reach; y++){
					if((!((x > 1023) || (x < 0))) && (!((y > 1023) || (y < 0)))){
					    if(!(map[x][y].getTerrainSquare().t == Terrain.OCEAN)){
							double dist = Math.sqrt((Math.pow(x - pt[0], 2) + (Math.pow(y - pt[1], 2))));
							if(dist < reach){
								
								double[] colour = this.t.coloursAsArray();
								
								for(int bsearchx = pt[0] - bsearch; bsearchx < pt[0] + bsearch; bsearchx++){
									for(int bsearchy = pt[1] - bsearch; bsearchy < pt[1] + bsearch; bsearchy++){
										try{
											if(!(map[bsearchx][bsearchy].getTerrainSquare().t == this.t)){
												if(!(pt[0] == bsearchx && pt[1] == bsearchy)){									
												    double[] newcolour = map[bsearchx][bsearchy].getTerrainSquare().t.coloursAsArray();
												    
											    	for (int i = 0; i < 3; i++){
											    		colour[i] = newcolour[i];
												    }
												}
											}
										}
										catch(IndexOutOfBoundsException e){}
									}
								}
								
								map[x][y] = new MapSquare(new TerrainSquare(colour[0], colour[1], colour[2], this.t));
							}
						}
					}
				}
			}
		}
		return map;
	}
}
