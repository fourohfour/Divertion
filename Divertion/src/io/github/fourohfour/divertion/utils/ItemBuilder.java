package io.github.fourohfour.divertion.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import io.github.fourohfour.divertion.item.BuiltItem;

public class ItemBuilder {
	public static BuiltItem buildItem(File f) throws FileReadException{
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		int search = 0;
		
		int height = 0;
		int width = 0;
		String name = null;
		
		BuiltItem i = null;
		RGB copy = null;
		int tracex = 0;
		int tracey = 0;
		
		int ln = 1;
		while(s.hasNext()){
			String str = s.next();
			//Look For Head
			if(search == 0){
				if(str.equalsIgnoreCase("HEAD")){
					search = 1;
				}
			}
			
			//Read Head
			else if(search == 1){
				if(str.equalsIgnoreCase("BODY")){
					i = new BuiltItem(name, height, width);
					search = 2;
				}
			    else if (str.equalsIgnoreCase("height")){
					search = 3;
				}
				else if(str.equalsIgnoreCase("width")){
					search = 4;
				}
				else if(str.equalsIgnoreCase("name")){
					search = 5;
				}
			}
			
			//Read Body
			else if(search == 2){
				RGB val = null;
				if(str.equalsIgnoreCase("c")){
					if(copy  == null){
						throw new FileReadException("Cannot copy from null", name, f.getPath(), ln);
					}
					val = copy;
				}
				else{
					String[] colours = str.split(";");
					int r, g, b;
					try{
					    r = Integer.valueOf(colours[0]);
					    g = Integer.valueOf(colours[1]);
					    b = Integer.valueOf(colours[2]);
					}
					catch (NumberFormatException ex){
						throw new FileReadException("That ain't no number!", name, f.getPath(), ln);
					}
					catch (IndexOutOfBoundsException ex){
						throw new FileReadException("Missin' some colons there chappy!", name, f.getPath(), ln);
					}
					//Any errors here and ah well.
					
					val = new RGB(r, g, b);
					copy = val;
				}
				i.setAt(tracex, tracey, val);
				tracey++;
				if(tracey == height){
					tracex++;
					tracey = 0;
				}
				if(tracex == width){
					break;
				}
				
			}
			
			//Check for Height Value
			else if (search == 3){
				try{
				    height = Integer.valueOf(str);
				    search = 1;
				}
				catch (NumberFormatException ex){
					throw new FileReadException("That ain't no number!", name, f.getPath(), ln);
				}
				
			}
			
			//Check for Width Value (yea this is a bad way of doing it)
			else if (search == 4){
				try{
				    width = Integer.valueOf(str);
				    search = 1;
				}
				catch (NumberFormatException ex){
					throw new FileReadException("That ain't no number!", name, f.getPath(), ln);
				}
			}
			
			//Check for Name
			else if (search == 5){
				name = str.replace("%20", " ");
			    search = 1;
			}
			ln++;
		}
		
		s.close();
		return i;
	}
}
