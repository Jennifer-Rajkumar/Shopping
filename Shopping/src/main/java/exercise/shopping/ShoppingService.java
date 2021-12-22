package exercise.shopping;

import java.util.TreeSet;

import exercise.item.ItemDTO;

public interface ShoppingService {
	public TreeSet<ItemDTO> getItems(String category);

}