package io.github.fourohfour.divertion.game;

public class Player {
	private Inventory inv;
	private String name;
	
	public Player(String n){
		this.name = n;
		this.inv = new Inventory();
	}

	public Inventory getInventory() {
		return inv;
	}
	
	public String getName() {
		return name;
	}
}
