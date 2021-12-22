package exercise.item;

import java.io.Serializable;
import java.util.TreeSet;

public interface ItemDAO extends Serializable {
	public ItemDTO getItem(int itemid);
	public TreeSet<ItemDTO> findAll(String category);
}
