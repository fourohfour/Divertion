package io.github.fourohfour.divertion.map;

import io.github.fourohfour.divertion.Divertion;
import io.github.fourohfour.divertion.gui.DrawMapLoad;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MapGenerator {
	private static int splitpoints = 5;
	private static int widenpasses = 5;
	private static int minwide = 1;
	private static int maxwide = 5;
	private static int seeds = 40;
	
	private static Map<Terrain, Integer> lats = new HashMap<>();
	static {
		lats.put(Terrain.DESERT, 600);
		lats.put(Terrain.SNOW, 100);
		lats.put(Terrain.MESA, 400);
		lats.put(Terrain.RAINFOREST, 500);
		lats.put(Terrain.MOUNTAINS, 950);
	}
	
	private static Map<Terrain, Integer> size = new HashMap<>();
	static {
		size.put(Terrain.DESERT, 35);
		size.put(Terrain.SNOW, 40);
		size.put(Terrain.MESA, 20);
		size.put(Terrain.RAINFOREST, 5);
		size.put(Terrain.MOUNTAINS, 40);
	}
	
	private static Map<Terrain, Integer> rarity = new HashMap<>();
	static {
		rarity.put(Terrain.DESERT, 20);
		rarity.put(Terrain.SNOW, 10);
		rarity.put(Terrain.MESA, 7);
		rarity.put(Terrain.RAINFOREST, 4);
		rarity.put(Terrain.MOUNTAINS, 30);
	}
	
	public static DivertionMap generateMap(long seed){
		Random rand = new Random();
		rand.setSeed(seed);
		
		MapSquare[][] map = new MapSquare[1024][1024];
		DrawMapLoad.message = "Creating Continents...";
		for(int x = 0; x < 1024; x++){
			for(int y = 0; y < 1024; y++){
				if(y < 11 || y > 1012){
				    map[x][y] = new MapSquare(Terrain.OCEAN);
				}
				else{
					map[x][y] = new MapSquare(Terrain.PLAINS);
				}
			}
		}
		for(int spliti = 0; spliti < splitpoints; spliti++){
			int a = rand.nextInt();
		}
		DrawMapLoad.message = "Flooding Pools and Puddles...";
		for(int i = 0; i < seeds; i++){
			int x = rand.nextInt(1020) + 3;
			int y = rand.nextInt(1020) + 3;
			
			map[x][y] = new MapSquare(Terrain.OCEAN);
			map[x + 1][y] = new MapSquare(Terrain.OCEAN);
			map[x][y + 1] = new MapSquare(Terrain.OCEAN);
			map[x - 1][y] = new MapSquare(Terrain.OCEAN);
			map[x][y - 1] = new MapSquare(Terrain.OCEAN);
		}
		
		DrawMapLoad.message = "Simulating Continental Drift...";
		//Widen Pass
		for(int w = 0 ; w < widenpasses; w++){
			MapSquare[][] newmap = map;
			for(int x = 0; x < 1024; x++){
				for(int y = 0; y < 1024; y++){
					if(map[x][y].getTerrainSquare().t == Terrain.OCEAN){
						int direction = rand.nextInt(4);
						try{
						switch(direction){
						case 0:
							newmap[x + 1][y] = new MapSquare(Terrain.OCEAN);
						case 1:
							newmap[x - 1][y] = new MapSquare(Terrain.OCEAN);
						case 2:
							newmap[x][y + 1] = new MapSquare(Terrain.OCEAN);
						case 3:
							newmap[x][y - 1] = new MapSquare(Terrain.OCEAN);
						}
						}
						catch(ArrayIndexOutOfBoundsException e){
							
						}
					}
				}
				if(x % 10 == 0 && x < 1001){
					DrawMapLoad.progress = Integer.valueOf(((x / 10)/widenpasses) + (100/widenpasses) * w);
				}
			}
			map = newmap;
		}
		
		//Biome Builder

		DrawMapLoad.message = "Adding Biomes...";
		Set<BiomeBand> bset = new HashSet<>();
		for(Terrain t : Terrain.values()){
			if(! (t == Terrain.OCEAN || t == Terrain.PLAINS)){
				for(int ip = 0; ip < rarity.get(t); ip++){
					int slat = rand.nextInt(1024);
				    int slong = lats.get(t) + rand.nextInt(200) - 100;
					Set<int[]> pts = new HashSet<>();
					pts.add(new int[]{slat, slong});
					for(int d =0; d < 7; d++){
					    int dlat = slat + (rand.nextInt(200) - 100);
					    int dlong = slong + rand.nextInt(26) - 13;
					    pts.add(new int[]{dlat, dlong});
					}
					int reach = rand.nextInt(50) + size.get(t);
					
					BiomeBand b = new BiomeBand(pts, reach, 5, t);
					bset.add(b);
				}
			}
		}
		
		DrawMapLoad.message = "Changing the face of the earth...";
		
		int bands = bset.size();
		double factor = 100 / bands;
		int count = 0;
		for(BiomeBand band : bset){
			DrawMapLoad.progress = Double.valueOf(factor * count).intValue();
			map = band.writeBand(map);
			count++;
		}
		
		DrawMapLoad.message = "Roughening Boarders...";
		
		MapSquare[][] newmap = map;
		for(int x = 0; x < 1024; x++){
			for(int y = 0; y < 1024; y++){
				if(!(map[x][y].getTerrainSquare().t == Terrain.OCEAN)){
					Terrain t = map[x][y].getTerrainSquare().t;
					int widen = rand.nextInt(maxwide - minwide) + minwide;
					for (int wx = x - (widen / 2); wx < x + (widen / 2); wx++){
						if(wx < 0){
							wx = 0;
						}
						else if(wx > 1023){
							break;
						}
						for (int wy = y - (widen / 2); wy < y + (widen / 2); wy++){
							if(wy < 0){
								wy = 0;
							}
							else if(wy > 1023){
								break;
							}
//							if(!(newmap[wx][wy].t == Terrain.OCEAN)){
							newmap[wx][wy] = new MapSquare(t);
//							}
						}
					}
				}
			}
			if(x % 10 == 0 && x < 1001){
				DrawMapLoad.progress = Integer.valueOf(x / 10);
			}
		}
		map = newmap;
		
		DivertionMap dmap = new DivertionMap(map, seed);
		
		DrawMapLoad.message = "Growing New Life...";
		
		for(int x = 0; x < 1024; x++){
			for(int y = 0; y < 1024; y++){
				if(dmap.getSquare(x, y).getTerrainSquare().t == Terrain.PLAINS){
					int spawntree = rand.nextInt(1000);
					if(spawntree == 0){
						dmap.setItemAt(x, y, Divertion.getItem("Oak Tree"));
					}
				}
				
				else if(dmap.getSquare(x, y).getTerrainSquare().t == Terrain.RAINFOREST){
					int spawntree = rand.nextInt(200);
					if(spawntree == 0){
						dmap.setItemAt(x, y, Divertion.getItem("Jungle Tree"));
					}
				}
				else if(dmap.getSquare(x, y).getTerrainSquare().t == Terrain.MOUNTAINS){
					int spawntree = rand.nextInt(2000);
					if(spawntree == 0){
						int xsize = rand.nextInt(50);
						int ysize = rand.nextInt(50);
						for(int px = x - (xsize / 2); px < x + (xsize / 2); px++){
							for(int py = y - (ysize / 2); py < y + (ysize / 2); py++){
								if (!((px < 0) || (py < 0))){
									if (!((px > 1023) || (py > 1023))){
								if(map[px][py].getTerrainSquare().t == Terrain.MOUNTAINS){
								    int place = rand.nextInt(50);
								    if(place == 0){
						                dmap.setItemAt(px, py, Divertion.getItem("Mountain"));
								    }
								}
								}
								}
							}
						}
					}
				}
				else if(dmap.getSquare(x, y).getTerrainSquare().t == Terrain.SNOW){
					int spawntree = rand.nextInt(5000);
					if(spawntree == 0){
						dmap.setItemAt(x, y, Divertion.getItem("Mountain"));
					}
				}
				else if(dmap.getSquare(x, y).getTerrainSquare().t == Terrain.DESERT){
					int spawntree = rand.nextInt(500);
					if(spawntree == 0){
						dmap.setItemAt(x, y, Divertion.getItem("Cactus"));
					}
				}
			}
			if(x % 10 == 0 && x < 1001){
				DrawMapLoad.progress = Integer.valueOf(x / 10);
			}
		}
		return dmap;
	}
}
