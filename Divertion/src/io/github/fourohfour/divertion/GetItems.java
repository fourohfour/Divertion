package io.github.fourohfour.divertion;

import io.github.fourohfour.divertion.item.BuiltItem;
import io.github.fourohfour.divertion.item.Item;
import io.github.fourohfour.divertion.utils.FileReadException;
import io.github.fourohfour.divertion.utils.ItemBuilder;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GetItems {
	public static Set<String> items = new HashSet<>();
	static {
		items.add("oak_tree");
		items.add("jungle_tree");
		items.add("mountain");
		items.add("cactus");
	}
	
	public static Map<String, Item> getItems(){
		Map<String, Item> imap = new HashMap<>();
		for(String str : items){
			try{
				BuiltItem item = ItemBuilder.buildItem(new File("./src/io/github/fourohfour/divertion/res/" + str + ".item"));
				
				Item newitem = new Item(item);
				imap.put(newitem.getName(), newitem);
			} catch (FileReadException e) {
				e.printStackTrace();
			}
		}
		return imap;
	}
}
