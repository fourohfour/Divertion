package io.github.fourohfour.divertion.map;

import java.util.ArrayList;
import java.util.List;

public class River {
	public static int LEFT = 1;
	public static int RIGHT = 2;
	public static int FORWARD = 0;
	public List<Integer> path;
	
	public River(){
		path = new ArrayList<>();
	}
}
