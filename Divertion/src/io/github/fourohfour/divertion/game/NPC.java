package io.github.fourohfour.divertion.game;

public class NPC {
	private String name;
	private int age;
	
	private int locx;
	private int locy;
	
	public NPC(int x, int y, String name, int age){
		this.locx = x;
		this.locy = y;
		
		this.name = name;
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public int[] getLocation(){
		return new int[]{locx, locy};
	}
	
	public void setLocation(int x, int y){
		this.locx = x;
		this.locy = y;
	}
}
